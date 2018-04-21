/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2009 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */


package com.sun.faces;

import java.util.Iterator;
import java.util.Map;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class ViewExpiredExceptionExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;

    public ViewExpiredExceptionExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext();) {
            ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
            Throwable t = context.getException();
            if (t instanceof ViewExpiredException) {
                ViewExpiredException vee = (ViewExpiredException) t;
                FacesContext fc = FacesContext.getCurrentInstance();
                Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
                NavigationHandler nav =
                        fc.getApplication().getNavigationHandler();
                this.thisMethodIsOnlyNecessaryBecauseOfTheWayWeForceTheViewExpiredException(fc);
                try {
                    // Push some useful stuff to the request scope for
                    // use in the page
                    requestMap.put("currentViewId", vee.getViewId());

                    nav.handleNavigation(fc, null, "viewExpired");
                    fc.renderResponse();

                } finally {
                    i.remove();
                }
            } 
        }
        // At this point, the queue will not contain any ViewExpiredEvents.
        // Therefore, let the parent handle them.
        getWrapped().handle();

    }

    

    private void thisMethodIsOnlyNecessaryBecauseOfTheWayWeForceTheViewExpiredException(FacesContext context) {
        UIViewRoot root = context.getApplication().getViewHandler().createView(context, "/main.xhtml");
        context.setViewRoot(root);


    }



}

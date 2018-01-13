<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core">

<ui:composition template="/WEB-INF/templates/BasicTemplate.xhtml">
    <ui:define name="content">
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Name"></h:outputText>
                <h:inputText value="${myFirstBean.name}"></h:inputText>
                <h:outputText value="Password"></h:outputText>
                <h:inputSecret value="${myFirstBean.password}"></h:inputSecret>
            </h:panelGrid>
            <h:commandButton value="Login" action="${myFirstBean.savepassword}"></h:commandButton>
        </h:form>
    </ui:define>
</ui:composition>
</html>
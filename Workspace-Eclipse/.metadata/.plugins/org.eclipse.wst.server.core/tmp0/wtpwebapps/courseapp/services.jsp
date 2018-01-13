<!DOCTYPE html>
<html lang="en">
<head>
<title>Course Management System</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.5.2.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Cabin_400.font.js"></script>
<script type="text/javascript" src="js/tabs.js"></script>
<script type="text/javascript" src="js/jquery.jqtransform.js" ></script>
<script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript" src="js/atooltip.jquery.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime-1.0" prefix="dt" %>
</head>
<body id="page6" onLoad="myFunction();">
<div class="main">
  <header>
    <div class="wrapper">
      <h1>  </h1>
       <h1>&nbsp  </h1>
	   <h1>&nbsp  </h1>
	   <br/>
	   
	   <br/>
	   <h1>&nbsp  </h1>
    </div>
    <nav>
    <form name="linkForm" method="post">
    <input type="hidden"  class="input"  name="viewType" value=""/>
                   <ul id="menu">
		  <li><a href="#" onClick="performAction('home');"><span><span>Search Courses</span></span></a></li>
		   <li><a href="#" onClick="performAction('managecourses');"><span><span>Manage Courses</span></span></a></li>
		   <li><a href="#" onClick="performAction('viewassignments');"><span><span>View Assignments</span></span></a></li>
		   <li><a href="#" onClick="performAction('viewgrades');"><span><span>View Grades</span></span></a></li>
		  <li id="menu_active"><a href="#" onClick="performAction('services');"><span><span>Service Requests</span></span></a></li>
         <li class="end"><a href="#" onClick="logoutAction('logout');"><span><span>Logout</span></span></a></li>
       
      </ul>
      </form>
    </nav>

    
    <script type="text/javascript">
    
    function logoutAction(viewType) {
    	
    	document.linkForm.viewType.value=viewType;
    	document.linkForm.action = "loginServlet";
    	document.linkForm.submit();
    }
    
    function performAction(viewType) {
    	document.linkForm.viewType.value=viewType;
    	document.linkForm.action = "servicesServlet";
    	if(viewType=='viewprofile') {
    		document.linkForm.action = "profileServlet";
    	}
    	document.linkForm.submit();
    }
    
    
    </script>

  </header>
  <!-- / header -->
  <!--content -->
  <section id="content">
    <div class="wrapper pad1">
          <article class="col1">
        
      </article> 
      <article class="col2">
        <h3 class="pad_top1" align="center">Raise Service Request</h3>
        <form id="ContactForm" name="ContactForm" action="enquiryServlet" method="post">
         <input type="hidden" class="input" name="viewType" value="enquirysubmit">
         <input type="hidden" class="input" name="id" value="${enquiry.id}">
          <div>
          
           <div  class="wrapper"> 
              <core:if test="${not empty errorMsg}">
           <font color="red"> <core:out value="${errorMsg}"></core:out> </font>
            </core:if>
            </div>
            
            
            <div  class="wrapper"> <span>Name:</span>
              <input type="text" class="input" name="custname" value="${enquiry.name}">
            </div>
            <div  class="wrapper"> <span>Email:</span>
              <input type="text" class="input" name="emailid" value="${enquiry.emailId}">
            </div>
            
        <div  class="wrapper"> <span>Type:</span>
       
          <select name="servicetype" id="servicetype">
        <option value="select">Select</option>
        <option value="1">Courses</option>
        <option value="2">Assignments</option>
        <option value="3">Other</option>
        </select>
       
            
            <div  class="textarea_box"> <span>Message:</span>
              <textarea name="message" cols="1" rows="1">${enquiry.message}</textarea>
            </div>
            
        <br/>
         <div  align="center">   <input type="submit" value="Submit" /> </div> </div>
        </form>
      </article>
    </div>
  </section>
  <!--content end-->
 
</div>
<script type="text/javascript">Cufon.now();</script>
</body>
</html>
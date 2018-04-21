<!DOCTYPE html>
<html lang="en">
<head>
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
<body id="page4">
<div class="main">
  <!--header -->
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
		  <li    id="menu_active"><a href="#" onClick="performAction('home');"><span><span>Search Courses</span></span></a></li>
		   <li><a href="#" onClick="performAction('managecourses');"><span><span>Manage Courses</span></span></a></li>
		   <li><a href="#" onClick="performAction('viewassignments');"><span><span>View Assignments</span></span></a></li>
		   <li><a href="#" onClick="performAction('viewgrades');"><span><span>View Grades</span></span></a></li>
		  <li ><a href="#" onClick="performAction('services');"><span><span>Service Requests</span></span></a></li>
        	<!-- <li><a href="#" onClick="performAction('viewprofile');"><span><span>Manage Profile</span></span></a></li> -->
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
    
    function enrollCourse(aptId) {
    	document.ContactForm.viewType.value="enrollcourse";
    	document.ContactForm.selectedcourse.value=aptId;
    	var r = confirm("Are you sure to enroll ? ");
    	if(r==true) {
    		document.ContactForm.submit();
    	}else {
    		return false;
    	}
    
    }
    
    </script>

    
  </header>
  <!-- / header -->
  <!--content -->
  <section id="content">
    <div class="wrapper pad1">
    
 <h3 class="pad_top1">Search Courses</h3>
      <form name="ContactForm" id="ContactForm" action="servicesServlet" method="post"> 
       <input type="hidden"  class="input"  name="viewType" value="search"/>
        <input type="hidden"  class="input"  name="selectedcourse" value=""/>
        <table width="50%">
        
        
        <tr><td colspan="8">&nbsp;</td></tr>
           
           
           
            <tr>
            <td colspan="2"> 
            <core:if test="${not empty errorMsg}">
             <font color="red"><core:out value="${errorMsg}"></core:out></font>
            </core:if>
            
            </td>
              </tr>
                         
           <tr><td>&nbsp;</td></tr>
           
           
            <tr>
            <td colspan="2"> 
                   
            </td>
              </tr>
                         
           <tr><td>&nbsp;</td></tr>
            
              <tr> <td>Department Name:</td>
            <td> <input type="text" class="input" name="deptname"  value=""/></td>
            </tr>
            
              <tr><td>&nbsp;</td></tr>
         <tr>     
        <td > Department Type : </td>
        <td >  <select name="dtype" id="dtype">
        <option value="select">Select</option>
         <option value="Under Graduate">Under Graduate</option>
        <option value="Graduate" selected>Graduate</option>
        </select>  
                </td>
        
              </tr>
        
                 
        <tr><td>&nbsp;</td></tr>
          
         <tr>
        <td>Course Name</td>
        <td> <input type="text"  class="input"  name="cname1" value=""/></td>
        </tr>
        <tr><td>&nbsp;</td></tr>
        
        <tr>
        <td>Course Code : </td>
        <td> <input type="text"  class="input"  name="ccode1"  value=""/></td>
        </tr>
        
        <tr><td>&nbsp;</td></tr>
        <tr>
         <td> Availability </td>
        <td>  <select name="avail1" id="avail1">
        <option value="select">Select</option>
         <option value="Spring">Spring</option>
        <option value="Summer">Summer</option>
        <option value="Fall" selected>Fall</option>
        </select>  
                </td>
             </tr>   
             
                       <tr><td>&nbsp;</td></tr>
              <tr>
					<td  align="center"><input type="submit" value="Search" /></td>
				</tr>
    </table>
    
    
        <table width="100%" >
        
        <tr><td>&nbsp;</td></tr>
        <tr><td>&nbsp;</td></tr>
    <tr>
        <td colspan="7"> <h4>Course Details</h4> </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
     <tr>
     <th>Course Name</th>
     <th>Course Code</th>
     <th>Professor</th>
     <th>Capacity</th>
     <th>Remaining</th>
     <th>Level</th>
     <th>Action</th>
      </tr> 
      
      <tr><td colspan="7">&nbsp;</td></tr> 
    <core:forEach var="course" items="${departmentsList}">
    <tr align="center">
    <td><core:out value="${course.courseName}"></core:out> </td>
    <td><core:out value="${course.courseCode}"></core:out> </td>
    <td><core:out value="${course.professor}"></core:out> </td>
    <td><core:out value="${course.capacity}"></core:out> </td>
    <td><core:out value="${course.remaining}"></core:out> </td>
    <td><core:out value="${course.type}"></core:out> </td>
    <td><a href="#"  onClick="enrollCourse('<core:out value="${course.courseId}"/>');">Enroll</a></td>
    </tr>
    
    </core:forEach>
    </table>
    
    </form>
    </div>
  </section>
 
</div>
<script type="text/javascript">Cufon.now();</script>
</body>
</html>
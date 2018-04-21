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
<body id="page4">
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
            <ul id="menu">
      <core:if test="${user.userType=='admin'}">
        <li><a href="#"><span><span>Modify Courses</span></span></a></li>
         <li  id="menu_active"><a href="#" onClick="modifyFunction('viewstudents');"><span><span>View Students</span></span></a></li>
        </core:if>
        <core:if test="${user.userType=='staff'}">
        <li ><a href="adddepartments.jsp"><span><span>Post Assignments</span></span></a></li>
        <li id="menu_active"><a href="#" onClick="modifyFunction('postgrades');"><span><span>Post Grades</span></span></a></li>
        </core:if>
        <li><a href="#" onClick="modifyFunction('enquiryhome');"><span><span>View Enquiries</span></span></a></li>
        <li class="end"><a href="login.jsp"><span><span>Logout</span></span></a></li>
      </ul>
    </nav>
    <script type="text/javascript">

    function modifyFunction(viewType) {

    	document.ContactForm.viewType.value=viewType;
    	if(viewType=='enquiryhome') {
    		document.ContactForm.action="enquiryServlet";
    	}
    	document.ContactForm.submit();
    }

    
	function updateEnquiry(enquiryId) {
    	document.ContactForm.viewType.value="editstudent";
    	document.ContactForm.selectedstudent.value=enquiryId;
    	document.ContactForm.submit();
    }
    
    </script>
    
  </header>
  <!-- / header -->
  <!--content -->
  <section id="content">
  <form name="ContactForm" id="ContactForm" action="viewDepartmentsServlet" method="post">
    <div class="wrapper pad1">
	
	      <article class="col1">
     
      </article>  
	
      <article class="col2">
      
        <input type="hidden"  class="input"  name="viewType" required="required" value="viewstudentdetails"/>
        <input type="hidden"  class="input"  name="selectedstudent" required="required" value="${courseId}"/>
        <input type="hidden"  class="input"  name="selectedupdate" required="required" value="${updateId}"/>
              <core:if test="${user.userType=='admin'}">
        
        <table align="center" width="100%">
                    
        <tr>
        <td> Filter Type : </td>
        <td> 
          <select name="type" id="type">
        <option value="select">Select</option>
         <option value="Approved">Approved</option>
        <option value="Pending">Pending Approval</option>
        </select>
        </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
                    
              <tr><td>&nbsp;</td></tr>
              <tr>
					<td colspan="2" align="center"><input type="submit" value="Search" /></td>
				</tr>
		
              </table>
              </core:if>
    
    
      </article>
    </div>
          <core:if test="${user.userType=='admin'}">
    
    <table width="100%">
    <tr>
        <td colspan="7"> <h4>View Student Details</h4> </td>
            </tr>
      <tr><td>&nbsp;</td></tr>
            <tr>
            <td colspan="7"> 
            <core:if test="${not empty errorMsg}">
             <font color="red"><core:out value="${errorMsg}"></core:out></font>
            </core:if>
            
            </td>
              </tr>
        
     
            <tr><td>&nbsp;</td></tr>
     <tr>
     <th>Student Id</th>
     <th>First Name</th>
     <th>Status</th>
     <th>Action</th>
      </tr>  
         
    
    
      <tr><td colspan="7">&nbsp;</td></tr> 
    <core:forEach var="student" items="${studentsList}">
    <tr align="center">
    <td><core:out value="${student.studentId}"></core:out> </td>
    <td><core:out value="${student.firstName}"></core:out> </td>
    <td><core:out value="${student.status}"></core:out> </td>
    <td><a href="#"  onClick="updateEnquiry('<core:out value="${student.studentId}"/>');">Edit</a></td>
    </tr>
    </core:forEach>
    
    </table>
    </core:if>
    
    
    
    <core:if test="${user.userType=='staff'}">
    
    <table width="100%">
    <tr>
        <td colspan="4"> <h4>View Student Details</h4> </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            
     <tr align="center">
     <th>Student Id</th>
     <th>First Name</th>
     <th>Last Name</th>
     <th align="left">Marks</th>
      </tr>  
    
          <tr><td>&nbsp;</td></tr>
            <tr>
            <td colspan="4"> 
            <core:if test="${not empty errorMsg}">
             <font color="red"><core:out value="${errorMsg}"></core:out></font>
            </core:if>
            
            </td>
              </tr>
        
      <tr><td colspan="4">&nbsp;</td></tr> 
    <core:forEach var="student" items="${studentsList}">
    <tr align="center">
    <td><core:out value="${student.studentId}"></core:out> </td>
    <td><core:out value="${student.firstName}"></core:out> </td>
    <td><core:out value="${student.lastName}"></core:out> </td>
    <td>
    <input type="text" class="input" name="marks_${student.studentId}"  id="marks_${student.studentId}" required="required" value=""/>
     </td>
    </tr>
    </core:forEach>
    
    
              <tr><td>&nbsp;</td></tr>
              <tr>
					<td colspan="2" align="center"><input type="submit" value="Update" /></td>
				</tr>
	
    
    </table>
    </core:if>
    
    </form>
  </section>
  <!--content end-->
  <!--footer -->
  <footer>
    <div class="wrapper">
      
    </div>
  </footer>
  <!--footer end-->
</div>
<script type="text/javascript">Cufon.now();</script>
</body>
</html>
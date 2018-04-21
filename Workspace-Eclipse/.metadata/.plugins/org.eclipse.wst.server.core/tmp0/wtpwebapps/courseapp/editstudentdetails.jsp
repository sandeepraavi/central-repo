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
            <ul id="menu">
       <core:if test="${user.userType=='admin'}">
        <li><a href="#"><span><span>Modify Courses</span></span></a></li>
         <li id="menu_active"><a href="#" onClick="modifyFunction('viewstudents');"><span><span>View Students</span></span></a></li>
        </core:if>
        <core:if test="${user.userType=='staff'}">
        <li><a href="adddepartments.jsp"><span><span>Post Assignments</span></span></a></li>
        <li id="menu_active"><a href="#" onClick="modifyFunction('postgrades');"><span><span>Post Grades</span></span></a></li>
        </core:if>
        <li><a href="#" onClick="modifyFunction('enquiryhome');"><span><span>View Enquiries</span></span></a></li>
        <li class="end"><a href="login.jsp"><span><span>Logout</span></span></a></li>
      </ul>
    </nav>


     <script type="text/javascript">
    
     function myFunction() {
     	
   	var dep ='${student.status}';
 	  selectObj = document.getElementById('status');
 	  for(var j = 0; j < selectObj.length; j++) {
 			var flat = dep.trim();
 	     if(selectObj.options[j].value.toLowerCase() == flat.toLowerCase()) {
 	       selectObj.options[j].selected = true;
 	     }
 	  }
     }
    function modifyFunction(viewType) {
    	
    	document.ContactForm.viewType.value=viewType;
    	if(viewType=='enquiryhome') {
    		document.ContactForm.action="enquiryServlet";
    	}
    	document.ContactForm.submit();
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
        <h3 class="pad_top1" align="center">Update Student Details</h3>
                <form id="ContactForm" action="viewDepartmentsServlet" method="post">
        <input type="hidden"  class="input"  name="viewType" required="required" value="updatestudent"/>
        <input type="hidden"  class="input"  name="selectedstudent" required="required" value="${student.studentId}"/>
        <table align="center">
              <tr><td>&nbsp;</td></tr>
               <tr>
        <td>  First Name: </td>
        <td> <input type="text"  class="input"  name="firstname" required="required" value="${student.firstName }"/></td>
            </tr>
            
            <tr><td>&nbsp;</td></tr>
             <tr>
        <td>  Middle Name: </td>
        <td> <input type="text"  class="input"  name="middlename" required="required" value="${student.middleName }"/></td>
            </tr>
            
            <tr><td>&nbsp;</td></tr>  
             <tr>
        <td>  Last Name: </td>
        <td> <input type="text"  class="input"  name="lastname" required="required" value="${student.lastName }"/></td>
            </tr>
            
            <tr><td>&nbsp;</td></tr>
             <tr>
        <td>  Mobile Number: </td>
        <td> <input type="text"  class="input"  name="mobileno" required="required" value="${student.contactNo }"/></td>
            </tr>
           
            <tr><td>&nbsp;</td></tr>
            <tr>
        <td>  Email Id: </td>
        <td> <input type="text"  class="input"  name="emailid" required="required" value="${student.emailId }"/></td>
            </tr>
         <tr><td>&nbsp;</td></tr>
                         <tr>
        <td> Status  : </td>
        <td>  <select name="status" id="status">
         <option value="Pending">Pending</option>
        <option value="Approved">Approved</option>
        </select>  
                </td>
            </tr>
            
                      <tr><td>&nbsp;</td></tr>
              <tr>
					<td colspan="2" align="center"><input type="submit" value="Update" /></td>
				</tr>
				
				
				

              </table>
    </form>
      </article>
    </div>
  </section>
  <!--content end-->
 
</div>
<script type="text/javascript">Cufon.now();</script>
</body>
</html>
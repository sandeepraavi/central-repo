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
         <li><a href="#" onClick="modifyFunction('viewstudents');"><span><span>View Students</span></span></a></li>
        </core:if>
        <core:if test="${user.userType=='staff'}">
        <li><a href="adddepartments.jsp"><span><span>Post Assignments</span></span></a></li>
        <li><a href="#" onClick="modifyFunction('postgrades');"><span><span>Post Grades</span></span></a></li>
        </core:if>
        <li  id="menu_active"><a href="#" onClick="modifyFunction('enquiryhome');"><span><span>View Enquiries</span></span></a></li>
        <li class="end"><a href="login.jsp"><span><span>Logout</span></span></a></li>
      </ul>
    </nav>
    <script type="text/javascript">

	function updateEnquiry(enquiryId) {
    	document.ContactForm.viewType.value="editenquirydetails";
    	document.ContactForm.selectedenquiry.value=enquiryId;
    	document.ContactForm.submit();
    }
	
    function modifyFunction(viewType) {

    	document.ContactForm.viewType.value=viewType;
    	document.ContactForm.action="viewDepartmentsServlet";
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
      
 <h3 class="pad_top1" align="center">View Service Details</h3>
        <form name="ContactForm" id="ContactForm" action="enquiryServlet" method="post">
        <input type="hidden"  class="input"  name="viewType" required="required" value="enquiryhome"/>
        <input type="hidden"  class="input"  name="selectedenquiry" required="required" value=""/>
        <table align="center" width="100%">
                    
        <tr>
        <td> Service Type : </td>
        <td> 
          <select name="servicetype" id="servicetype">
        <option value="select">Select</option>
         <option value="1">Enquiries</option>
        <option value="2">Assignments</option>
        <option value="2">Courses</option>
        <option value="3">Other</option>
        </select>
        </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
                    
              <tr><td>&nbsp;</td></tr>
              <tr>
					<td colspan="2" align="center"><input type="submit" value="Search" /></td>
				</tr>
		
              </table>
    </form>
    
      </article>
    </div>
    
    <table width="100%">
    <tr>
        <td colspan="7"> <h4>View Details</h4> </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
     <tr>
     <th>Service Type</th>
     <th>Name</th>
     <th>Mail Id</th>
     <th>Message</th>
     <th>Posted Date</th>
     <th>Status</th>
     <th>Action</th>
      </tr>  
         
    
    
      <tr><td colspan="7">&nbsp;</td></tr> 
    <core:forEach var="enquiry" items="${enquiryList}">
    <tr align="center">
    <td><core:out value="${enquiry.id}"></core:out> </td>
    <td><core:out value="${enquiry.name}"></core:out> </td>
     <td><core:out value="${enquiry.emailId}"></core:out> </td>
     <td><core:out value="${enquiry.message}"></core:out> </td>
     <td><core:out value="${enquiry.enquiryDate}"></core:out> </td>
     <td><core:out value="${enquiry.status}"></core:out> </td>
    <td><a href="#"  onClick="updateEnquiry('<core:out value="${enquiry.id}"/>');">Edit</a></td>
    
    </tr>
    
    </core:forEach>
    
    </table>
    
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
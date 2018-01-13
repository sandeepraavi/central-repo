
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
            <ul id="menu">
            <core:if test="${user.userType=='admin'}">
        <li  id="menu_active"><a href="#"><span><span>Modify Courses</span></span></a></li>
         <li><a href="#" onClick="modifyFunction('viewstudents');"><span><span>View Students</span></span></a></li>
        </core:if>
        <core:if test="${user.userType=='staff'}">
        <li  id="menu_active"><a href="adddepartments.jsp"><span><span>Post Assignments</span></span></a></li>
        <li><a href="#" onClick="modifyFunction('postgrades');"><span><span>Post Grades</span></span></a></li>
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
    
    function submitForm() {
    	      	document.ContactForm.submit();
    }
    </script>
  </header>
  <!-- / header -->
  <!--content -->
  <section id="content">
    <div class="wrapper pad1">
	
	      <article class="col1">
        <div class="box1">
          <h2 class="top">Modify</h2>
           
            <ul class="pad_bot2 list1">
                 <core:if test="${user.userType=='admin'}">
              <li> <a href="adddepartments.jsp">Add Course Details</a> </li>
              <li> <a href="#" onClick="modifyFunction('editdepartment');">Edit Course</a> </li>
              <li><a  href="#" onClick="modifyFunction('deletedepartment');">Delete Course</a> </li>
              </core:if>
                   <core:if test="${user.userType=='staff'}">
                    <li> <a href="adddepartments.jsp">Post Assignment</a> </li>
             		 <li> <a href="#" onClick="modifyFunction('editdepartment');">Edit Assignment</a> </li>
             		 <li><a  href="#" onClick="modifyFunction('deletedepartment');">Delete Assignment</a> </li>
                   </core:if>
            </ul>
        </div>
      </article>  
	
      <article class="col2">
                      <core:if test="${user.userType=='admin'}">
 <h3 class="pad_top1" align="center">
 <core:choose>
 <core:when test="${mode=='edit'}">Edit Course Details</core:when>
 <core:otherwise>Add New Department</core:otherwise>
  </core:choose> 
 </h3>
        <form id="ContactForm" name="ContactForm" action="viewDepartmentsServlet" method="post">
        <input type="hidden"  class="input"  name="selectedamenities" required="required" value=""/>
        <core:choose>
 <core:when test="${mode=='edit'}"> <input type="hidden"  class="input"  name="viewType" required="required" value="updatedepartment"/>
 <input type="hidden"  class="input"  name="cid" required="required" value="${course.courseId}"/>
 </core:when>
 <core:otherwise> <input type="hidden"  class="input"  name="viewType" required="required" value="adddepartment"/>
 
 </core:otherwise>
 
  </core:choose> 
       
        <table width="100%">
        
        
        <tr><td colspan="10">&nbsp;</td></tr>
            <tr>
            <td colspan="10"> 
            <core:if test="${not empty errorMsg}">
             <font color="red"><core:out value="${errorMsg}"></core:out></font>
            </core:if>
            
            </td>
              </tr>
              <tr><td>&nbsp;</td></tr>
              
            
              <tr> <td colspan="2">Department Name:</td>
            <td colspan="2"> <input type="text" class="input" name="deptname" required="required" value="${course.deptName }"/></td>
        <td colspan="2"> Department Type : </td>
        <td colspan="2">  <select name="dtype" id="dtype">
        <option value="select">Select</option>
         <option value="Under Graduate">Under Graduate</option>
        <option value="Graduate" selected>Graduate</option>
        </select>  
                </td>
                <td colspan="2"> &nbsp;</td>
              </tr>
        
                 
        <tr><td>&nbsp;</td></tr>
          
         <tr>
        <td>Course Name</td>
        <td> <input type="text"  class="input"  name="cname1" required="required" value="${course.courseName}"/></td>
        <td>Course Code : </td>
        <td> <input type="text"  class="input"  name="ccode1" required="required" value="${course.courseCode }"/></td>
        
         <td> Availability </td>
        <td>  <select name="avail1" id="avail1">
        <option value="select">Select</option>
         <option value="Spring">Spring</option>
        <option value="Summer">Summer</option>
        <option value="Fall" selected>Fall</option>
        </select>  
                </td>
                
                 <td> Capacity </td>
        <td> <input type="text"  class="input"  name="capacity1" required="required" value="${course.capacity }"/></td>
                
                
                 <td> Professor </td>
        <td> <input type="text"  class="input"  name="prof1" required="required" value="${course.professor}"/></td>
                
            </tr>
                  
 <core:if test="${mode!='edit'}">       
              <tr><td>&nbsp;</td></tr>
              
          <tr>
        <td>Course Name</td>
        <td> <input type="text"  class="input"  name="cname2" required="required" value=""/></td>
        <td>Course Code : </td>
        <td> <input type="text"  class="input"  name="ccode2" required="required" value=""/></td>
        
         <td> Availability </td>
        <td>  <select name="avail2" id="avail2">
        <option value="select">Select</option>
         <option value="1">Spring</option>
        <option value="2">Summer</option>
        <option value="3">Fall</option>
        </select>  
                </td>
                
                 <td> Capacity</td>
        <td> <input type="text"  class="input"  name="capacity2" required="required" value=""/></td>
                

                 <td> Professor </td>
        <td> <input type="text"  class="input"  name="prof2" required="required" value=""/></td>                
            </tr>
                  
              <tr><td>&nbsp;</td></tr>
              
               <tr>
        <td>Course Name</td>
        <td> <input type="text"  class="input"  name="cname3" required="required" value=""/></td>
        <td>Course Code : </td>
        <td> <input type="text"  class="input"  name="ccode3" required="required" value=""/></td>
        
         <td> Availability </td>
        <td>  <select name="avail3" id="avail3">
        <option value="select">Select</option>
         <option value="1">Spring</option>
        <option value="2">Summer</option>
        <option value="3">Fall</option>
        </select>  
                </td>
                
                 <td> Capacity</td>
        <td> <input type="text"  class="input"  name="capacity3" required="required" value=""/></td>
                
             
                 <td> Professor </td>
        <td> <input type="text"  class="input"  name="prof3" required="required" value=""/></td>   
            </tr>
                  
              <tr><td>&nbsp;</td></tr>
              
               <tr>
        <td>Course Name</td>
        <td> <input type="text"  class="input"  name="cname14" required="required" value=""/></td>
        <td>Course Code : </td>
        <td> <input type="text"  class="input"  name="ccode4" required="required" value=""/></td>
        
         <td> Availability</td>
        <td>  <select name="avail4" id="avail4">
        <option value="select">Select</option>
         <option value="1">Spring</option>
        <option value="2">Summer</option>
        <option value="3">Fall</option>
        </select>  
                </td>
                
                 <td> Capacity </td>
        <td> <input type="text"  class="input"  name="capacity4" required="required" value=""/></td>
                
               <td> Professor </td>
        <td> <input type="text"  class="input"  name="prof4" required="required" value=""/></td> 
            </tr>
                  
              <tr><td>&nbsp;</td></tr>
              
               <tr>
        <td>Course Name </td>
        <td> <input type="text"  class="input"  name="cname5" required="required" value=""/></td>
        <td>Course Code : </td>
        <td> <input type="text"  class="input"  name="ccode5" required="required" value=""/></td>
        
         <td> Availability </td>
        <td>  <select name="avail5" id="avail5">
        <option value="select">Select</option>
         <option value="1">Spring</option>
        <option value="2">Summer</option>
        <option value="3">Fall</option>
        </select>  
                </td>
                
                 <td> Capacity </td>
        <td> <input type="text"  class="input"  name="capacity5" required="required" value=""/></td>
                
              <td> Professor </td>
        <td> <input type="text"  class="input"  name="prof5" required="required" value=""/></td>  
            </tr>
      </core:if>             
              <tr><td>&nbsp;</td></tr>     
              <tr>
             
  <core:choose>
 <core:when test="${mode=='edit'}">
 <td colspan="8" align="center"><input type="button" onClick="submitForm();" value="Update Course" /></td>
 </core:when>
 <core:otherwise>
 <td colspan="8" align="center"><input type="button" onClick="submitForm();" value="Add Course" /></td>
 </core:otherwise>
 
  </core:choose>
					
				</tr>
				
				
				

              </table>
    </form>
    </core:if>
    
    
                    <core:if test="${user.userType=='staff'}">
    
            <h3 class="pad_top1" align="center">Post Assignment</h3>
        <form id="ContactForm" name="ContactForm" action="viewDepartmentsServlet" method="post">
 
        <core:choose>
 <core:when test="${mode=='edit'}"> <input type="hidden"  class="input"  name="viewType" required="required" value="assignmentupdate"/>
         <input type="hidden" class="input" name="uid" value="${assignment.updateId}">
 </core:when>
 <core:otherwise> <input type="hidden"  class="input"  name="viewType" required="required" value="assignmentsubmit"/>
 </core:otherwise>
 </core:choose>
          <div>
          
           <div  class="wrapper"> 
              <core:if test="${not empty errorMsg}">
           <font color="red"> <core:out value="${errorMsg}"></core:out> </font>
            </core:if>
            </div>
            
            
            <div  class="wrapper"> <span>Title:</span>
              <input type="text" class="input" name="title" value="${assignment.title}">
            </div>
            <div  class="wrapper"> <span>Marks:</span>
              <input type="text" class="input" name="marks" value="${assignment.marks}">
            </div>
            
             <div  class="wrapper"> <span>Deadline:</span>
              <input type="text" class="input" name="deadline" value="${assignment.deadLine}">
            </div>
            
        <div  class="wrapper"> <span>Course:</span>
       
          <select name="course" id="course">
        <option value="1" selected>Software Engineering</option>
        <option value="2">Compiler Design</option>
        <option value="5">Operating Systems</option>
        <option value="6">Advanced DB</option>
        <option value="9">Mechanics</option>
        </select>
       </div>
            
            <div  class="textarea_box"> <span>Message:</span>
              <textarea name="message" cols="1" rows="1">${assignment.description}</textarea>
            </div>
            
        <br/>
        
        <core:choose>
 <core:when test="${mode=='edit'}">
 <td colspan="8" align="center"><input type="button" onClick="submitForm();" value="Update Assignment" /></td>
 </core:when>
 <core:otherwise>
 <td colspan="8" align="center"><input type="button" onClick="submitForm();" value="Post Assignment" /></td>
 </core:otherwise>
 
  </core:choose>
        </form>
    
    
    
                    </core:if>
      </article>
    </div>
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
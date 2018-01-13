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
        <li id="menu_active"><a href="login.jsp"><span><span>Login</span></span></a></li>
        
      </ul>
      </form>
    </nav>
    
  </header>
  <!-- / header -->
  <!--content -->
  <section id="content">
    <div class="wrapper pad1" align="center">
    
 <h3 class="pad_top1">New User Form</h3>
        <form id="ContactForm" action="profileServlet" method="post">
        <input type="hidden"  class="input"  name="viewType" required="required" value="register"/>
        <table align="center">
        <tr>
        <td> User Name: </td>
        <td> <input type="text"  class="input"  name="username" required="required" value="student1"/></td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr> <td>Password:</td>
            <td> <input type="password" class="input" name="userpass" required="required" value="student1"/></td>
              </tr>
              
                   <tr><td>&nbsp;</td></tr>
              
        <tr>
        <td>  Security Question: </td>
        <td>  <select name="securityquestion">
        <option value="1">What is the name of your favorite teacher?</option>
        <option value="2">What is the name of your pet?</option>
        <option value="3">What is the name of your first employer?</option>
        <option value="4">What is the name of your best friend?</option>        
        </select></td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr> <td>Security Answer:</td>
            <td> <input type="password" class="input" name="securityanswer" required="required" value="student"/></td>
              </tr>
              
         <tr><td>&nbsp;</td></tr>
                <tr>
        <td> User Type  : </td>
        <td>  <select name="usertype" id="usertype">
         <option value="student">Student</option>
        <option value="staff">Staff</option>
        </select>  
                </td>
            </tr>


              <tr><td>&nbsp;</td></tr>
               <tr>
        <td>  First Name: </td>
        <td> <input type="text"  class="input"  name="firstname" required="required" value="student1"/></td>
            </tr>
            
            <tr><td>&nbsp;</td></tr>
             <tr>
        <td>  Middle Name: </td>
        <td> <input type="text"  class="input"  name="middlename" required="required" value="student1"/></td>
            </tr>
            
            <tr><td>&nbsp;</td></tr>  
             <tr>
        <td>  Last Name: </td>
        <td> <input type="text"  class="input"  name="lastname" required="required" value="student1"/></td>
            </tr>
            
            <tr><td>&nbsp;</td></tr>
             <tr>
        <td>  Mobile Number: </td>
        <td> <input type="text"  class="input"  name="mobileno" required="required" value="8121689601"/></td>
            </tr>
           
            <tr><td>&nbsp;</td></tr>
            <tr>
        <td>  Email Id: </td>
        <td> <input type="text"  class="input"  name="emailid" required="required" value="customer1@gmail.com"/></td>
            </tr>
        
        
        <tr><td>&nbsp;</td></tr>
                <tr>
        <td> Department : </td>
        <td>  <select name="deptname" id="deptname" >
         <option value="Computer Science">Computer Science</option>
        <option value="Psychology">Psychology</option>
        <option value="CIS">CIS</option>
        <option value="Mechanical">Mechanical</option>
        </select>  
                </td>
            </tr>
            
                      <tr><td>&nbsp;</td></tr>
              <tr>
					<td colspan="2" align="center"><input type="submit" value="Register" /></td>
				</tr>
				
				
				

              </table>
    </form>
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
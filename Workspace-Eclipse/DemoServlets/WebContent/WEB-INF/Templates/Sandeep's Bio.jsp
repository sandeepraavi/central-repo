<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<head>
    <title>Ravi's Thick Shake Factory</title>
<link rel="icon" type="image/x-icon" href="/favicon.ico">
</head>
    <style>
.mainbody .bg {
  position: absolute;
  z-index: -1;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-image: url('C:/Users/ImSandeep/Desktop/U C Missouri/Semester 2/Dr. Dabin Ding/Assignement 2/bg4.jpg') ;
  opacity: .5;
}

body {
	font-family: sans-serif;
	font-weight: normal;
	margin: 10px;
	color: #999;
}

form {
	margin: 40px 0;
}

div {
	clear: both;
	margin: 0 50px;
}

label {
  width: 200px;
  border-radius: 3px;
  border: 1px solid #D1D3D4
}

/* hide input */
input.radio:empty {
	margin-left: -999px;
}

/* style label */
input.radio:empty ~ label {
	position: relative;
	float: left;
	line-height: 2.5em;
	text-indent: 3.25em;
	margin-top: 2em;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

input.radio:empty ~ label:before {
	position: absolute;
	display: block;
	top: 0;
	bottom: 0;
	left: 0;
	content: '';
	width: 2.5em;
	background: #D1D3D4;
	border-radius: 3px 0 0 3px;
}

/* toggle hover */
input.radio:hover:not(:checked) ~ label:before {
	content:'\2714';
	text-indent: .9em;
	color: #C2C2C2;
}

input.radio:hover:not(:checked) ~ label {
	color: #888;
}

/* toggle on */
input.radio:checked ~ label:before {
	content:'\2714';
	text-indent: .9em;
	color: #9CE2AE;
	background-color: #4DCB6D;
}

input.radio:checked ~ label {
	color: #777;
}

/* radio focus */
input.radio:focus ~ label:before {
	box-shadow: 0 0 0 3px #999;
}
.tile a {
    display: block;
    padding: 10px;
    border: 1px solid red;
    margin-right: 5px;
}
.tileMe li {
    display: inline;
    float: left;
}        
    </style>
<body  >
    <div class="mainbody">
        <div class="bg"></div>
	 <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\logo.jpg" alt="Ravi's Thick Shake Factory" > 
	<div><form id="typeform">
			<input type="radio" name="selecttype" value="I"> Ice Cream
			<input type="radio" name="selecttype" value="M"> Milk Shake
			<input type="radio" name="selecttype" value="F"> Floats
		</form></div>
        
<div class="cones">
<h3>Cones</h3>
<ul class="tileMe">
    <li><a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\Cone - 1.jpg" alt="Waffle Cone" style="width: 159px;height: 135px;border:0">
</a><li>
    <li><a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\Choclate Waffle cone.jpg" alt="Choclate Waffle Cone" style="width: 159px;height: 135px;border:0">
</a><li>
    <li><a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\Waffle Bowl.jpg" alt="Waffle Bowl" style="width: 159px;height: 135px;border:0">
</a><li>
    <li><a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\Pretzel cone.jpg" alt="Pretzel Cone" style="width: 159px;height: 135px;border:0">
</a><li>
    <li><a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\Choclatey Dipped cup cone.jpg" alt="Choclatey Dipped cup cone" style="width: 159px;height: 135px;border:0">
</a> <li>
</ul>
         
</div>
<div class="flavours">
<h3>Ice Cream Flavours</h3>

 <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\1.jpg" alt="Arabia Coffee" style="width: 179px;height: 146px;border:0">
</a>  <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\2.Jpg" alt="Tender Coconut Haven" style="width: 179px;height: 146px;border:0">
</a>  <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\3.jpg" alt="Almond Crunch" style="width: 179px;height: 146px;border:0">
</a>  <a href="default.asp">
  <br><img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\4.jpg" alt="Awesome Orange" style="width: 179px;height: 146px;border:0">
</a>  <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\5.jpg" alt="Bean Vanilla" style="width: 179px;height: 146px;border:0">
</a>  <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\6.jpg" alt="Belgian Chocoholic" style="width: 179px;height: 146px;border:0">
</a>  <a href="default.asp">
  <br><img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\7.jpg" alt="Butterscotch Bliss" style="width: 179px;height: 146px;border:0">
</a>  <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\8.jpg" alt="Butter Pecan ballet" style="width: 179px;height: 146px;border:0">
</a> 
 <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\9.jpg" alt="Chikoo" style="width: 179px;height: 146px;border:0">
</a> 
</div>
<div class="shakes">
<h3>Milk Shakes</h3>

<form>
		<input type="radio" name="select milk" value="S"> Skim Milk
		<input type="radio" name="select milk" value="W"> Whole Milk
		<input type="radio" name="select milk" value="M">2% Milk 
	</form>
</div>	
<div class="sodas">
<h3>Sodas</h3>
 <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\s1.jpg" alt="HTML tutorial" style="width: 120px;height: 126px;border:0">
</a> 
 <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\s2.jpg" alt="HTML tutorial" style="width: 120px;height: 126px;border:0">
</a> 
 <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\s3.jpg" alt="HTML tutorial" style="width: 120px;height: 126px;border:0">
</a> 
 <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\s4.jpg" alt="HTML tutorial" style="width: 120px;height: 126px;border:0">
</a> 
 <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\s5.jpg" alt="HTML tutorial" style="width: 120px;height: 126px;border:0">
</a> 

 <a href="default.asp">
  <img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\s6.jpg" alt="HTML tutorial" style="width: 120px;height: 126px;border:0">
</a> 
    </div>
    
<script>
    $(document).ready(function(){
   $(".cones").hide();
   $(".flavours").hide();
   $(".shakes").hide();
   $(".sodas").hide();
});
$('#typeform input').on('change', function() {
   var selectedtype= $('input[name="selecttype"]:checked', '#typeform').val();
    
 if(selectedtype == 'I'){
    $(".cones").show();
   $(".flavours").show();
   $(".shakes").hide();
   $(".sodas").hide();
    }
    if(selectedtype == 'M'){
$(".cones").hide();
   $(".shakes").show();
   $(".flavours").show();
   $(".sodas").hide();
    }
    if(selectedtype == 'F'){
    $(".cones").hide();
   $(".flavours").show();
   $(".shakes").hide();
   $(".sodas").show();
    }    
});
</script>    
</body>
    
</html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Ice Cream Shop</title>
        <meta charset="utf-8">
        <meta name="format-detection" content="telephone=no" />
        <link rel="icon" href="images/favicon.ico">
        <link rel="shortcut icon" href="images/favicon.ico" />
        <link rel="stylesheet" href="css/stuck.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/touchTouch.css">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-migrate-1.1.1.js"></script>
        <script src="js/script.js"></script>
        <script src="js/superfish.js"></script>
        <script src="js/jquery.equalheights.js"></script>
        <script src="js/jquery.mobilemenu.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/tmStickUp.js"></script>
        <script src="js/jquery.ui.totop.js"></script>
        <script src="js/touchTouch.jquery.js"></script>

        <script>
            $(document).ready(function () {
                $().UItoTop({easingType: 'easeOutQuart'});
                $('#stuck_container').tmStickUp({});
                $('.gallery .gall_item').touchTouch();
            });
        </script>
        <!--[if lt IE 9]>
         <div style=' clear: both; text-align:center; position: relative;'>
           <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
             <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
           </a>
        </div>
        <script src="js/html5shiv.js"></script>
        <link rel="stylesheet" media="screen" href="css/ie.css">
        <![endif]-->
    </head>

    <body class="page1" id="top">
        <!--==============================
                      header
        =================================-->
        <header>
            <!--==============================
                        Stuck menu
            =================================-->
            <section id="stuck_container">
                <div class="container">
                    <div class="row">
                        <div class="grid_12">
                            <h1 style="margin: 0px 0px 0px 0px;" class="logo">
                                <a href="index.html">
                                    <span><img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\logo.jpg" width="100" height="125" alt="logo"/></span>
                                </a>
                            </h1>
                            <h1 style="margin: 45px 0px 30px 0px;" class="logo">
                                <a href="index.html">
                                    <span>
                                        Ravi's Thick Shake Factory
                                    </span><br><br>
                                    <span style="font-size: 20px; color: deeppink">  More Flavours.. More Fun... </span>
                                </a>
                            </h1>
                            <div class="socials">
                                <a href="#" ><img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\twitter.png"  alt="Twitter" ></a>
                                <a href="#" ><img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\facebook.png"  alt="Facebook" style="width: 48px; height: 48px; "></a>
                                <a href="#"><img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\google.png"  alt="Google Plus"></a>
                                <a href="#" ><img src="C:\Users\ImSandeep\Desktop\U C Missouri\Semester 2\Dr. Dabin Ding\Assignement 2\pintrest.png"  alt="Pintrest"></a>
                            </div>
                            <div class="navigation">
                                <nav>
                                    <ul class="sf-menu">
                                        <li class="current"><a href="index.html">Home</a></li>
                                        <li><a href="menu.html">Shop Now</a></li>
                                        <!-- <li><a href="reservation.html">Reserve</a></li>-->
                                        <li><a href="contacts.html">Contact Us</a></li>
                                    </ul>
                                </nav>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </header>
                               <div>
        <img src="images/ice%20cream.jpg"  > <centre>      <h2 style="color:deeppink;"> Thank You for shopping with us. Please visit again..  </h2></centre>
        </div> 
                                    
                                
                             
       <footer id="footer">
            <div class="container">
                <div class="row">
                    <div class="grid_12">

                        <div class="copyright">
                            <span class="brand">Ice Cream Shoppe</span> &copy; <span id="copyright-year">2016</span> | <a href="#">Privacy Policy</a>
                        </div>
                         <div class="socials">
                                <a href="#" ><img src="images/twitter.png"  alt="Twitter" ></a>
                                <a href="#" ><img src="images/facebook.png"  alt="Facebook" style="width: 48px; height: 48px; "></a>
                                <a href="#"><img src="images/google.png"  alt="Google Plus"></a>
                                <a href="#" ><img src="images/pintrest.png"  alt="Pintrest"></a>
                            </div>
                    </div>
                </div>
            </div>
        </footer>
        
    </body>
</html>
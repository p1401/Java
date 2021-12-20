<%-- 
    Document   : Login
    Created on : Jan 24, 2021, 6:45:37 PM
    Author     : duyph
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HZ Computer</title>
        <link rel="shortcut icon" href="src/favicon.ico">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                margin-top: 20px;
                padding: 0;
                background: #FFFFFF;
                text-align: justify;
                font-family: "Helvetica Neue", "Lucida Grande", "Segoe UI", Arial, Helvetica, Verdana, sans-serif;
                font-size:  0.875em;
                color: #616161;	/*xám*/
            }

            h1 {
                padding-top: 10px;
                padding-bottom: 50px;
                padding-left: 50px;
                color: #000000;
                font-weight: normal;
                font-size: 2em;
            }

            p {
                font-size: 14px; 
                font-weight: bold;
            }
            #menuContaniner {
                width: 500px;
                float: right;
                margin: -60px 0 0 0;
                background-color:#000000;
            }
            ul.main_nav {
                margin: 0 auto;
                margin-left: -250px;	
                padding: 0;
                list-style: none;
                height: 50px;
            }

            ul.main_nav li {
                border-right: 1px solid #BCBCBC;
                float: left;
                position: relative;
                text-align: center;
                margin: 0;padding: 0;
                display: inline;
                height: 45px;
                padding-top: 5px;
            }
            ul.main_nav li a {
                width: 100px;
                padding: 10px;
                text-decoration: none;
                display: block;
                font-weight:bold;
                color:gold;
            }
            
            ul.main_nav li a:hover{
                background-color: #FFFFFF;
                text-decoration: underline;
            }
            /* Content */
            #mainContainer {
                width: 1400px;
                height: 100%;
                margin: 40px auto;
                padding: 20px 5px;
                background: #FFFFFF;
            }
            div.para1 {
                line-height: 200%;
                padding:50px;
                margin-left: -50px;
                background-color:#FFFFFF;
                background: url("src/Info.jpg");
                width:100%;
                height:500px;
            }
            div.para1 h2 {
                color:#000000;
                text-align:left;
                font-size:45px;
                margin:100px;
                line-height:50px;
            }
            div.para1 h3{
                color:#556B2F;
            }
            div.para1 p{
                border:1px ridge white;
                text-align:center;
                width:120px; height:50px;
                margin-left:100px;
                background-color:red;
                font-size:10px;

            }
            div.para1 a {
                color: #000000;
                width: 100px;
                padding: 10px;
                text-decoration: none;
                display: block;
            }

            div.para2 {
                margin:10px; 
                display:inline;
            }

            div.boderPara2 {
                margin:15px;
                font-size: 30px;
                font-family: Arial;
            }

            div.boderPara2 a{
                text-decoration : none;
                color: #20B2AA;
            }
            
            div.boderPara2 a:hover{
                text-decoration: underline;
                color: crimson;
            }


        </style>
    </head>
    <body>
        <%
            HttpSession s = request.getSession(true);
            String us = (String) s.getAttribute("username");
            String admin = (String) s.getAttribute("admin");
        %>
        <!-- START HEADER -->
        <div id="header" style="height: 120px; margin: 0 auto; background-color:#000000;">
            <div>
                <h1 style="float:left; margin-left:50px">
                    <span style=""><a href="home" style="text-decoration:none;font-weight:bold;font-size:50px;color:red">HZ</a> </span>
                    <span style=""><a href="home" style="text-decoration:none;font-weight:bold;font-size:50px;color:#ABABAB">Computer</a></span>
                </h1>
                <p style="float:left;margin-top: 70px;font-weight: 900px;margin-left: 5px;word-spacing: 2px;color:red;font-size:15px;">
                    Gaming Store
                </p>
            </div>
        </div>
        <!-- END HEADER -->

        <!-- START MENU -->
        <section id="menuContaniner">
            <ul class="main_nav">

                <% if (us != null) {%>
                <li><a  href="about" >About</a></li>
                <li><a  href="shop" >Shop</a></li>

                <% if (admin != null) {%>
                <li><a  href="manager">Manager account</a></li>
                <li><a  href="manageritem">Manager Product</a></li>
                    <%} else {%>
                <li><a  href="cart">My Order</a></li><%}%>
                <li><a  href="logout">Logout</a></li>
                    <%} else {%>
                <li><a  href="about">About </a></li>
                <li><a  href="shop">Shop</a></li>
                <li><a  href="login">Login</a></li>
                <li><a  href="register">Register</a></li>
                <li><a  href="contact">Contact</a></li>
                    <%}%>
            </ul>
        </section>	
        <!-- END MENU -->
        <!-- START CONTENT PAGE -->
        <section id="mainContainer">

            <div class="para1">

                <h2><span style="color:#32CD32">Gaming</span> Gear</br></h2>
                <h3>We bring the best choice for you.</br>Browse our signature products and get your next order at your door now.
                </h3>
                <p><a href="about"> OUR STORY </a></p>
            </div>
            <!-- PARA 2 -->
            <div class="para2">
                <span style="padding-right:12px;">
                    <img src="src/Q1.png"style="width:500px;height:400px;">
                </span>
                <span style="padding-right:10px;">
                    <img src="src/Q2.png" style="width:500px;height:400px;">
                </span>
                <span style="padding-right:12px;">
                    <img src="src/Q3.png"  style="width:500px;height:400px;">
                </span>
                <span style="padding-left:350px;">
                    <img src="src/Q4.png"style="width:500px;height:400px;">
                </span>
            </div>  
            <div class="boderPara2">	
                <span style="float:center;padding-left:550px;"><a href="shop">ORDER HERE</a></span>
            </div>
        </section>
        <!-- end page -->
        <!-- start Footer-->
        <div id="footer" style="height: 220px; margin: 0 auto;padding: 0 20px;background-color: #D3D3D3; border: none solid #8C0209;">
            <p style="float:right;margin:30px;font-size:50px;margin-right:200px;"> <span style="color:red">HZ</span><span style="color:#000000"> Computer</span></p>
            <p style="float:right;margin-top:120px;margin-right:-260px;">
                <a href="https://www.instagram.com/"><img src="src/ins.png" style="width:65px; height:65px;"></img>
                <a href="https://www.facebook.com/"><img src="src/fb.png" style="width:65px; height:65px;"></img>
            </p>
            <p style="float:left;margin-top:20px;margin-left:100px;text-align:left;font-size:20px;"><br/>
                <span style="padding-left:100px;"><a href="about">MORE ABOUT US</a></span><br/>
                <span style="padding-left:100px;"><a href="contact">CONTACT</a></span><br/>
            </p>
        </div>
    </body>
</html>


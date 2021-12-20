<%-- 
    Document   : Login
    Created on : Jan 24, 2021, 9:07:27 PM
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
                margin-top: 20px;padding: 0;
                background: #FFFFFF;
                text-align: justify;
                font-family: "Helvetica Neue", "Lucida Grande", "Segoe UI", Arial, Helvetica, Verdana, sans-serif;
                font-size:  0.875em;
                color: #616161;	
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

            /* Menu */

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
                width: 1200px;
                height:100%;
                margin: 40px auto;
                padding: 20px 5px;
                background: #FFFACD;
                boder:10px solid black;
            }
            /* about */
            div.about {
                boder: 10px solid pink;
                text-align: center;
            }
        </style>

        <%
            HttpSession s = request.getSession(true);
            String us = (String) s.getAttribute("username");
            String admin = (String) s.getAttribute("admin");
        %>
    </head>

    <body>
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
                <li ><a  href="about" >About</a></li>
                <li ><a  href="shop">Shop</a></li>

                <% if (admin != null) {%>
                <li ><a  href="manager">Manager account</a></li>
                <li ><a  href="manageritem">Manager Product</a></li>
                    <%} else {%>
                <li ><a  href="cart">My Order</a></li><%}%>
                <li ><a  href="logout">Logout</a></li>
                    <%} else {%>
                <li ><a  href="about">About </a></li>
                <li ><a  href="shop">Shop</a></li>
                <li ><a  href="login">Login</a></li>
                <li ><a  href="register">Register</a></li>
                <li ><a  href="contact">Contact</a></li>
                    <%}%>
            </ul>
        </section>	
        <!-- END MENU -->

        <!-- START CONTENT PAGE -->
        <section id="mainContainer">
            <div class="about" >
                <h2 style="font-size:50px;font-family:Time New Roman">ABOUT US</h2>
                <div style="margin-top:20px;font-family:Candara;padding-left:210px;width:800px;font-size:20px;color:#556B2F;line-height:2em;">HZ Computer was established in 2015 and was certified by 
                                the Ministry of Science and Technology No. 99999 on July 25, 2019.
                            HZ Computer is a store operating in the business of gaming computer components 
                            and accessories. HZ Computer has achieved many successes, building a system of 
                            customers and partners nationwide, and known by customers and partners as a 
                            leading professional and prestigious computer store in Vietnam.
                            <br/>Currently, HZ Computer has been a partner of global technology 
                            firms and major distributors such as Dell, Intel, IBM, HP, Lenovo, Sony, Samsung, LG, Toshiba, Acer, AMP, Apple, ...
                </div>
                <div style="margin-top:50px;">
                    <img src="src/companies.png" style="width:1000px;height:500px;"></img>
                </div>
            </div>
        </section>
        <!-- end page -->

        <!-- start Footer-->
        <div id="footer" style="height: 220px; margin: 0 auto;padding: 0 20px;
             background-color: #D3D3D3; border: none solid #8C0209;">
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
        <!-- end page -->                   
    </body>
</html>



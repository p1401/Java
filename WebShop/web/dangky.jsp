<%-- 
    Document   : Login
    Created on : Jan 24, 2021, 9:00:56 PM
    Author     : duyph
--%>

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
                height: 100%;
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

            /* REGISTER FORM*/
            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 6px;
                margin-bottom: 16px;
                resize: vertical;
            }
            input[type=password], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 6px;
                margin-bottom: 16px;
                resize: vertical;
            }

            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                border-radius: 0px;
                background-color: #f2f2f2;
                padding: 20px;
                width:500px;
                margin-left:350px;
                margin-top: 50px;
                text-align:left;
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
                <h2 style="font-size:45px;font-family:Time New Roman">SIGN UP</h2>
                <div class="container">
                    <form action="register" method="POST">
                        <label>Username</label>
                        <input type="text"  name="username" value="${users.username}" required placeholder="Your username..">

                        <label>Password</label>
                        <input type="password"   name="password" required placeholder="Your password..">

                        <label>Re-enter Password</label>
                        <input type="password" name="repassword" required placeholder="Your re-enter password..">

                        <label>Email</label>
                        <input type="text"  name="email" value="${users.email}" required placeholder="Your email..">

                        <label>Phone</label>
                        <input type="text"  name="phone" value="${users.phone}" required placeholder="Your phone..">

                        <input type="submit" value="Save">

                        <%
                            if (request.getAttribute("errorMessage") != null) {
                        %>
                        <h2 style="color: red"><%= request.getAttribute("errorMessage")%></h2>
                        <%
                            }
                        %>

                    </form>
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


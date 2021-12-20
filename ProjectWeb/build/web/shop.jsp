<%-- 
    Document   : shop
    Created on : Aug 22, 2019, 3:25:14 PM
    Author     : sony
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
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
            
            footer{
                position: relative;
                width: 100%;
                display: flex;
                justify-content: space-between;
                flex-wrap: wrap;
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
                background: #f1f1f1;
                boder:10px solid black;
            }

            div.about {
                boder: 10px solid pink;
                text-align: center;
            }
            /* shop */
            .product {
                /*              position: absolute;*/
                top: 50%;
                left: 50%;
                transform: translate(0,0);
                width: 240px;
                height: 300px;
                background: #fff;
                box-shadow: 0 5px 15px rgba(0,0,0,.25);
                border-radius: 5px;
                overflow: hidden;
                margin: 35px;
            }
            .product .imgbox {
                height: 100%;
                box-sizing: border-box;
            }
            .product .imgbox img {
                display: block;
                width: 99%;
                margin: 20px auto 0;
            }
            .details {
                position: absolute;
                width: 100%;
                bottom: -50px;
                background: #fff; 
                padding: 10px;
                box-sizing: border-box;
                box-shadow: 0 0 0 rgba(0,0,0,0);
                transition: .5s;
            }/*
            */            
            .product:hover .details {
                bottom: 0;
            }
            .details h2 {
                margin: 0;
                padding: 0;
                font-size: 16px;
                width: 100%;
            }
            .details h2 span {
                font-size: 13px;
                color: #ccc;
                font-weight: normal;
            }
            .details .price {
                /*                position: absolute;*/
                top: 10px;
                right: 10px;
                font-weight: bold;
                color: #ff4faf;
                font-size: 20px;  
            }/*
            */          
            .details a{
                display: block;
                padding: 5px;
                color: #fff;
                margin: 15px 0 0;
                background: #ff4faf;
                text-align: center;
                text-decoration: none;
                transition: .3s;
                cursor: pointer;
            }
            .details a:hover {
                background: #ff209a; 
            }

            .products ul,.products ul li {
                list-style: none;
                display: inline-block;
            }
        </style>

        <%
            HttpSession s = request.getSession(true);
            String us = (String) s.getAttribute("username");
            String admin = (String) s.getAttribute("admin");
            ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("listProduct");
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
            <div class="about" >
                <h2 style="font-size:45px;font-family:Time New Roman">WELCOME TO OUR SHOP</h2>
                <div class="products">
                    <% for (Product p : list) {%>
                    <ul>
                        <li>
                            <div class="product">
                                <div class="imgbox">
                                    <img src="img/<%=p.getProductImage()%>">
                                </div>
                                <div class="details">
                                    <h2> <%=p.getProductName()%><br><span>Product ID: <%=p.getProductID()%></span></h2>
                                    <div class="price"> <%=p.getProductPrice()%> </div>
                                    <a href="detail?pid=<%=p.getProductID()%>&price=<%=p.getProductPrice()%>"> See Detail </a>
                                </div>
                            </div>
                        </li>
                    </ul>
                    <% }%>
                    <div class="page">
                        <p><c:forEach begin="1" end="${maxPage}" var="i">
                                <a href="shop?txtPage=${i}">${i}</a>
                            </c:forEach></p>
                    </div>
                </div>


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
<%-- 
    Document   : Login
    Created on : Jan 24, 2021, 7:33:23 PM
    Author     : duyph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>HZ Computer</title>
        <link rel="shortcut icon" href="src/favicon.ico">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
        body {
            font-family: 'Mukta', sans-serif;
            background: url("src/background.jpg")      no-repeat ;
            background-size: 2000px 1000px;
        }

        /*/////////////// FONT STYLES ////////////////////*/
        .content-all {
            max-width: 500px;
            position: relative;
            margin: 200px auto;
            width: 50%;
            background-color: whitesmoke;
            border-radius: 20px;
        }
        .content-bottom {
            padding: 40px 40px;
            margin: 10px 10px;
            position: relative; 
        }

        /*/////////////// FORM STYLES ////////////////////*/

        form .field-group {
            background: rgba(255, 255, 255, 0.15);
            display: flex;
            margin-bottom: 20px;
            padding: 2px 10px 2px 0;
        }

        .field input {
            padding: 10px 0 10px 15px;
            font-size: 17px;
            font-weight: 300;
            letter-spacing: 1px;
            background: transparent;
            font-family: 'Mukta', sans-serif;
            width: 380.25px;
            background-color: #ccc;
        }
        
        .field input:hover{
            background-color: white;
        }

        form .register a {
            font-size: 15px;
            letter-spacing: 2px;
            font-weight: normal;
            text-transform: uppercase;
            color: red !important;

        }

    </style>
    <body>
        <div class="content-all">
            <div class="content-bottom">
                <form action="login" method="post">
                    <div>
                        <a href="home"><img src="src/log.png" style="margin-left: 100px;margin-top:-80px;width:200px;height:200px;"></img></a>
                    </div>
                    <div class="field-group">
                        <span aria-hidden="true"></span>
                        <div class="field">
                            <input name="username" id="text1" type="text" value="" placeholder="Username" required >
                        </div>
                    </div>
                    <div class="field-group">
                        <span aria-hidden="true"></span>
                        <div class="field">
                            <input name="password" id="myInput" type="Password" placeholder="Password" required >
                        </div>
                    </div>
                    <div class="field" style="margin-left: 10px">
                        <input type="submit" class="btn" value="LOGIN">
                    </div>
                    <div class="register" style="margin-left: 120px;margin-top: 15px; ">
                        <a href="register">CREATE ACCOUNT</a>
                    </div>
                </form>

                <%
                    if (request.getAttribute("errorMessage") != null) {
                %>
                <h2 style="color: red"><%= request.getAttribute("errorMessage")%></h2>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>


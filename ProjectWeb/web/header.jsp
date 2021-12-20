<%-- 
    Document   : header
    Created on : Jan 25, 2021, 4:09:03 PM
    Author     : nam
--%>

<%@page import="entity.user"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.DAO"%>
<%@page import="entity.account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel ='stylesheet' href='css/header.css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <style>
            .dropdown{
                position: relative;
                display: inline-block;
            }
            .dropdown-content{
                display: none;
                position: absolute;
                background-color: #f5f5f5;
                z-index: 1;
                list-style: none;
            }
            .dropdown:hover .dropdown-content{
                display: inline-block;
            }
            .dropdown:active .dropdown-content{
                display: inline-block;
            }
            .dropdown-item {
                display: block;
                width: 100%;
                padding: .25rem 1.5rem;
                clear: both;
                font-weight: 400;
                color: #212529;
                text-align: inherit;
                white-space: nowrap;
                background-color: transparent;
                border: 0;
            }
        </style>
    </head>
    <body>
        <%HttpSession ses = request.getSession();
            Object a = ses.getAttribute("account");
        %>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: black">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto" style="float: right">
                    <li class="nav-item" ><a class="nav-link" style="color: white" href="contact.jsp">  Tìm cửa hàng  </a></li>&nbsp;
                    <%if (a == null) {%>
                    <li class="nav-item"><a class="nav-link" style="color: white" href="login.jsp">   Đăng nhập   </a></li>&nbsp;
                        <%} else {
                            account acc = (account) a;
                            user u = (user) ses.getAttribute("user");
                        %>
                    <li class="nav-item dropdown">
                        <a class="nav-link" style="color: white" href="#" id="navbarDropdown">  Hello <%=u.getLastName()%>  </a>
                        <div class="dropdown-content">
                            <%if (acc.isAdmin()) {%>
                            <a class="dropdown-item" href="AdminUserControl">Quản lý User</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="ManagerProductControl">Quản lý Sản Phẩm</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="BillControl">Đơn hàng</a>
                            <%} else {%>
                            <a class="dropdown-item" href="ManagerUserControl">Quản lý Tài khoản</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="HistoryControl">Lịch sử mua</a>
                            <%}%>
                        </div>
                    </li>&nbsp;
                    <li class="nav-item"><a class="nav-link" style="color: white" href="LogOutControl">  Đăng xuất  </a></li>&nbsp;
                    <%}%>
                    <li class="nav-item">
                        <c:if test="${account.admin != true}">
                            <a class="nav-link" style="color: white" href="CartControl">  Giỏ hàng  </a>
                        </c:if>
                    </li>&nbsp;
                </ul>
            </div>
        </nav>
        <div class="header2">
            <div>
                <div class="left" style="margin-left: 100px">
                    <a href="HomeControl"><img src="image/logo.png" style="width:100%;height: 50%;"></a>
                </div>
                <div class="left" style="margin-left: 100px;margin-top: 50px">
                    <ul class="menu">
                        <li><a href="CategoryControl?cate=2">Sale Off</a></li>
                        <li><a href="CategoryControl?gender=0">Nữ</a></li>
                        <li><a href="CategoryControl?gender=1">Nam</a></li>
                        <li><a href="ProductListControl">Sản phẩm</a></li>
                    </ul>
                </div>
                <div class="right" style="margin-right: 20px">
                    <form class="example" action="SearchControl" style="margin: 40px" method="post">
                        <input type="text" placeholder="Search.." name="search" value="${txtSearch}">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>
        </div>
        <script src="jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>

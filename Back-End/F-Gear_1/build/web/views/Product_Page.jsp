<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>F-GEAR</title>
        <link rel="icon" href="./assets/Images/pinterest_board_photo.png">
        <link rel="stylesheet" href="../assets/CSS/Product_Page.css">
        <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
        <link rel="stylesheet" href="../assets/CSS/Responive.css">
        <link rel="stylesheet" href="../assets/CSS/Homepage.css">
        <!-- Font Awesome link-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap link-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    </head>

    <body>
        <%@include file="Header.jsp" %>

        <div class="container-fluid">
            <div class="row text-center" style="z-index:10;">
                <div class="image-wrapper col-xl-12 col-md-12 col-lg-12 col-sm-12 col-12 "
                     style="width:100% ; min-height: 200px;">
                    <img src="../assets/Images/676vn_1890_cls_18aa655da8844630bd62a071e80d5ace.webp" alt=""
                         class="image-represent" style="width:100% ; height:100%;">
                </div>
            </div>
            <div class="row" style="margin-top:40px;">
                <div class="product-title-wrapper">
                    <h2 class="product-title">Your world in here</h2>
                </div>
            </div>
            <div class="row">
                <div class="filter-wrapper">
                    <form action="" class="filter-form">
                        <select name="sort_by" id="filter-list" class="filter-list">
                            <option value="None" class="filter-item">Filter product</option>
                            <option value="price_ASC" class="filter-item">Price Ascending</option>
                            <option value="price_DESC" class="filter-item">Price Descending</option>
                            <option value="Letter_A-Z" class="filter-item">Letter A-Z</option>
                            <option value="Letter_Z-A" class="filter-item">Letter Z-A</option>
                        </select>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="product-wrapper " style="display: none;">
                    <div class="products">
                        <c:forEach var="product" items="${listOfProduct}" >
                            <div class="product-item col-lg-2 col-xl-2 col-md-4 col-sm-6 col-12">
                                <img src="${product.listImage.get(0).url}"
                                     alt="" class="product-item_image">

                                <div class="image-redirect">
                                    <span class="product-name text-center" style="color:#0033ff;">${product.proName}</span>
                                    <a href="../Detail?proID=${product.proID}" class="image-redirect_link">View detail</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="product-list-wrapper ">
                    <div class="product-list">


                    </div>
                </div>
            </div>
            <div class="row" style="margin-bottom:30px;">
                <div class="paging-wrapper">
                    <div class="paging-icon change-prev">
                        <i class="fa-solid fa-angles-left"></i>
                    </div>
                    <div class="page-index">
                        <ul class="index-list">
                        </ul>
                    </div>
                    <div class="paging-icon ">
                        <i class="fa-solid fa-angles-right change-next"></i>
                    </div>
                </div>
            </div>
            <%@include file="./Footer.jsp" %>

        </div>
    </body>
    <script src="./assets/JavaScript/CommonFeatures.js"></script>
    <script src="../assets/JavaScript/Product_Page.js"></script>
    <script src="../assets/JavaScript/Homepage.js"></script>

</html>
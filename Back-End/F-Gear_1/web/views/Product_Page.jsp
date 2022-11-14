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
        <link rel="stylesheet" href="../assets/CSS/Responive.css">
        <link rel="stylesheet" href="../assets/CSS/Header.css">
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
            <!-- Header -->
            <!--        <div class="row header">
                        <header class="header-wrapper col-lg-11 col-sm-11 col-md-11 col-xl-11 col-11" style="height:100px;">
                            <div class="header-logo  col-6 col-sm-6 col-md-4 col-lg-2 col-xl-2" style="height:100%;">
                                <a href="" class="header-logo_link">
                                    <img src="Assets/Images/Logo_After_Login.png" alt="F-Gear" class="header-logo_image center">
                                </a>
                            </div>
                            <div class="header-navigator col-6 col-sm-6 col-md-7 col-lg-10 col-xl-10 " style="height:100%;">
                                <div class="btn-menu" style="display:none; height:100%;cursor: pointer;">
                                    <i class="fa-solid fa-bars"></i>
                                </div>
                                <div class="navigator-wrapper">
                                    <div class="navigator-wrapper-inner">
                                        <div class="navigator-page col-lg-6 col-xl-7">
                                            <nav class="navigator">
                                                <ul class="navigator-list">
                                                    <li class="navigator-item">
                                                        <a href="" class="navigator-item_link active">Home</a>
                                                    </li>
                                                    <li class="navigator-item">
                                                        <a href="" class="navigator-item_link">Store</a>
                                                    </li>
                                                    <li class="navigator-item">
                                                        <a href="" class="navigator-item_link">Sale</a>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                        <div class="navigatior-user">
                                            <div class="user navigator-user-cart">
                                                <a href="" class="user-cart_link" style="color: #333;font-size: 1.6rem;">
                                                    <i class="fa-solid fa-cart-shopping"></i>
                                                </a>
                                            </div>
                                            <div class=" user navigator-user-account">
                                                <div class="user-account-avatar">
                                                    <img src="Assets/Images/280013939_368144518688847_7624068726298628073_n.jpg"
                                                        alt="VietHoang" class="user-account-image">
                                                </div>
                                                <div class="user-welcome">
                                                    <span class="welcome-content">Welcome viethoang</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
            
                        </header>
                    </div>-->
            <!-- Make a white space which is buffered for height because header has position is fixed -->
            <!--        <div class="row ">
                        <div class="white-space">
            
                        </div>
                    </div>-->
            <!-- Categories sidebar -->
            <!--        <div class="row sidebar-wrapper " style="background-color:#fff;">
                        <div class=" btn-nav">
                            <div class="navigator-btn_menu"><i class="fa-solid fa-bars"></i></div>
                            <div class="btn-navigator-list col-lg-5  col-md-5 col-xl-5">
                                <div class="btn-navigator-item col-lg-1 col-md-1 col-xl-1 ">
                                    <button class="item-btn categories-btn">
                                        <i class="fa-sharp fa-solid fa-list"></i>
                                        <span class="btn-content">Categories</span>
                                    </button>
                                    <div class="kinds-product-wrapper">
                                        <div class="kinds-product">
                                            <ul class="kinds-product-list">
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
                                                <li class="kind-prodict-item">
                                                    <i class="fa-solid fa-laptop"></i>
                                                    <a href="" class="kind-product-link">Laptop Gaming</a>
                                                </li>
            
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="btn-navigator-item col-lg-1 col-md-1 col-xl-1 ">
                                    <button class="item-btn">
                                        <i class="fa-solid fa-credit-card"></i>
                                        <span class="btn-content payment">Payment guidlines</span>
                                    </button>
                                </div>
                                <div class="btn-navigator-item col-lg-1 col-md-1 col-xl-1 ">
                                    <button class="item-btn">
                                        <i class="fa-solid fa-screwdriver-wrench"></i>
                                        <span class="btn-content ">Maintenance policy</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>-->
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
                                    <a href="../Detail/DetailPro?proID=${product.proID}" class="image-redirect_link">View detail</a>
                                </div>
                                <c:set var = "discount" value = "${product.discount}"/>
                                <c:if test = "${discount != 0}">
                                    <div class="discount-wrapper">
                                        <span class="discount-context">Saling</span>
                                    </div>
                                </c:if>
                                

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
﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
    <link rel="stylesheet" href="../assets/CSS/Responive.css">
    <link rel="stylesheet" href="../assets/CSS/Detail_Product.css">

    <link rel="icon" href="../assets/Assets/Images/pinterest_board_photo.png">
    <!-- Font Awesome link-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- Bootstrap link-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>

<body>
    <div class="container-fluid">
        <!-- Header -->
        <div class="row header">
            <header class="header-wrapper col-lg-11 col-sm-11 col-md-11 col-xl-11 col-11" style="height:100px;">
                <div class="header-logo  col-6 col-sm-6 col-md-4 col-lg-2 col-xl-2" style="height:100%;">
                    <a href="" class="header-logo_link">
                        <img src="../assets/Images/Logo_After_Login.png" alt="F-Gear" class="header-logo_image center">
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
                                            <a href="../views/Homepage.jsp" class="navigator-item_link active">Home</a>
                                        </li>
                                        <li class="navigator-item">
                                            <a href="../views/Product_Page.jsp" class="navigator-item_link">Store</a>
                                        </li>
                                        <li class="navigator-item">
                                            <a href="" class="navigator-item_link">Sale</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="navigatior-user">
                                <div class="user navigator-user-cart">
                                    <a href="../views/Cart.jsp" class="user-cart_link" style="color: #333;font-size: 1.6rem;">
                                        <i class="fa-solid fa-cart-shopping"></i>
                                    </a>
                                </div>
                                <div class=" user navigator-user-account">
                                    <div class="user-account-avatar">
                                        <img src="../assets/Images/280013939_368144518688847_7624068726298628073_n.jpg"
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
        </div>
        <!-- Make a white space which is buffered for height because header has position is fixed -->
        <div class="row ">
            <div class="white-space">

            </div>
        </div>
        <!-- Categories sidebar -->
        <div class="row sidebar-wrapper " style="background-color:#fff;">
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
        </div>
    </div>
</body>


<script src="./assets/JavaScript/CommonFeatures.js"></script>
</html>
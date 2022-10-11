<!DOCTYPE html>
﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>F-GEAR</title>
        <link rel="icon" href="../assets/Images/pinterest_board_photo.png">
        <link rel="stylesheet" href="../assets/CSS/Cart.css">
        <link rel="stylesheet" href="../assets/CSS/Header.css">
        <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
        <link rel="stylesheet" href="../assets/CSS/Responive.css">
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
            </div>
            <!-- Make a white space which is buffered for height because header has position is fixed -->
            <%@include file="./Header.jsp" %>

            <div class="row" style="margin-top: 100px;margin-left:100px;">
                <div class="backward-button-wrapper">
                    <button class="backward_link">
                        <i class="fa-solid fa-chevron-left"></i>
                        <span class="backward-content" style="margin-left:15px ;">Go back to store</span>
                    </button>
                </div>
            </div>
            <div class="row">
                <div class="logo-wrapper">
                    <img src="" alt="" class="logo-image">
                </div>
            </div>
            <div class="row " style="width:800px;display: flex;justify-content:center; height:400px;margin-bottom: 135px;">
                <div class="cart-table-wrapper" style="width:1102px;height:100%;">
                    <div class="cart-table" style="width:100%;height:100%;overflow-y:scroll ;">
                        <table class="table" style="width:100%;height:100%;margin-bottom: 0;">
                            <thead class="text-center">
                                <tr>
                                    <th scope="col">Product name</th>
                                    <th scope="col">Image</th>
                                    <th scope="col">Amount</th>
                                    <th scope="col">Price</th>

                                    <th scope="col">Warranty period</th>
                                    <th scope="col"></th>

                                </tr>
                            </thead>
                            <tbody style="vertical-align: middle;text-align:center;">
                                <tr class="table-row">
                                    <th scope="row" class="cart-item_name">Laptop MSI Gaming</th>
                                    <td class="cart-item_image">
                                        <img src="../assets/Images/p-acer-aspire-3-a315-42-r8px-2_437eed7003ca40a2a05a60d2356089c6_grande_ec84095863e94a38a2aa943d27b28e49.webp"
                                             alt="" class="product-image img-responsive" style="width:120px;">
                                    </td>
                                    <td class="cart-item_amount">
                                        <div class="item-wrapper">
                                            <div class="btn btn-decreasing">
                                                <button class="descring_amount">
                                                    <i class="fa-solid fa-minus"></i>
                                                </button>
                                            </div>
                                            <div class="amount-wrapper">
                                                <span class="amount-content" style="font-size:1.5rem;"></span>
                                            </div>
                                            <div class="btn btn-increasing">
                                                <button class="descring_amount">
                                                    <i class="fa-solid fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="cart-item_price">16.000.000 đ</td>

                                    <td class="cart-item_warranty">2 years</td>
                                    <td class="remove-cart" style="font-size: 1.6rem;cursor: pointer;">
                                        <a href="?removeItem=true" class="remove-cart_link">
                                            <!-- Put id of item in here,it will send to servlet-->
                                            <i class="fa-solid fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                                <tr class="table-row">
                                    <th scope="row" class="cart-item_name">Laptop MSI Gaming</th>
                                    <td class="cart-item_image">
                                        <img src="../assets/Images/p-acer-aspire-3-a315-42-r8px-2_437eed7003ca40a2a05a60d2356089c6_grande_ec84095863e94a38a2aa943d27b28e49.webp"
                                             alt="" class="product-image img-responsive" style="width:120px;">
                                    </td>
                                    <td class="cart-item_amount">
                                        <div class="item-wrapper">
                                            <div class="btn btn-decreasing">
                                                <button class="descring_amount">
                                                    <i class="fa-solid fa-minus"></i>
                                                </button>
                                            </div>
                                            <div class="amount-wrapper">
                                                <span class="amount-content" style="font-size:1.5rem;"></span>
                                            </div>
                                            <div class="btn btn-increasing">
                                                <button class="descring_amount">
                                                    <i class="fa-solid fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="cart-item_price">16.000.000 đ</td>

                                    <td class="cart-item_warranty">2 years</td>
                                    <td class="remove-cart" style="font-size: 1.6rem;cursor: pointer;">
                                        <a href="?removeItem=true" class="remove-cart_link">
                                            <!-- Put id of item in here,it will send to servlet-->
                                            <i class="fa-solid fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="checkout-wrapper" style="margin-top: 30px;">
                        <button class="checkout-btn">Choose your payment method</button>
                        <div class="modal-wrapper">
                            <div class="modal-content">
                                <div class="modal-form-wrapper">
                                    <div class="modal-title">
                                        <span class="modal-title" style="margin-bottom:30px;font-size: 1.4rem;">Choose your payment method</span>
                                        <i class="fa-solid fa-xmark close-icon" style="font-size:2rem;margin-left: 70px; margin-bottom:30px;cursor: pointer;"></i>
                                    </div>
                                    <form action="" class="modal-form">
                                        <div class="input-wrapper">
                                            <input type="radio" name="payment" id="store" class="input-select"
                                                   value="store">
                                            <label for="store" class="input-label">Pay at store</label>
                                        </div>
                                        <div class="input-wrapper">
                                            <input type="radio" name="payment" id="e-wallet" class="input-select"
                                                   value="e-wallet">
                                            <label for="e-wallet" class="input-label">Pay with VN-Pay </label>
                                        </div>
                                        <button class="checkout-btn">Check-out</button>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="./Footer.jsp" %>

        </div>
    </body>
    <script src="../assets/JavaScript/CommonFeatures.js"></script>
    <script src="../assets/JavaScript/Cart.js"></script>

</html>
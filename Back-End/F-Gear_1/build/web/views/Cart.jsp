<!DOCTYPE html>
﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <style>
        /* Chrome, Safari, Edge, Opera */
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        /* Firefox */
        input[type=number] {
            -moz-appearance: textfield;
        }
    </style>
    <body>
        
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
            <div>
                <form action="../Cart">
                    <button class="backward_link" name="orderOp" value="clearAll" style="margin-top: 25px;margin-left:110px">Clear All Item</button>
                </form>
            </div>
            <div style="margin-left: 110px">
                <br/>
                <span>
                    <h5 style="color: red;">Total Price: <fmt:formatNumber type = "number" maxFractionDigits = "3" value="${sessionScope.total}"/> vnd</h5>                
                </span>
                <br/>
                <span>
                    <h5 style="color: red;">Total Quantity: <fmt:formatNumber type = "number" maxFractionDigits = "3" value="${sessionScope.quantity}"/></h5>                
                </span> 
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
                                <c:set var="o" value="${sessionScope.cart}"></c:set>
                                <c:forEach items="${o}" var="i">
                                    <tr class="table-row">
                                        <th scope="row" class="cart-item_name">${i.product.proName}</th>
                                        <td class="cart-item_image">
                                            <img src="${i.product.listImage.get(0).url}"
                                                 alt="" class="product-image img-responsive" style="width:120px;">
                                        </td>
                                <form action="../Cart">
                                    <td class="cart-item_amount">
                                        <div class="item-wrapper">
                                            <div >
                                                <form action="../Cart">
                                                    <button type="submit" name="orderOp" value="decreasing">
                                                        <input type="hidden" name="proID" value="${i.product.proID}">
                                                        <input type="hidden" name="quantity" value="${i.quantity}">
                                                        <i class="fa-solid fa-minus"></i>
                                                    </button>
                                                </form>
                                            </div>
                                            <div>
                                                <form action="../Cart">
                                                    <input type="hidden" name="proID" value="${i.product.proID}">
                                                    <input style="width: 40px;" type="number" min="1" name="quantity" value="${i.quantity}" required="">
                                                    <input type="submit" name="orderOp" value="inputQuantity" style="display: none">
                                                </form>                                      
                                            </div>
                                            <div >
                                                <form action="../Cart">
                                                    <button type="submit" name="orderOp" value="increasing" >
                                                        <input type="hidden" name="proID" value="${i.product.proID}">
                                                        <input type="hidden" name="quantity" value="${i.quantity}">
                                                        <i class="fa-solid fa-plus"></i>
                                                    </button>
                                                </form>
                                            </div>
                                        </div>
                                    </td>
                                </form>
                                <td class="cart-item_price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value="${i.quantity*i.price}" /> vnd</td>

                                <td class="cart-item_warranty">${i.product.guaDetail}</td>
                                <form action="../Cart">
                                    <td class="remove-cart" style="font-size: 1.6rem;cursor: pointer;">
                                        <button name="orderOp" value="remove" class="fa-solid fa-trash" style="border: none">
                                            <!-- Put id of item in here,it will send to servlet-->
                                            <input type="hidden" name="proID" value="${i.product.proID}">
                                            </td>
                                            </form>
                                            </tr>                                                                
                                        </c:forEach>                              
                                        </tbody>
                                        </table>
                                        </div>
                                        <div class="checkout-wrapper" style="margin-top: 30px;">
                                            <button style="display: ${sessionScope.cart ==null?"none":"block"}" class="checkout-btn">Choose your payment method</button>
                                            <input type="submit" disabled="" style="display: ${sessionScope.cart ==null?"block":"none"}; padding:15px 10px; border-radius: 10px" value="Choose your payment method"/>

                                            <div class="modal-wrapper">
                                                <div class="modal-content">
                                                    <div class="modal-form-wrapper">
                                                        <div class="modal-title">
                                                            <span class="modal-title" style="margin-bottom:30px;font-size: 1.4rem;">Choose your payment method</span>
                                                            <i class="fa-solid fa-xmark close-icon" style="font-size:2rem;margin-left: 70px; margin-bottom:30px;cursor: pointer;"></i>
                                                        </div>
                                                        <form  action="../PaymentController" class="modal-form">
                                                            <div class="input-wrapper">
                                                                <input type="radio" name="payment" id="store" class="input-select"
                                                                       value="store">
                                                                <label for="store" class="input-label">Pay at store</label>
                                                            </div>
                                                            <div  style="display: ${sessionScope.size >1?"none":"block"}" class="input-wrapper">
                                                                <input type="radio" name="payment" id="e-wallet" class="input-select"
                                                                       value="e-wallet">
                                                                <label for="e-wallet" class="input-label">Pay with Paypal </label>
                                                            </div>
                                                            <span style="color:red; width:90%; display:${sessionScope.size >1?"block":"none"} ">According to the new policy, you can only pay for 1 product with PayPal e-wallet</span>
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
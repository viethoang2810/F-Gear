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
    <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css">
    <!-- This file contains all of common styles of pages-->
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
    body {
        background-color: #d7d1d1;
        user-select: none;
    }

    .step::after {
        content: '';
        position: absolute;
        width: 13px;
        height: 30px;
        top: 0;
        left: -13px;
        background-color: #ffe022;
        clip-path: polygon(100% 0, 0% 100%, 100% 100%);
    }

    .step-btn {
        transition: 0.2s;
    }

    .step-btn:hover {
        scale: 110%;
    }
</style>

<body>
    <%@include file="./Header.jsp" %>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />

    <div style="width: 100%; padding: 40px 0;">
        <h1 style="text-decoration: underline; color: #e5203f;">
            I. PRODUCT WARRANTY STEPS
        </h1>
        <div
            style="width: 80%; margin: 80px 0 0 40px; box-shadow: 9px 20px 20px -8px #000; height: auto; border: 1px solid #e4e4e4; border-radius: 20px; position: relative; background-color: white; padding: 40px 20px;">
            <div class="step"
                style="width: 30%; height: 70px; background-color: #e5203f; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px; color: #fff; margin-left: 80px; position: absolute; top: -40px; display: flex; justify-content: space-around;">
                <h2 style="font-weight: bold; line-height: 70px; "></h2>
                <h4 style="font-weight: bold; line-height: 40px; text-decoration: underline;">STEP 1</h4>
            </div>
            <h4>
                When in need of product warranty, please contact FGear through the following forms:
            </h4>
            <ul>
                <li style="margin: 10px 0;">
                    <h5> Warranty call center: <span style="font-weight: bold;">1800.6173</span></h5>
                </li>
                <li style="margin: 10px 0;">
                    <h5> <span style="font-weight: bold;">Live chat</span> with FGear at Website or Fanpage</h5>
                </li>
                <li style="margin: 10px 0;">
                    <h5> <span style="font-weight: bold;">
                            Direct contact</span> at FGear Store</h5>
                </li>
            </ul>
            <div
                style="position: absolute; right: 50px; bottom: -20px; display: flex; justify-content: space-between; width: 60%;">
                <button class="step-btn"
                    style="width: 46%; padding: 0px 10px; border: none; background-color: #e5203f; border-radius: 20px; color: #fff; margin-right: 30px;">
                    📱 | Call the operator immediately
                </button>
                <button class="step-btn"
                    style="width: 46%; padding: 10px; border: none; background-color: #e5203f; border-radius: 20px; color: #fff;">
                    💬 | Call the operator immediately
                </button>
            </div>
        </div>
        <div
            style="width: 80%; margin: 80px 0 0 40px; box-shadow: 9px 20px 20px -8px #000; height: auto; border: 1px solid #e4e4e4; border-radius: 20px; position: relative; background-color: white; padding: 40px 20px;">
            <div class="step"
                style="width: 30%; height: 70px; background-color: #e5203f; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px; color: #fff; margin-left: 80px; position: absolute; top: -40px; display: flex; justify-content: space-around;">
                <h2 style="font-weight: bold; line-height: 70px; "></h2>
                <h4 style="font-weight: bold; line-height: 40px; text-decoration: underline;">STEP 2</h4>
            </div>
            <h4>
                You send the product or bring the product in need of warranty to:
            </h4>
            <h5 style="color: #e5203f;">
                <span> Southern area:</span><br>
                WARRANTY CENTER FGEAR
            </h5>
            <h5 style="color: #e5203f;">
                <span> Northern area:</span><br>
                SHOWROOM FGEAR THAI HA
            </h5>
        </div>
        <div
            style="width: 80%; margin: 80px 0 0 40px; box-shadow: 9px 20px 20px -8px #000; height: auto; border: 1px solid #35c400; border-radius: 20px; position: relative; background-color: white; padding: 40px 20px;">
            <div class="step"
                style="width: 30%; height: 70px; background-color: #35c400; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px; color: #fff; margin-left: 80px; position: absolute; top: -40px; display: flex; justify-content: space-around;">
                <h2 style="font-weight: bold; line-height: 70px; "></h2>
                <h4 style="font-weight: bold; line-height: 40px; text-decoration: underline;">STEP 3</h4>
            </div>
            <h4 style="color:#35c400;">
                Complete the product warranty and hand over the product to the customer.
            </h4>
        </div>

    </div>

    <p style="color: red">The store's warranty policy is applied to each specific product group, product as follows:</p>
    <br />
    <div class="row " style="width:800px;display: flex;justify-content:center; height:400px;margin-bottom: 135px;">
        <div class="cart-table-wrapper" style="width:1102px;height:100%;">
            <div class="cart-table" style="width:100%;height:100%;overflow-y:scroll ;">
                <table class="table" style="width:100%;height:100%;margin-bottom: 0;">
                    <thead class="text-center">
                        <tr>
                            <th scope="col" style="color: red">Category Name</th>
                            <th scope="col" style="color: red">Brand Name</th>
                            <th scope="col" style="color: red">Type Warranty</th>
                            <th scope="col" style="color: red">Intend Time</th>
                            <th scope="col" style="color: red">Note</th>
                        </tr>
                    </thead>
                    <tbody style="vertical-align: middle;text-align:center;">
                        <c:forEach items="${listOfPolicy}" var="policy">
                            <tr class="table-row">
                                <td scope="row" class="cart-item_name">${policy.cateName}</td>
                                <td scope="row" class="cart-item_name">${policy.brandName}</td>
                                <td scope="row" class="cart-item_name">${policy.typePolicy}</td>
                                <td scope="row" class="cart-item_name">${policy.intendTime}</td>
                                <td scope="row" class="cart-item_name">${policy.note}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>



    <%@include file="./Footer.jsp" %>
</body>
<script src="../assets/JavaScript/CommonFeatures.js"></script>
<script src="../assets/JavaScript/Cart.js"></script>

</html>

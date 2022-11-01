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

    <body>
        <%@include file="./Header.jsp" %>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <p style="color: red">The store's warranty policy is applied to each specific product group, product as follows:</p>       
        <br/>
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
                                    <td scope="row" class="cart-item_name">${policy.typeWarranty}</td>
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

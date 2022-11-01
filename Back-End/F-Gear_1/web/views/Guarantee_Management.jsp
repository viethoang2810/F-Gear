﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>F-GEAR</title>
        <link rel="icon" href="../assets/Images/pinterest_board_photo.png">
        <link rel="stylesheet" href="../assets/CSS/Product_Management.css">
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
        .subtable {
            display: none;
        }

        .subtable-active {
            display: block;
        }
        .priceInput {
            border: 1px solid #000;
        }
        .hideSmall {
            visibility: hidden;
        }

        .priceInputError {
            border: 1px solid red;
        }

        .priceError {
            visibility: visible;
            color: red;
        }
    </style>

    <body>
        <div class="container-fluid">
            <div class="row header">
                <header class="header-wrapper">
                    <img src="../assets/Images/Logo_After_Login.png" alt="" class="header-logo">
                </header>
            </div>
            <!-- Make a white space which is buffered for height because header has position is fixed -->
            <div class="row ">
                <div class="white-space">

                </div>
                <form action="./Guarantee" style="width: 70%; margin-left: 20%;">
                    <input type="text" placeholder="Search . . ."
                           style="width: 60%; height: 40px; padding: 5px 0 5px 10px;" name="name" />
                    <button style="padding: 8px 15px; border: none; background-color: gray; color: white; border-radius: 10px;" name="adminOp" value="search">Search</button>
                </form>
            </div>
            <div class="row sidebar-row" >
                <div class="sidebar-wrapper">
                    <div class="siderbar sidebar-nav col-lg-3 col-xl-2 col-md-12 col-sm-12 col-12">
                        <div class="navigation-wrapper">
                            <ul class="navigation-list">
                                <li class="navigation-item ">
                                    <a href="../Admin/Dashboard" class="navigation-item_link">Dashbroad</a>
                                </li>
                                <li class="navigation-item">
                                    <a href="../Admin/Management" class="navigation-item_link ">Product Management</a>
                                </li>
                                <li class="navigation-item ">
                                    <a href="../Brand/*" class="navigation-item_link">Brand Management</a>
                                </li>
                                <li class="navigation-item ">
                                    <a href="../Category/*" class="navigation-item_link">Category Management</a>
                                </li>
                                <li class="navigation-item active ">
                                    <a href="../Guarantee/*" class="navigation-item_link">Guarantee Management</a>
                                </li>
                                <li class="navigation-item">
                                    <a href="../WarrantyPolicy/*" class="navigation-item_link ">Warranty Policy</a>
                                </li>                               
                            </ul>
                        </div>
                        <button class="modal-btn">Add new</button>
                        <p style="color: red">${result}<p>
                        <div class="add-modal-wrapper">
                            <div class="add-modal-content">
                                <div class="add-modal-form-wrapper">
                                    <div class="add-modal-title">
                                        <span class="modal-title" style="margin-bottom:30px;">Add new Guarantee</span>
                                        <span> <i class="fa-solid fa-xmark close-icon" style="font-size:2rem;margin-left: 70px; margin-bottom:30px;cursor: pointer;"></i></span>
                                    </div>
                                    <form action="./Guarantee" class="add-form">
                                        <div class="add-input-wrapper">
                                            <label for="detailGua" class="input-label">Guarantee Detail</label>
                                            <input required type="text" name="detailGua" id="proName"  class="input-text" value="${guarantee.detailGua}">
                                        </div>
                                        
                                        <div class="submit-wrapper"> <button id="addBtn" class="addBtn" type="submit" class="submit-btn" name="adminOp" value="create">Save</button></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-mgt_list col-lg-8 col-xl-9 col-md-12 col-sm-12 col-12 text-center" style="overflow-y:scroll ; margin: 0 auto;">
                        <table class="table">
                            <thead class="table-head">
                                <tr>
                                    <th scope="col" style="text-align: center" >Guarantee ID</th>
                                    <th scope="col" style="text-align: center">Guarantee Detail</th>
                                    <th scope="col" style="text-align: center"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="guarantee" items="${listOfGuarantee}">
                                    <tr style="vertical-align: middle;" class="table-row">
                                        <td scope="row" style="text-align: center">${guarantee.guaranteeID}</td>
                                        <td class="table-product_name" style="text-align: center">${guarantee.detailGua}</td>
                                        <td class="table-btns">
                                            <button class="btn-action btn-edit">
                                                <i class="fa-solid fa-pen-to-square"></i>
                                            </button>
<%--
                                            <button class="btn-action btn-remove">
                                                <i class="fa-solid fa-trash"></i>
                                            </button>
--%>
                                            <div class="edit-modal-wrapper" style="padding-bottom:20px;">
                                                <div class="edit-modal-content">
                                                    <div class="edit-modal-form-wrapper">
                                                        <div class="edit-modal-title">
                                                            <span class="modal-title" style="margin-bottom:30px;">Update Guarantee </span>
                                                            <span> <i class="fa-solid fa-xmark exit-icon" style="font-size:2rem;margin-left: 70px; margin-bottom:30px;cursor: pointer;"></i></span>
                                                        </div>
                                                        <form action="./Guarantee" class="edit-modal-form"  method="POST">
                                                            <input type="hidden" name="gua_ID" class="product-id" value="${guarantee.guaranteeID}">
                                                            <div class="edit-input-wrapper">
                                                                <label for="proName" class="input-label">Name product</label>
                                                                <input type="text" name="detailGua" value="${guarantee.detailGua}" id="proName" class="input-text productName" required="" >
                                                            </div>
                                                            
                                                            <!-- Put id of product here-->
                                                            <button type="submit" class="edit-modal-btn-action" name="adminOp"
                                                                    value="updated">Update Guarantee</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-wrapper">
                                                <div class="modal-content">
                                                    <div class="modal-form-wrapper">
                                                        <span class="confirm-annotation" style="margin-bottom:30px;">You really
                                                            want remove product ${product.proID}</span>
                                                        <form action="../Admin/Management" class="modal-form" method="POST">
                                                            <input type="hidden" name="product_id" class="product-id" value="${product.proID}">
                                                            <!-- Put id of product here-->
                                                            <button type="submit" class="modal-btn-action" name="adminOp"
                                                                    value="remove">Confirm</button>
                                                            <button type="submit" class="modal-btn-action" name="adminOp"
                                                                    value="cancel">Cancel</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <%@include file="./Footer.jsp" %>

        </div>
    </body>
    <script type="module" src="../assets/JavaScript/Guarantee_Brand_Category_Management.js"></script>
</html>
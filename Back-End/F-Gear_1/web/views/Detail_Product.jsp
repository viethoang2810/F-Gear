<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
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
        <link rel="stylesheet" href="../assets/CSS/Detail_Product.css">
        <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
        <link rel="stylesheet" href="../assets/CSS/Responive.css">
        <<link rel="stylesheet" href="../assets/CSS/Homepage.css"/>
        <!-- Font Awesome link-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap link-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    </head>

    <body style="position: relative;">
        <%@include file="Header.jsp" %>

        <div class="container-fluid">

            <!-- Make a white space which is buffered for height because header has position is fixed -->
            <div class="row " >
                <div class="white-space">

                </div>
            </div>
            <%
                HttpSession sesstion = request.getSession();
                if (session.getAttribute("checkAdded") != null) {
                    if ((boolean) session.getAttribute("checkAdded")) {
                        out.println(" <div class=' pop-up-wrapper'>");
                        out.println("<div class='pop-up-content'>");
                        //out.println("<i class='fa-solid fa-circle-xmark reject-icon'></i>");
                        out.println("<i class='fa-solid fa-circle-check accept-icon'></i>");
                        out.println(" <span class='content_text'>Add product to cart successful</span>");
                        out.println("</div>");
                        out.println("</div>");
                        session.setAttribute("checkAdded", false);
                    } 
                }
            %>

            <!-- Categories sidebar -->
            <!--            <div class="row sidebar-wrapper " style="background-color:#fff;">
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
                        <div class="row ">
                            <div class="white-space">
            
                            </div>
                        </div>-->
            <div class="row product-description">
                <div class="description-wrapper">
                    <div class="product-images-description col-lg-5 col-md-6 col-sm-12 col-12 col-xs-12 col-12">
                        <div class="product-image-main">
                            <img src="${productFound.listImage.get(0).url}"
                                 alt="Laptop Acer" class="product-image">
                        </div>
                        <div class="product-image-involve">
                            <ul class="image-invole-list">
                                <li class="image-invole-item active-picture">
                                    <img src="${productFound.listImage.get(0).url}"
                                         alt="" class="involve-item">
                                </li>
                                <li class="image-invole-item ">
                                    <img src="${productFound.listImage.get(0).url}" alt=""
                                         class="involve-item">
                                </li>
                                <li class="image-invole-item">
                                    <img src="${productFound.listImage.get(0).url}"
                                         alt="${productFound.proName}" class="involve-item">
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="product-text-description col-lg-5 col-md-6 col-sm-12 col-12 col-xs-12">
                        <div class="product-description-heading">
                            <h3 class="product-description-name" style="font-weight: 700;">${productFound.proName}</h3>
                        </div>
                        <div class="policy-insurance">
                            <ul class="insurance-list">
                                <li class="insurance-item">
                                    <i class="fa-regular fa-circle-check"></i>
                                    <span class="insurance-content">12 months genuine warranty</span>
                                </li>
                                <li class="insurance-item">
                                    <i class="fa-regular fa-circle-check"></i>
                                    <span class="insurance-content">12 months genuine warranty</span>
                                </li>
                                <li class="insurance-item">
                                    <i class="fa-regular fa-circle-check"></i>
                                    <span class="insurance-content">12 months genuine warranty</span>
                                </li>
                            </ul>
                        </div>
                        <div class="product-gifts">
                            <div class="heading-gift">
                                <img src="../assets/Images/giftbox.png" alt="Gift" class="gifts-icon"
                                     style="width:30px;margin-right: 10px; height:30px;">
                                <h2 class="gift-heading-title">Your gifts</h2>
                            </div>
                            <ul class="gifts-list" style="list-style: none;">
                                <li class="gift-item">
                                    <img src="../assets/Images/gift.png" alt="" class="gift-icon" style="width:20px">
                                    <span class="gift-name">Balo Acer Office</span>
                                </li>
                                <li class="gift-item">
                                    <img src="../assets/Images/gift.png" alt="" class="gift-icon" style="width:20px">
                                    <span class="gift-name">Balo Acer Office</span>
                                </li>
                            </ul>
                        </div>
                        <div class="product-price-description">
                            <div class="price-description" style="display: flex; ">
                                <h5 class="price-description-title" style="margin-right: 10px;">Original Price : </h5>

                                <span class="price-number"
                                      style="font-weight: 500; font-size:1.2rem ; color: rgb(116, 112, 112);text-decoration:line-through;">${productFound.proOriginalPrice}đ</span>
                            </div>
                            <div class="price-description" style="display: flex; ">
                                <h5 class="price-description-title" style="margin-right: 10px;">Current Price : </h5>
                                <span class="price-number"
                                      style="font-weight: 500; font-size:1.2rem ; color: rgb(237, 17, 17);">${productFound.proCurrentPrice}đ</span>
                            </div>
                        </div>
                        <form action="../Cart">
                            <input type="hidden" name="proID" value="${productFound.proID}">
                            <input type="hidden" name="quantity" value="1">
                            <div class="btn-user-actions">
                                <button class="btn-action" name="orderOp" value="addToCart">Add to your cart</button>
                                <button class="btn-action" name="orderOp" value="buyNow">Buying Now</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row table-wrapper">
                <div class="product-table-description">
                    <table class="product-specifications table-bordered">
                        <thead class="table-heading">
                        <th class="heading-content">Specification</th>
                        <th></th>
                        </thead>
                        <tbody class="table-body">
                            <c:forEach var="specItem" items="${productFound.listSpecification}">
                                <tr class="table-row">
                                    <td class="specification-name">${specItem.specName}</td>
                                    <td class="specification">${specItem.specDetail}</td>
                                </tr>
                            </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
            <%@include file="Footer.jsp" %>

        </div>
    </body>
    <script src="../assets/JavaScript/Detail_Product.js"></script>
    <script src="./assets/JavaScript/CommonFeatures.js"></script>

</html>
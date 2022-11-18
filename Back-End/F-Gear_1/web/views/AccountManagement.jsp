<%-- 
    Document   : AccountManagement
    Created on : Oct 29, 2022, 8:13:35 PM
    Author     : Admin
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>F-GEAR</title>
        <link rel="icon" href="../assets/Images/Logo_After_Login.png">
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
            </div>
            <div class="row sidebar-row" >
                <div class="sidebar-wrapper">
                    <div class="siderbar sidebar-nav col-lg-3 col-xl-2 col-md-12 col-sm-12 col-12">
                        <div class="navigation-wrapper">
                            <ul class="navigation-list">
                                <li class="navigation-item ">
                                    <a href="../Access/Dashboard?op=chartadminpage" class="navigation-item_link">Dashbroad</a>
                                </li>
                                <li class="navigation-item ">
                                    <a href="../Admin/Management" class="navigation-item_link ">Product Management</a>
                                </li>
                                <li class="navigation-item active">
                                    <a href="../Admin/AccountManagement" class="navigation-item_link ">Account Management</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="product-mgt_list col-lg-8 col-xl-9 col-md-12 col-sm-12 col-12 text-center" style="overflow-y:scroll ; margin: 0 auto;">
                        <table class="table">
                            <thead class="table-head">
                                <tr>
                                    <th scope="col">Username</th>
                                    <th scope="col">Full Name</th>
                                    <th scope="col">Phone Number</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col" style="display: flex;align-items: center;justify-content: center;"> 
                                        <a class="table-product-totalOrder_title" href="../Admin/AccountManagement">Total order</a> 
                                        <div class="sorting-wrapper" style="display: block; text-align: center; margin-left:5px; ">
                                            <div style="height: 5px;">
                                                <a href="?sort_total-order=ASC"><i class="fa-solid fa-sort-up"></i></a>
                                            </div>
                                            <div  style="height: 20px; ">
                                                <a href="?sort_total-order=DESC"><i class="fa-solid fa-sort-down"></i></a>
                                            </div>
                                        </div>
                                    </th>
                                    <th scope="col">Total Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="account" items="${listOfAccount}">
                                    <tr style="vertical-align: middle;" class="table-row">
                                        <td scope="row">${account.username}</td>
                                        <td class="table-product_name">${account.fullname}</td>
                                        <td class="table-product_original">0${account.phoneNumber}</td>
                                        <td class="table-product_discount">${account.gender}</td>
                                        <td class="table-product_discount">
                                            ${account.totalOrder}

                                        </td>

                                        <td class="table-product_discount">${account.totalPrice}đ</td>

                                        
                                    </tr>
                                </c:forEach>                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <footer class="footer-wrapper">
                    <div class="footer-logo col-lg-2">
                        <img src="../assets/Images/logo_transparent.png" alt="F-Gear" class="footer-logo_image">
                    </div>
                    <div class="contact-info">
                        <div class="company-description">
                            <h4 class="company-title">F-GEAR</h4>
                            <div class="company-information">
                                <span class="information-title"><b>Address :</b></span>
                                <span class="information-specific">Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ
                                    Đức, Thành phố Hồ Chí Minh</span>
                            </div>
                            <div class="company-information">
                                <span class="information-title"><b>Hotline :</b></span>
                                <span class="information-specific">0335349368</span>
                            </div>
                            <div class="social-medias-contact">
                                <a href="" class="social-media-contact_link">
                                    <img src="Assets/Images/facebook.png" alt="" class="link-image">
                                </a>
                                <a href="" class="social-media-contact_link">
                                    <img src="Assets/Images/instagram.png" alt="" class="link-image">
                                </a>
                                <a href="" class="social-media-contact_link">
                                    <img src="Assets/Images/youtube.png" alt="" class="link-image">
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="footer-google-map">
                        <div class="mapouter">
                            <div class="gmap_canvas"><iframe class="gmap_iframe" width="100%" frameborder="0" scrolling="no"
                                                             marginheight="0" marginwidth="0"
                                                             src="https://maps.google.com/maps?width=300&amp;height=200&amp;hl=en&amp;q=Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ Đức, Thành phố Hồ Chí Minh&amp;t=&amp;z=14&amp;ie=UTF8&amp;iwloc=B&amp;output=embed"></iframe><a
                                    href="https://mcpenation.com/">MCPE Nation</a></div>
                            <style>
                                .mapouter {
                                    position: relative;
                                    text-align: right;
                                    width: 100%;
                                    height: 180px;
                                }

                                .gmap_canvas {
                                    overflow: hidden;
                                    background: none !important;
                                    width: 100%;
                                    height: 180px;
                                }

                                .gmap_iframe {
                                    height: 180px !important;
                                }
                            </style>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </body>
    <script type="module" src="../assets/JavaScript/AccountManagement.js"></script>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Header</title>
        <link rel="icon" href="../assets/Images/pinterest_board_photo.png">
        <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
        <link rel="stylesheet" href="../assets/CSS/Responive.css">
        <link rel="stylesheet" href="../assets/CSS/Detail_Product.css">
        <link rel="stylesheet" href="../assets/CSS/Homepage.css">
        <link rel="stylesheet" href="../assets/CSS/Homepage.css"/>


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
                                                <span class="navigator-item_link active home">Home</span>
                                            </li>
                                            <li class="navigator-item">
                                                <span class="navigator-item_link store">Store</span>
                                            </li>
                                            <li class="navigator-item">
                                                <span class="navigator-item_link sale">Sale</span>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                                <jsp:useBean id="user" class="com.fptuni.swp391.F_Gear.DTO.Users" scope="session"/>

                                <div class="navigatior-user">
                                    <div class="user navigator-user-cart">
                                        <a href="../views/Cart.jsp" class="user-cart_link" style="color: #333;font-size: 1.6rem; display: flex;">
                                            <i class="fa-solid fa-cart-shopping"></i> <span style="color: red" class="cart-size">${size == null ? "0" : size} </span> 
                                        </a>
                                    </div>
                                    <div class=" user navigator-user-account">
                                        <div class="user-account-avatar">
                                            <img src="../avatar/${user.avatar}"
                                                 alt="${user.fullName}" class="user-account-image">
                                        </div>
                                        <div class="user-welcome">
                                            <div class="user-welcome">
                                                <span class="welcome-content">Welcome ${user.fullName}</span>
                                                <div class="logout-wrapper">
                                                    <i class="fa-solid fa-power-off"></i>
                                                    <a href="../Access?op=logout" class="logout_link">Logout</a>
                                                </div>
                                            </div>
                                        </div>
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
            <div class="btn-navigator-list col-lg-5  col-md-5 col-xl-8">
                <div class="body-category">
                    <i class="fa-solid fa-bars"></i>
                    <span> Categories</span>
                    <div class="body-category-list">
                        <ul class="body-category-list-item">
                            <hr />
                            <li class="body-category-list-each-item">
                                <a >Laptop Gaming</a>
                            </li>
                            <hr />
                            <li class="body-category-list-each-item">
                                <a>Office Laptop</a>
                            </li>
                            <hr />
                            <li class="body-category-list-each-item">
                                <a>Mouses</a>
                            </li>
                            <hr />
                            <li class="body-category-list-each-item">
                                <a>Head Phones</a>
                            </li>
                            <hr />
                        </ul>
                        <div class="body-category-sub-list body-category-sub-list-active">
                            <ul class="body-category-list-sub-item">
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Brands</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Homepage?action=Brand&brand=ACER&cate=1"/>">ACER</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Brand&brand=ASUS&cate=1"/>">ASUS</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Brand&brand=MSI&cate=1"/>">MSI</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Brand&brand=DELL&cate=1"/>">DELL</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Brand&brand=LENOVO&cate=1"/>">LENOVO</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Brand&brand=HP&cate=1"/>">HP</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Homepage?action=Price&price=1&cate=1"/>">Under 20 million</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Price&price=2&cate=1"/>">From 20 to less than 25 million</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Price&price=3&cate=1"/>">From 25 to less than 30 million</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Price&price=4&cate=1"/>">Over 30 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>ASUS</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Homepage?action=Series&series=ROG&cate=1"/>">ROG Series</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Series&series=TUF&cate=1"/>">TUF Series</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Series&series=Zephyrus&cate=1"/>">Zephyrus Series</a></li>
                                            <li><a href="<c:url value="./Homepage?action=Series&series=ROG Strix G&cate=1"/>">ROG Strix G</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>MSI Gaming</h4>
                                        <ul>
                                            <li><a href="#">GF Series</a></li>
                                            <li><a href="#">GL Series</a></li>
                                            <li><a href="#">GS Series</a></li>
                                            <li><a href="#">MSI AMD Series</a></li>
                                            <li><a href="#">Bravo Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>DELL Gaming</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Series&series=DELL G&cate=1"/>">DELL Gaming G Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Alienware&cate=1"/>">Alienware Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>LENOVO Gaming</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Series&series=LENOVO&cate=1"/>">Legion Gaming</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Ideapad&cate=1"/>">Ideapad Gaming</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="body-category-sub-list">
                            <ul class="body-category-list-sub-item">
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Brands</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=MSI&cate=2"/>">MSI</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=DELL&cate=2"/>">DELL</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=ACER&cate=2"/>">ACER</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=ASUS&cate=2"/>">ASUS</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=HP&cate=2"/>">HP</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=LG&cate=2"/>">LG</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=HUAWEI&cate=2"/>">HUAWEI</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Price&price=5&cate=2"/>">Under 15 million</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=6&cate=2"/>">From 15 million to under 20 million</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=7&cate=2"/>">Over 20 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop by CPU</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=TypeCore&type=Intel Core i3&cate=2"/>">Intel Core i3</a></li>
                                            <li><a href="<c:url value="./Home?action=TypeCore&type=Intel Core i5&cate=2"/>">Intel Core i5</a></li>
                                            <li><a href="<c:url value="./Home?action=TypeCore&type=Intel Core i7&cate=2"/>">Intel Core i7</a></li>
                                            <li><a href="<c:url value="./Home?action=TypeCore&type=AMD Ryzen&cate=2"/>">AMD Ryzen</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop ASUS</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Series&series=VivoBook&cate=2"/>">VivoBook Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=VivoBook Pro&cate=2"/>">VivoBook Pro Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=ZenBook&cate=2"/>">ZenBook Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Oled&cate=2"/>">ASUS Oled Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop ACER</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Series&series=Aspire&cate=2"/>">Aspire Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Swift&cate=2"/>">Swift Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop DELL</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Series&series=Vostro&cate=2"/>">Vostro Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Latitude&cate=2"/>">Latitude Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop HP</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Series&series=Pavilion&cate=2"/>">Pavilion Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Probook&cate=2"/>">Probook Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Envy&cate=2"/>">Envy Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop MSI</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Series&series=Modern&cate=2"/>">Modern Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Prestige&cate=2"/>">Prestige Series</a></li>
                                            <li><a href="<c:url value="./Home?action=Series&series=Summit&cate=2"/>">Summit Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="body-category-sub-list">
                            <ul class="body-category-list-sub-item">
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Mouses by brands</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=LOGITECH&cate=3"/>">LOGITECH</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=ASUS&cate=3"/>">ASUS</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=RAZER&cate=3"/>">RAZER</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=CORSAIR&cate=3"/>">CORSAIR</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=STEELSERIES&cate=3"/>">STEELSERIES</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=HYPERX&cate=3"/>">HYPERX</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Mouses by brands</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=DARE - U&cate=3"/>">DARE - U</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=Fuhlen&cate=3"/>">Fuhlen</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=Akko&cate=3"/>">Akko</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=MSI&cate=3"/>">MSI</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=EDRA&cate=3"/>">EDRA</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=LENOVO&cate=3"/>">LENOVO</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Price&price=8&cate=3"/>">Under 500 thousand</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=9&cate=3"/>">From 500 thousand to under 1 million</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=10&cate=3"/>">From 1 million to under 2 million</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=11&cate=3"/>">From 2 million to under 3 million</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=12&cate=3"/>">Over 3 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Connect Type</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Type&type=Bluetooth&cate=3"/>">Bluetooth</a></li>
                                            <li><a href="<c:url value="./Home?action=Type&type=Wired&cate=3"/>">Wired</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="body-category-sub-list">
                            <ul class="body-category-list-sub-item">
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Headphones by brands</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=LOGITECH&cate=4"/>">LOGITECH</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=ASUS&cate=4"/>">ASUS</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=RAZER&cate=4"/>">RAZER</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=CORSAIR&cate=4"/>">CORSAIR</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=STEELSERIES&cate=4"/>">STEELSERIES</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=HYPERX&cate=4"/>">HYPERX</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Headphones by brands</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=DARE - U&cate=4"/>">DARE - U</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=LENOVO&cate=4"/>">LENOVO</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=EDRA&cate=4"/>">EDRA</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=MSI&cate=4"/>">MSI</a></li>
                                            <li><a href="<c:url value="./Home?action=Brand&brand=AKKO&cate=4"/>">AKKO</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Price&price=8&cate=4"/>">Under 500 thousand</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=9&cate=4"/>">From 500 thousand to under 1 million</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=10&cate=4"/>">From 1 million to under 2 million</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=11&cate=4"/>">From 2 million to under 3 million</a></li>
                                            <li><a href="<c:url value="./Home?action=Price&price=12&cate=4"/>">Over 3 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Connect Type</h4>
                                        <ul>
                                            <li><a href="<c:url value="./Home?action=Type&type=Bluetooth&cate=4"/>">Bluetooth</a></li>
                                            <li><a href="<c:url value="./Home?action=Type&type=Wired&cate=4"/>">Wired</a></li>
                                        </ul>
                                    </div>
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
                <div class="btn-navigator-item col-lg-1 col-md-1 col-xl-1 ">
                    <form action="../WarrantyPolicyShow/">
                    <button class="item-btn" type="submit">
                        <i class="fa-solid fa-screwdriver-wrench"></i>
                        <span class="btn-content ">Warranty Policy</span>                       
                    </button>
                    </form>
                </div>                        
            </div>
        </div>
    </div>
</div>
</body>


<script src="../assets/JavaScript/CommonFeatures.js"></script>
<script src="../assets/JavaScript/Homepage.js"></script>
</html>
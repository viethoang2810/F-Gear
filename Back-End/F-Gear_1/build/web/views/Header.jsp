<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Header</title>
        <link rel="stylesheet" href="./assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
        <link rel="stylesheet" href="./assets/CSS/Responive.css">
        <link rel="stylesheet" href="./assets/CSS/Detail_Product.css">
        <link rel="stylesheet" href="./assets/CSS/Homepage.css">
        <link rel="stylesheet" href="./assets/CSS/responsive.css">


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
                                            <li><a href="#">ACER</a></li>
                                            <li><a href="#">ASUS</a></li>
                                            <li><a href="#">MSI</a></li>
                                            <li><a href="#">DELL</a></li>
                                            <li><a href="#">LENOVO</a></li>
                                            <li><a href="#">HP</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="#">Under 20 million</a></li>
                                            <li><a href="#">From 20 to less than 25 million</a></li>
                                            <li><a href="#">From 25 to less than 30 million</a></li>
                                            <li><a href="#">Over 30 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>ASUS</h4>
                                        <ul>
                                            <li><a href="#">ROG Series</a></li>
                                            <li><a href="#">TUF Series</a></li>
                                            <li><a href="#">Zephyrus Series</a></li>
                                            <li><a href="#">ROG Strix G</a></li>
                                            <li><a href="#">ROG Flow Series</a></li>
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
                                            <li><a href="#">DELL Gaming G Series</a></li>
                                            <li><a href="#">Alienware Series</a></li>
                                            <li><a href="#">Logitech</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>LENOVO Gaming</h4>
                                        <ul>
                                            <li><a href="#">LENOVO Gaming Series</a></li>
                                            <li><a href="#">Ideapad Gaming Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Graphics card</h4>
                                        <ul>
                                            <li><a href="#">GTX 1650</a></li>
                                            <li><a href="#">GTX 3050/3050Ti</a></li>
                                            <li><a href="#">GTX 3060</a></li>
                                            <li><a href="#">GTX 3070/3080</a></li>
                                            <li><a href="#">AMD Radeon RX</a></li>
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
                                            <li><a href="#">MSI</a></li>
                                            <li><a href="#">DELL</a></li>
                                            <li><a href="#">ACER</a></li>
                                            <li><a href="#">ASUS</a></li>
                                            <li><a href="#">HP</a></li>
                                            <li><a href="#">LG</a></li>
                                            <li><a href="#">HUAWEI</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="#">Under 15 million</a></li>
                                            <li><a href="#">From 15 million to under 20 million</a></li>
                                            <li><a href="#">Over 20 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop by CPU</h4>
                                        <ul>
                                            <li><a href="#">Intel Core i3</a></li>
                                            <li><a href="#">Intel Core i5</a></li>
                                            <li><a href="#">Intel Core i7</a></li>
                                            <li><a href="#">Intel Core i9</a></li>
                                            <li><a href="#">AMD Ryzen</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop ASUS</h4>
                                        <ul>
                                            <li><a href="#">VivoBook Series</a></li>
                                            <li><a href="#">VivoBook Pro Series</a></li>
                                            <li><a href="#">Zenbook Series</a></li>
                                            <li><a href="#">ASUS Oled Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop ACER</h4>
                                        <ul>
                                            <li><a href="#">Aspire Series</a></li>
                                            <li><a href="#">Swift Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop DELL</h4>
                                        <ul>
                                            <li><a href="#">Vostro Series</a></li>
                                            <li><a href="#">Inspiron Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop HP</h4>
                                        <ul>
                                            <li><a href="#">Probook Series</a></li>
                                            <li><a href="#">Envy Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop MSI</h4>
                                        <ul>
                                            <li><a href="#">Modern Series</a></li>
                                            <li><a href="#">Prestige Series</a></li>
                                            <li><a href="#">Summit Series</a></li>
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
                                            <li><a href="#">LOGITECH</a></li>
                                            <li><a href="#">ASUS</a></li>
                                            <li><a href="#">RAZER</a></li>
                                            <li><a href="#">CORSAIR</a></li>
                                            <li><a href="#">STEELSERIES</a></li>
                                            <li><a href="#">HYPERX</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Mouses by brands</h4>
                                        <ul>
                                            <li><a href="#">DARE - U</a></li>
                                            <li><a href="#">Fuhlen</a></li>
                                            <li><a href="#">Akko</a></li>
                                            <li><a href="#">MSI</a></li>
                                            <li><a href="#">EDRA</a></li>
                                            <li><a href="#">LENOVO</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="#">Under 500 thousand</a></li>
                                            <li><a href="#">From 500 thousand to under 1 million</a></li>
                                            <li><a href="#">From 1 million to under 2 million</a></li>
                                            <li><a href="#">From 2 million to under 3 million</a></li>
                                            <li><a href="#">Over 3 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Connect Type</h4>
                                        <ul>
                                            <li><a href="#">Bluetooth</a></li>
                                            <li><a href="#">Wireless</a></li>
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
                                            <li><a href="#">LOGITECH</a></li>
                                            <li><a href="#">ASUS</a></li>
                                            <li><a href="#">RAZER</a></li>
                                            <li><a href="#">CORSAIR</a></li>
                                            <li><a href="#">STEELSERIES</a></li>
                                            <li><a href="#">HYPERX</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Headphones by brands</h4>
                                        <ul>
                                            <li><a href="#">DARE - U</a></li>
                                            <li><a href="#">LENOVO</a></li>
                                            <li><a href="#">EDRA</a></li>
                                            <li><a href="#">MSI</a></li>
                                            <li><a href="#">AKKO</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="#">Under 500 thousand</a></li>
                                            <li><a href="#">From 500 thousand to under 1 million</a></li>
                                            <li><a href="#">From 1 million to under 2 million</a></li>
                                            <li><a href="#">From 2 million to under 3 million</a></li>
                                            <li><a href="#">Over 3 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Connect Type</h4>
                                        <ul>
                                            <li><a href="#">Bluetooth</a></li>
                                            <li><a href="">Wireless</a></li>
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
            </div>
        </div>
    </div>
</div>
</body>


<script src="./assets/JavaScript/CommonFeatures.js"></script>
<script src="./assets/JavaScript/Homepage.js"></script>
</html>
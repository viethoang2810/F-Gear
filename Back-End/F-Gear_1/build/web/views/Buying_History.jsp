<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>F-Gear</title>
        <link rel="icon" href="../assets/Images/pinterest_board_photo.png">
        <link rel="stylesheet" href="../assets/CSS/BuyingHistory.css">
        <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
        <link rel="stylesheet" href="../assets/CSS/Responive.css">
        <link rel="stylesheet" href="../assets/CSS/User_Profile.css">

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
                <header class="header-wrapper">
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
                                                <a href="../Home/Homepage" class="navigator-item_link ">Home</a>
                                            </li>
                                            <li class="navigator-item">
                                                <a href="../Profile/UserProfile" class="navigator-item_link ">Profile</a>
                                            </li>
                                            <li class="navigator-item">
                                                <a href="../Profile/Buying_History.jsp" class="navigator-item_link active">History</a>
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
            <div class="row body">
                <div class="body-wrapper">
                    <div class="user-avatar col-xl-3 col-lg-4 col-md-12 col-sm-12 col-12" >
                        <div class="avatar-image">
                            <img src="../assets/Images/280013939_368144518688847_7624068726298628073_n.jpg" alt="" class="user-avatar-image">
                        </div>
                        <span class="user-name" style="font-weight: 600; font-size: 1.3rem;">viethoang</span>
                    </div>
                    <div class="user-cart col-xl-8 col-lg-7 col-md-12 col-sm-12 col-12">
                        <div class="history-table">
                            <table class="table text-center table-wrapper" >
                                <thead style="height:80px;vertical-align:middle;background-color: var(--background-color); color:rgb(59, 57, 57);">
                                    <tr class="border-dark" >
                                        <th scope="col">Id</th>
                                        <th scope="col" >Bought date</th>
                                        <th scope="col" >Product name</th>
                                        <th scope="col" >Amount</th>
                                        <th scope="col" >Price</th>
                                        <th scope="col" >Warranty period (month(s0))</th>
                                    </tr>
                                </thead>
                                <tbody class="table-body">
                                    <tr class="table-row">
                                        <th scope="row" class="cart-info">1</th>
                                        <th class="cart-info">23-9-2022</th>
                                        <th class="cart-info">
                                            <a href="" class="product-name_link">Laptop MSI Gaming</a>
                                        </th>
                                        <th class="cart-info">1</th>
                                        <th class="cart-info">16.000.000Ä</th>
                                        <th class="cart-info">2 years</th>
                                    </tr>
                                   

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="./Footer.jsp" %>

        </div>
    </body>
    <script type="text/javascript" src="../assets/JavaScript/CommonFeatures.js"></script>
</html>
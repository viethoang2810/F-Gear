<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>F-Gear</title>
        <link rel="icon" href="../assets/Images/pinterest_board_photo.png">
        <link rel="stylesheet" href="../assets/CSS/User_Profile.css">
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
                                                <a href="../Home/HomePage" class="navigator-item_link ">Home</a>
                                            </li>
                                            <li class="navigator-item">
                                                <a href="../Profile/YourProfile" class="navigator-item_link active">Profile</a>
                                            </li>
                                            <li class="navigator-item">
                                                <a href="../Profile/Buying_History" class="navigator-item_link">History</a>
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
                                    <div class=" user navigator-user-account"  style="width: 300px;">
                                        <div class="user-account-avatar">
                                            <img src="../avatar/${user.avatar}"
                                                 alt="${user.fullName}" class="user-account-image">
                                        </div>
                                        <div class="user-welcome">
                                            <span class="welcome-content">Welcome ${user.fullName}</span>
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

                            <img src="../avatar/${user.avatar}" alt="" class="user-avatar-image">
                        </div>
                        <div class="change-image" >
                            <form class="form-file" action="./UserProfile" method="POST" enctype="multipart/form-data">
                                <input type="hidden" name="username" value="${user.userName}"/>
                                <label for="file-upload" class="custom-file-upload" >
                                    <i class="fa fa-cloud-upload"></i> Choose from your device
                                </label>
                                <input id="file-upload" type="file" name="file-upload" />
                            </form>
                        </div>
                    </div>
                    <div class="user-infors col-xl-7 col-lg-7 col-md-12 col-sm-12 col-12">
                        <h3 class="user-infor-title" style="text-align:center;">User Information</h3>
                        <form action="./Profile" class="user-infor-form" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="username" value="${user.userName}"/>
                            <div class="user-input">
                                <label class="user-label"  for="username">Full name :</label>
                                <input class="user-input-info" type="text" value="${user.fullName}"  id="username" name="fullname"/>
                            </div>

                            <div class="user-input">
                                <label class="user-label" for="phone-number">Phone number :</label>
                                <input class="user-input-info" type="text" value="0${user.phoneNumber}"  id="phone-number" name="phonenumber"/>
                            </div>
                            <div class="user-input" style="display: flex;">
                                <span class="user-label user-input-title">Gender : </span>
                                <div class="user-input-wrapper">
                                    <%
                                        String gender = user.getGender();

                                    %>
                                    <label  for="gender-male">Male</label>
                                    <input class="user-radio" style="margin-right: 30px;" type="radio" value="Male" name="gender" id="gender-male" <%if(gender.equals("Male")) out.print("checked");%>/>                                  
                                    <label for="gender-female">Female</label>
                                    <input class="user-radio" type="radio" value="Female" name="gender" id="gender-female"  <%if(gender.equals("Female")) out.print("checked");%>/>
                                </div>
                            </div>
                            <button class="submit-btn" style="display: block;text-align:center;" name="action" value="updateInfor">Save your informations</button>
                        </form>
                    </div>
                </div>
            </div>
            <%@include file="./Footer.jsp" %>

        </div>

    </body>
    <script src="../assets/JavaScript/CommonFeatures.js"></script>
    <script src="../assets/JavaScript/User_Profile.js"></script>

</html>
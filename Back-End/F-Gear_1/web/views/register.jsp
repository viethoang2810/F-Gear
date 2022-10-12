<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/CSS/register.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
      <link rel="stylesheet" href="../assets/CSS/responsive.css"/>
    <title>Register</title>
</head>

<body>
    <!-- <header class="header">
        <div class="header-logo-container">
            <img class="header-logo"
                src="https://th.bing.com/th/id/R.af2b82154a39f7ddd7e1cbcddf32540c?rik=VNWwpCivVSf%2f0g&pid=ImgRaw&r=0"
                alt="logo-here" />
        </div>
        <div class="header-link">
            <ul class="header-list-link">
                <li class="active"><a href="./index.html">Home</a></li>
                <li>Store</li>
                <li>Sales</li>
            </ul>
            <div class="header-list-btn">
                <button style="background-color: transparent;"><a href="./register.html">sign-up</a></button>
                <button><a href="./login.html">sign-in</a></button>
            </div>
        </div>
    </header> -->
    <div class="login">
        <img class="login-logo"
             src="../assets/Images/Logo_After_Login.png">
        <form class="login-form" action="./Access" method="POST">
            <input required class="login-form-text" type="text" name="userName" placeholder="Username" value="${userName}"/>
            <input required class="login-form-text" type="password" name="password" placeholder="Password" value="${password}"/>
            <input required class="login-form-text" type="password" name="cofirm" placeholder="Confirm password" value="${cofirm}"/>
            <input required class="login-form-text" type="text" name="phone" placeholder="Phone number" value="${phone}"/>
            <button class="login-form-submit" name="op" value="register">Join with us</button>
            <br/>
            <i style="color: red">${message}</i>
        </form>
        <div class="login-create">
            <a href="Access?op=login">You already have account ?</a>
        </div>

    </div>
    <!-- <footer class="footer">
        <div class="footer-right">
            <img class="footer-logo"
                src="https://th.bing.com/th/id/R.af2b82154a39f7ddd7e1cbcddf32540c?rik=VNWwpCivVSf%2f0g&pid=ImgRaw&r=0"
                alt="logo-here" />
            <div>
                <h1>F-Gear Store</h1>
                <p>Address: 210/10 LÃª VÄn Sá»¹, PhÆ°á»ng 10, Quáº­n PhÃº Nhuáº­n</p>
                <p>Contact: 0903333333</p>
                <div class="footer-link">
                    <i class="fa-brands fa-facebook"></i>
                    <i class="fa-brands fa-instagram"></i>
                    <i class="fa-brands fa-youtube"></i>
                </div>
            </div>
        </div>
        <div class="footer-left">
            <h3>Payments policy</h3>
            <h3>Maintenance policy</h3>
        </div>
    </footer> -->
</body>
<script src="JavaScript/FormValidate.js"></script>
</html>
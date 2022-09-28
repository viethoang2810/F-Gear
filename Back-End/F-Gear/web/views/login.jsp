<<<<<<< HEAD
<!DOCTYPE html>
<html lang="en">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="/assets/CSS/login.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/CSS/responsive.css"/>">
        <title>Login</title>
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
                 src="https://th.bing.com/th/id/R.af2b82154a39f7ddd7e1cbcddf32540c?rik=VNWwpCivVSf%2f0g&pid=ImgRaw&r=0">
            <form class="login-form" action="accesscontroller">
                <input class="login-form-text" type="text" placeholder="Username" name="userName" value="${user.userName}" />
                <input class="login-form-text" type="password" placeholder="Password" name="password" value="${user.password}" />
                <i>${message}</i>
                <div class="logo-form-user-action">
                    <div>
                        <input type="checkbox" class="login-form-radio" />
                        <label>Remember password</label>
                    </div>
                    <a href="./index.html">Forgot password ?</a>
                </div>
                <button class="login-form-submit" name="op" value="login" >Go to store</button>
            </form>
            <button class="login-google">
                <img src="./Assets/Images/" />
                <a href=""> Login with Google</a>
            </button>
            <div class="login-create">
                <a href="./register.html">Create account ?</a>
            </div>

        </div>
        <!-- <footer class="footer">
            <div class="footer-right">
                <img class="footer-logo"
                    src="https://th.bing.com/th/id/R.af2b82154a39f7ddd7e1cbcddf32540c?rik=VNWwpCivVSf%2f0g&pid=ImgRaw&r=0"
                    alt="logo-here" />
                <div>
                    <h1>F-Gear Store</h1>
                    <p>Address: 210/10 Lê Văn Sỹ, Phường 10, Quận Phú Nhuận</p>
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
=======
>>>>>>> 8720a6b061c7dedb60799aa05d81c30ce896b7d8

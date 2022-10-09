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
        <div class="login">
            <img class="login-logo"
                 src="../assets/Images/Logo_After_Login.png">
            <form class="login-form" action="./Access" method="POST">
                <input class="login-form-text" type="text" placeholder="Username" name="userName" value="${user.userName}" />
                <input class="login-form-text" type="password" placeholder="Password" name="password"/>
                <i>${message}</i>
                <div class="logo-form-user-action">
                    <div>
                        <input type="checkbox" class="login-form-radio" />
                        <label>Remember password</label>
                    </div>
                    <a href="./index.jsp">Forgot password ?</a>
                </div>
                <button class="login-form-submit" name="op" value="login" >Go to store</button>
            </form>
            <button class="login-google">
                <img src="../assets/Images/R.png" />
                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/F-Gear_1/./Access?op=loginwithgoogle&response_type=code
		   &client_id=981197715312-butc49a1aut585l2hhqsf1s4it4etihq.apps.googleusercontent.com&approval_prompt=force"> Login with Google</a>
            </button>
            <div class="login-create">


                <a href="./">Create account ?</a>


                <a href="./Access?access=register">Create account ?</a>

                <a href="Access?op=signup">Create account ?</a>


            </div>

        </div>
        <!-- <footer class="footer">
            <div class="footer-right">
                <img class="footer-logo"
                    src="https://th.bing.com/th/id/R.af2b82154a39f7ddd7e1cbcddf32540c?rik=VNWwpCivVSf%2f0g&pid=ImgRaw&r=0"
                    alt="logo-here" />
                <div>
                    <h1>F-Gear Store</h1>
                    <p>Address: 210/10 Lê V?n S?, Ph??ng 10, Qu?n Phú Nhu?n</p>
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
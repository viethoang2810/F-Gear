<%-- Document : ForgotPassword_Page Created on : Oct 14, 2022, 5:57:33 PM Author : ADMIN --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Forgot Password Page</title>
        </head>
        <style>
            body {
                padding: 0;
                margin: 0;
            }

            .container {
                width: 100%;
                height: 100vh;
                padding: 40px 0;

            }

            .body {
                width: 60%;
                margin: 0 auto;
                padding: 20px 0;
                display: flex;
                justify-content: space-between;
                height: 60%;
            }

            img {
                width: 50%;
                height: 100%;
                border-bottom-left-radius: 20px;
                border-top-left-radius: 20px;
            }

            form {
                width: 50%;
                margin: 0 auto;
                background-color: white;
                height: 100%;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                border-bottom-right-radius: 20px;
                border-top-right-radius: 20px;
            }



            input {
                width: 90%;
                border: none;
                outline: none;
                background-color: #ddd8d8;
                padding: 15px 10px;
                border-radius: 30px;

            }

            b {
                padding: 5px 0;
                font-size: 24px;
            }

            button {
                width: 60%;
                padding: 14px 10px;
                border: none;
                border-radius: 20px;
                background-color: #f1cccc;
                font-size: 16px;
            }

            button:hover {
                background-color: red;
                color: white;
                cursor: pointer;
            }
        </style>

        <body>
            <div class="container">
                <div class="body">
                    <img src="https://media.istockphoto.com/vectors/register-account-submit-access-login-password-username-internet-vector-id1281150061?k=20&m=1281150061&s=612x612&w=0&h=wpCvmggedXRECWK-FVL98MMllubyevIrXuUu50fdCqE="
                        alt="" />
                    <form action="../Access">
                        <b>Username</b> <input type="text" class="username" placeholder="Username" name="userName"
                            value="" /><br />
                        <b>Email</b> <input type="text" class="password" placeholder="Gmail (Using FPT Gmail)" name="gmail"
                            value="" /><br />
                        <i>${message}</i><br />
                        <button name="op" value="forgotpassword">Retrieve</button>
                    </form>
                </div>
            </div>
        </body>

        </html>
<%-- 
    Document   : ForgotPassword_Page
    Created on : Oct 14, 2022, 5:57:33 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password Page</title>
    </head>
    <body>
        <form action="../Access">
            username: <input type="text" placeholder="Username" name="userName" value="" /><br/>
            gmail: <input type="text" placeholder="Gmail" name="gmail" value=""/><br/>
            <i>${message}</i><br/>
            <button name="op" value="forgotpassword" >Retrieve</button>
        </form>
    </body>
</html>

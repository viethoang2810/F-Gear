<%-- 
    Document   : Contact
    Created on : Oct 10, 2022, 7:04:28 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
        <!--        <link rel="stylesheet" href="./assets/CSS/GlobalStyles.css">  This file contains all of common styles of pages
                <link rel="stylesheet" href="./assets/CSS/Responive.css">
                <link rel="stylesheet" href="./assets/CSS/Detail_Product.css">
                <link rel="stylesheet" href="./assets/CSS/Homepage.css">
                <link rel="stylesheet" href="./assets/CSS/responsive.css">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <%--<%@include file="Header.jsp" %>--%>
    <body>
        <div class="container">
            <div class="jumbotron text-center">
                <h1>Listen all your request</h1>

            </div>
            <br>
            <form action="MailController" method="post">
                <table class="table table-hover">
                    <tr>
                        <td>Name</td>
                        <td><input type="text" required="" placeholder="Name" name="name" class="form-control"></td>
                    </tr>

                    <tr>
                        <td>Email</td>
                        <td><input type="email" required="" placeholder="Email" name="email" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Subject</td>
                        <td><input type="text" required="" placeholder="Subject" name="subject" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Message</td>
                        <td><textarea name="message" required="" rows="5" cols="100" placeholder="Your Message"></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" id="submit" class="btn btn-primary" value="Submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>

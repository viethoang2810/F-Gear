<%-- 
    Document   : admin_Page
    Created on : Oct 3, 2022, 3:08:06 PM
    Author     : nguye
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1 style="text-align: center; color: red">Admin Manager</h1> <hr/>
        <form action="./admin">
            <div style="margin-left: 282px">
                <input type="text" name="name">
                <input type="submit" name="op" value="search">
            </div>
        </form>
        <br/>
        <table border="1" cellspacing="0" style="margin-left: auto; margin-right: auto">           
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>OriginalPrice</th>
                    <th>Discount</th>   
                    <th>CurrentPrice</th>
                    <th>BrandID</th>
                    <th>CateID</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${list}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${p.getProID()}</td>
                        <td>${p.getProName()}</td>
                        <td>${p.getProOriginalPrice()}</td>
                        <td>${p.getDiscount()}</td>
                        <td>${p.getProCurrentPrice()}</td>
                        <td>${p.getBrandID()}</td>
                        <td>${p.getCateID()}</td>
                        <td>${p.status==0?"Inactive":"Active"}</td>
                    </td>
                        <td>
                            <a href="./admin?op=edit&proID=${p.getProID()}"/>Update</a>
                        </td>                   
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

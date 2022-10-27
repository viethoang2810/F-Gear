<%-- 
    Document   : ReviewPayment
    Created on : Oct 27, 2022, 2:22:22 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Review</title>
    </head>
    <style>
        body {
            user-select: none;
        }
        .body {
            display: flex;

        }
        td , th{
            text-align: center;
        }

        .checkout__container {
            width: 40%;
            margin: 20px auto;
            background: #f7e9ef;
            padding: 20px 20px;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            position: relative;
            height: 360px;
        }
        .product {
            width: 50%;
            position: relative;
            margin: 20px;
            background: #f1ecec;
            padding: 10px 10px 40px 10px;
            border-radius: 10px;
        }
        fieldset {
            border-radius: 10px;

        }
        input {
            border: none;
            background: #f7e9ef;
            width: 100%;
        }

        input:focus {
            outline: none;
            padding: 0;
            font-size: 20px;
            background: #f7e9ef;
        }
        button {
            width: 40%;
            padding: 10px 0;
            margin: 30px 0 30px 160px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            color: #fff;
            background-color: #cc2dee;
            position: absolute;
            bottom: 0;
            right: 20px;
            font-size: 28px;
        }
        button:hover {
            opacity: 0.7;
        }

        .total {
            width: 200px;
            height: 20px;
            background: #f760a1;
            padding: 20px;
            border-radius: 10px;
            color: white;
            font-size: 20px;
            float: right;
            text-align: center;
        }
    </style>
    <body>
        <div>
            <a href="./views/Cart.jsp">Back To Cart</a>
        </div>
        <div class="body">
            <form class="checkout__container" action="CheckoutAtStore">
                <h3>Billing Address</h3>
                <fieldset>
                    <legend><i class="fa-solid fa-location-crosshairs"></i> Full Name</legend>
                    <div>${sessionScope.user.fullName}</div>
                </fieldset>
                <fieldset>
                    <legend><i class="fa-solid fa-phone"></i> Phone</legend>
                    <div>${sessionScope.user.phoneNumber}</div>
                </fieldset>
                <button>Checkout</button>
            </form>
            <div class="product">
                <table>
                    <thead>
                        <tr>
                            <th style="text-align: left; width: 60%;">Product</th>
                            <th>Price</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${cart}">
                            <tr>
                                <td style="text-align: left;">
                                    <div>
                                        <h4>${item.product.proName}</h4>
                                    </div>
                                </td>
                                <td>
                                    <fmt:setLocale value="vi_VN"/>
                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value="${item.price}" />
                                    VND
                                </td>
                                <td>
                                    <span>
                                        ${item.quantity}
                                    </span>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <span class="total">Total: <fmt:setLocale value="vi_VN"/>
                    <fmt:formatNumber value="${sessionScope.total}" type="currency"/>
                </span>
            </div>
        </div>
    </body>
</html>

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
        .product {
            width: 80%;
            position: relative;
            left: 50%;
            /*top: 50%;*/
            margin: 20px;
            padding: 10px 10px 40px 10px;
            border-radius: 10px;
            transform: translateX(-50%);
        }
        table {
            width: 100%;
            text-align: center;
            font-size: 20px;
        }
        td {
            border-bottom: 1px solid #000;  
            padding: 20px 0;
        }
        .button-52 {
            font-size: 16px;
            font-weight: 200;
            letter-spacing: 1px;
            padding: 13px 20px 13px;
            outline: 0;
            border: 1px solid black;
            cursor: pointer;
            position: relative;
            background-color: rgba(0, 0, 0, 0);
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
            left: 50%;
            transform: translateX(-50%);
        }

        .button-52:after {
            content: "";
            background-color: #ffe54c;
            width: 100%;
            z-index: -1;
            position: absolute;
            height: 100%;
            top: 7px;
            left: 7px;
            transition: 0.2s;
        }

        .button-52:hover:after {
            top: 0px;
            left: 0px;
        }

        @media (min-width: 768px) {
            .button-52 {
                padding: 13px 50px 13px;
            }
        }
    </style>
    <body>
        <a href="./Home/Homepage" style="text-decoration: none;">
            <button style="padding:15px 20px; border-radius: 24px; font-size: 24px; cursor: pointer;">
                👈 Back to Home    
            </button> 
        </a>

        <div style="width: 100%; text-align: center;">
            <h1 style="font-size: 42px;">F-Gear Shop</h1>
            <p style="font-size: 24px;">Always bring the best customer service and experience.</p>
        </div>
        <hr/>
        <div style="width:100%; text-align: center;">
            <form action="CheckoutPaypal_Controller" style="display: flex; justify-content: space-around; width:100%; text-align: center;">
                <div style="width: 33%;">
                    <h1>BILL TO</h1>
                    <h3>Customer name: ${sessionScope.user.fullName}</h3>
                    <h3>Phone number: ${sessionScope.user.phoneNumber}</h3>
                </div>
                <div style="width: 33%;">
                    <h1>DETAILS</h1>
                    <h3>Genuine products with great deals.</h3>
                </div>
                <div style="width: 33%;">
                    <h1>PAYMENT</h1>
                    <h3>
                        Total:
                        <fmt:setLocale value="en_US"/>
                        <fmt:formatNumber value="${sessionScope.total/23000+TAX+shipping}" type="currency"/>
                    </h3>
                </div>
                <c:forEach var="item" items="${sessionScope.cart}">
                    <input type="hidden" name="productId" value="${item.product.proID}"/>
                    <input type="hidden" name="productName" value="${item.product.proName}"/>
                    <input type="hidden" name="subtotal" value="${item.price/23000}"/>
                    <input type="hidden" name="quantity" value="${item.quantity}"/>
                    <input type="hidden" name="tax" value="${TAX}"/>
                    <input type="hidden" name="shipping" value="${shipping}"/>
                    <input type="hidden" name="total" value="${sessionScope.total/23000+TAX+shipping}"/>
                </c:forEach>
            </form>
        </div>
        <hr/>
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
                                    ${item.product.proName}
                                </div>
                            </td>
                            <td>
                                <fmt:setLocale value="en_US"/>
                                <fmt:formatNumber value="${item.price/23000}" type="currency"/>
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
            <div style="display: flex; justify-content: space-around; width: 100%; margin: 40px 0">
                <div style="font-size: 20px;">
                    <p>Shipping:  <fmt:setLocale value="en_US"/>
                        <fmt:formatNumber value="${shipping}" type="currency"/></p>
                    <p>TAX:   <fmt:setLocale value="en_US"/>
                        <fmt:formatNumber value="${TAX}" type="currency"/></p>
                </div>
                <div>
                    <form action="CheckoutPaypal_Controller">
                        <button class="button-52" role="button">Check out</button>
                        <c:forEach var="item" items="${sessionScope.cart}">
                            <input type="hidden" name="productId" value="${item.product.proID}"/>
                            <input type="hidden" name="productName" value="${item.product.proName}"/>
                            <input type="hidden" name="subtotal" value="${item.price/23000}"/>
                            <input type="hidden" name="quantity" value="${item.quantity}"/>
                            <input type="hidden" name="tax" value="${TAX}"/>
                            <input type="hidden" name="shipping" value="${shipping}"/>
                            <input type="hidden" name="total" value="${sessionScope.total/23000+TAX+shipping}"/>
                        </c:forEach>
                    </form>
                </div>
            </div>
    </body>
</html>

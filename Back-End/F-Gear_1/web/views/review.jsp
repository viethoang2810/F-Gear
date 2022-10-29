<%-- 
    Document   : review
    Created on : Oct 17, 2022, 6:28:58 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order review</title>
    </head>
    <style>
        /* CSS */
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
        table { 
            width: 750px; 
            border-collapse: collapse; 
            margin:50px auto;
        }

        /* Zebra striping */
        tr:nth-of-type(odd) { 
            background: #eee; 
        }

        th { 
            background: #3498db; 
            color: white; 
            font-weight: bold; 
        }

        td, th { 
            padding: 10px; 
            border: 1px solid #ccc; 
            text-align: left; 
            font-size: 18px;
        }

        @media 
        only screen and (max-width: 760px),
        (min-device-width: 768px) and (max-device-width: 1024px)  {

            table { 
                width: 100%; 
            }

            table, thead, tbody, th, td, tr { 
                display: block; 
            }

            thead tr { 
                position: absolute;
                top: -9999px;
                left: -9999px;
            }

            tr { border: 1px solid #ccc; }

            td { 
                border: none;
                border-bottom: 1px solid #eee; 
                position: relative;
                padding-left: 50%; 
            }

            td:before { 
                position: absolute;
                top: 6px;
                left: 6px;
                width: 45%; 
                padding-right: 10px; 
                white-space: nowrap;
                content: attr(data-column);

                color: #000;
                font-weight: bold;
            }

        }
        article {
            background: linear-gradient(
                to right, 
                hsl(98 100% 62%), 
                hsl(204 100% 59%)
                );
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            text-align: center;
        }
        h1 {
            font-size: 10vmin;
            line-height: 1.1;
        }
    </style>
    <body>
        <article>
            <h1>Review Order</h1>
        </article>
        <div>
            <form action="./excute_payment" method="post">

                <!--<input type="submit"  value="Pay now"/>-->
                <button class="button-52" role="button">Pay now</button>
                <table>
                    <tr>
                        <td colspan="2"><b>Transaction Details:</b>
                            <input type="hidden" name="paymentId" value="${param.paymentId}"/>
                            <input type="hidden" name="PayerID" value="${param.PayerID}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td>
                            ${transaction.description}
                        </td>
                    </tr>
                    <tr>
                        <td>Subtotal:</td>
                        <td>
                            ${transaction.amount.details.subtotal}
                        </td>
                    </tr>
                    <tr>
                        <td>Shipping:</td>
                        <td>
                            ${transaction.amount.details.shipping}
                        </td>
                    </tr>
                    <tr>
                        <td>tax</td>
                        <td>
                            ${transaction.amount.details.tax}
                        </td>
                    </tr>
                    <tr>
                        <td>total</td>
                        <td>
                            ${transaction.amount.total}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>Payer Information:</b></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td>
                            ${payer.firstName}
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td>
                            ${payer.lastName}
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>
                            ${payer.email}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>Shipping Address:</b></td>
                    </tr>
                    <tr>
                        <td>Recipient Name:</td>
                        <td>
                            ${shippingAddress.recipientName}
                        </td>
                    </tr>
                    <tr>
                        <td>Line 1:</td>
                        <td>
                            ${shippingAddress.line1}
                        </td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td>
                            ${shippingAddress.city}
                        </td>
                    </tr>
                    <tr>
                        <td>State:</td>
                        <td>
                            ${shippingAddress.state}
                        </td>
                    </tr>
                    <tr>
                        <td>Country Code:</td>
                        <td>
                            ${shippingAddress.countryCode}
                        </td>
                    </tr>
                    <tr>
                        <td>Postal Code:</td>
                        <td>
                            ${shippingAddress.postalCode}
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>

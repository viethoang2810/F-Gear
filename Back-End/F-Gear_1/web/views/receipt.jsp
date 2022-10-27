<%-- 
    Document   : receipt
    Created on : Oct 17, 2022, 8:19:03 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="./index.html">Back to Home</a>
        <h1>Receipt</h1>
        <h1>Thanks for your purchasing our products</h1>
        <div>

            <table>
                <tr>
                    <td colspan="2"><b>Transaction Details:</b></td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td>Merchant:</td>
                    <td>
                        F-GEAR Shop
                    </td>
                </tr>
                <tr>
                    <td>Payer:</td>
                    <td>
                        ${payer.firstName} ${payer.lastName}
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
            </table>
        </div>
    </body>
</html>

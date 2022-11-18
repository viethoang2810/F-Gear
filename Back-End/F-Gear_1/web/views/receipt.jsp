<%-- 
    Document   : newjsp
    Created on : Oct 10, 2022, 5:19:09 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .shadow{
            font-family:Mr Dafoe, sans-serif;
            font-size:72px;
            text-align:center;
            text-shadow: 0 -3px 0 #333,
                0 6px 8px rgba(0,0,0,.4),
                0 9px 10px rgba(0,0,0,.15),
                0 30px 10px rgba(0,0,0,.18),
                0 15px 10px rgba(0,0,0,.21);
        }

        h1{
            font-size: 30px;
            color: #fff;
            text-transform: uppercase;
            font-weight: 300;
            text-align: center;
            margin-bottom: 15px;
        }
        table{
            width:50%;
            margin: 0 auto;
            table-layout: fixed;
        }
        .tbl-header{
            background-color: rgba(255,255,255,0.3);
        }
        .tbl-content{
            height:300px;
            overflow-x:auto;
            margin-top: 0px;
            border: 1px solid rgba(255,255,255,0.3);
        }
        th{
            padding: 20px 15px;
            text-align: left;
            font-weight: 500;
            font-size: 24px;
            color: #fff;
            text-transform: uppercase;
        }
        td{
            padding: 15px;
            text-align: left;
            vertical-align:middle;
            font-weight: 300;
            font-size: 20px;
            color: #fff;
            border-bottom: solid 1px rgba(255,255,255,0.1);
        }


        /* demo styles */
        body{
            background: -webkit-linear-gradient(left, #25c481, #25b7c4);
            background: linear-gradient(to right, #25c481, #25b7c4);
            font-family: 'Roboto', sans-serif;
        }

        /* follow me template */

        .made-with-love a {
            color: #fff;
            text-decoration: none;
        }
        .made-with-love a:hover {
            text-decoration: underline;
        }


        /* for custom scrollbar for webkit browser*/

        ::-webkit-scrollbar {
            width: 6px;
        } 
        ::-webkit-scrollbar-track {
            -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
        } 
        ::-webkit-scrollbar-thumb {
            -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
        }
    </style>
    <body>
        <a href="./Home/HomePage" style="font-size: 32px;text-decoration: none ;cursor: pointer;">👈 Back to Home</a>
        <link href="https://fonts.googleapis.com/css?family=Mr+Dafoe" rel="stylesheet">
        <div class="shadow">RECEIPT</div>
        <h1 style="text-align: center;">Thanks for your purchasing our products</h1>
        <div>
            <table >
                <tr>
                    <td colspan="2"><b>Transaction Details:</b></td>
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
    <script>
        $(window).on("load resize ", function () {
            var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
            $('.tbl-header').css({'padding-right': scrollWidth});
        }).resize();
    </script>
</html>

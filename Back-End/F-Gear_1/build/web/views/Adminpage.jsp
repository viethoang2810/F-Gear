<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/CSS/Adminpage.css"/>
    <link rel="stylesheet" href="../assets/CSS/responsive.css"/>
    <title>Admin Page</title>
    <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
    <link rel="stylesheet" href="../assets/CSS/Responive.css">
</head>
<style>
    td, th {
        border: 1px solid #000;
        padding: 5px 10px;
    }
    .tabs-box {
        width: 100%;
        padding:30px 0;
    }

    .tabs {
        display: flex;
        position: relative;
        justify-content: center;
        user-select: none;
        flex-wrap: wrap;
        width: 100%;
    }

    .tabs .line {
        position: absolute;
        left: 0;
        bottom: 0;
        width: 0;
        height: 6px;
        border-radius: 15px;
        background-color: #c23564;
        transition: all 0.2s ease;
    }

    .tab-item {
        /*min-width: 80px;*/
        padding: 16px 20px 11px 20px;
        font-size: 18px;
        text-align: center;
        color: #c23564;
        background-color: #fff;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
        border-bottom: 5px solid transparent;
        opacity: 0.6;
        cursor: pointer;
        transition: all 0.5s ease;
    }

    .tab-icon {
        font-size: 24px;
        width: 32px;
        position: relative;
        top: 2px;
    }

    .tab-item:hover {
        opacity: 1;
        background-color: rgba(194, 53, 100, 0.05);
        border-color: rgba(194, 53, 100, 0.1);
    }

    .tab-item.active {
        opacity: 1;
    }

    .tab-content {
        padding: 28px 0;
    }

    .tab-pane {
        color: #333;
        display: none;
    }

    .tab-pane.active {
        display: block;
    }

    .tab-pane h2 {
        font-size: 24px;
        margin-bottom: 8px;
    }

</style>

<body>
    <fmt:setLocale value="vi_VN"/>
    <div class="container-fluid">
        <div class="row header">
            <header class="header-wrapper">
                <img src="../assets/Images/Logo_After_Login.png" alt="" class="header-logo">
            </header>
        </div>
        <div class="row ">
            <div class="white-space">

            </div>
        </div>
        <div class="dashboard-container">
            <div class="dashboard-container-box">
                <h1 class="dashboard-container-title"><a href="../Admin/Dashboard">Dashboard</a></h1>
                <h2 class="dashboard-container-name-item"><a href="../Admin/Management">Product Management</a></h2>
                <h2 class="dashboard-container-name-item"><a href="../Admin/AccountManagement">Account Management</a></h2>
            </div>
            <div class="dashboard-container-statistics">
                <h1>Statistics per month</h1>
                <div class="dashboard-container-statistics-list-item">
                    <div class="dashboard-container-statistics-item">
                        <h2>Gross Monthly Sales</h2>
                        <span>
                            <fmt:formatNumber value="${total}" type="currency"/>
                        </span>
                    </div>
                    <div class="dashboard-container-statistics-item">
                        <h2>Total Sold Products</h2>
                        <span>
                            ${quantity}
                        </span>
                    </div>
                    <div class="dashboard-container-statistics-item">
                        <h2>Top product of all-time bestsellers</h2>
                    </div>
                    <div class="dashboard-container-statistics-item">
                        <h2>Top selling products per types</h2>
                    </div>
                </div>
            </div>

            <div class="chart chart-active">
                <canvas id="myChart" width="400" height="200"></canvas>
            </div>
            <div class="chart">
                <canvas id="myChart2" width="400" height="200"></canvas>
            </div>
            <div class="chart">
                <canvas id="myChart3" width="400" height="200"></canvas>
            </div>
            <div class="chart">
                <canvas id="myChart4" width="400" height="200"></canvas>
            </div>




            <div class="tabs-box">
                <h1 style="text-align: center;">Top selling products per month</h1> 
                <!-- Tab items -->
                <div class="tabs">
                    <div class="tab-item active">
                        <i class="tab-icon fas fa-code"></i>
                        January
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-cog"></i>
                        February
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-plus-circle"></i>
                        March
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        April
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        May
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        June
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        July
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        August
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        September
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        October
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        November
                    </div>
                    <div class="tab-item">
                        <i class="tab-icon fas fa-pen-nib"></i>
                        December
                    </div>
                    <div class="line"></div>
                </div>


                <div class="tab-content">
                    <div class="tab-pane active">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth1}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth2}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth3}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach> 
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth4}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth5}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth6}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth7}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth8}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth9}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach> 
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth10}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth11}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane">
                        <table style="width: 80%; margin: 0 auto; border-collapse: collapse;">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Sold Quantity</th>
                                    <th>Sales Of Products</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lm1" items="${listSellingMonth12}">
                                    <tr>
                                        <td>${lm1.proName}</td>
                                        <td  style="text-align: center;">${lm1.quantity}</td>
                                        <td  style="text-align: center;"> <fmt:formatNumber value="${lm1.total}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>     

            <div style="width: 100%; background: #f1a8a8; border-radius: 10px; padding: 20px 0;">
                <h1 style="text-align: center;">Total users: 200</h1>
                <div style="width: 100%; display: flex; justify-content: center; margin: 20px 0; text-align: center;">
                    <div style="width: 40%; margin-right: 30px; background: #9292d7; border-radius: 10px; padding: 20px 0;">
                        <h2>Users in Web's account</h2>
                        <span style="font-size: 30px;">120</span>
                    </div>
                    <div style="width: 40%; background: #ea4335; border-radius: 10px; padding: 20px 0;">
                        <h2>Users with Google's account</h2>
                        <span style="font-size: 30px;">80</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var ctx2 = document.getElementById('myChart2').getContext('2d');
    var ctx3 = document.getElementById('myChart3').getContext('2d');
    var ctx4 = document.getElementById('myChart4').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'bar', // hoặc là line/bar/radar
        data: {
            labels: [
    ${listEachMonth[0].month},${listEachMonth[1].month},
    ${listEachMonth[2].month},${listEachMonth[3].month},
    ${listEachMonth[4].month}, ${listEachMonth[5].month},
    ${listEachMonth[6].month}, ${listEachMonth[7].month},
    ${listEachMonth[8].month}, ${listEachMonth[9].month},
    ${listEachMonth[10].month}, ${listEachMonth[11].month},
    ${listEachMonth[12].month}
            ],
            // Information about the dataset
            datasets: [{
                    label: "Gross Monthly Sales",
                    backgroundColor: 'lightblue',
                    borderColor: 'royalblue',
                    data: [
    ${listEachMonth[0].total},${listEachMonth[1].total},
    ${listEachMonth[2].total},${listEachMonth[3].total},
    ${listEachMonth[4].total}, ${listEachMonth[5].total},
    ${listEachMonth[6].total}, ${listEachMonth[7].total},
    ${listEachMonth[8].total}, ${listEachMonth[9].total},
    ${listEachMonth[10].total}, ${listEachMonth[11].total},
                    ],
                }]
        },
        // Configuration options, đừng đụng phần này nha các bro
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            },
            layout: {
                padding: 10,
            },
            legend: {
                position: 'bottom',
            },
            title: {
                display: true,
                text: 'sales in 2022'
            },
            scales: {
                yAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Total Income'
                        }
                    }],
                xAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Month of the Year'
                        }
                    }]
            }
        }
    })
    var chart2 = new Chart(ctx2, {
        // The type of chart we want to create
        type: 'bar', // hoặc là line/bar/radar
        data: {
            labels: [
    ${listQuantityEachMonth[0].month}, ${listQuantityEachMonth[1].month},
    ${listQuantityEachMonth[2].month}, ${listQuantityEachMonth[3].month},
    ${listQuantityEachMonth[4].month}, ${listQuantityEachMonth[5].month},
    ${listQuantityEachMonth[6].month}, ${listQuantityEachMonth[7].month},
    ${listQuantityEachMonth[8].month}, ${listQuantityEachMonth[9].month},
    ${listQuantityEachMonth[10].month}, ${listQuantityEachMonth[11].month},
            ],
            // Information about the dataset
            datasets: [{
                    label: "Total Sold Products",
                    backgroundColor: 'lightgreen',
                    borderColor: 'royalgreen',
                    data: [
    ${listQuantityEachMonth[0].quantity}, ${listQuantityEachMonth[1].quantity},
    ${listQuantityEachMonth[2].quantity}, ${listQuantityEachMonth[3].quantity},
    ${listQuantityEachMonth[4].quantity}, ${listQuantityEachMonth[5].quantity},
    ${listQuantityEachMonth[6].quantity}, ${listQuantityEachMonth[7].quantity},
    ${listQuantityEachMonth[8].quantity}, ${listQuantityEachMonth[9].quantity},
    ${listQuantityEachMonth[10].quantity}, ${listQuantityEachMonth[11].quantity},
                    ],
//                        backgroundColor: [
//                            '#303d22',
//                            '#4dc3dd',
//                            '#ce0eb8',
//                            '#92cc98',
//                            '#ea6152',
//                            '#f23064',
//                            '#515641',
//                            '#916751',
//                            '#19d64f',
//                            '#ce5eb2',
//                            '#cea510',
//                            '#5e2b07',
//                        ]
                }]
        },
        // Configuration options, đừng đụng phần này nha các bro
        options: {
            layout: {
                padding: 10,
            },
            legend: {
                position: 'bottom',
            },
            title: {
                display: true,
                text: 'sales in 2022'
            },
            scales: {
                yAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Number of products'
                        }
                    }],
                xAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Month of the Year'
                        }
                    }]
            }
        }
    })
    var chart3 = new Chart(ctx3, {
        // The type of chart we want to create
        type: 'doughnut', // hoặc là line/bar/radar/pie/
        data: {
            labels: [
                "${listSellingAllTime[0].proName}", "${listSellingAllTime[1].proName}",
                "${listSellingAllTime[2].proName}", "${listSellingAllTime[3].proName}",
                "${listSellingAllTime[4].proName}", "${listSellingAllTime[5].proName}",
                "${listSellingAllTime[6].proName}", "${listSellingAllTime[7].proName}",
                "${listSellingAllTime[8].proName}", "${listSellingAllTime[9].proName}",
                "${listSellingAllTime[10].proName}", "${listSellingAllTime[11].proName}",
            ],
            // Information about the dataset
            datasets: [{
                    label: "Sold Quantity",
                    backgroundColor: 'darksalmon',
                    borderColor: 'darksalmon',
                    data: [
    ${listSellingAllTime[0].quantity},${listSellingAllTime[1].quantity},
    ${listSellingAllTime[2].quantity},${listSellingAllTime[3].quantity},
    ${listSellingAllTime[4].quantity},${listSellingAllTime[5].quantity},
    ${listSellingAllTime[6].quantity},${listSellingAllTime[7].quantity},
    ${listSellingAllTime[8].quantity},${listSellingAllTime[9].quantity},
    ${listSellingAllTime[10].quantity},${listSellingAllTime[11].quantity},
                    ],
                    backgroundColor: [
                        '#303d22',
                        '#4dc3dd',
                        '#ce0eb8',
                        '#92cc98',
                        '#ea6152',
                        '#f23064',
                        '#515641',
                        '#916751',
                        '#19d64f',
                        '#ce5eb2',
                        '#cea510',
                        '#5e2b07',
                    ]
                }]
        },
        // Configuration options, đừng đụng phần này nha các bro
        options: {
            title: {
                display: true,
                text: 'sales in 2022'
            },
            legend: {
                position: 'right',
            },
        }
    })
    var chart4 = new Chart(ctx4, {
        // The type of chart we want to create

        data: {
            // Information about the dataset
            datasets: [
                {
                    type: 'line',
                    label: "Laptops Gaming",
//                        backgroundColor: 'lightblue',
                    borderColor: 'blue',
                    fill: false,
                    data: [
    ${listGamingQuanity[0].quantity},${listGamingQuanity[1].quantity},
    ${listGamingQuanity[2].quantity},${listGamingQuanity[3].quantity},
    ${listGamingQuanity[4].quantity},${listGamingQuanity[5].quantity},
    ${listGamingQuanity[6].quantity},${listGamingQuanity[7].quantity},
    ${listGamingQuanity[8].quantity},${listGamingQuanity[9].quantity},
    ${listGamingQuanity[10].quantity},${listGamingQuanity[11].quantity},
                    ],
                },
                {
                    type: 'line',
                    label: "Office Laptops",
//                        backgroundColor: 'lightgreen',
                    borderColor: 'red',
                    fill: false,
                    data: [
    ${listOfficeQuanity[0].quantity},${listOfficeQuanity[1].quantity},
    ${listOfficeQuanity[2].quantity},${listOfficeQuanity[3].quantity},
    ${listOfficeQuanity[4].quantity},${listOfficeQuanity[5].quantity},
    ${listOfficeQuanity[6].quantity},${listOfficeQuanity[7].quantity},
    ${listOfficeQuanity[8].quantity},${listOfficeQuanity[9].quantity},
    ${listOfficeQuanity[10].quantity},${listOfficeQuanity[11].quantity},
                    ],
                },
                {
                    type: 'line',
                    label: "Mouses",
//                        backgroundColor: 'green',
                    borderColor: 'green',
                    fill: false,
                    data: [
    ${listMouseQuanity[0].quantity},${listMouseQuanity[1].quantity},
    ${listMouseQuanity[2].quantity},${listMouseQuanity[3].quantity},
    ${listMouseQuanity[4].quantity},${listMouseQuanity[5].quantity},
    ${listMouseQuanity[6].quantity},${listMouseQuanity[7].quantity},
    ${listMouseQuanity[8].quantity},${listMouseQuanity[9].quantity},
    ${listMouseQuanity[10].quantity},${listMouseQuanity[11].quantity},
                    ],
                }, {
                    type: 'line',
                    label: "Headphones",
//                        backgroundColor: 'black',
                    borderColor: 'black',
                    fill: false,
                    data: [
    ${listHeadphoneQuanity[0].quantity},${listHeadphoneQuanity[1].quantity},
    ${listHeadphoneQuanity[2].quantity},${listHeadphoneQuanity[3].quantity},
    ${listHeadphoneQuanity[4].quantity},${listHeadphoneQuanity[5].quantity},
    ${listHeadphoneQuanity[6].quantity},${listHeadphoneQuanity[7].quantity},
    ${listHeadphoneQuanity[8].quantity},${listHeadphoneQuanity[9].quantity},
    ${listHeadphoneQuanity[10].quantity},${listHeadphoneQuanity[11].quantity},
                    ],
                }

            ], labels: ["January", "February", "March", "April", "May", "June", "July", "August ", "September", "October", "November", "December"],

        },
        // Configuration options, đừng đụng phần này nha các bro
        options: {
            layout: {
                padding: 10,
            },
            legend: {
                position: 'bottom',
            },
            title: {
                display: true,
                text: 'sales in 2022'
            },
            scales: {
                yAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Number of products'
                        }
                    }],
                xAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: 'Month of the Year'
                        }
                    }]
            }
        }
    })

    const listStatistics = document.querySelectorAll('.dashboard-container-statistics-item')
    const listChart = document.querySelectorAll('.chart')

    listStatistics.forEach((item, index) => {
        const chart = listChart[index]
        item.onclick = function () {
            document.querySelector('.chart.chart-active').classList.remove('chart-active')
            chart.classList.add('chart-active')
        }
    })

    const $ = document.querySelector.bind(document);
    const $$ = document.querySelectorAll.bind(document);

    const tabs = $$(".tab-item");
    const panes = $$(".tab-pane");

    const tabActive = $(".tab-item.active");
    const line = $(".tabs .line");

    line.style.left = tabActive.offsetLeft + "px";
    line.style.width = tabActive.offsetWidth + "px";

    tabs.forEach((tab, index) => {
        const pane = panes[index];

        tab.onclick = function () {
            $(".tab-item.active").classList.remove("active");
            $(".tab-pane.active").classList.remove("active");

            line.style.left = this.offsetLeft + "px";
            line.style.width = this.offsetWidth + "px";

            this.classList.add("active");
            pane.classList.add("active");
        };
    });

</script>


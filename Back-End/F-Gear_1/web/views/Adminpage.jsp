﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./CSS/Adminpage.css">
    <link rel="stylesheet" href="./CSS/responsive.css">
    <title>Admin Page</title>
</head>
<style>

</style>

<body>
    <div class="dashboard-container">
        <div class="dashboard-container-box">
            <h1 class="dashboard-container-title"><a href="#">Dashboard</a></h1>
            <h2 class="dashboard-container-name-item">Product Management</h2>
        </div>
        <div class="dashboard-container-statistics">
            <h1>Statistics per month</h1>
            <div class="dashboard-container-statistics-list-item">
                <div class="dashboard-container-statistics-item">
                    <h2>Total Income</h2>
                    <span>1.000.000 VNĐ</span>
                </div>
                <div class="dashboard-container-statistics-item">
                    <h2>Chart 2</h2>
                    <span>1.000.000 VNĐ</span>
                </div>
                <div class="dashboard-container-statistics-item">
                    <h2>Chart 3</h2>
                    <span>1.000.000 VNĐ</span>
                </div>
                <div class="dashboard-container-statistics-item">
                    <h2>Chart 4</h2>
                    <span>1.000.000 VNĐ</span>
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

    </div>

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var ctx2 = document.getElementById('myChart2').getContext('2d');
    var ctx3 = document.getElementById('myChart3').getContext('2d');
    var ctx4 = document.getElementById('myChart4').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'line', // hoặc là line/bar/radar
        data: {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August ", "September", "October", "November", "December"],
            // Information about the dataset
            datasets: [{
                label: "Doanh thu",
                backgroundColor: 'lightblue',
                borderColor: 'royalblue',
                data: [20, 19, 19, 58, 61, 47, 28, 36, 17, 69, 11, 91],
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
        type: 'line', // hoặc là line/bar/radar
        data: {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August ", "September", "October", "November", "December"],
            // Information about the dataset
            datasets: [{
                label: "Rainfall",
                backgroundColor: 'lightblue',
                borderColor: 'royalblue',
                data: [40, 29, 19, 68, 71, 87, 48, 79, 27, 91, 11, 75],
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
                text: 'Chart 2'
            },
            scales: {
                yAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'Precipitation in mm'
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
        type: 'line', // hoặc là line/bar/radar
        data: {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August ", "September", "October", "November", "December"],
            // Information about the dataset
            datasets: [{
                label: "Rainfall",
                backgroundColor: 'lightblue',
                borderColor: 'royalblue',
                data: [29, 29, 49, 48, 41, 17, 58, 39, 77, 59, 21, 71],
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
                text: 'Chart 3'
            },
            scales: {
                yAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'Precipitation in mm'
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
    var chart4 = new Chart(ctx4, {
        // The type of chart we want to create
        type: 'line', // hoặc là line/bar/radar
        data: {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August ", "September", "October", "November", "December"],
            // Information about the dataset
            datasets: [{
                label: "Rainfall",
                backgroundColor: 'lightblue',
                borderColor: 'royalblue',
                data: [20, 19, 49, 48, 11, 17, 58, 39, 27, 9, 81, 71],
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
                text: 'Chart 4'
            },
            scales: {
                yAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'Precipitation in mm'
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

</script>

</html>
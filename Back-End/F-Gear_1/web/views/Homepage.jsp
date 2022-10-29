
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">


    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="../assets/CSS/Homepage.css"/>
        <link rel="stylesheet" href="../assets/CSS/responsive.css"/>
        <title>F-Gear</title>
    </head>

    <style>
        h3 {
            font-weight: 500;
        }

        label {
            cursor: pointer;
        }

        #place,
        #brand {
            user-select: none;
            cursor: pointer;
            margin: 0;
            padding: 0;
        }

        .brand {
            display: none;

        }

        .brand-active {
            display: block;
            overflow: hidden;
            animation: show ease-in .3s;
        }

        .place {
            display: none;

        }

        .place-active {
            display: block;
            overflow: hidden;
            animation: show ease-in .3s;
        }

        .checkboxBtn {
            width:80%; padding: 5px 7px; border: none; border-radius: 10px;
            cursor: pointer;
            background-color: #83aae3;
            margin-top: 20px;
        }
        .checkboxBtn:hover {
            background-color: #0d6efd;
            color: white;
        }

        @keyframes show {
            0% {
                height: 0px;
            }

            100% {
                height: 100px;
            }
        }
    </style>

    <body>

        <%@include file="Header.jsp" %>

        <div class="body">
            <div class="body-interactive">
                <div class="body-category-search">
                    <form action="./Home">
                        <input type="text" placeholder="Enter code or name of product . . . " name="keySearch" />
                        <button name="option" value="search" type="submit"> <i class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                </div>
            </div>
            <div class="body-img">
                <img src="https://theme.hstatic.net/1000026716/1000440777/14/slideshow_3.jpg?v=28748" />
                <div>
                    <img src="https://theme.hstatic.net/1000026716/1000440777/14/solid1.jpg?v=28748" />
                    <img src="https://theme.hstatic.net/1000026716/1000440777/14/solid2.jpg?v=28748" />
                </div>
            </div>
            <h1 class="body-title">
                Featurerd Product
            </h1>
            <div style="display: flex; justify-content: space-between;">
                <form action="" style="background-color: #00000017; width: 15%; padding-left: 20px; border-radius: 10px;">
                    <div>
                        <h3 id="brand">Brand 
                            <img src="https://www.freeiconspng.com/uploads/arrow-down-icon-png-1.png" style="width:30px;"/>
                        </h3>
                        <div class="brand">
                            <ul style="list-style: none; padding: 0;">
                                <li>
                                    <input type="checkbox" id="logitech" value="logitech" name=""/>
                                    <label for="logitech">Logitech</label>
                                </li>
                                <li>
                                    <input type="checkbox" id="razer" value="razer" name=""/>
                                    <label for="razer">Razer</label>
                                </li>
                                <li>
                                    <input type="checkbox" id="edra" value="edra" name=""/>
                                    <label for="edra">Edra</label>
                                </li>
                                <li>
                                    <input type="checkbox" id="asus" value="asus" name=""/>
                                    <label for="asus">Asus</label>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <h3 id="place">Place  
                            <img src="https://www.freeiconspng.com/uploads/arrow-down-icon-png-1.png" style="width:30px;"/>
                        </h3>
                        <div class="place">
                            <ul style="list-style: none; padding: 0;">
                                <li>
                                    <input type="checkbox" id="hcm" value="hcm" name=""/>
                                    <label for="hcm">Ho Chi Minh City</label>
                                </li>
                                <li>
                                    <input type="checkbox" id="hn" value="hn" name=""/>
                                    <label for="hn">Ha Noi</label>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <button class="checkboxBtn">Search</button>
                </form>
                <div class="body-list-product" style="width: 84%;">
                    <c:forEach var="list" items="${listHomepage}" varStatus="status">
                        <a href="<c:url value="../Detail/DetailPro?proID=${list.proID}"/>">
                            <img
                                src="${list.listImage[status.index].url}" />
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>


        <%@include file="./Footer.jsp" %>

    </body>
    <script>
        const place = document.getElementById('place')
        const brand = document.getElementById('brand')

        place.onclick = function () {
            document.querySelector('.place').classList.toggle('place-active')
        }
        brand.onclick = function () {
            document.querySelector('.brand').classList.toggle('brand-active')
        }
    </script>


</html>
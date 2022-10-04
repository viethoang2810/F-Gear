
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
    <link rel="stylesheet" href="./assets/CSS/Homepage.css"/>
    <link rel="stylesheet" href="./assets/CSS/responsive.css"/>
    <title>F-Gear</title>
</head>

   

    <body>

        <%@include file="Header.jsp" %>

        <div class="body">
            <div class="body-interactive">
                <h1 class="body-category">
                    <i class="fa-solid fa-bars"></i>
                    <span> Categories</span>
                    <div class="body-category-list">
                        <ul class="body-category-list-item">
                            <hr />
                            <li class="body-category-list-each-item">
                                <a href="#">Laptop Gaming</a>
                            </li>
                            <hr />
                            <li class="body-category-list-each-item">
                                <a href=" #">Office Laptop</a>
                            </li>
                            <hr />
                            <li class="body-category-list-each-item">
                                <a href=" #">Mouses</a>
                            </li>
                            <hr />
                            <li class="body-category-list-each-item">
                                <a href=" #">Head Phones</a>
                            </li>
                            <hr />
                        </ul>
                        <div class="body-category-sub-list body-category-sub-list-active">
                            <ul class="body-category-list-sub-item">
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Brands</h4>
                                        <ul>
                                            <li><a href="#">ACER</a></li>
                                            <li><a href="#">ASUS</a></li>
                                            <li><a href="#">MSI</a></li>
                                            <li><a href="#">DELL</a></li>
                                            <li><a href="#">LENOVO</a></li>
                                            <li><a href="#">HP</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="#">Under 20 million</a></li>
                                            <li><a href="#">From 20 to less than 25 million</a></li>
                                            <li><a href="#">From 25 to less than 30 million</a></li>
                                            <li><a href="#">Over 30 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>ASUS</h4>
                                        <ul>
                                            <li><a href="#">ROG Series</a></li>
                                            <li><a href="#">TUF Series</a></li>
                                            <li><a href="#">Zephyrus Series</a></li>
                                            <li><a href="#">ROG Strix G</a></li>
                                            <li><a href="#">ROG Flow Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>MSI Gaming</h4>
                                        <ul>
                                            <li><a href="#">GF Series</a></li>
                                            <li><a href="#">GL Series</a></li>
                                            <li><a href="#">GS Series</a></li>
                                            <li><a href="#">MSI AMD Series</a></li>
                                            <li><a href="#">Bravo Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>DELL Gaming</h4>
                                        <ul>
                                            <li><a href="#">DELL Gaming G Series</a></li>
                                            <li><a href="#">Alienware Series</a></li>
                                            <li><a href="#">Logitech</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>LENOVO Gaming</h4>
                                        <ul>
                                            <li><a href="#">LENOVO Gaming Series</a></li>
                                            <li><a href="#">Ideapad Gaming Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Graphics card</h4>
                                        <ul>
                                            <li><a href="#">GTX 1650</a></li>
                                            <li><a href="#">GTX 3050/3050Ti</a></li>
                                            <li><a href="#">GTX 3060</a></li>
                                            <li><a href="#">GTX 3070/3080</a></li>
                                            <li><a href="#">AMD Radeon RX</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="body-category-sub-list">
                            <ul class="body-category-list-sub-item">
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Brands</h4>
                                        <ul>
                                            <li><a href="#">MSI</a></li>
                                            <li><a href="#">DELL</a></li>
                                            <li><a href="#">ACER</a></li>
                                            <li><a href="#">ASUS</a></li>
                                            <li><a href="#">HP</a></li>
                                            <li><a href="#">LG</a></li>
                                            <li><a href="#">HUAWEI</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="#">Under 15 million</a></li>
                                            <li><a href="#">From 15 million to under 20 million</a></li>
                                            <li><a href="#">Over 20 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop by CPU</h4>
                                        <ul>
                                            <li><a href="#">Intel Core i3</a></li>
                                            <li><a href="#">Intel Core i5</a></li>
                                            <li><a href="#">Intel Core i7</a></li>
                                            <li><a href="#">Intel Core i9</a></li>
                                            <li><a href="#">AMD Ryzen</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop ASUS</h4>
                                        <ul>
                                            <li><a href="#">VivoBook Series</a></li>
                                            <li><a href="#">VivoBook Pro Series</a></li>
                                            <li><a href="#">Zenbook Series</a></li>
                                            <li><a href="#">ASUS Oled Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop ACER</h4>
                                        <ul>
                                            <li><a href="#">Aspire Series</a></li>
                                            <li><a href="#">Swift Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop DELL</h4>
                                        <ul>
                                            <li><a href="#">Vostro Series</a></li>
                                            <li><a href="#">Inspiron Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop HP</h4>
                                        <ul>
                                            <li><a href="#">Probook Series</a></li>
                                            <li><a href="#">Envy Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Laptop MSI</h4>
                                        <ul>
                                            <li><a href="#">Modern Series</a></li>
                                            <li><a href="#">Prestige Series</a></li>
                                            <li><a href="#">Summit Series</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="body-category-sub-list">
                            <ul class="body-category-list-sub-item">
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Mouses by brands</h4>
                                        <ul>
                                            <li><a href="#">LOGITECH</a></li>
                                            <li><a href="#">ASUS</a></li>
                                            <li><a href="#">RAZER</a></li>
                                            <li><a href="#">CORSAIR</a></li>
                                            <li><a href="#">STEELSERIES</a></li>
                                            <li><a href="#">HYPERX</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Mouses by brands</h4>
                                        <ul>
                                            <li><a href="#">DARE - U</a></li>
                                            <li><a href="#">Fuhlen</a></li>
                                            <li><a href="#">Akko</a></li>
                                            <li><a href="#">MSI</a></li>
                                            <li><a href="#">EDRA</a></li>
                                            <li><a href="#">LENOVO</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="#">Under 500 thousand</a></li>
                                            <li><a href="#">From 500 thousand to under 1 million</a></li>
                                            <li><a href="#">From 1 million to under 2 million</a></li>
                                            <li><a href="#">From 2 million to under 3 million</a></li>
                                            <li><a href="#">Over 3 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Connect Type</h4>
                                        <ul>
                                            <li><a href="#">Bluetooth</a></li>
                                            <li><a href="#">Wireless</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="body-category-sub-list">
                            <ul class="body-category-list-sub-item">
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Headphones by brands</h4>
                                        <ul>
                                            <li><a href="#">LOGITECH</a></li>
                                            <li><a href="#">ASUS</a></li>
                                            <li><a href="#">RAZER</a></li>
                                            <li><a href="#">CORSAIR</a></li>
                                            <li><a href="#">STEELSERIES</a></li>
                                            <li><a href="#">HYPERX</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Headphones by brands</h4>
                                        <ul>
                                            <li><a href="#">DARE - U</a></li>
                                            <li><a href="#">LENOVO</a></li>
                                            <li><a href="#">EDRA</a></li>
                                            <li><a href="#">MSI</a></li>
                                            <li><a href="#">AKKO</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Price</h4>
                                        <ul>
                                            <li><a href="#">Under 500 thousand</a></li>
                                            <li><a href="#">From 500 thousand to under 1 million</a></li>
                                            <li><a href="#">From 1 million to under 2 million</a></li>
                                            <li><a href="#">From 2 million to under 3 million</a></li>
                                            <li><a href="#">Over 3 million</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="body-category-list-sub-each-item">
                                    <div class="body-category-list-sub2-each-item">
                                        <h4>Connect Type</h4>
                                        <ul>
                                            <li><a href="#">Bluetooth</a></li>
                                            <li><a href="">Wireless</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </h1>
                <div class="body-category-search">
                    <form action="">
                        <input type="text" placeholder="Enter code or name of product . . . " />
                        <button> <i class="fa-solid fa-magnifying-glass"></i></button>
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
            <div class="body-list-product">
                <c:forEach var="list" items="${listHomepage}" varStatus="status">
                    <a href="<c:url value="/views/Detail_Product.jsp?id=${list.proID}"/>">
                        <img
                            src="${list.listImage[status.index].url}" />
                    </a>
                </c:forEach>
            </div>
        </div>


            <%@include file="./Footer.jsp" %>

</body>
<script src="./assets/JavaScript/Homepage.js">


</html>
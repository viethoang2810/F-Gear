<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../assets/CSS/Homepage.css"/>
        <link rel="stylesheet" href="../assets/CSS/Sale.css"/>
        <link rel="stylesheet" href="../assets/CSS/responsive.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Document</title>
    </head>

    <body>
        <%@include file="Header.jsp" %>

        <div class="body-img">
            <img src="https://theme.hstatic.net/1000026716/1000440777/14/slideshow_3.jpg?v=28748" />
            <div>
                <img src="https://theme.hstatic.net/1000026716/1000440777/14/solid1.jpg?v=28748" />
                <img src="https://theme.hstatic.net/1000026716/1000440777/14/solid2.jpg?v=28748" />
            </div>
        </div>

        <div class="sale-body">
            <h1 class="sale-title">Back to school</h1>
            <c:forEach var="saleItem" items="${proOnSale}">
                <div class="sale-brand-item">
                    <div class="sale-brand">
                        <span>${saleItem.key}</span>
                    </div>
                    <div class="body-list-product">
                        <c:forEach var="item" items="${proOnSale.get(saleItem.key)}">
                            <a href="../Detail/DetailPro?proID=${item.proID}">
                                <img
                                    src="${item.listImage.get(0).url}" />
                            </a>
                            
                        </c:forEach>
                    </div>
                    <button type="button" class="slide">
                        <a href="../Product/Store">
                            <div> Show more</div>
                            <i class="fa-solid fa-arrow-right"></i>
                        </a>
                    </button>

                </div>

            </c:forEach>
        </div>
    </div>
</div>
<%@include file="Footer.jsp" %>

</body>

</html>
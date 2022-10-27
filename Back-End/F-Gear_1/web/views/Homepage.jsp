
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



    <body>

        <%@include file="Header.jsp" %>

        <div class="body">
            <div class="body-interactive">
                <div class="body-category-search">
                    <form action="./Home?action=search">
                        <input type="text" placeholder="Enter code or name of product . . . " />
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
            <div class="body-list-product">
                <c:forEach var="list" items="${listHomepage}" varStatus="status">
                    <a href="<c:url value="../Detail/DetailPro?proID=${list.proID}"/>">
                        <img
                            src="${list.listImage[status.index].url}" />
                    </a>
                </c:forEach>
            </div>
        </div>


        <%@include file="./Footer.jsp" %>

    </body>



</html>
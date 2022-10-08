<%-- 
    Document   : editProduct_Page
    Created on : Oct 2, 2022, 2:38:07 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color: red">Edit Product</h1>
        <form action="./admin">   
            Product ID: <br/>
            <input type="number" name="proID" readonly="" value="${product.proID}"/><br/>
            New Product Name: <br/>
            <input type="text" name="proName" value="${product.proName}" required=""><br/>
            New Original Price: <br/>
            <input type="number" name="proOriginalPrice" value="${product.proOriginalPrice}" required=""><br/>
            New Discount: <br/>
            <input type="number" name="Discount" value="${product.discount}" required="" min="0" max="50"><br/>
            New Status:
            <select name="status">
                <option value="0" ${product.status==0?"selected":""}>Inactive</option>
                <option value="1" ${product.status==1?"selected":""}>Active</option>
            </select>
            <br/>
            <input type="submit" name="op" value="update"/>
        </form> 
        <i style="color:red">${result}</i>
    </body>
</html>

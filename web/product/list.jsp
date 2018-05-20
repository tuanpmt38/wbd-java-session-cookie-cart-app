<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/4/18
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>List product</h1>
<table border="1px">

    <tr>
        <td>Name product</td>
        <td>Price</td>
        <td>Add to cart</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
    <tr>

        <td><a href="/products?action=view&id=${product.getId()}">${product.getProductname()}</a></td>
        <td>${product.getProductprice()}</td>
        <td>
            <a href="/cart?action=add&id=${product.getId()}">
                Add to cart
            </a>
        </td>

    </tr>
    </c:forEach>
</table>
</body>
</html>

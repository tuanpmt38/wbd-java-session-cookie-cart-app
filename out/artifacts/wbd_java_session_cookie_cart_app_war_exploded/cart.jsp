<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 5/6/18
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    Map carts = (HashMap) httpSession.getAttribute("shoppingCart");
    List products = new ArrayList<>();
    if(carts != null) {
        products.addAll(carts.values());
        request.setAttribute("products", products);
    }
%>

<h1>Info cart</h1>
<p>
    <a href="/products">Back to products</a>
</p>
<c:if test="${requestScope['products'].size() > 0}">
    <table border="1">
        <thead>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope['products']}" var="product">
            <tr>
                <td>
                        ${product.getProductname()}
                </td>
                <td>
                        ${product.getProductprice()}
                </td>
                <td>
                        ${product.getAmount()}
                </td>
                <td>
                    <a href="/cart?action=update&id=${product.getId()}&amount=${product.getAmount() - 1}">minus</a>
                </td>
                <td>
                    <a href="/cart?action=update&id=${product.getId()}&amount=${product.getAmount() + 1}">plus</a>
                </td>
                <td>
                    <a href="/cart?action=remove&id=${product.getId()}">remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--<p>--%>
        <%--<a href="/buy-all">Buy all</a>--%>
    <%--</p>--%>
</c:if>
</body>
</html>

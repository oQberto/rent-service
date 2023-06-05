<%--
  Created by IntelliJ IDEA.
  User: ermak
  Date: 6/5/2023
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Apartments</title>
</head>
<body>
<ul>
    <c:forEach var="apartment" items="${requestScope.apartments}">
        <li>${apartment.toString()}</li>
    </c:forEach>
</ul>
</body>
</html>

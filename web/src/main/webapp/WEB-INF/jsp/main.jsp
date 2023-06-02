<%--
  Created by IntelliJ IDEA.
  User: ermak
  Date: 6/2/2023
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>rent-service</title>
</head>
<body>
<h1>List of cities:</h1>
<h1>Hi from Main</h1>
<ul>
    <c:forEach var="city" items="${requestScope.cities}">
        <li>${city.name}</li>
    </c:forEach>
</ul>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 09.07.2023
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework 25</title>
</head>
<body>
<c:forEach var="elem" items="${products}">
    <h1><c:out value="${elem}"/></h1>
</c:forEach>
</body>
</html>

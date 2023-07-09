<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%
        List<String> names = Arrays.asList("Pasha", "Misha", "Sasha");
    %>
</head>
<body>
<form action="<c:url value="/login"/>" method="post">
    <%
        Map<String, String> errors = (Map<String, String>)request.getAttribute("errors");
        if (errors != null && errors.get("login") != null){
            out.println("<h1>" + errors.get("login") + "</h1>");
        }
    %>
    <input type="text" name="login">
    <%
        if (errors != null && errors.get("password") != null){
            out.println("<h1>" + errors.get("password") + "</h1>");
        }
    %>
    <input type="password" name="password">
    <input type="submit" name="Login">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<c:forEach var="elem" items="${names}">
    <c:if test="${elem.length()>3}">
        <h1><c:out value="${elem}"/></h1>
    </c:if>
    <c:if test="${elem.length()<=3}">
        <h1><c:out value="${elem}"/>: is less than 4</h1>
    </c:if>
<%--    <c:if test="${errors['password'] != null}">--%>
<%--        <c:redirect url="success.jsp"/>--%>
<%--    </c:if>--%>
    <c:choose>
        <c:when test="${elem == 'Pasha'}"><h1>This is Pasha</h1></c:when>
    </c:choose>
</c:forEach>
<a href="/products">here</a>
<a href="/homework_25.jsp">Homework 25</a>

</body>
</html>
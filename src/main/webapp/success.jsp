<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>Done</h1>
<c:forEach var="elem" items="${names}">
    <h1><c:out value="${elem}"/></h1>
</c:forEach>
</body>
</html>

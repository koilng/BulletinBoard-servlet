<%--
  Created by IntelliJ IDEA.
  User: grits
  Date: 01.09.2021
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css"/>
    <title>Title</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/board/">
    Header: <label>
    <input type="text" name="bullheader">
</label>
    Text: <label>
    <input type="text" name="bulltext">
</label>
    <input type="submit" value="Add bulletin">
</form>
</body>
</html>

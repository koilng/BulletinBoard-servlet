<%--
  Created by IntelliJ IDEA.
  User: grits
  Date: 01.09.2021
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logging out...</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("/board");
%>
</body>
</html>

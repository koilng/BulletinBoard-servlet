<%@ page import="dao.BulletinDAO" %>
<%@ page import="model.Bulletin" %>
<%--  Created by IntelliJ IDEA.
  User: grits
  Date: 01.09.2021
  Time: 11:49
  To change this template use File | Settings | File Templates.
&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css"/>
    <title>Bulletins</title>
</head>
<body>
<%
    if (session.getAttribute("person") == null) {
        out.println("<a href=\"/loginpage.html\">Log in</a>");
    } else {
        out.println("<a href=\"/add.jsp\">Add bulletin</a>");
        out.println("<a href=\"/logout.jsp\">Logout</a>");
    }
%>

<br>
<h1>Bulletins: </h1>

<div class="products">
    <div class="container">
        <div class="products_grid">
            <%
                BulletinDAO dao = (BulletinDAO) session.getAttribute("bulletinDAO");
                for (int i = 0; i < dao.index().size(); i++) {
                    Bulletin currentBulletin = dao.index().get(i);
                    currentBulletin.setId(i);
                    out.println(
                            "<div class=\"products_grid_plate\"> " +
                                    "<div class=\"text\">" +
                                    "<h2>" + currentBulletin.getHeader() + "</h2>" +
                                    "<br>" + currentBulletin.getText() +
                                    "</div>" +
                                    "<div class=\"buttons\">" +
                                    "<div class=\"like_button\">" +
                                    "<form method=\"post\" action=\"/board/\">" +
                                    "<button type=\"submit\" name=\"like\" value=\"" + currentBulletin.getId() + " \" class=\"button\"><img class=\"button_image\" src=\"like.png\" alt=\"like\"></button>" +
                                    "</form>" +
                                    "</div>" +
                                    "<div class=\"counter\">" +
                                    currentBulletin.getLikes() +
                                    "</div>" +
                                    "<div class=\"dislike_button\">" +
                                    "<form method=\"post\" action=\"/board/\">" +
                                    "<button type=\"submit\" name=\"dislike\" value=\"" + currentBulletin.getId() + " \" class=\"button\"><img class=\"button_image\" src=\"dislike.png\" alt=\"dislike\"></button>" +
                                    "</form>" +
                                    "</div>" +
                                    "<div class=\"counter\">" +
                                    currentBulletin.getDislikes() +
                                    "</div>" +
                                    "</div>" +
                                    "</div>");
                }
            %>
        </div>
    </div>
</div>

<br>
</body>
</html>

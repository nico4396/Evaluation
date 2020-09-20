<%--
  Created by IntelliJ IDEA.
  User: rujia
  Date: 2020/9/13
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>清空</title>
</head>
<body>
<%
    session.removeAttribute("uname");
    response.sendRedirect("login");
%>
</body>
</html>

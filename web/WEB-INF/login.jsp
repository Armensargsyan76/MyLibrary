<%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 11.09.2022
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
%>

<%   if (msg != null) { %>
<p style="color: red"><%=msg%></p>
<% } %>

<form action="/login" method="post">
    <input type="email" name="email" placeholder="please input email"><br>
    <input type="password" name="password" placeholder="please input password"><br>
    <input type="submit" name="login">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 10.09.2022
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
%>

<%   if (msg != null) { %>
<p style="color: red"><%=msg%></p>
<% } %>
PLease input user's data
<form action="/userAdd" method="post">
    <input type="text" name="name" placeholder="please input name"><br>
    <input type="text" name="surname" placeholder="please input surname"><br>
    <input type="email" name="email" placeholder="please input email"><br>
    <input type="password" name="password" placeholder="please input password"><br>
    <input type="submit" name="register">
</form>

</body>
</html>

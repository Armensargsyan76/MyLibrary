<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Library</title>
</head>
<%
    User user = (User) session.getAttribute("user");
%>
<body>

<a href="/author/add">Add new author</a>
<a href="/authors">Show all authors</a>
<a href="/books">show all books</a>
<%
    if (user != null) {
%>
<a href="/book/add">Add new book</a>
<a href="/logout">Logout</a>
<%
    } else {
%>
<a href="/userAdd">Register</a>
<a href="/login">Login</a>
<%
    }
%>
</body>
</html>

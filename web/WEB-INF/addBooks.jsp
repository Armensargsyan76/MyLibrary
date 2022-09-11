<%@ page import="java.util.List" %>
<%@ page import="model.Author" %><%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 07.09.2022
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add books</title>
</head>
<body>
<%
    List<Author> authors = (List<Author>) request.getAttribute("authors");
%>
please input book's data
<form action="/book/add" method="post" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="please input book's title"><br>
    <input type="text" name="description" placeholder="please input book's description"><br>
    <input type="number" name="price" placeholder="please input book's price"><br>
    <select name="author_id">
        <% for (Author author : authors) {%>
        <option value="<%=author.getId()%>"><%=author.getName()%> <%=author.getSurname()%>
        </option>
        <%
            }
        %>
    </select>
    <input type="file" name="image">
    <input type="submit" value="register">
</form>
</body>
</html>

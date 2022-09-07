<%@ page import="java.util.List" %>
<%@ page import="model.Author" %>
<%@ page import="model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 07.09.2022
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<%
    List<Author> authors = (List<Author>) request.getAttribute("authors");
    Book book = (Book) request.getAttribute("book");
%>
please update book's data
<form action="/book/edit" method="post">
    <input type="hidden" name="bookId" value="<%=book.getId()%>">
    <input type="text" name="title" value="<%=book.getTitle()%>"/><br>
    <input type="text" name="description" value="<%=book.getDescription()%>"/><br>
    <input type="number" name="price" value="<%=book.getPrice()%>"/><br>
    <select name="authorId">
        <% for (Author author : authors) {
            if (author.equals(book.getAuthor())) {
        %>
        <option selected value="<%=author.getId()%>"><%=author.getName()%> <%=author.getSurname()%>
            (<%=author.getEmail()%>) <%=author.getAge()%>
        </option>
        <%
        } else {%>
        <option value="<%=author.getId()%>"><%=author.getName()%> <%=author.getSurname()%> (<%=author.getEmail()%>
            ) <%=author.getAge()%>
        </option>
        <% }
        } %>
    </select>
    <input type="submit" value="Update">
</form>
</body>
</html>

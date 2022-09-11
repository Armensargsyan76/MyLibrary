<%@ page import="java.util.List" %>
<%@ page import="model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 06.09.2022
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books page</title>
</head>
<body>

<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<table border="1">
    <tr>
        <th>image</th>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>price</th>
        <th>author name</th>
        <th>action</th>
    </tr>
    <%
        for (Book book : books) {%>
    <tr>
        <td>
            <%
                if (book.getImage() == null || book.getImage().length() == 0) {%>
            <img src="/image/defaultProfilePic.png " width="100"/>
            <% } else { %>
            <img src="${pageContext.request.contextPath}/getImageBook?image=<%=book.getImage()%>" width="100"><br>
            <% } %>
        </td>
        <td><%=book.getId()%>
        </td>
        <td><%=book.getTitle()%>
        </td>
        <td><%=book.getDescription()%>
        </td>
        <td><%=book.getPrice()%>
        </td>
        <td>
            <%=book.getAuthor().getName()%>
        </td>
        <td>
            <a href="/books/delete?booksId=<%=book.getId()%>">Delete</a> |
            <a href="/book/edit?bookId=<%=book.getId()%>">Edit</a>
        </td>

    </tr>

    <%
        }
    %>

</table>


</body>
</html>

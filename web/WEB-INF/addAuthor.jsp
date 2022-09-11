<%--
  Created by IntelliJ IDEA.
  User: Armen
  Date: 06.09.2022
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ad Author</title>
</head>
<body>
Please input author's data
<form action="/author/add" method="post" enctype="multipart/form-data">
<input type="text" name="name" placeholder="please input author name"/><br>
<input type="text" name="surname" placeholder="please input author surname"><br>
<input type="email" name="email" placeholder="please input author email"><br>
<input type="number" name="age" placeholder="please input author age"><br>
    image:
    <input type="file" name="image"><br>
<input type="submit" name="Register">

</form>
</body>
</html>

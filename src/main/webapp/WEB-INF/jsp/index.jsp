<%--
  Created by IntelliJ IDEA.
  User: Artiom
  Date: 12.06.2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>The Bank List</title>
</head>
<body>
    <form action="" method="post">
        <input type="text" name="richestVal" placeholder="richest user" value="${richest}">
        <button name="method" type="submit" value="richest">Get</button>
        <br>
        <input type="text" name="sumVal" placeholder="accounts sum" value="${sum}">
        <button name="method" type="submit" value="sum">Get</button>
    </form>
</body>
</html>

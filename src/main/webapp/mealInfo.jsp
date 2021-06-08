<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meal Info</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meal Info</h2>

<form method="post" action="">
    <label><input type="text" name="description"></label>Description<br>
    <label><input type="number" name="calories"></label>Calories<br>
    <label><input type="datetime-local" name="localDateTime"></label>Date<br>

    <input type="submit" value="OK" name="OK"><br>
</form>



</body>
</html>
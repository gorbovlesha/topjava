<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>

    <c:forEach var="meals" items="${requestScope.mealsList}">
        <tr style="color: ${meals.excess ? 'red' : 'greenyellow'}">
            <td>${meals.id}</td>
            <td>${meals.dateTime}</td>
            <td>${meals.description}</td>
            <td>${meals.calories}</td>
        </tr>
    </c:forEach>
</table>
<br><br>

<h3>Create new meal</h3>
<form method="post" action="">
    <label><input type="text" name="description"></label>Description<br>
    <label><input type="number" name="calories"></label>Calories<br>
    <label><input type="datetime-local" name="localDateTime"></label>Date<br>

    <input type="submit" value="OK" name="OK"><br>
</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table>
<tr>
    <th>Date</th>
    <th>Description</th>
    <th>Calories</th>
</tr>
    <c:forEach var="meals" items="${requestScope.mealsList}">
        <tr>
<td>${meals.dateTime}</td>
<td>${meals.description}</td>
<td>${meals.calories}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
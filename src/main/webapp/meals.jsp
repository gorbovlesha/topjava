<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
        <javatime:format value="${meals.dateTime}" pattern="yyyy-MM-dd HH:mm" var="parsedDate" />
        <tr style="color: ${meals.excess ? 'red' : 'greenyellow'}">
            <td>${meals.id}</td>
            <td>${parsedDate}</td>
            <td>${meals.description}</td>
            <td>${meals.calories}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
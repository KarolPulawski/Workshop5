<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th>id</th>
    <th>sender</th>
    <th>content</th>
    <tbody>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td>${message.id}</td>
            <td>${message.sender.username}</td>
            <td>${message.content}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

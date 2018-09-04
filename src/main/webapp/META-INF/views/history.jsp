<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th>id</th>
    <th>receiver</th>
    <th>content</th>
    <th>Read?</th>
    <tbody>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td>${message.id}</td>
            <td>${message.receiver.username}</td>
            <td>${message.content}</td>
            <td>${message.read}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

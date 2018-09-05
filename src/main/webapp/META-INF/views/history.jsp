<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
            <c:choose>
                <c:when test = "${fn:length(message.content) > 10}">
                    <td>${fn:substring(message.content, 0, 9)}...</td>
                </c:when>
                <c:otherwise>
                    <td>${message.content}</td>
                </c:otherwise>
            </c:choose>
            <td>${message.read}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

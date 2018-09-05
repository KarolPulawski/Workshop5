<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Send message: <a href="/send">click</a> </h4>
<h4>History: <a href="/history">click</a> </h4>

<table>
    <th>id</th>
    <th>sender</th>
    <th>content</th>
    <th>read?</th>
    <tbody>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td>${message.id}</td>
            <td>${message.sender.username}</td>
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
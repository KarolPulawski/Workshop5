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
    <th>READ</th>
    <tbody>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td>${message.id}</td>
            <td>${message.sender.username}</td>

            <c:if test="${message.read == false}">
                <c:choose>
                    <c:when test = "${fn:length(message.content) > 10}">
                        <td style = "font-weight:bold">${fn:substring(message.content, 0, 9)}...</td>
                    </c:when>
                    <c:otherwise>
                        <td style = "font-weight:bold">${message.content}</td>
                    </c:otherwise>
                </c:choose>
            </c:if>

            <c:if test="${message.read == true}">
                <c:choose>
                    <c:when test = "${fn:length(message.content) > 10}">
                        <td>${fn:substring(message.content, 0, 9)}...</td>
                    </c:when>
                    <c:otherwise>
                        <td>${message.content}</td>
                    </c:otherwise>
                </c:choose>
            </c:if>

            <td>${message.read}</td>

            <td>
                <form action="/readMessage" method="get">
                    <button type="submit" name="id" value="${message.id}">Read</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>



</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <td>${message.content}</td>
            <td>${message.read}</td>
            <%--<td><a href="/tweet/tweetDetails?tweet_id=${tweet.id}">click</a></td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>



</body>
</html>
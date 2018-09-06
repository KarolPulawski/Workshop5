<%@include file="default/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <th>id</th>
        <th>owner</th>
        <th>text</th>
        <th>created</th>
        <th>details</th>
        <tbody>
        <c:forEach items="${tweets}" var="tweet">
            <tr>
                <td>${tweet.id}</td>
                <td>${tweet.user.username}</td>
                <td>${tweet.text}</td>
                <td>${tweet.created}</td>
                <td><a href="/tweet/tweetDetails?tweet_id=${tweet.id}">click</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>

<%@include file="default/footer.jsp"%>

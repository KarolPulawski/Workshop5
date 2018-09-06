<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>WELCOME in TWEETER "${currentUser.username}"</h2>
    <h4>Display all tweets: <a href="/tweet/allTweets">click</a> </h4>

    <h4>My tweets: <a href="/tweet/allTweetsCurrentUser">click</a> </h4>

    <h4>Tweets of user id:</h4>

    <form action="/tweet/allTweetsSpecificUser" method="get">
        <select name = "value">
            <c:forEach items="${users}" var="u">

                <c:if test = "${u.id != currentUser.id}">
                    <option value="${u.id}">${u.username}</option>
                </c:if>

            </c:forEach>
        </select>
        <input type="submit" value="Click">
    </form>

    <h4>Add tweet -> <a href="/tweet/addTweet">click</a> </h4>

    <h4>Log out: <a href="/logout">click</a> </h4>

    <h4>Send message: <a href="/messages">messages</a> </h4>

    <h4>Edit user: <a href="/edit">click to edit</a> </h4>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Tweet id: ${tweet.id}</p>
    <p>Owner: ${tweet.user.username}</p>
    <p>Content: ${tweet.text}</p>
    <p>Date of create: ${tweet.created}</p>
</body>
</html>

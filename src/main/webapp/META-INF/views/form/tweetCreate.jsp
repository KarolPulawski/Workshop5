<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="tweet" type="pl.coderslab.entity.Tweet"--%>
<form:form modelAttribute="tweet" method="post">
    <form:errors path="*"/>
    Text: <form:textarea path="text"/></br>
    <input type="submit" name="Submit" value="Send">
</form:form>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="user" type="pl.coderslab.entity.User"--%>
<form:form modelAttribute="user" method="post">
    <form:errors path="*"/>
    Username: <form:input path="username"/></br>
    Password: <form:password path="hashPassword"/></br>

    Enabled:
    Yes: <form:radiobutton path="enabled" value="true"/>
    No: <form:radiobutton path="enabled" value="false"/></br>

    Email: <form:input path="email"/></br>
    <input type="submit" name="Submit" value="Send">
</form:form>
</body>
</html>
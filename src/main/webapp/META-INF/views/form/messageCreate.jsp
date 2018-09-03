<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="message" type="pl.coderslab.entity.Message"--%>
<form:form modelAttribute="message" method="post">
    <form:errors path="*"/>
    Receiver: <form:select path="receiver" items="${users}" itemLabel="username" itemValue ="id"></form:select></br>
    Content: <form:textarea path="content"/></br>
    <form:hidden path="read" value = "false"></form:hidden>
    <input type="submit" name="Submit" value="Send">
</form:form>
</body>
</html>
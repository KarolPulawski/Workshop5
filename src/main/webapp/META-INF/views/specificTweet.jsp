<%@include file="default/header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <p>
        <table>
            <th>Comment id: </th>
            <th>Comment owner: </th>
            <th>Comment text: </th>
            <th>Created: </th>

            <tbody>
            <c:forEach items="${comments}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.user.username}</td>
                    <td>${c.text}</td>
                    <td>${c.created}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </p>

    <p>
        Add comment:
        <%--@elvariable id="comment" type="pl.coderslab.entity.Comment"--%>
        <form:form modelAttribute="comment" method="post">
            <form:errors path="*"/>
            Text: <form:textarea path="text"/></br>
            <form:hidden path="tweet" value="${tweet.id}"></form:hidden>
            <input type="submit" name="Submit" value="Send">
        </form:form>
    </p>
</body>
</html>
<%@include file="default/footer.jsp"%>
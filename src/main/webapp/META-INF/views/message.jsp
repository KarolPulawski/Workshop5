<%@include file="default/header.jsp"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <th>id</th>
    <th>sender</th>
    <th>content</th>
    <tbody>
        <tr>
            <td>${message.id}</td>
            <td>${message.sender.username}</td>
            <td>${message.content}</td>
        </tr>
    </tbody>
</table>

<td>
    <form action="/messages" method="get">
        <button type="submit">Back to messages</button>
    </form>
</td>

<td>
    <form action="/history" method="get">
        <button type="submit">Back to history</button>
    </form>
</td>

</body>
</html>

<%@include file="default/footer.jsp"%>
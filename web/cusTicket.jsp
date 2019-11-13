<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Printer ut kundens billett</title>
</head>
<body>
<div class="wrap">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>
                    gate
                </th>

            </tr>
            </thead>
            <jsp:useBean id="tickets" scope="request" type="java.util.List"/>
            <c:forEach items="${tickets}" var="tic">
            <tr>

                <td>
                    <c:out value="${tic.gate}"/>
                </td>
            </tr>
            </c:forEach>
</body>
</html>

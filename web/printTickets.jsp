<%--
  Created by IntelliJ IDEA.
  User: kristofferfoss
  Date: 10/11/2019
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>printer ut navn ogc flyet deres</title>
</head>
<body>
<div class="wrap">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>
                    flightID
                </th>
                <th>
                    customerID
                </th>

            </thead>
    <jsp:useBean id="searches" scope="request" type="java.util.List"/>
    <c:forEach items="${searches}" var="search">
        <tr>

        <td>
        <c:out value="${search.flightID}"/>
        </td>
        <td>
        <c:out value="${search.customerID}"/>
        </td>
    </tr>
     </c:forEach>
    </body>
</html>

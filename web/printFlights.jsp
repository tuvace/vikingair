
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="wrap">
    <div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>
                flightDate
            </th>
            <th>
                price
            </th>
            <th>
               flightTo
            </th>
            <th>
                flightFrom
            </th>
            <th>
                airplaneType
            </th>
            <th>
                bookedSeat
            </th>
            <th>
                totalSeat
            </th>

        </tr>

        </thead>
        <jsp:useBean id="flights" scope="request" type="java.util.List"/>
            <c:forEach items="${flights}" var="flight">
                <tr>

                    <td>
                        <c:out value="${flight.flightDate}"/>
                    </td>
                    <td>
                        <c:out value="${flight.price}"/>
                    </td>
                    <td>
                        <c:out value="${flight.flightTo}"/>
                    </td>
                    <td>
                        <c:out value="${flight.flightFrom}"/>
                    </td>
                    <td>
                        <c:out value="${flight.duration}"/>
                    </td>
                    <td>
                        <c:out value="${flight.bookedSeat}"/>
                    </td>
                    <td>
                        <c:out value="${flight.totalSeat}"/>
                    </td>


                </tr>

            </c:forEach>
    </table>
    </div>
</div>




</body>
</html>

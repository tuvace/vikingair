<%@ page import="servlets.FlightSearch.FlightSearch" %>
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
                Flyets avgangstid
            </th>
            <th>
                Pris
                
            </th>
            <th>
               Til
            </th>
            <th>
                Fra
            </th>
            <th>
                Reisetid
            </th>
            <th>
                Reserverte seter
            </th>
            <th>
                Totalt antall seter
            </th>

        </tr>

        </thead>

            <jsp:useBean id="flsResults" scope="request" type="java.util.List"/>
            <c:forEach items="${flsResults}" var="flightSearch">
                <tr>
                    <td>
                        <c:out value="${flightSearch.flightDate}"/>
                    </td>
                    <td>
                        <c:out value="${flightSearch.price}"/>
                    </td>
                    <td>
                        <c:out value="${flightSearch.flightTo}"/>
                    </td>
                    <td>
                        <c:out value="${flightSearch.flightFrom}"/>
                    </td>
                    <td>
                        <c:out value="${flightSearch.duration}"/>
                    </td>
                    <td>
                        <c:out value="${flightSearch.bookedSeat}"/>
                    </td>
                    <td>
                        <c:out value="${flightSearch.totalSeat}"/>
                    </td>
                    <td>
                        <input type="radio" name ="radios" value="flightSearch">
                        Velg en flyvning
                        <input type="submit" value="Trykk" href="booking.jsp">

                    </td>
                </tr>

            </c:forEach>

    </table>
    </div>
</div>
</body>
</html>

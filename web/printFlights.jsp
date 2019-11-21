<%@ page import="servlets.FlightSearch.FlightSearch" %>
<%@ page import="servlets.FlightSearch.FlightDetailServlet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/kontaktoss.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrap">
    <div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>
                Flyets identifikasjon
            </th>
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
            <div id="flightData">
            <jsp:useBean id="flsResults" scope="request" type="java.util.List"/>
            <c:forEach items="${flsResults}" var="flightSearch">
                <!-- link for bestilling av billett-->
                <c:url var="orderTicket" value="FlightDetailServlet">
                    <c:param name="command" value="save"/>
                    <c:param name="flightID" value="${flightSearch.flightID}"/>
                </c:url>
                <tr>
                    <td>
                        <c:out value="${flightSearch.flightID}"/>
                    </td>
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
                        <a href="${orderTicket}">Bestill reise</a>


                    </td>
                </tr>
            </c:forEach>
            </div>
    </table>
    </div>
</div>
</body>
</html>




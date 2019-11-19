<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dbcode.dbUtilities" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>
<%--
  Created by IntelliJ IDEA.
  User: henriettefremstad
  Date: 16/11/2019
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
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

            <div id = "customerInfo">
                <br>
                <jsp:useBean id="customer" scope="session" type="servlets.customers.Customer"/>
                Navn: <br>
                <c:out value="${customer.firstName}"> </c:out>
                <c:out value="${customer.middleName}"> </c:out>
                <c:out value="${customer.lastName}"> </c:out><br><br>
            </div>


            <div id="flightData">
                <jsp:useBean id="flsData" scope="request" type="java.util.List"/>
                <c:forEach items="${flsData}" var="ticketBooking">
                    <!-- link for bestilling av billett-->
                    <c:url var="orderTicket" value="TicketBookingServlet">
                        <c:param name="command" value="save"/>
                        <c:param name="flightID" value="${TicketBooking.flightID}"/>
                    </c:url>


                    <tr>
                        <td>Fly identifikasjon:</td>
                        <td><c:out value="${ticketBooking.flightID}"/></td>
                    </tr>
                    <tr>
                        <td>Dato og klokkeslett:</td>
                        <td><c:out value="${ticketBooking.flightDate}"/></td>
                    </tr>
                    <tr>
                        <td>Pris:</td>
                        <td><c:out value="${ticketBooking.price}"/></td>
                    </tr>
                    <tr>
                        <td>Fly fra:</td>
                        <td><c:out value="${ticketBooking.flightFrom}"/></td>
                    </tr>
                    <tr>
                        <td>Fly til:</td>
                        <td><c:out value="${ticketBooking.flightTo}"/></td>
                    </tr>
                </c:forEach>
            </div>

            <div id="BekreftBestilling">
                <tr>
                    <td> <a href="${orderTicket}">Bekreft Bestilling</a></td>
                </tr>
            </div>
                </table>
        </table>
    </div>
</div>
</body>
</html>




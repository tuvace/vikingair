<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dbcode.dbUtilities" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/kontaktoss.css" rel="stylesheet" type="text/css">
    <style>
        h1 {
            color: cornflowerblue;
            text-shadow: 2px 2px 4px black;
            font-size: 50px;
            font-variant: small-caps;
        }
        .button {
            background-color: lightskyblue;
            border: none;
            border-radius: 5px;
            color: white;
            padding: 8px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            font-variant: small-caps;
            margin: 4px 2px;
            cursor: pointer;
            box-shadow: 2px 2px 4px black;
        }
        .button2 {
            background-color: lightskyblue;
            position: absolute;
            top: 40px;
            left: 20px;
            font-size: 30px;
            box-shadow: 2px 2px 4px black;
            text-shadow: 2px 2px 4px black;
        }
        .button3 {
            font-size: 30px;
        }
    </style>
</head>
<body>
<div style="text-align: center">
<c:if test="${sessionScope.customer == null}">
    <h1>Du må logge inn for å bestille</h1> <br>
    <a href = "login.jsp" class = "button button3"> Logg inn </a>

</c:if>
<c:if test="${sessionScope.customer != null}">
<div class="wrap">

    <div class="container">
        <table class="table table-hover">

            <div id = "customerInfo">
                <br>
                <jsp:useBean id="customer" scope="session" type="classes.Customer"/>
                Navn: <br>
                <c:out value="${customer.firstName}"> </c:out>
                <c:out value="${customer.middleName}"> </c:out>
                <c:out value="${customer.lastName}"> </c:out><br><br>
            </div>



            <form action="TicketBookingServlet" method="post" name="saveTicket">
            <div id="flightData">
                <jsp:useBean id="flsData" scope="request" type="java.util.List"/>
                <c:forEach items="${flsData}" var="ticketBooking">
                    <!-- link for bestilling av billett-->

                    <tr>
                        <td> <input type="hidden" value="${ticketBooking.flightID}" name="flightID"></td>
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
                    <tr>
                        <input type="hidden" value="${customer.customerID}" name="customerID">
                    </tr>
                </c:forEach>
            </div>
            <div id="BekreftBestilling">
                <tr>
                    <input type="submit" class="button" value="Bekreft bestilling"/>
                </tr>
                <tr>
                    <td>Økonomi eller Business:</td>
                    <td> <input type="radio"  value="Økonomi" name="flight_class" checked="checked"> Economy</td>
                    <td> <input type="radio" value="Business" name="flight_class" > Business</td>
                </tr>
                <tr>
                    <td>Bagasje mengde:</td>
                    <td> <input type="radio" name = "baggage" value="10" checked="checked"> Håndbagasje(10kg)</td>
                    <td><input type="radio" name = "baggage" value="15">  15kg</td>
                    <td><input type="radio" name = "baggage" value="20"> 20kg</td>
                </tr>
            </div>
            </form>
                </table>
        </table>
        </c:if>
    </div>
</div>
</div>
</body>
</html>




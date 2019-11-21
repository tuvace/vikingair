<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>Printer ut kundens billett</title>

<body>
<div class="wrap">
    <section>
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>

                <th>
                    seatRow
                </th>
            </tr>
            </thead>
            <div id="CustomerInfo">
            <jsp:useBean id="customer" scope="session" type="servlets.customers.Customer"/>
            <c:out value="${customer.firstName}"/>
            <c:out value="${customer.lastName}"/>
            </div>
            <tr>
            <td>






            <jsp:useBean id="tickets" scope="request" type="java.util.List"/>
            <c:forEach items="${tickets}" var="tic">
                <c:out value="${tic.gate}"/>
                <c:out value="${tic.seatRow}"/>
                <c:out value="${tic.seatLetter}"/>
                <c:out value="${tic.classType}"/>
                <c:out value="${tic.flightTo}"/>
                <c:out value="${tic.flightFrom}"/>

                </td>

                <c:url var="templink" value="TicketServlet">
                    <c:param name="command" value="cancel"/>
                    <c:param name="ticketID" value="${tempTicketID}" />
                </c:url>

                <td>
                    <a href="${templink}"
                       onclick="if (!(confirm ('Er du sikker på at du vil avbestille billetten?'))) return false"> Avbestill</a>
                </td>

                <td><a href=TicketServlet?action=update&ticket_id=<c:out value="${ticket.ticketID}"/>"><i class="fas fa-edit"></i></a></td>
                <td><a href=TicketServlet?action=update&ticket_id=<c:out value="${ticket.ticketID}"/>"><i class="fas fa-trash"></i></a></td>

            </tr>
            </c:forEach>
        </table>
    </div>
    </section>
</div>
</body>
</html>

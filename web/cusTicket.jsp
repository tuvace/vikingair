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
                    Informasjon
                </th>
            </tr>
            </thead>
            <div id="CustomerInfo">
                <tr>
                <td>
            <jsp:useBean id="customer" scope="session" type="servlets.customers.Customer"/>
            <c:out value="${customer.firstName}"/>
            <c:out value="${customer.lastName}"/>

            <jsp:useBean id="tickets" scope="request" type="java.util.List"/>
            <c:forEach items="${tickets}" var="tic">
                <c:out value="${tic.gate}"/>
                <c:out value="${tic.flightTo}"/>
                <c:out value="${tic.flightFrom}"/>

                </td>

                <c:url var="templink" value="TicketServlet">
                    <c:param name="command" value="cancel"/>
                    <c:param name="ticketID" value="${tempTicketID}" />
                </c:url>

                <td>
                    <form action="TicketServlet" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${tic.ticketID}">
                        <button class="button" type="submit"> Slett </button>
                    </form>
                </td>
    </div>


            </tr>
            </c:forEach>
        </table>
    </div>
    </section>
</div>
</body>
</html>

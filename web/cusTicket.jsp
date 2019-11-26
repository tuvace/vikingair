<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>Printer ut kundens billett</title>
        <style>
            .button
            {
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
            h1 {
                color: lightskyblue;
                text-shadow: 2px 2px 4px black;
                font-size: 50px;
                font-variant: small-caps;
            }
        </style>

<body>
<div style="text-align: center">
    <h1> Dine Billetter </h1>
<div class="wrap">
    <section>
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>

            </tr>
            </thead>
            <div id="CustomerInfo">
                <tr>


<jsp:useBean id="customer" scope="session" type="classes.Customer"/>
            <c:out value="${customer.firstName}"/>
            <c:out value="${customer.lastName}"/>
            <jsp:useBean id="tickets" scope="session" type="java.util.List"/>
                <th> Gate</th>
                <th> Destinasjon </th>
                <th> Avgang </th>
                <c:forEach items="${tickets}" var="tickets">
                <tr>
                    <td> <c:out value="${tickets.gate}"/></td>

                    <td><c:out value="${tickets.flightTo}"/></td>

                    <td> <c:out value="${tickets.flightFrom}"/></td>

                <td>

                    <form action="TicketServlet" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="cus_id" value="${customer.customerID}">
                        <input type="hidden" name="tic_id" value="${tickets.ticketID}">
                        <button class="button" type="submit"> Avbestill </button>
                    </form>

                </td>
                </tr>
             </c:forEach>
    </div>


            </tr>
        </table>
    </div>
    </section>
</div>
</div>
</body>
</html>

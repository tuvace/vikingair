<%--
  Created by IntelliJ IDEA.
  User: tuvace
  Date: 2019-11-01
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>

<!-- Denne jspen er ansvarlig for outputten som blir synlig på nettsiden
     når vi printer ut kunder som er lagret i databasen. -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Importerer JSTL -->
<html>
<head>
    <!-- Imports bootstrap so it can be used in this file -->
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>Get Customers</title>

    <!-- Functions as the output each customer that is displayed when all customers from the db is printed and uses bean to receive a "payload"
     from a customer object. The object is sent through request. -->
<body>
<div class="wrap">
    <section>
        <div class="container">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        Fornavn
                    </th>
                    <th>
                        Etternavn
                    </th>
                    <th>
                        E-post
                    </th>
                    <!-- &oslah is a code for the norwegian letter "ø". -->
                    <th>
                        F&oslashdselsdato
                    </th>
                </tr>
                </thead> <%-- Uses the bean class to retrieve information about the objects in the ArrayList customers.
                The following loop iterates through the customers list, the <c: out value displays the value in the website.  --%>

                <jsp:useBean id="customers" scope="request" type="java.util.List"/>
                <c:forEach items= "${customers}" var="customer">
                    <tr>
                        <td>
                            <c:out value = "${customer.firstName}"/>
                        </td>
                        <td>
                            <c:out value = "${customer.lastName}"/>
                        </td>
                        <td>
                            <c:out value = "${customer.email}"/>
                        </td>

                        <!-- Displays icons for updating and deleting on the website and whenever these icons/buttons are being used it redirects to
                          the CustomerController actions update and delete. -->
                        <td><a href="CustomerServlet?action=update&cus_id=<c:out value="${customer.customerID}"/>"><i class="fas fa-edit"></i></a></td>
                        <td><a href="CustomerServlet?action=delete&cus_id=<c:out value="${customer.customerID}"/>"><i class="fas fa-trash"></i></a></td>

                    </tr>

                </c:forEach>
            </table>

        </div>
    </section>
</div>
</body>
</html>
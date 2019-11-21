<%--
  Created by IntelliJ IDEA.
  User: kristofferfoss
  Date: 21/11/2019
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="customer" scope="session" type="servlets.customers.Customer"/>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Fornavn" name="firstName"/>
    <input type="hidden" value="editFirstName" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Etternavn" name="lastName"/>
    <input type="hidden" value="editLastName" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Adresse" name="customerAddress"/>
    <input type="hidden" value="editAddress" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Mobilnummer" name="phoneNumber"/>
    <input type="hidden" value="editPhone" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Email Adresse" name="email"/>
    <input type="hidden" value="editEmail" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
</body>
</html>

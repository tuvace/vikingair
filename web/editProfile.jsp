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
    <title>Rediger profil</title>
    <link href="css/profil.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#b8860b">
<div style="text-align: center">
<h1>Rediger profilinformasjon (én om gangen)</h1>
<jsp:useBean id="customer" scope="session" type="classes.Customer"/>
    Endre fornavn: <br>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Fornavn" name="firstName"/>
    <input type="hidden" value="editFirstName" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
    Endre etternavn: <br>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Etternavn" name="lastName"/>
    <input type="hidden" value="editLastName" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
    Endre adresse: <br>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Adresse" name="customerAddress"/>
    <input type="hidden" value="editAddress" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
    Endre mobilnummer: <br>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Mobilnummer" name="phoneNumber"/>
    <input type="hidden" value="editPhone" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
</form>
    Endre email: <br>
<form action="CustomerServlet" method="post">
    <input type="text" placeholder="Email Adresse" name="email"/>
    <input type="hidden" value="editEmail" name="action">
    <input type="hidden" name="username" value="${customer.customerID}">
    <button class="button" type="submit">Endre</button>
    </form>
</div>
</>
</html>

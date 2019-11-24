<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuvace
  Date: 2019-10-08
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="no">
<head>
  <style>
    h1 {
      color: white;
      text-shadow: 2px 2px 4px black;
      font-size: 50px;
      font-variant: small-caps;
    }
    p.small {
      font-variant: small-caps;
      font-size: 20px;
    }
    .button {
      background-color: lightskyblue;
      border: none;
      border-radius: 5px;
      color: white;
      padding: 6px 16px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 15px;
      font-variant: small-caps;
      margin: 2px 2px;
      cursor: pointer;
      box-shadow: 2px 2px 4px black;
      text-shadow: 2px 2px 2px black;
      position: center ;
    }
    .button2 {
      background-color: lightskyblue;
      position: relative;
      top: 30px;
      font-size: 50px;
      box-shadow: 2px 2px 4px black;
      text-shadow: 2px 2px 4px black;
    }
    .button3 {
      background-color: lightskyblue;
      position: absolute;
      top: 40px;
      right: 20px;
      font-size: 30px;
      box-shadow: 2px 2px 4px black;
      text-shadow: 2px 2px 4px black;
    }
    .button4 {
      width: 200px;
      height: 30px;
    }

  </style>
  <meta charset="UTF-8">
  <title>Viking Airways</title>
  <link href="css/index.css" rel="stylesheet" type="text/css">
<body>
<div style="text-align: center;">
  <form action="index.jsp">
    <button class="button button2"> Viking Airways </button>
  </form>
  <br><br><br>

    <c:if test="${sessionScope.customer == null}">

        <a href = "login.jsp" class = "button button3"> Logg inn </a>

    </c:if>

    <c:if test="${sessionScope.customer != null}">

    <p id="skriftStørrelse"> Velkommen: <jsp:useBean id="customer" scope="session" type="servlets.customers.Customer"/>
        <c:out value="${customer.firstName}"> </c:out> <p>

    </c:if>


    <c:if test="${sessionScope.customer.userID == '1'}">
    <a href="adminHovedside.jsp" class="button"> Admin </a>
    </c:if>


  <form action="FlightSearchServlet" method="Get">
    <p id="søkBox">
      <input type="text" placeholder="Fra*" name="flightFrom" required>
      <input type="text" placeholder="Til*" name="flightTo" required>
      <br>
      <input type="date" placeholder="Dato" name="flightDate" required>
      <button class="button" type="submit"> Søk </button> <br>
      *Påkrevd informasjon
    </p>
  </form>
    <div id="lavprisBox">
     <!--
     En <a> tag står for attribute og fungerer på den måten at man kan linke videre til en ny lokalasjon med å bestemme en href type.
     href setter linken som skal bli videresendt når en person trykker på linken. class type setter klassen til  taggen og den bruker
     vi for å gi taggen et design. Her har henriette allerede lagd et design for button button4 så da velger vi bare å bruke samme klasse på
     alle taggene så designet blir likt på alle knappene

     -->
      <a href="profil.jsp" class="button button4" > Lavpriskalender </a>
      <br>
      <a href="kontaktoss.html" class="button button4"> Kontakt Oss </a>
      <br>
     <a href="profil.jsp" class="button button4"> Min side </a>
    </div>
  </form>

</div>
</body>
</html>
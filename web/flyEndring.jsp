<%--
  Created by IntelliJ IDEA.
  User: kristofferfoss
  Date: 24/11/2019
  Time: 14:26
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
    <title>Endre fly</title>
</head>
<body bgcolor="#b8860b">
<div style="text-align: center">
<h1>Rediger flydetaljer (én om gangen)</h1>
Endre destinasjon: <br>
<form action="adminSearchServlet" method="post">
    <input type="text" placeholder="Legg inn FlyID" name="flightID"/>
    <input type="text" placeholder="From where?" name="from"/>
    <input type="hidden" value="editFrom" name="action">
    <button class="button" type="submit"> Endre </button>
</form>
Endre avgangssted: <br>
<form action="adminSearchServlet" method="post">
    <input type="text" placeholder="Legg inn FlyID" name="flightID"/>
    <input type="text" placeholder="To where?" name="to"/>
    <input type="hidden" value="editTo" name="action">
    <button class="button" type="submit"> Endre </button>
</form>
Endre gate: <br>
<form action="adminSearchServlet" method="post">
    <input type="text" placeholder="Legg inn FlyID" name="flightID"/>
    <input type="text" placeholder="What Gate?" name="gate"/>
    <input type="hidden" value="editGate" name="action">
    <button class="button" type="submit"> Endre </button>
</form>
Endre flyvningstid: <br>
<form action="adminSearchServlet" method="post">
    <input type="text" placeholder="Legg inn FlyID" name="flightID"/>
    <input type="text" placeholder="How many minutes will the plane use?" name="duration"/>
    <input type="hidden" value="editDuration" name="action">
    <button class="button" type="submit"> Endre </button>
</form>
    SLETT FLY (Advarsel: dette sletter flyet fra databasen): <br>
<form action="adminSearchServlet" method="post">
    <input type="text" placeholder="Legg inn FlyID" name="flightID"/>
    <input type="hidden" value="deleteFlight" name="action">
    <button class="button" type="submit"> Endre </button>
</form>
<a href="adminHovedside.jsp" class="button">Gå tilbake til Admin Hovedside</a>
</div>
</body>
</html>

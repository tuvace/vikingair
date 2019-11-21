<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuvace
  Date: 2019-11-19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="no">
<head>
<body style="background-color:#D0E6FF;"> </body>
    <style>
        h1 {
            color: white;
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
        .button2 {background-color: palegreen}
        .button3 {
            background-color: lightskyblue;
            position: absolute;
            top: 40px;
            left: 20px;
            font-size: 30px;
            box-shadow: 2px 2px 4px black;
            text-shadow: 2px 2px 4px black;
        }
    </style>

    <meta charset="UTF-8">
    <title>Bestillingsbekreftelse</title>
</head>
<body>
<div style="text-align: center;">
    <h1> Bestillingsbekreftelse </h1>
    <br>

    <form action="index.jsp">
        <button class="button button3"> Viking Airways </button>
    </form>

    <br>
    <h1 style="color:white; text-shadow: 2px 2px 4px black;"> Din bestilling er fullført! </h1>
        <h2 style="color:white; text-shadow: 2px 2px 4px black;"> Gå inn på Mine Sider for å se billetten. </h2>
    <a href="profil.jsp"> <button class="button"> Mine Sider </button>  </a>


</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title> Logg inn </title>
    <link href="css/login.css" rel="stylesheet" type="text/css">

</head>
<div style="text-align: center;">
    <h1> Logg inn </h1>
    <br>
    <body>
    <form action="index.jsp">
        <button class="button button3"> Viking Airways </button>
    </form>
    <form name="LoginForm" method="get" action="LoginServlet">
        <div class="container">
            <p id="loginBox">
                Email Adresse: <br>
                <input type="text" placeholder="Email Adresse" name="username" required>
                <br> <br>
                Passord: <br>
                <input type="password" placeholder="Passord" name="userPassword" required>
                <br> <br>
                <button class="button" type="submit" value="login"> Logg inn </button>

            </p>
            <%-- Får opp feilmeldingen definert i LoginServlet hvis session feiler,
                 at man prøver å logge inn med feil brukernavn eller passord. --%>
            <jsp:useBean id="errormsg" scope="request" class="java.lang.String"/>
            <c:if test="${requestScope.errormsg != null}">
                <p style="color:#ff3300; text-shadow: 2px 2px 4px black;"> <c:out value="${errormsg}"/> </p>
            </c:if>

        </div>
        <br>
    </form>
    <form action="register.jsp">
        <p id="registrerBox">
            Har du ikke bruker?
            <br> <br>
            <button class="button button2"> Registrer ny bruker </button>
        </p>
    </form>


    </body>
</div>

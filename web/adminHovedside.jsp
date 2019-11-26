<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> Admin Hovedside </title>
    <style>

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
            font-size: 30px;
            box-shadow: 2px 2px 4px black;
            text-shadow: 2px 2px 4px black;
            height: 50px;
            width: 500px;
        }
        .button3 {
            width: 400px;
            height: 40px;
        }
    </style>
</head>
<body bgcolor="#b8860b">
<div style="text-align: center;">
    <form action="index.jsp">
        <button class="button button2"> Forside </button>
    </form>
    <br> <br> <br> <br>
    <form action="adminFlight.jsp">
        <button class="button button3"> Registrer nytt fly </button>
    </form>
    <br>
    <form action="adminSearchServlet" method="get">
        <input type="submit" class="button button3" value="Print ut alle billetter"/>
    </form>
    <br>
    <form action="flyEndring.jsp">
        <button class="button button3"> Foresp&oslashr endring av eksisterende fly </button>
    </form>
    <br>
    <form action="index.jsp">
        <button class="button button3"> Foresl&aring UI forbedring </button>
    </form>
</div>
</body>
</html>
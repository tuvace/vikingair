<!DOCTYPE html>
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
    .button2 {
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
<title> Registration </title>
    <link href="css/register.css" rel="stylesheet" type="text/css">
</head>
<body>
    <form action="index.jsp">
        <button class="button button2"> Viking Airways </button>
    </form>
<div style="text-align: center;">
<h1> Registrer deg </h1>
<br>
<form action="registrerServlet" method="post" name="addKunde">
   <div class="container">
    <p id="registerBox">
    Fornavn: <br>
        <input type="text" name="firstName"><br>
    Etternavn: <br>
        <input type="text" name="lastName"><br>
    Adresse: <br>
        <input type="text" name="customerAddress"><br>
    Epost Adresse: <br>
        <input type="text" name="email"><br>
    Mobilnummer: <br>
        <input type="number" name="phoneNumber"><br>
    Kj&oslashnn: <br>
        <input type="radio" name="gender" value="male"> Mann <br>
        <input type="radio" name="gender" value="female"> Kvinne <br>
        <input type="radio" name="gender" value="others"> Annet <br><br>
    Passord: <br>
    <input type="password" name="password">
       <br><br>

    <input type="submit" class="button" value="Registrer deg"/>

    </p>
   </div>
</form>
</div>
</body>
</html>
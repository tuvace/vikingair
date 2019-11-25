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
        text-shadow: 2px 2px 2px black;
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
<title>FlightRegistration</title>
<link href="css/flight.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="index.jsp">
    <button class="button button2"> Viking Airways </button>
</form>
<div style="text-align: center">
  <h1> Registrer ditt fly</h1>
</div>

<form action="adminFlight" method="post">
  <p id="flightBox">
Flynummer:
    <input type="number" name="flightID"><br>
<br>
Avgangsdato:
  <input type="date" name="flightDate">
 <br> <br>

 Fra:
    <input type="text" name="flightFrom">
<br><br>
Til:
      <input type="text" name="flightTo"><br><br>
Duration (in minutes):
    <input type="number" name="duration"><br><br>

Sete mengde:
 <select name="price">
  <option value="1000">50</option>
  <option value="1500">75</option>
  <option value="2000">100</option>
  <option value="2500">200</option>
</select><br><br>
Flymodell:
<select name="airplaneType">
  <option value="Air Canada Boeing 787-9">Air Canada Boeing 787-9</option>
  <option value="Airbus A380 House Livery">Airbus A380 House Livery</option>
  <option value="Alaska Airlines Boeing 737-700">Alaska Airlines Boeing 737-700</option>
  <option value="Alaska/Horizon Q400">Alaska/Horizon Q400</option>
</select><br><br>
Gate:
 <input type="text" name="gate" maxlength=5><br><br>
 Baggasje tillatelse (in kilos):
 <select name="baggage_limit">
   <option value="3000">3000kg</option>
   <option value="3500">3500kg</option>
   <option value="4000">4000kg</option>
   <option value="4500">4500kg</option>
   <option value="5000">5000kg</option>
   <option value="5500">5500kg</option>
   <option value="6000">6000kg</option>
   <option value="6500">6500kg</option>
</select><br><br>
 <button class="button" type="submit" value="adminFlight"> Registrer fly </button>
  </p>
</form>

</body>
</html>
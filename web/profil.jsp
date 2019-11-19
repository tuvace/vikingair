<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link href="css/profil.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="index.jsp">
		<button class="button button2"> Viking Airways </button>
	</form>
<div style="text-align: center;">
<h1> Din profil </h1>
<br>

	<c:if test="${sessionScope.customer == null}">

		<a href = "login.jsp" class = "button button3"> Logg inn </a>

	</c:if>
	<c:if test="${sessionScope.customer != null}">


	<p id="profileBox">
		<br>
		<jsp:useBean id="customer" scope="session" type="servlets.customers.Customer"/>
		Navn: <br>
		<c:out value="${customer.firstName}"> </c:out>
		<c:out value="${customer.middleName}"> </c:out>
		<c:out value="${customer.lastName}"> </c:out><br><br>
		Adresse:<br>
		<c:out value="${customer.customerAddress}"> </c:out><br><br>
		Mobilnummer:<br>
		<c:out value="${customer.phoneNumber}"> </c:out><br><br>
		Email: <br>
		<c:out value="${customer.email}"> </c:out>
	</p>

	</c:if>
		<br>
	<form action="registrer.html">
		<button class="button"> Endre profilinfomasjon </button>
	</form>
	
	<form action="registrer.html">
			<button class="button"> Endre passord </button>
		</form>

			<form action="/TicketServlet" method="get">
				<button class="button"> billett </button>
			</form>
	<br>
	<form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" class="button" value="Logg ut" />
	</form>
</form>
</div>
</body>
</html>
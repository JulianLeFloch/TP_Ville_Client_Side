<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Distance entre deux villes</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<style>
::-webkit-scrollbar {
	display: none;
}

footer {
	padding: 2rem 1rem 4rem !important;
}
</style>
</head>

<%@include file="navbar.jsp"%>
<body>
	<br>
	<br>
	<section class="has-text-centered">
	
	<div class="field has-text-centered">
                                <img src="https://cdn-icons-png.flaticon.com/512/727/727613.png?w=826" width="167">
                            </div>
		<c:choose>
			<c:when test="${ empty nomA }">

				<form method="post" action="calculDistance">

					<div class="columns is-mobile is-centered">
						<div class="column is-half">

							<div class="select is-small is-rounded is-info">
								<select name="pointA" id="pointA">
									<option value="" disabled selected hidden>Ville n°1</option>
									<c:forEach items="${ villes }" var="current" varStatus="status">
										<option value="${current.nomCommune}">${current.nomCommune}</option>
									</c:forEach>
								</select>
							</div>
						
							<div class="select is-small is-rounded is-info">
								<select name="pointB" id="pointB">
									<option value="" disabled selected hidden>Ville n°2</option>
									<c:forEach items="${ villes }" var="current" varStatus="status">
										<option value="${current.nomCommune}">${current.nomCommune}</option>
									</c:forEach>
								</select>

							</div>
						</div>
					</div>
					<br>

					<input class="button is-info is-medium" value="Calculer"
						type="submit" />

				</form>

			</c:when>

			<c:otherwise>
				<br>
				<div class="has-text-centered" style="font-size: 24px">
					<c:out
						value="La distance entre ${ nomA } et ${ nomB } est de ${ distance } km."></c:out>
				</div>
				<section class="section has-text-centered">
					<div class="container">
						<input class="button is-info is-medium"
							value="Choisir d'autres villes "
							onclick="window.location='http://localhost:8080/TP_Client_Part/calculDistance'">
					</div>
				</section>

			</c:otherwise>
		</c:choose>

		<section class="section has-text-centered">
					<div class="container">
						<input class="button is-success is-medium"
							value="Retour à l'accueil" onclick="RetourAccueil()">
					</div>
				</section>
		
	</section>
	<%@include file="footer.jsp"%>
	<%@include file="animation.jsp"%>
</body>
</html>
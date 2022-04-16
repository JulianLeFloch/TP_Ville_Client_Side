<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Accueil</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.9.3/css/bulma.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.5/css/dataTables.bulma.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.bulma.min.css">

<script type="text/javascript" charset="utf8"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.11.5/js/dataTables.bulma.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/responsive/2.2.9/js/responsive.bulma.min.js"></script>
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
	<section class="section has-text-centered">
		<div class="container">
			<p class="Title" style="font-size: 18px">
				<strong>Liste des villes enregistrées dans la base de données :</strong>
			</p>
		</div>
	</section>

	<div style="margin: 0 20px 20px 20px; font-size: 18px">
		<table id="table_villes"
			class="table is-bordered is-striped is-narrow is-hoverable"
			style="width: 100%">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Code commune</th>
					<th>Code postal</th>
					<th>Libelle acheminement</th>
					<th>Ligne 5</th>
					<th>Latitude</th>
					<th>Longitude</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ villes }" var="villes">
					<tr>
						<td><c:out value="${ villes.getNomCommune() }"></c:out></td>
						<td><c:out value="${ villes.getCodeCommuneInsee() }"></c:out></td>
						<td><c:out value="${ villes.getCodePostal() }"></c:out></td>
						<td><c:out value="${ villes.getLibelleAcheminement() }"></c:out></td>
						<td><c:out value="${ villes.getLigne5() }"></c:out></td>
						<td><c:out value="${ villes.getLatitude() }"></c:out></td>
						<td><c:out value="${ villes.getLongitude() }"></c:out></td>
						<td><a href="<%=application.getContextPath()%>/modifierVille?codeCommuneInsee=${ villes.getCodeCommuneInsee() }" onclick="ModifierVille()">Modifier ville</a></td>
						<td><a href="<%=application.getContextPath()%>/supprimerVille?codeCommuneInsee=${ villes.getCodeCommuneInsee()}" onclick="SupprimerVille()">Supprimer ville</a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>

		<script type="text/javascript">
			$(document).ready(function() {
				$('#table_villes').dataTable({
					"pagingType" : "full_numbers",
					"language" : {
						"decimal" : "",
						"emptyTable" : "Pas de données disponibles dans la base de données",
						"info" : "Vous avez vu _END_ villes sur un total de _TOTAL_",
						"infoEmpty" : "Montrer 0 sur 0 sur un total de 0 villes",
						"infoFiltered" : "(filtré sur un total de  _MAX_ données)",
						"infoPostFix" : "",
						"thousands" : ".",
						"lengthMenu" : 'Montrer <select>'
						+ '<option value="10">10</option>'						
						+ '<option value="20">20</option>'
						+ '<option value="30">30</option>'
						+ '<option value="40">40</option>'
						+ '<option value="50" selected>50</option>'
						+ '<option value="100">100</option>'
						+ '</select> villes',
						"loadingRecords" : "Chargement...",
						"processing" : "Attente...",
						"search" : "Rechercher une ville dans la liste :",
						"zeroRecords" : "Il n'y a malheureusement pas de ville trouvé avec cette recherche...",
						"paginate" : {
							"first" : "Première page",
							"last" : "Page finale",
							"next" : "Suivant",
							"previous" : "Précédemment"
					     }
					}
				});
			});
		</script>
	</div>
	<%@include file="animation.jsp"%>
	<%@include file="footer.jsp"%>
</body>
</html>
</html>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ville bien modifiée</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
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
      <section>
          <div class="hero-body">
              <div class="container">
              <div class="field has-text-centered">
                                <img src="https://cdn-icons-png.flaticon.com/512/1177/1177445.png?w=826" width="167">
                            </div>
              <p class="Title has-text-centered" style="font-size: 24px">
				<strong>La ville  suivante : <c:out value="${ villeNonModif.getNomCommune()}"></c:out></strong>
			</p>
			<p class="Title has-text-centered" style="font-size: 24px">
				<strong>A bien été modifiée dans la base de données, voici ses nouvelles informations : </strong>
			</p>
          </div>
          </div>
      </section>
      
      <div style="margin: 0 20px 20px 20px; font-size: 16px">
		<table id="table_villes"
			class="table is-bordered is-striped is-narrow is-hoverable "
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
				</tr>
			</thead>
			<tbody>
					<tr>
						<td><c:out value="${ villeModif.getNomCommune() }"></c:out></td>
						<td><c:out value="${ villeModif.getCodeCommuneInsee() }"></c:out></td>
						<td><c:out value="${ villeModif.getCodePostal() }"></c:out></td>
						<td><c:out value="${ villeModif.getLibelleAcheminement() }"></c:out></td>
						<td><c:out value="${ villeModif.getLigne5() }"></c:out></td>
						<td><c:out value="${ villeModif.getLatitude() }"></c:out></td>
						<td><c:out value="${ villeModif.getLongitude() }"></c:out></td>
					</tr>
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
      <section class="section has-text-centered">
			<div class="container">
				<input class="button is-success" value="Retour à l'accueil" onclick="RetourAccueil()">
			</div>
	</section>
  </body>
  <%@include file="animation.jsp"%>
  <%@include file="footer.jsp"%>
</html>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ajouter une ville</title>
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
      <section class="hero is-fullheight">
          <div class="hero-body">
              <div class="container">
                <div class="columns is-5-tablet is-4-desktop is-3-widescreen">
                    <div class="column">
                        <form class="box" method="post" action="ajouterVille">
                            <div class="field has-text-centered">
                                <img src="https://cdn-icons-png.flaticon.com/512/3157/3157646.png" width="167">
                            </div>
                            <div class="field">
                                <label class="label">Nom</label>
                                <div class="control has-icons-left">
                                    <input type="text" name="nom" id="nom" class="input" placeholder="Nom de la ville" required>
                                    <span class="icon is-small is-left">
                						<i class="fa fa-map-pin"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Code de la commune</label>
                                <div class="control has-icons-left">
                                    <input type="text" name="codeCommune" id="codeCommune"  class="input" placeholder="Code commune de la ville" required>
                                    <span class="icon is-small is-left">
                                        <i class="fa fa-barcode"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Code postal</label>
                                <div class="control has-icons-left">
                                    <input type="text" class="input" name="codePostal" id="codePostal" placeholder="Code postal de la ville">
                                    <span class="icon is-small is-left">
                                       <i class="fa fa-envelope"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Libéllé acheminnement</label>
                                <div class="control has-icons-left">
                                    <input type="text" name="libelle" id="libelle" class="input" placeholder="Libéllé acheminnement de la ville">
                                    <span class="icon is-small is-left">
                                       <i class="fa fa-road"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Ligne 5</label>
                                <div class="control has-icons-left">
                                    <input type="text" name="ligne5" id="ligne5" class="input" placeholder="Ligne 5 de la ville">
                                    <span class="icon is-small is-left">
                                        <i class="fa fa-train"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Longitude</label>
                                <div class="control has-icons-left">
                                    <input type="text" name="longitude" id="longitude" class="input" placeholder="Longitude de la ville">
                                    <span class="icon is-small is-left">
                                        <i class="fa fa-globe"></i>
                                    </span>
                                </div>
                            </div>
                            
                            <div class="field">
                                <label class="label">Latitude</label>
                                <div class="control has-icons-left">
                                    <input type="text" name="latitude" id="latitude" class="input" placeholder="Latitude de la ville">
                                    <span class="icon is-small is-left">
                                        <i class="fa fa-globe"></i>
                                    </span>
                                </div>
                            </div>
                            <br>
                            <div class="field has-text-centered">
                                <input class="button is-success" value="Ajouter la ville dans la base de données" type="submit"/>
                            </div>
                        </form>
                    </div>
                </div>
              </div>
          </div>
      </section>
  </body>
  <%@include file="footer.jsp" %>
</html>

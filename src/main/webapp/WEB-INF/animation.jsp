<script type="text/javascript">

function ModifierVille(){
	if(confirm("Voulez-vous modifier cette ville ?")){
		window.location="http://localhost:8080/TP_Client_Part/modifierVille";
	}
	else{
		return;
	}
}

function RetourAccueil(){
	if(confirm("�tes-vous s�r de vouloir retourner � l'accueil ?")){
		window.location="http://localhost:8080/TP_Client_Part/accueil";
	}
	else{
		return;
	}
}

function SupprimerVille(){
	if(confirm("Voulez-vous supprimer cette ville ?")){
		window.location="http://localhost:8080/TP_Client_Part/supprimerVille";
	}
	else{
		return;
	}
}


</script>
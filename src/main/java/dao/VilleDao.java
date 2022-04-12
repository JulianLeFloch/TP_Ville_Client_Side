package dao;

import java.util.ArrayList;

import dto.Ville;

public interface VilleDao {

	ArrayList<Ville> recupererVilleDeFrance();
	
	void ajouterVille(String nom, String codeCommune, String codePostal, String libelle, String ligne5, String longitude, String latitude);
}

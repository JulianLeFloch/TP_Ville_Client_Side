package dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import dto.Ville;

public interface VilleDao {

	ArrayList<Ville> recupererAllVillesDeFrance();
	
	void ajouterVille(String nom, String codeCommune, String codePostal, String ligne5, String libelle, String longitude, String latitude)  throws UnsupportedEncodingException;

	void ModifierVille(String nom, String codeCommune, String codePostal, String ligne5, String libelle, String longitude, String latitude)  throws UnsupportedEncodingException;

	void SupprimerVille(String code);

	Ville VilleAvecCode(String codeVille);
}

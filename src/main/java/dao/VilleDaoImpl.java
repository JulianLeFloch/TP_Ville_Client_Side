package dao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import dto.Ville;
import transform.BuilderObject;

public class VilleDaoImpl implements VilleDao {


	@Override
	public ArrayList<Ville> recupererVilleDeFrance() {

		BuilderObject builder = new BuilderObject();
		JSONArray json;
		ArrayList<Ville> listeVilles = null;
		try {
			json = builder.readJsonFromUrl("http://localhost:8181/Villes");
			ObjectMapper mapper = new ObjectMapper();
			listeVilles = mapper.readValue(json.toString(), new TypeReference<ArrayList<Ville>>() {
			});
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("non");
		}

		for (Ville current : listeVilles) {
			System.out.println(current.getNomCommune() + "/n");
		}

		return listeVilles;
	}

	@Override
	public void ajouterVille(String nom, String codeCommune, String codePostal, String libelle,
			String latitude, String longitude, String ligne5) {
	
		try {
			URL url = new URL("http://localhost:8181/Ville_Ajouter?Code_commune_INSEE=" + codeCommune + "&Code_postal=" + codePostal + "&Nom_Commune=" + nom
					+ "&Libelle_acheminement=" + libelle + "&Latitude=" + latitude  + "&Longitude=" + longitude +  "Ligne_5=" + ligne5);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setRequestProperty("Accept", "application/json");

			if (httpUrlConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + httpUrlConnection.getResponseCode());
			}

			System.out.println("Output from Serveur ... /n");
			httpUrlConnection.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

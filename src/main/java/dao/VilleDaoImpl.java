package dao;

import java.io.IOException;
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
}

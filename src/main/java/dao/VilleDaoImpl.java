package dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Ville;
import transform.BuilderObject;

public class VilleDaoImpl implements VilleDao {


	@Override
	public ArrayList<Ville> recupererAllVillesDeFrance() {

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
	public void ajouterVille(String nom, String codeCommune, String codePostal, String ligne5,
			String libelle, String longitude, String latitude){
		try {
			   CloseableHttpClient httpClient = HttpClients.createDefault();
			   
			   String requestBody = "{\n"
			   		+ "    \"nomCommune\": \""+nom+"\",\n"
			   		+ "	\"codeCommuneInsee\": \""+codeCommune+"\",\n"
			   		+ "	\"codePostal\": \""+codePostal+"\",\n"
			   		+ "	\"ligne5\": \""+ligne5+"\",\n"
			   		+ "	\"libelleAcheminement\": \""+libelle+"\",\n"
			   		+ "	\"longitude\": \""+longitude+"\",\n"
			   		+ "	\"latitude\": \""+latitude+"\"\n"
			   		+ "	}";
			   System.out.println(requestBody.toString());
			   StringEntity stringEntity = new StringEntity(requestBody);
			   HttpPost httpPost = new HttpPost();
			   httpPost.setURI(new URI("http://localhost:8181/Ville_Ajouter"));
			   httpPost.addHeader("Content-type", "application/json");
			   httpPost.setEntity(stringEntity);
			   CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			   System.out.println("Status Code - " + httpResponse.getStatusLine().toString());
			  } catch (URISyntaxException e) {
			   e.printStackTrace();
			  } catch (UnsupportedEncodingException e) {
			   e.printStackTrace();
			  } catch (ClientProtocolException e) {
			   e.printStackTrace();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}

	@Override
	public void modifierVille(String nom, String codeCommune, String codePostal, String ligne5, String libelle,
			String longitude, String latitude) throws UnsupportedEncodingException {
		try {
			   CloseableHttpClient httpClient = HttpClients.createDefault();
			   
			   String requestBody = "{\n"
			   		+ "    \"nomCommune\": \""+nom+"\",\n"
			   		+ "	\"codeCommuneInsee\": \""+codeCommune+"\",\n"
			   		+ "	\"codePostal\": \""+codePostal+"\",\n"
			   		+ "	\"ligne5\": \""+ligne5+"\",\n"
			   		+ "	\"libelleAcheminement\": \""+libelle+"\",\n"
			   		+ "	\"longitude\": \""+longitude+"\",\n"
			   		+ "	\"latitude\": \""+latitude+"\"\n"
			   		+ "	}";
			   System.out.println(requestBody.toString());
			   StringEntity stringEntity = new StringEntity(requestBody);
			   HttpPost httpPost = new HttpPost();
			   httpPost.setURI(new URI("http://localhost:8181/Ville_Ajouter"));
			   httpPost.addHeader("Content-type", "application/json");
			   httpPost.setEntity(stringEntity);
			   CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			   System.out.println("Status Code - " + httpResponse.getStatusLine().toString());
			  } catch (URISyntaxException e) {
			   e.printStackTrace();
			  } catch (UnsupportedEncodingException e) {
			   e.printStackTrace();
			  } catch (ClientProtocolException e) {
			   e.printStackTrace();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
		
	}
}

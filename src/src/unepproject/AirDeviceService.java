package src.unepproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import src.model.AirDevice;
/*
 * SERVICE AIR DEVICE
 * BEN JEMMA OTHMAN
 * ©Medothman.Benjemaa@esprit.tn©
 */
public class AirDeviceService {
	
	   //SERVICE:
	   public JSONArray getAirDevices() throws IOException, JSONException {
	  
	    String url = "http://localhost:3000/AirDevice";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		JSONArray jsonArr = new JSONArray(response.toString());
		return jsonArr;
		
	   } 
	   
	   public JSONArray addAirDevice(AirDevice a) throws IOException, JSONException {

			String url = "http://localhost:3000/AirDevice/";
			JSONObject json = new JSONObject();
		
			json.put("country", a.getCountry());
			json.put("state",a.getState());
			json.put("number", a.getNumber());
			json.put("date", a.getDate());
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setDoOutput(true);
			con.setDoInput(true);
			OutputStream os = con.getOutputStream();
			os.write(json.toString().getBytes("UTF-8"));
			os.close();
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					((HttpURLConnection) (new URL(url)).openConnection()).getInputStream(), Charset.forName("UTF-8")));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONArray jsonObj = new JSONArray(response.toString());
			return jsonObj;

		}
	   public JSONArray deleteAirDevice(int id ) throws IOException, JSONException {

			String url = "http://localhost:3000/AirDevice/"+id;
		
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setDoOutput(true);
			con.setDoInput(true);
			OutputStream os = con.getOutputStream();
			os.close();
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					((HttpURLConnection) (new URL(url)).openConnection()).getInputStream(), Charset.forName("UTF-8")));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONArray jsonObj = new JSONArray(response.toString());
			return jsonObj;

		}
	   public JSONArray updateAirDevice(AirDevice a) throws IOException, JSONException {

			String url = "http://localhost:3000/AirDevice/"+a.getIdDevice();
			JSONObject json = new JSONObject();
		
			json.put("country", a.getCountry());
			json.put("state",a.getState());
			json.put("number", a.getNumber());
			json.put("date", a.getDate());
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setDoOutput(true);
			con.setDoInput(true);
			OutputStream os = con.getOutputStream();
			os.write(json.toString().getBytes("UTF-8"));
			os.close();
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					((HttpURLConnection) (new URL(url)).openConnection()).getInputStream(), Charset.forName("UTF-8")));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONArray jsonObj = new JSONArray(response.toString());
			return jsonObj;

		}
}

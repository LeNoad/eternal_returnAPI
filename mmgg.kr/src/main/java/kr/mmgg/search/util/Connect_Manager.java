package kr.mmgg.search.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Connect_Manager {
	
	private int responseCode;
	private String result_api_data;
	private String output;
	private Static_Api_Key api;
	private JSONObject jsonObject;
	public String connect_toAPI(String urL_api_connect) {
		api = new Static_Api_Key();
		URL urlObject = null;
		HttpURLConnection con = null;
		StringBuffer response = new StringBuffer();
		try {
			urlObject = new URL(urL_api_connect);
			con = (HttpURLConnection) urlObject.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("accept", "application/json");
			con.setRequestProperty("x-api-key", api.getKey());
			responseCode = con.getResponseCode();
//			System.out.println("responseCode : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while ((output = br.readLine()) != null) {
				response.append(output);
				result_api_data = output;
			}
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject) parser.parse(result_api_data);
			if(jsonObject.get("code").toString().equals("404")) {
				System.out.println(jsonObject.get("code").toString());
				return null;
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result_api_data;
	}
}

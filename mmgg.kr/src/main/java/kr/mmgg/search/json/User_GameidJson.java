package kr.mmgg.search.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.mmgg.search.dto.User_GameidDTO;
import kr.mmgg.search.uri.User_GameidURI;

public class User_GameidJson {
	private User_GameidURI user_gameiduri;
	private User_GameidDTO user_gameiddto;
	private User_GameinfoJson user_gameinfojson;
	public List<User_GameidDTO> read_json(String nickname){
		user_gameinfojson = new User_GameinfoJson();
		JSONObject userGameid_json;
		JSONArray userGameid_json_arr = null;
		JSONObject userGameid_json_arr_obj;
		ArrayList<User_GameidDTO> list = new ArrayList<User_GameidDTO>();
		
		user_gameiduri = new User_GameidURI();
		
		try {
			JSONParser parser = new JSONParser();
			userGameid_json = (JSONObject) parser.parse(user_gameiduri.gameid(nickname));
			userGameid_json_arr = (JSONArray) userGameid_json.get("userGames");
			
			for (int i = 0; i < userGameid_json_arr.size(); i++) {
				user_gameiddto = new User_GameidDTO();
				userGameid_json_arr_obj = (JSONObject) userGameid_json_arr.get(i);
				user_gameiddto.setGameId(userGameid_json_arr_obj.get("gameId").toString());
				user_gameiddto.setUserNum(Integer.parseInt(userGameid_json_arr_obj.get("userNum").toString()));
				user_gameinfojson.read_json(user_gameiddto.getGameId());
				list.add(user_gameiddto);
			}
			

		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}

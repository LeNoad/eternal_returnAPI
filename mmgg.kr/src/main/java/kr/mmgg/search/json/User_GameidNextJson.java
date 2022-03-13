package kr.mmgg.search.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.mmgg.search.dto.User_GameidDTO;
import kr.mmgg.search.uri.User_GameidURI;


public class User_GameidNextJson {
	private User_GameidURI user_gameiduri;
	private User_GameidDTO user_gameiddto;
	private User_GameinfoJson user_gameinfojson;

	public List<User_GameidDTO> readnext_json(String gameid, String nickname) {
		user_gameinfojson = new User_GameinfoJson();
		JSONObject userGameid_json;
		JSONArray userGameid_json_arr = null;
		JSONObject userGameid_json_arr_obj;
		ArrayList<User_GameidDTO> list = new ArrayList<User_GameidDTO>();
		user_gameiduri = new User_GameidURI();
		try {
			JSONParser parser = new JSONParser();
			userGameid_json = (JSONObject) parser.parse(user_gameiduri.next(gameid, nickname));
			userGameid_json_arr = (JSONArray) userGameid_json.get("userGames");// 에러
			if (userGameid_json_arr != null) { // URI로 접속하여서 널값이 아닐경우만 가져온다.
				for (int i = 0; i < userGameid_json_arr.size(); i++) {
					user_gameiddto = new User_GameidDTO();
					userGameid_json_arr_obj = (JSONObject) userGameid_json_arr.get(i);
					user_gameiddto.setGameId(userGameid_json_arr_obj.get("gameId").toString());
					list.add(user_gameiddto);
				}
//				try {
//					user_gameiddto.setNext(userGameid_json.get("next").toString());
//				} catch (NullPointerException e) {
//					user_gameiddto.setNext(null);
//				}
			}
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}

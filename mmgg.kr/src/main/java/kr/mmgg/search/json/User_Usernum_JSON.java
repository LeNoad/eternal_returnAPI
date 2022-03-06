package kr.mmgg.search.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.mmgg.search.dto.User_Usernum_DTO;
import kr.mmgg.search.uri.User_URI;

public class User_Usernum_JSON {
	private User_URI uri;
	private User_Usernum_DTO dto;
	public List<User_Usernum_DTO> read_json(String nickname) {
		JSONObject jsonObject;
		List<User_Usernum_DTO> list = new ArrayList<User_Usernum_DTO>();
		uri = new User_URI();
		dto = new User_Usernum_DTO();
		try {
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject) parser.parse(uri.usernum_uri(nickname));
			JSONObject user_json = (JSONObject) jsonObject.get("user");
			dto.setNickname(user_json.get("nickname").toString());
			dto.setUserNum(user_json.get("userNum").toString());
			list.add(dto);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}

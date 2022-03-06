package kr.mmgg.search.uri;

import java.util.List;

import kr.mmgg.search.dto.User_Usernum_DTO;
import kr.mmgg.search.json.User_Usernum_JSON;
import kr.mmgg.search.util.Connect_Manager;
import kr.mmgg.search.util.Static_Api_Key;

public class User_GameidURI {
	private Static_Api_Key api_value;
	private String gameid_uri;
	private Connect_Manager connect;
	private User_URI usernumURI;

	public String gameid(String nickname) {
		User_Usernum_JSON usernum_json = new User_Usernum_JSON();
		List<User_Usernum_DTO> usernum_list = usernum_json.read_json(nickname);
		User_Usernum_DTO usernum_dto = usernum_list.get(0);
		api_value = new Static_Api_Key();
		connect = new Connect_Manager();
		gameid_uri = api_value.getUrl() + "/user/games/" + usernum_dto.getUserNum();
		return connect.connect_toAPI(gameid_uri);
	}

	public String next(String gameid, String nickname) {
		User_Usernum_JSON usernum_json = new User_Usernum_JSON();
		List<User_Usernum_DTO> usernum_list = usernum_json.read_json(nickname);
		User_Usernum_DTO usernum_dto = usernum_list.get(0);
		api_value = new Static_Api_Key();
		connect = new Connect_Manager();
		gameid_uri = api_value.getUrl() + "/user/games/" + usernum_dto.getUserNum() + "?next=" + gameid;
		return connect.connect_toAPI(gameid_uri);
	}

	public String gameinfo(String gameid) {
		api_value = new Static_Api_Key();
		connect = new Connect_Manager();
		gameid_uri = api_value.getUrl() + "/games/" + gameid;
		return connect.connect_toAPI(gameid_uri);
	}

}

package kr.mmgg.search.uri;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import kr.mmgg.search.util.Connect_Manager;
import kr.mmgg.search.util.Static_Api_Key;


public class User_URI {
	private Static_Api_Key api_value;
	private Connect_Manager connect;
	
	public String top_rank_curl_solo() {
		api_value = new Static_Api_Key();
		connect = new Connect_Manager();
		String top_rank_url_solo = api_value.getUrl() +  "/rank/top/9/1";
		return connect.connect_toAPI(top_rank_url_solo);
	}
	public String top_rank_curl_duo() {
		api_value = new Static_Api_Key();
		connect = new Connect_Manager();
		String top_rank_url_duo = api_value.getUrl() +  "/rank/top/9/2";
		return connect.connect_toAPI(top_rank_url_duo);
	}
	public String top_rank_curl_squad() {
		api_value = new Static_Api_Key();
		connect = new Connect_Manager();
		String top_rank_url_squad = api_value.getUrl() +  "/rank/top/9/3";
		return connect.connect_toAPI(top_rank_url_squad);
	}
	public String stats_uri(String user_number) {
		api_value = new Static_Api_Key();
		connect = new Connect_Manager();
		String stats_url = api_value.getUrl() + "/user/stats/"+user_number+"/7";
		return connect.connect_toAPI(stats_url);
	}
	public String usernum_uri(String nickname) {
		api_value = new Static_Api_Key();
		connect = new Connect_Manager();
		String usernum_url = api_value.getUrl() + "/user/nickname?query=" + encodeURIComponent(nickname);
		return connect.connect_toAPI(usernum_url);
	}
	public static String encodeURIComponent(String component) {
		String result = null;
		try {
			result = URLEncoder.encode(component, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}

package kr.mmgg.search.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.mmgg.search.entity.ranking_solo;
import kr.mmgg.search.uri.User_URI;
import kr.mmgg.search.util.dateTime;

public class User_Toprank_SOLO_JSON {
	private User_URI uri;
	private ranking_solo dto;

	public List<ranking_solo> read_json() {
		JSONObject jsonObject;
		JSONArray userTopRank_json = null;
		JSONObject userTopRank_arr;
		dateTime date;
		ArrayList<ranking_solo> list = new ArrayList<ranking_solo>();
		uri = new User_URI();
		try {
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject) parser.parse(uri.top_rank_curl_solo());
			userTopRank_json = (JSONArray) jsonObject.get("topRanks");
			for (int j = 0; j < 5; j++) {
				dto = new ranking_solo();
				date = new dateTime();
				userTopRank_arr = (JSONObject) userTopRank_json.get(j);
				dto.setNickname(userTopRank_arr.get("nickname").toString());
				dto.setMmr(userTopRank_arr.get("mmr").toString());
				dto.setRank(Integer.parseInt(userTopRank_arr.get("rank").toString()));
				dto.setDate(date.dateTime());
				list.add(dto);
			}
		} catch (ParseException e) {
			// TODO: handle exception
		}
		return list;
	}
}

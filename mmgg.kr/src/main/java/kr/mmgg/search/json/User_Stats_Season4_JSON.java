package kr.mmgg.search.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.mmgg.search.dto.User_Usernum_DTO;
import kr.mmgg.search.entity.maininfo_user_season4;
import kr.mmgg.search.uri.User_URI;
import kr.mmgg.search.util.dateTime;

public class User_Stats_Season4_JSON {
	private User_URI uri;
	private maininfo_user_season4 dto;

	public List<maininfo_user_season4> read_json(String nickname) {
		JSONObject jsonObject;
		JSONArray userStats_json;
		JSONObject userStats_json_teammode;
		JSONArray userStats_json_characterNum;
		List<maininfo_user_season4> list = new ArrayList<maininfo_user_season4>();
		uri = new User_URI();
		dto = new maininfo_user_season4();
		dateTime date = new dateTime();
		// 유저넘버 DTO 출력
		User_Usernum_JSON usernum_json = new User_Usernum_JSON();
		List<User_Usernum_DTO> usernum_list = usernum_json.read_json(nickname);
		if (usernum_list.size() == 0) {
			System.out.println("클라이언트로부터 받아온 값이 없습니다.");
		}

		User_Usernum_DTO usernum_dto = usernum_list.get(0);
		dto.setUsernum(Integer.parseInt(usernum_dto.getUserNum()));
		dto.setNickname(usernum_dto.getNickname());
		dto.setDate(date.dateTime());
		try {
			JSONParser parser = new JSONParser();
			if (uri.season4_stats_uri(usernum_dto.getUserNum()) == null) {
				list.add(dto);
			} else {
				jsonObject = (JSONObject) parser.parse(uri.season4_stats_uri(usernum_dto.getUserNum()));
				userStats_json = (JSONArray) jsonObject.get("userStats");
//			if (!userStats_json.get(0).equals(null)) {
//				userStats_json_teammode = (JSONObject) userStats_json.get(0);
//				dto.setRank_solo_mmr(userStats_json_teammode.get("mmr").toString());
//				dto.setRank_solo_totalgames(userStats_json_teammode.get("totalGames").toString());
//				dto.setRank_solo_totalwins(userStats_json_teammode.get("totalWins").toString());
//				dto.setRank_solo_top3(userStats_json_teammode.get("top3").toString());
//				dto.setRank_solo_averagerank(userStats_json_teammode.get("averageRank").toString());
//				dto.setRank_solo_averagekills(userStats_json_teammode.get("averageKills").toString());
//				dto.setRank_solo_averageassistants(userStats_json_teammode.get("averageAssistants").toString());
//			}
				try {
					if (userStats_json.listIterator(0).hasNext()) {
						userStats_json_teammode = (JSONObject) userStats_json.get(0);
						userStats_json_characterNum = (JSONArray) userStats_json_teammode.get("characterStats");
						JSONObject userStats_json_characterCode = (JSONObject) userStats_json_characterNum.get(0);
						dto.setRank_solo_charactercode_1(userStats_json_characterCode.get("characterCode").toString());
						dto.setRank_solo_mmr(Integer.parseInt(userStats_json_teammode.get("mmr").toString()));
						dto.setRank_solo_totalgames(userStats_json_teammode.get("totalGames").toString());
						dto.setRank_solo_totalwins(userStats_json_teammode.get("totalWins").toString());
						dto.setRank_solo_top3(userStats_json_teammode.get("top3").toString());
						dto.setRank_solo_averagerank(userStats_json_teammode.get("averageRank").toString());
						dto.setRank_solo_averagekills(userStats_json_teammode.get("averageKills").toString());
						dto.setRank_solo_averageassistants(userStats_json_teammode.get("averageAssistants").toString());
					}
				} catch (IndexOutOfBoundsException e) {
					dto.setRank_solo_mmr(0);
					dto.setRank_solo_totalgames("");
					dto.setRank_solo_totalwins("");
					dto.setRank_solo_top3("");
					dto.setRank_solo_averagerank("");
					dto.setRank_solo_averagekills("");
					dto.setRank_solo_averageassistants("");
				}
				try {
					if (userStats_json.listIterator(1).hasNext()) {
						userStats_json_teammode = (JSONObject) userStats_json.get(1);
						userStats_json_characterNum = (JSONArray) userStats_json_teammode.get("characterStats");
						JSONObject userStats_json_characterCode = (JSONObject) userStats_json_characterNum.get(0);
						dto.setRank_duo_charactercode_1(userStats_json_characterCode.get("characterCode").toString());
						dto.setRank_duo_mmr(Integer.parseInt(userStats_json_teammode.get("mmr").toString()));
						dto.setRank_duo_totalgames(userStats_json_teammode.get("totalGames").toString());
						dto.setRank_duo_totalwins(userStats_json_teammode.get("totalWins").toString());
						dto.setRank_duo_top3(userStats_json_teammode.get("top3").toString());
						dto.setRank_duo_averagerank(userStats_json_teammode.get("averageRank").toString());
						dto.setRank_duo_averagekills(userStats_json_teammode.get("averageKills").toString());
						dto.setRank_duo_averageassistants(userStats_json_teammode.get("averageAssistants").toString());
					}
				} catch (IndexOutOfBoundsException e) {
					dto.setRank_duo_mmr(0);
					dto.setRank_duo_totalgames("");
					dto.setRank_duo_totalwins("");
					dto.setRank_duo_top3("");
					dto.setRank_duo_averagerank("");
					dto.setRank_duo_averagekills("");
					dto.setRank_duo_averageassistants("");
				}
				try {
					if (!userStats_json.listIterator(2).hasNext()) {
						userStats_json_teammode = (JSONObject) userStats_json.get(2);
						userStats_json_characterNum = (JSONArray) userStats_json_teammode.get("characterStats");
						JSONObject userStats_json_characterCode = (JSONObject) userStats_json_characterNum.get(0);
						dto.setRank_squad_charactercode_1(userStats_json_characterCode.get("characterCode").toString());
						dto.setRank_squad_mmr(Integer.parseInt(userStats_json_teammode.get("mmr").toString()));
						dto.setRank_squad_totalgames(userStats_json_teammode.get("totalGames").toString());
						dto.setRank_squad_totalwins(userStats_json_teammode.get("totalWins").toString());
						dto.setRank_squad_top3(userStats_json_teammode.get("top3").toString());
						dto.setRank_squad_averagerank(userStats_json_teammode.get("averageRank").toString());
						dto.setRank_squad_averagekills(userStats_json_teammode.get("averageKills").toString());
						dto.setRank_squad_averageassistants(
								userStats_json_teammode.get("averageAssistants").toString());
					}
				} catch (IndexOutOfBoundsException e) {
					dto.setRank_squad_mmr(0);
					dto.setRank_squad_totalgames("");
					dto.setRank_squad_totalwins("");
					dto.setRank_squad_top3("");
					dto.setRank_squad_averagerank("");
					dto.setRank_squad_averagekills("");
					dto.setRank_squad_averageassistants("");
				}
				list.add(dto);
			}
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

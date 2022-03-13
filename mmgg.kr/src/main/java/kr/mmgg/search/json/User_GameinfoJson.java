package kr.mmgg.search.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.mmgg.search.entity.gameinfo_data;
import kr.mmgg.search.uri.User_GameidURI;

public class User_GameinfoJson {
	private User_GameidURI user_Gameiduri;
	private gameinfo_data user_Gameinfodto;

	public List<gameinfo_data> read_json(String gameid) {
		JSONObject userGameinfo_json;
		JSONArray userGameinfo_json_arr = null;
		JSONObject userGameinfo_json_arr_obj;
		JSONObject userGameinfo_json_weapon;
		JSONArray userGameinfo_json_traitFirst;
		JSONArray userGameinfo_json_traitSecond;
		ArrayList<gameinfo_data> list = new ArrayList<gameinfo_data>();
		user_Gameiduri = new User_GameidURI();
		try {
			JSONParser parser = new JSONParser();
			userGameinfo_json = (JSONObject) parser.parse(user_Gameiduri.gameinfo(gameid));
			userGameinfo_json_arr = (JSONArray) userGameinfo_json.get("userGames");
			for (int i = 0; i < userGameinfo_json_arr.size(); i++) {
				user_Gameinfodto = new gameinfo_data();
				userGameinfo_json_arr_obj = (JSONObject) userGameinfo_json_arr.get(i);
				userGameinfo_json_weapon = (JSONObject) userGameinfo_json_arr_obj.get("equipment");
				userGameinfo_json_traitFirst = (JSONArray) userGameinfo_json_arr_obj.get("traitFirstSub");
				userGameinfo_json_traitSecond = (JSONArray) userGameinfo_json_arr_obj.get("traitSecondSub");
				user_Gameinfodto.setGameId(Integer.parseInt(userGameinfo_json_arr_obj.get("gameId").toString()));
				user_Gameinfodto.setNickname(userGameinfo_json_arr_obj.get("nickname").toString());
				user_Gameinfodto.setUserNum(Integer.parseInt(userGameinfo_json_arr_obj.get("userNum").toString()));
				user_Gameinfodto.setMatchingMode(Integer.parseInt(userGameinfo_json_arr_obj.get("matchingMode").toString()));
				user_Gameinfodto.setMatchingTeamMode(Integer.parseInt(userGameinfo_json_arr_obj.get("matchingTeamMode").toString()));
				user_Gameinfodto.setSeasonId(Integer.parseInt(userGameinfo_json_arr_obj.get("seasonId").toString()));
				user_Gameinfodto.setGameRank(Integer.parseInt(userGameinfo_json_arr_obj.get("gameRank").toString()));
				user_Gameinfodto.setCharacterLevel(Integer.parseInt(userGameinfo_json_arr_obj.get("characterLevel").toString()));
				user_Gameinfodto.setMmrBefore(Integer.parseInt(userGameinfo_json_arr_obj.get("mmrBefore").toString()));
				user_Gameinfodto.setMmrGain(Integer.parseInt(userGameinfo_json_arr_obj.get("mmrGain").toString()));

				user_Gameinfodto.setDamageToPlayer(Integer.parseInt(userGameinfo_json_arr_obj.get("damageToPlayer").toString()));
				user_Gameinfodto.setDamageToMonster(Integer.parseInt(userGameinfo_json_arr_obj.get("damageToMonster").toString()));

				user_Gameinfodto.setPlayerKill(Integer.parseInt(userGameinfo_json_arr_obj.get("playerKill").toString()));
				user_Gameinfodto.setPlayerAssistant(Integer.parseInt(userGameinfo_json_arr_obj.get("playerAssistant").toString()));
				user_Gameinfodto.setMonsterKill(Integer.parseInt(userGameinfo_json_arr_obj.get("monsterKill").toString()));

				user_Gameinfodto.setCharacterNum(Integer.parseInt(userGameinfo_json_arr_obj.get("characterNum").toString()));
				user_Gameinfodto.setSkinCode(Integer.parseInt(userGameinfo_json_arr_obj.get("skinCode").toString()));

				if (userGameinfo_json_weapon.get("0") != null) {
					user_Gameinfodto.setEquipment_0(Integer.parseInt(userGameinfo_json_weapon.get("0").toString()));
				} else {
					user_Gameinfodto.setEquipment_0(0);
				}
				if (userGameinfo_json_weapon.get("1") != null) {
					user_Gameinfodto.setEquipment_1(Integer.parseInt(userGameinfo_json_weapon.get("1").toString()));
				} else {
					user_Gameinfodto.setEquipment_1(0);
				}
				if (userGameinfo_json_weapon.get("2") != null) {
					user_Gameinfodto.setEquipment_2(Integer.parseInt(userGameinfo_json_weapon.get("2").toString()));
				} else {
					user_Gameinfodto.setEquipment_2(0);
				}
				if (userGameinfo_json_weapon.get("3") != null) {
					user_Gameinfodto.setEquipment_3(Integer.parseInt(userGameinfo_json_weapon.get("3").toString()));
				} else {
					user_Gameinfodto.setEquipment_3(0);
				}
				if (userGameinfo_json_weapon.get("4") != null) {
					user_Gameinfodto.setEquipment_4(Integer.parseInt(userGameinfo_json_weapon.get("4").toString()));
				} else {
					user_Gameinfodto.setEquipment_4(0);
				}
				if (userGameinfo_json_weapon.get("5") != null) {
					user_Gameinfodto.setEquipment_5(Integer.parseInt(userGameinfo_json_weapon.get("5").toString()));
				} else {
					user_Gameinfodto.setEquipment_5(0);
				}
				try {
					user_Gameinfodto.setTraitFirstCore(Integer.parseInt(userGameinfo_json_arr_obj.get("traitFirstCore").toString()));
					user_Gameinfodto.setTraitFirstSub_1(Integer.parseInt(userGameinfo_json_traitFirst.get(0).toString()));
					user_Gameinfodto.setTraitFirstSub_2(Integer.parseInt(userGameinfo_json_traitFirst.get(1).toString()));
					user_Gameinfodto.setTraitSecondSub_1(Integer.parseInt(userGameinfo_json_traitSecond.get(0).toString()));
					user_Gameinfodto.setTraitSecondSub_2(Integer.parseInt(userGameinfo_json_traitSecond.get(1).toString()));
				} catch (IndexOutOfBoundsException e) {
					// TODO: handle exception
					
				}
//				System.out.println("게임번호 : " + user_Gameinfodto.getGameId());
//				System.out.println("닉네임 : " + user_Gameinfodto.getNickname());
//				System.out.println("유저번호 : " + user_Gameinfodto.getUserNum());
//				System.out.println("게임모드 : " + user_Gameinfodto.getMatchingMode());
//				System.out.println("매칭팀모드 : " + user_Gameinfodto.getMatchingTeamMode());
//				System.out.println("게임내 순위 : " + user_Gameinfodto.getGameRank());
//				System.out.println("케릭터 래밸 : " + user_Gameinfodto.getCharacterLevel());
//				System.out.println("MMR : " + user_Gameinfodto.getMmrBefore() + "+" + user_Gameinfodto.getMmrGain());
//				System.out.println("딜량 : " + user_Gameinfodto.getDamageToPlayer());
//				System.out.println("동물 딜량 :" + user_Gameinfodto.getDamageToMonster());
//				System.out.println("K : " + user_Gameinfodto.getPlayerKill());
//				System.out.println("A : " + user_Gameinfodto.getPlayerAssistant());
//				System.out.println("H : " + user_Gameinfodto.getMonsterKill());
//				System.out.println("케릭번호 : " + user_Gameinfodto.getCharacterNum());
//				System.out.println("스킨번호 : " + user_Gameinfodto.getSkinCode());
//				System.out.println("장착무기 0번 : " + user_Gameinfodto.getEquipment_0());
//				System.out.println("장착무기 1번 : " + user_Gameinfodto.getEquipment_1());
//				System.out.println("장착무기 2번 : " + user_Gameinfodto.getEquipment_2());
//				System.out.println("장착무기 3번 : " + user_Gameinfodto.getEquipment_3());
//				System.out.println("장착무기 4번 : " + user_Gameinfodto.getEquipment_4());
//				System.out.println("장착무기 5번 : " + user_Gameinfodto.getEquipment_5());
//				System.out.println("---------------------------------------------------------" + (i + 1) + "명");
//				System.out.println(user_Gameinfodto.toString());
//				System.out.println("---------------------------------------------------------" + (i + 1) + "명");
//				gameinfoRepository.save(user_Gameinfodto);
//				gameinfoRepository.save(list.get(i));
//				System.out.println(list.get(i));
//				System.out.println("-----------------");
				
				list.add(user_Gameinfodto);
			}
//			System.out.println("---------------------------------------------------------까지가 한판");
//			System.out.println(list.size());
//			for (int j = 0; j < list.size(); j++) {
//				gameinfoRepository.save(list.get(j));
//			}
//				if(gameinfoRepository.findByGameIdAndNickname(Integer.parseInt(user_Gameinfodto.getGameid()), user_Gameinfodto.getNickname()) {
			
//				}
//				if(user_Gameinfojdbc.select_gameinfo_sql(user_Gameinfodto.getGameid(), user_Gameinfodto.getNickname())) {
//					user_Gameinfojdbc.insert_gameinfo_sql(user_Gameinfodto.getGameid(), user_Gameinfodto.getNickname(),
//							user_Gameinfodto.getUserNum(), user_Gameinfodto.getGameRank(),
//							user_Gameinfodto.getCharacterLevel(), user_Gameinfodto.getMmrBefore(),
//							user_Gameinfodto.getMmrGain(), user_Gameinfodto.getDamageToMonster(),
//							user_Gameinfodto.getDamageToMonster(), user_Gameinfodto.getPlayerKill(),
//							user_Gameinfodto.getPlayerAssistant(), user_Gameinfodto.getMonsterKill(),
//							user_Gameinfodto.getCharacterNum(), user_Gameinfodto.getSkinCode(),
//							user_Gameinfodto.getEquipment_0(), user_Gameinfodto.getEquipment_1(),
//							user_Gameinfodto.getEquipment_2(), user_Gameinfodto.getEquipment_3(),
//							user_Gameinfodto.getEquipment_4(),user_Gameinfodto.getEquipment_5());
//				}
//			user_Gameinfojdbc.autoclose_jdbc();
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		System.out.println("리스트 보냄");
		return list;
	}
}

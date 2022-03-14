package kr.mmgg.search.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.mmgg.search.dto.User_GameidDTO;
import kr.mmgg.search.dto.User_Select_GameidDTO;
import kr.mmgg.search.entity.gameinfo_data;
import kr.mmgg.search.entity.maininfo_user_season4;
import kr.mmgg.search.entity.maininfo_user_season5;
import kr.mmgg.search.entity.maininfo_user_normal;
import kr.mmgg.search.entity.ranking_duo;
import kr.mmgg.search.entity.ranking_solo;
import kr.mmgg.search.entity.ranking_squad;
import kr.mmgg.search.json.User_GameidJson;
import kr.mmgg.search.json.User_GameidNextJson;
import kr.mmgg.search.json.User_GameinfoJson;
import kr.mmgg.search.json.User_Toprank_DUO_JSON;
import kr.mmgg.search.json.User_Toprank_SOLO_JSON;
import kr.mmgg.search.json.User_Toprank_SQUAD_JSON;
import kr.mmgg.search.json.User_Stats_Season4_JSON;
import kr.mmgg.search.json.User_Stats_Season5_JSON;
import kr.mmgg.search.json.User_Stats_Normal_JSON;
import kr.mmgg.search.repository.DuoRepository;
import kr.mmgg.search.repository.GameinfoRepository;
import kr.mmgg.search.repository.GameinfoSelectRepository;
import kr.mmgg.search.repository.MainInfoNormalRepository;
import kr.mmgg.search.repository.MainInfoSeason4Repository;
import kr.mmgg.search.repository.MainInfoSeason5Repository;
import kr.mmgg.search.repository.SoloRepository;
import kr.mmgg.search.repository.SquadRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MainPageService {

	private SoloRepository soloRepository;
	private DuoRepository duoRepository;
	private SquadRepository squadRepository;
	
	private GameinfoRepository gameInfoRepository;
	private GameinfoSelectRepository gameInfoSelectInfoRepository;
	
	private MainInfoNormalRepository mainInfoNormalRepository;
	private MainInfoSeason4Repository mainInfoSeason4Repository;
	private MainInfoSeason5Repository mainInfoSeason5Repository;

	public List<ranking_solo> solo_view() {
		return soloRepository.findAll();
	}

	public List<ranking_duo> duo_view() {
		return duoRepository.findAll();
	}

	public List<ranking_squad> squad_view() {
		return squadRepository.findAll();
	}

	public maininfo_user_normal maininfonormal_view(String nickname) {
		return mainInfoNormalRepository.findByNickname(nickname);
	}
	public maininfo_user_season4 maininfoseason4_view(String nickname) {
		return mainInfoSeason4Repository.findByNickname(nickname);
	}
	public maininfo_user_season5 maininfoseason5_view(String nickname) {
		return mainInfoSeason5Repository.findByNickname(nickname);
	}

	public List<gameinfo_data> gameinfo_view(String nickname) {
		List<gameinfo_data> gameid_list = gameInfoSelectInfoRepository.findByNickname(nickname);
		ArrayList<gameinfo_data> gameinfo_list = new ArrayList<gameinfo_data>();
		gameinfo_data gameinfo_dto;
		Integer count = gameInfoSelectInfoRepository.count(nickname);
		if (count >= 10) {
			for (int i = 0; i < 10; i++) { // 웹사이트로 보낼 리스트수 (전적갯수)
				gameinfo_dto = new gameinfo_data();
				gameinfo_dto = gameInfoSelectInfoRepository.findByNicknameAndGameId(gameid_list.get(i).getNickname(), gameid_list.get(i).getGameId());
				System.out.println(gameinfo_dto.toString());
				gameinfo_list.add(gameinfo_dto);
			}
		} else {
			for (int i = 0; i < count; i++) {
				gameinfo_dto = new gameinfo_data();
				gameinfo_dto = gameInfoSelectInfoRepository.findByNicknameAndGameId(gameid_list.get(i).getNickname(), gameid_list.get(i).getGameId());
				System.out.println(gameinfo_dto.toString());
				gameinfo_list.add(gameinfo_dto);
			}
		}
		return gameinfo_list;
	}

	public void refresh_ranking_ALL() {
		User_Toprank_SOLO_JSON solo_json = new User_Toprank_SOLO_JSON();
		User_Toprank_DUO_JSON duo_json = new User_Toprank_DUO_JSON();
		User_Toprank_SQUAD_JSON squad_json = new User_Toprank_SQUAD_JSON();

		List<ranking_solo> solo_list = solo_json.read_json();
		List<ranking_duo> duo_list = duo_json.read_json();
		List<ranking_squad> squad_list = squad_json.read_json();

		for (int i = 0; i < 5; i++) {
			ranking_solo solo_dto = solo_list.get(i);
			ranking_duo duo_dto = duo_list.get(i);
			ranking_squad squad_dto = squad_list.get(i);

			soloRepository.save(solo_dto);
			duoRepository.save(duo_dto);
			squadRepository.save(squad_dto);
		}
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
	public List<gameinfo_data> requestGameData(String gameId) {
		List<gameinfo_data> list = gameInfoRepository.findByGameId(gameId);
		System.out.println(list.toString());
		return list;
	}
	
	@Transactional
	public void refresh_info(String nickname) {
		User_Stats_Normal_JSON normal_stats_JSON = new User_Stats_Normal_JSON();
		User_Stats_Season4_JSON season4_stats_JSON = new User_Stats_Season4_JSON();
		User_Stats_Season5_JSON season5_stats_JSON = new User_Stats_Season5_JSON();
		
		List<maininfo_user_normal> maininfonormal_list = normal_stats_JSON.read_json(nickname);
		List<maininfo_user_season4> maininfoseason4_list = season4_stats_JSON.read_json(nickname);
		List<maininfo_user_season5> maininfoseason5_list = season5_stats_JSON.read_json(nickname);
		
		maininfo_user_normal maininfonormal_dto = maininfonormal_list.get(0);
		maininfo_user_season4 maininfoseason4_dto = maininfoseason4_list.get(0);
		maininfo_user_season5 maininfoseason5_dto = maininfoseason5_list.get(0);
		
		if(mainInfoNormalRepository.findByNickname(nickname) != null) {
			int normal_id = mainInfoNormalRepository.findByNickname(nickname).getId();
			mainInfoNormalRepository.flush();
			mainInfoNormalRepository.deleteById(normal_id);
			mainInfoNormalRepository.flush();
			mainInfoNormalRepository.save(maininfonormal_dto);
			mainInfoNormalRepository.flush();
		} else {
			mainInfoNormalRepository.save(maininfonormal_dto);
		}
		if(mainInfoSeason4Repository.findByNickname(nickname) != null) {
			int season4_id = mainInfoSeason4Repository.findByNickname(nickname).getId();
			mainInfoSeason4Repository.flush();
			mainInfoSeason4Repository.deleteById(season4_id);
			mainInfoSeason4Repository.flush();
			mainInfoSeason4Repository.save(maininfoseason4_dto);
			mainInfoSeason4Repository.flush();
		} else {
			mainInfoSeason4Repository.save(maininfoseason4_dto);
		}
		if(mainInfoSeason5Repository.findByNickname(nickname) != null) {
			int season5_id = mainInfoSeason5Repository.findByNickname(nickname).getId();
			mainInfoSeason5Repository.flush();
			mainInfoSeason5Repository.deleteById(season5_id);
			mainInfoSeason5Repository.flush();
			mainInfoSeason5Repository.save(maininfoseason5_dto);
			mainInfoSeason5Repository.flush();
		} else {
			mainInfoSeason5Repository.save(maininfoseason5_dto);
		}
		
		User_GameidJson gameid_Json = new User_GameidJson();
		User_GameidNextJson gameidnext_json = new User_GameidNextJson();
		User_GameinfoJson gameinfo_json = new User_GameinfoJson();

		List<User_GameidDTO> list = gameid_Json.read_json(nickname);
		ArrayList<gameinfo_data> glist = new ArrayList<gameinfo_data>();
		int lastindex = list.size() - 1;
		String lastGameid = list.get(lastindex).getGameId();
		Integer userNum = list.get(lastindex).getUserNum();
		Integer firstGameid_db = 0;
		if (gameInfoSelectInfoRepository.findGameIdforUserNum(userNum) != null) {
			firstGameid_db = gameInfoSelectInfoRepository.findGameIdforUserNum(userNum).getGameId();
		}
		Boolean refresh_flag = false;
		System.out.println("DB안의 마지막저장되어있는 게임번호: " + firstGameid_db);
		System.out.println("CURL로 받아오는 첫번째 게임번호: " + list.get(0).getGameId());
		
		
		for (int i = 0; i < list.size(); i++) {
			List<gameinfo_data> gameinfo_list = gameinfo_json.read_json(list.get(i).getGameId());
			ArrayList<String> test = gameInfoRepository.SearchForUserNum(list.get(i).getGameId());
//			Integer count = gameInfoRepository.SearchForUserNumCount(list.get(i).getGameId());
			System.out.println(i+"번째"+test.toString()+" 플래그 : " +refresh_flag);
				for (int j = 0; j < gameinfo_list.size(); j++) {
					if (gameinfo_list.get(j).getGameId().equals(firstGameid_db)) {
						System.out.println(gameinfo_list.get(j).getGameId() + " 까지 Curl 에서 받아온 데이터와 DB에서 받아온 마지막게임번호가 일치합니다.");
						refresh_flag = true;
					} else {
						if(!test.contains(gameinfo_list.get(j).getUserNum().toString())) {
							glist.add(gameinfo_list.get(j));
							System.out.println(gameinfo_list.get(j));
						} else {
							System.out.println("게임번호"+gameinfo_list.get(j).getGameId()+"번의 유저번호"+test.get(j)+"번을 포함 하고있습니다.");	
						}
					}
				}
		}
		do {
//			Integer nextfirstGameid_curl = 0;
			List<User_GameidDTO> nextlist = gameidnext_json.readnext_json(lastGameid, nickname);
//			if (nextlist.size() != 0) {
//				nextfirstGameid_curl = Integer.parseInt(nextlist.get(0).getGameId());
//			}
			lastindex = nextlist.size() - 1;
			for (int i = 0; i < nextlist.size(); i++) {
				List<gameinfo_data> gameinfo_list = gameinfo_json.read_json(nextlist.get(i).getGameId());
				ArrayList<String> test = gameInfoRepository.SearchForUserNum(nextlist.get(i).getGameId());
//				Integer count = gameInfoRepository.SearchForUserNumCount(list.get(i).getGameId());
				System.out.println(i+"번째"+test.toString()+ " 플래그 : " + refresh_flag);
				for (int j = 0; j < gameinfo_list.size(); j++) {
					if (gameinfo_list.get(j).getGameId().equals(firstGameid_db)) {
						System.out.println("데이터베이스에서 검색된 마지막 게임번호는"+firstGameid_db+"이며" +gameinfo_list.get(j).getGameId() + "번은 Curl에서 받아온 게임번호 입니다.");
						refresh_flag = true;
					} else {
						if(!test.contains(gameinfo_list.get(j).getUserNum().toString())) {
							glist.add(gameinfo_list.get(j));
							System.out.println(gameinfo_list.get(j));
						} else {
							System.out.println("게임번호"+gameinfo_list.get(j).getGameId()+"번은 유저번호"+test.get(j)+"번을 포함 하고있습니다.");
						}
					}
				}
			}
			//nextfirstGameid_curl <= firstGameid_db &&
			//nextfirstGameid_curl >= firstGameid_db &&
			if (lastindex == -1 ||  refresh_flag == true) {
				break;
			} else {
				lastGameid = nextlist.get(lastindex).getGameId();
			}
		} while (true);
		System.out.println("List Size : " + glist.size() + " 데이터를 저장합니다.");
		gameInfoRepository.saveAll(glist);
		gameInfoRepository.flush();
	}

	public boolean exits_gameid(String nickname) {
		if (gameInfoSelectInfoRepository.findByNickname(nickname) != null) {
			return true;
		} else {
			return false;
		}
	}
	public boolean exits_normal_nickname(String nickname) {
		if (mainInfoNormalRepository.findByNickname(nickname) != null) {
			return true;
		} else {
			return false;
		}
	}
	public boolean exits_season4_nickname(String nickname) {
		if (mainInfoSeason4Repository.findByNickname(nickname) != null) {
			return true;
		} else {
			return false;
		}
	}
	public boolean exits_season5_nickname(String nickname) {
		if (mainInfoSeason5Repository.findByNickname(nickname) != null) {
			return true;
		} else {
			return false;
		}
	}
}

package kr.mmgg.search.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import kr.mmgg.search.dto.select_tierDTO;
import kr.mmgg.search.entity.maininfo_user;
import kr.mmgg.search.repository.MainInfoRepository;
import kr.mmgg.search.service.MainPageService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainPageController {
	private MainPageService mainPageService;
	private MainInfoRepository mainInfoRepository;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("solo_list", mainPageService.solo_view());
		model.addAttribute("duo_list", mainPageService.duo_view());
		model.addAttribute("squad_list", mainPageService.squad_view());
		return "main";
	}

	@GetMapping("/ranking")
	public String ranking() {

		return "ranking"; // 랭킹
	}

	@GetMapping("/master_ranking")
	public String master_ranking() {

		return "master_ranking"; // 장인 랭킹
	}

	@GetMapping("/statistics")
	public String statistics() {

		return "statistics"; // 통계
	}

	@GetMapping("/Item_Encyclopedia")
	public String Item_Encyclopedia() {

		return "Item_Encyclopedia"; // 아이템도감
	}

	@GetMapping("/refresh_ranking_all")
	public String refresh_ranking_all() {
		mainPageService.refresh_ranking_ALL();
		return "redirect:/"; // 전적 갱신후 리다이렉트
	}

	@PostMapping("/search")
	@Transactional
	public String refresh_info(@RequestParam("nickname") String nickname, Model model) { // 임시로
		maininfo_user user = mainPageService.maininfo_view(nickname);
		
		System.out.println(nickname);
		int user_id = mainInfoRepository.findByNickname(nickname).getId();
		mainInfoRepository.flush();
		mainInfoRepository.deleteById(user_id);
		mainInfoRepository.flush();
		mainPageService.refresh_info(nickname);
		mainInfoRepository.flush();
		if(user.getRank_solo_mmr() == null) {
			user.setRank_solo_mmr(0);
		}
		if(user.getRank_duo_mmr() == null) {
			user.setRank_duo_mmr(0);
		}
		if(user.getRank_squad_mmr() == null) {
			user.setRank_squad_mmr(0);
		}
		int[] rank_mmr = new int[3];
		String[] tier = new String[3];
		select_tierDTO tierDto = new select_tierDTO();
		
		if (user.getRank_solo_mmr() != null) {
			rank_mmr[0] = user.getRank_solo_mmr();
		}
		if (user.getRank_duo_mmr() != null) {
			rank_mmr[1] = user.getRank_duo_mmr();
		}
		if (user.getRank_squad_mmr() != null) {
			rank_mmr[2] = user.getRank_squad_mmr();
		}
		for (int i = 0; i < 3; i++) {
			if (rank_mmr[i] == 0) {
				tier[i] = "null";
			} else if (rank_mmr[i] > 0 && rank_mmr[0] < 399) {
				tier[i] = "1";
			} else if (rank_mmr[i] > 400 && rank_mmr[i] <= 799) {
				tier[i] = "2";
			} else if (rank_mmr[i] > 800 && rank_mmr[i] <= 1199) {
				tier[i] = "3";
			} else if (rank_mmr[i] > 1200 && rank_mmr[i] <= 1599) {
				tier[i] = "4";
			} else if (rank_mmr[i] > 1600 && rank_mmr[i] <= 1999) {
				tier[i] = "5";
			} else if (rank_mmr[i] > 2000 && rank_mmr[i] <= 2399) {
				tier[i] = "6";
			} else if (rank_mmr[i] > 2400 && rank_mmr[i] <= 2599) {
				tier[i] = "7";
			} else {
				tier[i] = "8";
			}
		}
		if(user.getRank_solo_charactercode_1() != null) {
			tierDto.setThumnailNum(user.getRank_solo_charactercode_1());
		} else {
			if(user.getRank_duo_charactercode_1() != null) {
				tierDto.setThumnailNum(user.getRank_duo_charactercode_1());
			} else {
				if(user.getRank_squad_charactercode_1() != null) {
					tierDto.setThumnailNum(user.getRank_squad_charactercode_1());
				} else {
					tierDto.setThumnailNum(null);
				}
			}
		}
		tierDto.setSolo_tier(tier[0]);
		tierDto.setDuo_tier(tier[1]);
		tierDto.setSquad_tier(tier[2]);
		model.addAttribute("tier", tierDto);
		model.addAttribute("main_list", user);
		model.addAttribute("gameinfo_list", mainPageService.gameinfo_view(nickname));
		return "/search";
	}

	@GetMapping("/search")
	public String search(String nickname, Model model) {

		maininfo_user user = mainPageService.maininfo_view(nickname);

		if (!mainPageService.exits_nickname(nickname)) {
			mainPageService.refresh_info(nickname);
		}

		model.addAttribute("main_list", user);
		
		
		if (mainPageService.exits_gameid(nickname)) {
			model.addAttribute("gameinfo_list", mainPageService.gameinfo_view(nickname));
		}
		
		if(user.getRank_solo_mmr() == null) {
			user.setRank_solo_mmr(0);
		}
		if(user.getRank_duo_mmr() == null) {
			user.setRank_duo_mmr(0);
		}
		if(user.getRank_squad_mmr() == null) {
			user.setRank_squad_mmr(0);
		}
		
		int[] rank_mmr = new int[3];
		String[] tier = new String[3];
		select_tierDTO tierDto = new select_tierDTO();
		
		if (user.getRank_solo_mmr() != null) {
			rank_mmr[0] = user.getRank_solo_mmr();
		}
		if (user.getRank_duo_mmr() != null) {
			rank_mmr[1] = user.getRank_duo_mmr();
		}
		if (user.getRank_squad_mmr() != null) {
			rank_mmr[2] = user.getRank_squad_mmr();
		}
		for (int i = 0; i < 3; i++) {
			if (rank_mmr[i] == 0) {
				tier[i] = "null";
			} else if (rank_mmr[i] > 0 && rank_mmr[0] < 399) {
				tier[i] = "1";
			} else if (rank_mmr[i] > 400 && rank_mmr[i] <= 799) {
				tier[i] = "2";
			} else if (rank_mmr[i] > 800 && rank_mmr[i] <= 1199) {
				tier[i] = "3";
			} else if (rank_mmr[i] > 1200 && rank_mmr[i] <= 1599) {
				tier[i] = "4";
			} else if (rank_mmr[i] > 1600 && rank_mmr[i] <= 1999) {
				tier[i] = "5";
			} else if (rank_mmr[i] > 2000 && rank_mmr[i] <= 2399) {
				tier[i] = "6";
			} else if (rank_mmr[i] > 2400 && rank_mmr[i] <= 2599) {
				tier[i] = "7";
			} else {
				tier[i] = "8";
			}
		}
		if(user.getRank_solo_charactercode_1() != null) {
			tierDto.setThumnailNum(user.getRank_solo_charactercode_1());
		} else {
			if(user.getRank_duo_charactercode_1() != null) {
				tierDto.setThumnailNum(user.getRank_duo_charactercode_1());
			} else {
				if(user.getRank_squad_charactercode_1() != null) {
					tierDto.setThumnailNum(user.getRank_squad_charactercode_1());
				} else {
					tierDto.setThumnailNum(null);
				}
			}
		}
		tierDto.setSolo_tier(tier[0]);
		tierDto.setDuo_tier(tier[1]);
		tierDto.setSquad_tier(tier[2]);
		model.addAttribute("tier", tierDto);
		return "/search";
	}
}

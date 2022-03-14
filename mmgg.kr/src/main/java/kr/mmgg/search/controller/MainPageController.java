package kr.mmgg.search.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import kr.mmgg.search.dto.User_SelecttierDTO;
import kr.mmgg.search.entity.gameinfo_data;
import kr.mmgg.search.entity.maininfo_user_season4;
import kr.mmgg.search.entity.maininfo_user_season5;
import kr.mmgg.search.entity.maininfo_user_normal;
import kr.mmgg.search.repository.MainInfoNormalRepository;
import kr.mmgg.search.repository.MainInfoSeason4Repository;
import kr.mmgg.search.repository.MainInfoSeason5Repository;
import kr.mmgg.search.service.MainPageService;
import kr.mmgg.search.util.TierSelect_Manager;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainPageController {
	private MainPageService mainPageService;
	
	private MainInfoNormalRepository mainInfoNormalRepository;
	private MainInfoSeason4Repository mainInfoSeason4Repository;
	private MainInfoSeason5Repository mainInfoSeason5Repository;

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
	
	@RequestMapping(value= "/requestGamedata", method= {RequestMethod.POST})
	@ResponseBody
	public List<gameinfo_data> requestGamedata(@RequestParam("gameId") String gameId) {
		List<gameinfo_data> list = mainPageService.requestGameData(gameId);
		return list;
	}
	@PostMapping("/searchSeason5")
	public String refreshSeason5(@RequestParam("nickname") String nickname, Model model) { //
		TierSelect_Manager tierSelect = new TierSelect_Manager();
		maininfo_user_season5 user = mainPageService.maininfoseason5_view(nickname);
		
		System.out.println(nickname);
		mainPageService.refresh_info(nickname);
		
		model.addAttribute("tier", tierSelect.season5_rank_tier_select(user));
		model.addAttribute("main_list", user);
		model.addAttribute("gameinfo_list", mainPageService.gameinfo_view(nickname));
		return "/searchSeason5";
	}
	
	@GetMapping("/searchSeason5")
	public String searchSeason5(String nickname, Model model) {
		TierSelect_Manager tierSelect = new TierSelect_Manager();
		if (!mainPageService.exits_season5_nickname(nickname)) {
			mainPageService.refresh_info(nickname);
		}	
		if (mainPageService.exits_gameid(nickname)) {
			model.addAttribute("gameinfo_list", mainPageService.gameinfo_view(nickname));
		}
		maininfo_user_season5 user = mainPageService.maininfoseason5_view(nickname);
		model.addAttribute("tier", tierSelect.season5_rank_tier_select(user));
		model.addAttribute("main_list", user);
		return "/searchSeason5";
	}
	
	@PostMapping("/searchSeason4")
	public String refreshSeason4(@RequestParam("nickname") String nickname, Model model) { //
		TierSelect_Manager tierSelect = new TierSelect_Manager();
		maininfo_user_season4 user = mainPageService.maininfoseason4_view(nickname);
		System.out.println(nickname);
		mainPageService.refresh_info(nickname);
		
		model.addAttribute("tier", tierSelect.season4_rank_tier_select(user));
		model.addAttribute("main_list", user);
		model.addAttribute("gameinfo_list", mainPageService.gameinfo_view(nickname));
		return "/searchSeason4";
	}
	
	@GetMapping("/searchSeason4")
	public String searchSeason4(String nickname, Model model) {
		TierSelect_Manager tierSelect = new TierSelect_Manager();
		if (!mainPageService.exits_season4_nickname(nickname)) {
			mainPageService.refresh_info(nickname);
		}	
		if (mainPageService.exits_gameid(nickname)) {
			model.addAttribute("gameinfo_list", mainPageService.gameinfo_view(nickname));
		}
		maininfo_user_season4 user = mainPageService.maininfoseason4_view(nickname);
		model.addAttribute("tier", tierSelect.season4_rank_tier_select(user));
		model.addAttribute("main_list", user);
		return "/searchSeason4";
	}
	
	
	@PostMapping("/searchNormal")
	public String refreshNormal(@RequestParam("nickname") String nickname, Model model) { //
		TierSelect_Manager tierSelect = new TierSelect_Manager();
		maininfo_user_normal normal_user = mainPageService.maininfonormal_view(nickname);
		System.out.println(nickname);
		mainPageService.refresh_info(nickname);
		model.addAttribute("tier", tierSelect.normal_tier_select(normal_user));
		model.addAttribute("main_list", normal_user);
		model.addAttribute("gameinfo_list", mainPageService.gameinfo_view(nickname));
		return "/searchNormal";
	}

	@GetMapping("/searchNormal")
	public String searchNormal(String nickname, Model model) {
		TierSelect_Manager tierSelect = new TierSelect_Manager();
		if(!mainPageService.exits_normal_nickname(nickname)) {
			mainPageService.refresh_info(nickname);
		}
		if (mainPageService.exits_gameid(nickname)) {
			model.addAttribute("gameinfo_list", mainPageService.gameinfo_view(nickname));
		}
		maininfo_user_normal normal_user = mainPageService.maininfonormal_view(nickname);
		model.addAttribute("tier", tierSelect.normal_tier_select(normal_user));
		model.addAttribute("main_list", normal_user);
		return "/searchNormal";
	}
}

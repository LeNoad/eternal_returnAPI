package kr.mmgg.search.util;

import kr.mmgg.search.dto.User_SelecttierDTO;
import kr.mmgg.search.entity.maininfo_user_season4;
import kr.mmgg.search.entity.maininfo_user_season5;
import kr.mmgg.search.entity.maininfo_user_normal;

public class TierSelect_Manager {
	public User_SelecttierDTO season5_rank_tier_select(maininfo_user_season5 user) {
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
		User_SelecttierDTO tierDto = new User_SelecttierDTO();
		
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
		return tierDto;
	}
	
	public User_SelecttierDTO season4_rank_tier_select(maininfo_user_season4 user) {
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
		User_SelecttierDTO tierDto = new User_SelecttierDTO();
		
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
		return tierDto;
	}
	
	public User_SelecttierDTO normal_tier_select(maininfo_user_normal normal_user) {
		if(normal_user.getNormal_solo_mmr() == null) {
			normal_user.setNormal_solo_mmr(0);
		}
		if(normal_user.getNormal_duo_mmr() == null) {
			normal_user.setNormal_duo_mmr(0);
		}
		if(normal_user.getNormal_squad_mmr() == null) {
			normal_user.setNormal_squad_mmr(0);
		}
		
		int[] rank_mmr = new int[3];
		String[] tier = new String[3];
		User_SelecttierDTO tierDto = new User_SelecttierDTO();
		
		if (normal_user.getNormal_solo_mmr() != null) {
			rank_mmr[0] = normal_user.getNormal_solo_mmr();
		}
		if (normal_user.getNormal_duo_mmr() != null) {
			rank_mmr[1] = normal_user.getNormal_duo_mmr();
		}
		if (normal_user.getNormal_squad_mmr() != null) {
			rank_mmr[2] = normal_user.getNormal_squad_mmr();
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
		if(normal_user.getNormal_solo_charactercode_1() != null) {
			tierDto.setThumnailNum(normal_user.getNormal_solo_charactercode_1());
		} else {
			if(normal_user.getNormal_duo_charactercode_1() != null) {
				tierDto.setThumnailNum(normal_user.getNormal_duo_charactercode_1());
			} else {
				if(normal_user.getNormal_squad_charactercode_1() != null) {
					tierDto.setThumnailNum(normal_user.getNormal_squad_charactercode_1());
				} else {
					tierDto.setThumnailNum(null);
				}
			}
		}
		tierDto.setSolo_tier(tier[0]);
		tierDto.setDuo_tier(tier[1]);
		tierDto.setSquad_tier(tier[2]);
		return tierDto;
	}
}

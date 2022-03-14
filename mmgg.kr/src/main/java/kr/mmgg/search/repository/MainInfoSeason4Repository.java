package kr.mmgg.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.mmgg.search.entity.maininfo_user_season4;

@Repository
public interface MainInfoSeason4Repository extends JpaRepository<maininfo_user_season4, Integer>{
	public maininfo_user_season4 findByNickname(String nickname);
}

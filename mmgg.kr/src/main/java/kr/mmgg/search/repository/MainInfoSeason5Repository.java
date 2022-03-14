package kr.mmgg.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.mmgg.search.entity.maininfo_user_season4;
import kr.mmgg.search.entity.maininfo_user_season5;

@Repository
public interface MainInfoSeason5Repository extends JpaRepository<maininfo_user_season5, Integer>{
	public maininfo_user_season5 findByNickname(String nickname);
}

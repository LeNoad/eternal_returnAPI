package kr.mmgg.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.mmgg.search.entity.maininfo_user;

@Repository
public interface MainInfoRepository extends JpaRepository<maininfo_user, Integer>{
	public maininfo_user findByNickname(String nickname);
}

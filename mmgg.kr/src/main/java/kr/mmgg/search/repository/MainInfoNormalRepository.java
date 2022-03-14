package kr.mmgg.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kr.mmgg.search.entity.maininfo_user_normal;

@Repository
public interface MainInfoNormalRepository extends JpaRepository<maininfo_user_normal, Integer>{
	public maininfo_user_normal findByNickname(String nickname);
}

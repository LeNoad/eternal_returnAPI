package kr.mmgg.search.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import kr.mmgg.search.entity.gameinfo_data;

import java.lang.Integer;
import java.util.List;

@Repository
public interface GameinfoRepository extends JpaRepository<gameinfo_data, Integer>{
	public gameinfo_data findByUserNumAndGameId(Integer userNum, Integer gameid);
	public List<gameinfo_data> findByNickname(String nickanme);
	
}

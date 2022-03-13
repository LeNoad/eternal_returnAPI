package kr.mmgg.search.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.mmgg.search.dto.User_Select_GameidDTO;
import kr.mmgg.search.entity.gameinfo_data;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface GameinfoRepository extends JpaRepository<gameinfo_data, Integer>{
	public gameinfo_data findByUserNumAndGameId(Integer userNum, Integer gameid);
	public List<gameinfo_data> findByNickname(String nickanme);
	
	@Query(value = "SELECT * FROM gameinfo_data WHERE gameId=:gameId ORDER BY gameRank asc", nativeQuery = true)
	public List<gameinfo_data> findByGameId(@Param("gameId")String gameId);
	
	@Query(value = "SELECT userNum FROM gameinfo_data WHERE gameId=:gameId order by gameId desc", nativeQuery = true)
	public ArrayList<String> SearchForUserNum(@Param("gameId")String gameid);
	
	@Query(value = "SELECT count(*) FROM gameinfo_data WHERE gameId=:gameId", nativeQuery = true)
	public Integer SearchForUserNumCount(@Param("gameId")String gameid);
}

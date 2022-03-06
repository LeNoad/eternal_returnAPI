package kr.mmgg.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.mmgg.search.entity.gameinfo_data;

@Repository
public interface GameinfoSelectRepository extends JpaRepository<gameinfo_data, Integer>{
	public gameinfo_data findByNicknameAndGameId(String nickname, Integer gameId);
	
	@Query(value = "SELECT * FROM gameinfo_data WHERE userNum=:userNum ORDER BY gameId DESC LIMIT 1", nativeQuery = true)
	public gameinfo_data findGameIdforUserNum(@Param("userNum") Integer userNum);
	
	@Query(value = "SELECT * FROM gameinfo_data WHERE nickname=:nickname ORDER BY gameId desc", nativeQuery = true)
	public List<gameinfo_data> findByNickname(@Param("nickname") String nickname);
	
	@Query(value = "SELECT count(*) FROM gameinfo_data WHERE nickname=:nickname ORDER BY gameId desc", nativeQuery = true)
	public Integer count(@Param("nickname") String nickname);
}

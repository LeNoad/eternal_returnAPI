package kr.mmgg.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kr.mmgg.search.entity.ranking_squad;

@Repository
public interface SquadRepository extends JpaRepository<ranking_squad, Integer>{

}

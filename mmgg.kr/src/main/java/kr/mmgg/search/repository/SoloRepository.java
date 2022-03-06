package kr.mmgg.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.mmgg.search.entity.ranking_solo;

@Repository
public interface SoloRepository extends JpaRepository<ranking_solo, Integer>{

}

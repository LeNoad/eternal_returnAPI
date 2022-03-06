package kr.mmgg.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.mmgg.search.entity.ranking_duo;

@Repository
public interface DuoRepository extends JpaRepository<ranking_duo, Integer>{
}

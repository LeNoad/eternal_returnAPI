package kr.mmgg.search.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ranking_squad")
public class ranking_squad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rank;
	private String nickname;
	private String mmr;
	private String date;
}

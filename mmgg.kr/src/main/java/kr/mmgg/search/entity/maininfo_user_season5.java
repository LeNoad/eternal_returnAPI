package kr.mmgg.search.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "maininfo_user_season5")
public class maininfo_user_season5 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="userNum")
	private Integer usernum;
	
	@Column(name="nickname")
	private String nickname;
	@Column(name="rank_solo_mmr")
	private Integer rank_solo_mmr;
	@Column(name="rank_solo_totalgames")
	private String rank_solo_totalgames;
	@Column(name="rank_solo_totalwins")
	private String rank_solo_totalwins;
	@Column(name="rank_solo_top3")
	private String rank_solo_top3;
	@Column(name="rank_solo_averagerank")
	private String rank_solo_averagerank;
	@Column(name="rank_solo_averagekills")
	private String rank_solo_averagekills;
	@Column(name="rank_solo_averageassistants")
	private String rank_solo_averageassistants;
	@Column(name="rank_solo_charactercode_1")
	private String rank_solo_charactercode_1;
	
	@Column(name="rank_duo_mmr")
	private Integer rank_duo_mmr;
	@Column(name="rank_duo_totalgames")
	private String rank_duo_totalgames;
	@Column(name="rank_duo_totalwins")
	private String rank_duo_totalwins;
	@Column(name="rank_duo_top3")
	private String rank_duo_top3;
	@Column(name="rank_duo_averagerank")
	private String rank_duo_averagerank;
	@Column(name="rank_duo_averagekills")
	private String rank_duo_averagekills;
	@Column(name="rank_duo_averageassistants")
	private String rank_duo_averageassistants;
	@Column(name="rank_duo_charactercode_1")
	private String rank_duo_charactercode_1;
	
	@Column(name="rank_squad_mmr")
	private Integer rank_squad_mmr;
	@Column(name="rank_squad_totalgames")
	private String rank_squad_totalgames;
	@Column(name="rank_squad_totalwins")
	private String rank_squad_totalwins;
	@Column(name="rank_squad_top3")
	private String rank_squad_top3;
	@Column(name="rank_squad_averagerank")
	private String rank_squad_averagerank;
	@Column(name="rank_squad_averagekills")
	private String rank_squad_averagekills;
	@Column(name="rank_squad_averageassistants")
	private String rank_squad_averageassistants;
	@Column(name="rank_squad_charactercode_1")
	private String rank_squad_charactercode_1;
	
	@Column(name="date")
	private String date;
}

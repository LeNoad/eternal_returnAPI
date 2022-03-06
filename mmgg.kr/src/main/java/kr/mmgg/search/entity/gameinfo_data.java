package kr.mmgg.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class gameinfo_data {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gameinfo_id")
	private Integer gameinfo_id;
	
	private Integer gameId;
	private String nickname;
	private Integer userNum;
	private Integer matchingMode;
	private Integer matchingTeamMode;
	private Integer gameRank;
	private Integer characterLevel;
	private Integer mmrBefore;
	private Integer mmrGain;
	private Integer damageToPlayer;
	private Integer damageToMonster;
	private Integer playerKill;
	private Integer playerAssistant;
	private Integer monsterKill;
	private Integer characterNum;
	private Integer skinCode;
	private Integer equipment_0;
	private Integer equipment_1;
	private Integer equipment_2;
	private Integer equipment_3;
	private Integer equipment_4;
	private Integer equipment_5;
	
	private Integer traitFirstCore;
	private Integer traitFirstSub_1;
	private Integer traitFirstSub_2;
	
	private Integer traitSecondSub_1;
	private Integer traitSecondSub_2;
}

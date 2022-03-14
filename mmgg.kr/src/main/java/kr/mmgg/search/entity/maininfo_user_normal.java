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
@Table(name = "maininfo_user_normal")
public class maininfo_user_normal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="userNum")
	private Integer usernum;
	
	@Column(name="nickname")
	private String nickname;
	@Column(name="normal_solo_mmr")
	private Integer normal_solo_mmr;
	@Column(name="normal_solo_totalgames")
	private String normal_solo_totalgames;
	@Column(name="normal_solo_totalwins")
	private String normal_solo_totalwins;
	@Column(name="normal_solo_top3")
	private String normal_solo_top3;
	@Column(name="normal_solo_averagerank")
	private String normal_solo_averagerank;
	@Column(name="normal_solo_averagekills")
	private String normal_solo_averagekills;
	@Column(name="normal_solo_averageassistants")
	private String normal_solo_averageassistants;
	@Column(name="normal_solo_charactercode_1")
	private String normal_solo_charactercode_1;
	
	@Column(name="normal_duo_mmr")
	private Integer normal_duo_mmr;
	@Column(name="normal_duo_totalgames")
	private String normal_duo_totalgames;
	@Column(name="normal_duo_totalwins")
	private String normal_duo_totalwins;
	@Column(name="normal_duo_top3")
	private String normal_duo_top3;
	@Column(name="normal_duo_averagerank")
	private String normal_duo_averagerank;
	@Column(name="normal_duo_averagekills")
	private String normal_duo_averagekills;
	@Column(name="normal_duo_averageassistants")
	private String normal_duo_averageassistants;
	@Column(name="normal_duo_charactercode_1")
	private String normal_duo_charactercode_1;
	
	@Column(name="normal_squad_mmr")
	private Integer normal_squad_mmr;
	@Column(name="normal_squad_totalgames")
	private String normal_squad_totalgames;
	@Column(name="normal_squad_totalwins")
	private String normal_squad_totalwins;
	@Column(name="normal_squad_top3")
	private String normal_squad_top3;
	@Column(name="normal_squad_averagerank")
	private String normal_squad_averagerank;
	@Column(name="normal_squad_averagekills")
	private String normal_squad_averagekills;
	@Column(name="normal_squad_averageassistants")
	private String normal_squad_averageassistants;
	@Column(name="normal_squad_charactercode_1")
	private String normal_squad_charactercode_1;
	
	@Column(name="date")
	private String date;
}

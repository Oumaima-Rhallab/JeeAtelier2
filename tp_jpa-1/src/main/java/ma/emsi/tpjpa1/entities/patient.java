package ma.emsi.tpjpa1.entities;
import java.util.Date;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString @AllArgsConstructor


public class patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NOM",length = 25)
	private String nom;
	
	@Temporal(TemporalType.DATE) 
	private Date dateNaissance;
	private int score;
	private boolean malade;
	

}

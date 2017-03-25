package invitaz.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="TBL_USER_LOCATION")
public class UserLocation {

	@Id
    @SequenceGenerator(name="userlocation_iduserlocation_seq",  sequenceName="userlocation_iduserlocation_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="userlocation_iduserlocation_seq")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NLOCATION_ID", referencedColumnName = "ID", nullable = false,foreignKey = @ForeignKey(name = "FK_USERLOCATION_REF_LOCATION"))
	private Location location;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUSER_ID", referencedColumnName = "ID", nullable = false,foreignKey = @ForeignKey(name = "FK_USERLOCATION_REF_USER"))
	private Users user;
	
	
	
	
	
}

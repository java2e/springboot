package invitaz.entity;

import java.util.Date;

import javax.persistence.Column;
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

import invitaz.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="TBL_USERS")
public class Users extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="user_iduser_seq",  sequenceName="user_iduser_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_iduser_seq")
	private Long id;

	@Column(name="VNAME")
	private String name;
	
	@Column(name="VSURNAME")
	private String surname;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NLOCATION_ID", referencedColumnName = "ID", nullable = false,foreignKey = @ForeignKey(name = "FK_USER_REF_LOCATION"))
	private Location location;
	
	@Column(name="BSTATE")
	private boolean state;
	
	@Column(name="DLAST_ENTER")
	private Date lastEnter;
	
	@Column(name="DBIRTH_DATE")
	private Date birthDate;
	
	@Column(name="VPASSWORD")
	private String password;
	
	@Column(name="VEMAIL")
	private String email;

	@Column(name="VPHONE_NUMBER")
	private String phoneNumber;
	
	

}

package invitaz.entity;

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

import invitaz.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="TBL_CITY")
public class City extends BaseEntity{
	
	private static final long serialVersionUID = 1L;


	@Id
    @SequenceGenerator(name="city_idcity_seq",  sequenceName="city_idcity_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="city_idcity_seq")
	private Long id;
	
	
	@Column(name="VNAME")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_ID",referencedColumnName = "ID", nullable = false,foreignKey = @ForeignKey(name = "FK_CITY_REF_COUNTRY"))
	private Country country;

	
}

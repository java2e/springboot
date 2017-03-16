package invitaz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import invitaz.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="TBL_COUNTRY")
public class Country extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="country_idcountry_seq",  sequenceName="country_idcountry_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="country_idcountry_seq")
	private Long id;
	
	@Column(name="VNAME")
	private String name;
	

}

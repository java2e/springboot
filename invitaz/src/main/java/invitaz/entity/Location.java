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
import lombok.Setter;

import lombok.Getter;

@Entity
@Getter
@Setter
@Table(name="TBL_LOCATION")
public class Location extends BaseEntity {

	
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="location_idlocation_seq",  sequenceName="location_idlocation_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="location_idlocation_seq")
	private Long id;
	
	@Column(name="VNAME")
	private String name;
	
	@Column(name="VLAT")
	private String lat;
	
	@Column(name="VLOT")
	private String lon;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NCITY_ID",referencedColumnName="ID",nullable=false,updatable=true,foreignKey = @ForeignKey(name = "FK_LOCATION_REF_CITY"))
	private City city;
	
	
	


}

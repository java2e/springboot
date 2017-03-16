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
@Getter
@Setter
@Table(name="TBL_EVENT_TYPES")
public class EventTypes extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="eventtypes_ideventtypes_seq",  sequenceName="eventtypes_ideventtypes_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="eventtypes_ideventtypes_seq")
	private Long id; 
	
	@Column(name="VNAME")
	private String name;
	
	
	
}

package invitaz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import invitaz.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TBL_EVENT_STATE")
public class EventState extends BaseEntity
{

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="eventstate_ideventstate_seq",  sequenceName="event_ideventstate_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="event_ideventstate_seq")
	private Long id; 
	
	@Column(name="VNAME")
	private String name;
	
}

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

@Entity
@Getter
@Setter
@Table(name="TBL_EVENT")
public class Event extends BaseEntity{

	
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="event_idevent_seq",  sequenceName="event_idevent_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="event_idevent_seq")
	private Long id;
	
	@Column(name="VNAME")
	private String name;
	
	@Column(name="VDETAIL")
	private String detail;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NLOCATION_ID",nullable=false,referencedColumnName="ID",foreignKey=@ForeignKey(name="FK_EVENT_REF_LOCATION"))
	private Location location;
	
	@Column(name="DSTART_DATE")
	private Date startDate;
	
	@Column(name="DEND_DATE")
	private Date endDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NUSER_ID",referencedColumnName="ID",nullable=false,foreignKey=@ForeignKey(name="FK_EVENT_REF_USER"))
    private Users user;
	
	@Column(name="VIMG")
	private String img;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NEVENT_TYPE_ID",nullable=false,referencedColumnName="ID",foreignKey=@ForeignKey(name="FK_EVENT_REF_EVENT_TYPES"))
	private EventTypes eventType;
	

}

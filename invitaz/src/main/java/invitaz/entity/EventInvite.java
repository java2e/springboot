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

import invitaz.core.entity.BaseEntity;
import lombok.Setter;

import lombok.Getter;

@Entity
@Getter
@Setter
@Table(name="TBL_EVENT_INVITE")
public class EventInvite extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="eventinvite_ideventinvite_seq",  sequenceName="eventinvite_ideventinvite_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="eventinvite_ideventinvite_seq")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NEVENT_ID",nullable=false,referencedColumnName="ID",foreignKey=@ForeignKey(name="FK_EVENT_INVITE_REF_EVENT"))
	private Event event;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NFRIEND_ID",referencedColumnName="ID",nullable=false,foreignKey=@ForeignKey(name="FK_EVENT_INVITE_REF_USER"))
	private Users friend;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NEVENT_STATE_ID",referencedColumnName="ID",nullable=false,foreignKey=@ForeignKey(name="FK_EVENT_INVITE_REF_EVENT_STATE"))
	private EventState eventState;
	
	@Column(name="VEVENT_LINK")
	private String eventLink;


}

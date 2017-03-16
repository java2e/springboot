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
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="TBL_USER_FRIEND")
public class UserFriend extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="userfriend_iduserfriend_seq",  sequenceName="userfriend_iduserfriend_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="userfriend_iduserfriend_seq")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NUSER_ID",referencedColumnName="ID",nullable=false,foreignKey=@ForeignKey(name = "FK_USERS_REF_USER"))
	private Users user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NFRIEND_ID",referencedColumnName="ID",nullable=false,foreignKey=@ForeignKey(name = "FK_USERS_REF_FRIEND"))
	private Users friend;
	
	@Column(name="BSTATE")
	private boolean state;

	
	
	
	

}

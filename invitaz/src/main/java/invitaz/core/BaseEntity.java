package invitaz.core;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	  	@Column(name = "VCLIENT_IP")
	    private String clientIp;

	    @Column(name = "NIS_DELETED", nullable = false)
	    private Boolean isDeleted = Boolean.FALSE;
	
	    @Column(name="DCREATE_DATE")
	    private Date createDate;


}

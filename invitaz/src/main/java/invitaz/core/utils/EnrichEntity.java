package invitaz.core.utils;

import java.util.Date;

import org.apache.logging.log4j.ThreadContext;

import invitaz.core.entity.BaseEntity;


public class EnrichEntity
{

    public static final String CLIENT_IP_KEY = "ClientIP";
    public static final String USERNAME_KEY = "Username";

    public static void fillBaseEntityColums(BaseEntity be)
    {
	if (null != be)
	{
	    be.setClientIp(ThreadContext.get(CLIENT_IP_KEY));
	    Date now = new Date();
	    be.setCreateDate(now);
	    if (null == be.getCreateDate())
	    {
		be.setCreateDate(now);
	    }
	}
    }

}

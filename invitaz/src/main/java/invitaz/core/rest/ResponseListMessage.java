package invitaz.core.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.logging.log4j.ThreadContext;

import invitaz.core.dto.BaseDTO;


@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseListMessage<T extends BaseDTO> 
{
	private String status;
	private String uuid;
	private String request;
	private String username;
	private String errorCode;
	private String errorMessage;
	private String validationCause;
	private String hostName;

	@XmlElementWrapper(name = "body")
	@XmlAnyElement(lax=true)
	private List<T> body;

	public ResponseListMessage() 
	{}

	private ResponseListMessage(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getUuid() 
	{
		return uuid;
	}

	public void setUuid(String uuid) 
	{
		this.uuid = uuid;
	}

	public String getRequest() 
	{
		return request;
	}

	public void setRequest(String request) 
	{
		this.request = request;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getErrorCode() 
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode) 
	{
		this.errorCode = errorCode;
	}

	public String getErrorMessage() 
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) 
	{
		this.errorMessage = errorMessage;
	}

	public List<T> getBody() 
	{
		return body;
	}

	public void setBody(List<T> body) 
	{
		this.body = body;
	}

	public String getHostName() 
	{
		return hostName;
	}

	public void setHostName(String hostName) 
	{
		this.hostName = hostName;
	}
	
	public String getValidationCause()
	{
		return validationCause;
	}

	public void setValidationCause(String validationCause)
	{
		this.validationCause = validationCause;
	}

	/**
	 * RestResponse creation with single objects of type BaseDTO
	 * 
	 * @param responseObject
	 *            any object that is subject to the Rest Response and of type
	 *            BaseDTO
	 * @param status
	 *            Status enumeration 1 for success 0 for failure
	 * @return Rest Response in formatted and data filled form
	 */
	public static final <T extends BaseDTO> ResponseListMessage<T> create(List<T> body, Status status) 
	{
		String uuid = ThreadContext.get("UUID");
		String request = ThreadContext.get("REQUEST");
		String hostName = ThreadContext.get("HOSTNAME");
//		if (hostName == null) 
//		{
//			hostName = ConfigurationReader.readValue(Constants.HOSTNAME);
//		}
		String username = ThreadContext.get("ADMIN");
		ResponseListMessage<T> message = new ResponseListMessage(status.getValue());
		message.setUsername(username);
		message.setUuid(uuid);
		message.setRequest(request);
		message.setHostName(hostName);
		message.setBody(body);
		return message;
	}


	/**
	 * RestResponse creation with single objects of type BaseDTO
	 * @param responseObject any object that is subject to the Rest Response and of type Collection<? extends BaseDTO>
	 * @param status  Status enumeration 1 for success 0 for failure
	 * @param errorCode errorCode
	 * @param errorMessage detailed error message
	 * @param validationCause validation cause
	 * @return Rest Response in formatted and data filled form
	 */
	public static <T extends BaseDTO> ResponseListMessage<T> create(List<T> responseObject, Status status, String errorCode, String errorMessage, String validationCause) 
	{
		ResponseListMessage<T> message = create(responseObject, status);
		message.setErrorCode(errorCode);
		message.setErrorMessage(errorMessage);
		message.setValidationCause(validationCause);
		return message;
	}

	@Override
	public String toString() 
	{
		return "[status: " + status + ", uuid: " + uuid + ", request: " + request + ", host: " + hostName + ", username: " + username + ", errorCode: " + errorCode + ", errorMessage: " + errorMessage + ", validationCause: " + validationCause + ", body" + body + "]";
	}
}

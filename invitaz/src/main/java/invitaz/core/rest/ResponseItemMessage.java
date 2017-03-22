package invitaz.core.rest;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;

import org.apache.logging.log4j.ThreadContext;

import invitaz.core.dto.BaseDTO;


public class ResponseItemMessage<T extends BaseDTO> 
{
    	@XmlElement(nillable = true)
	private String status;
    	@XmlElement(nillable = true)
	private String uuid;
    	@XmlElement(nillable = true)
	private String request;
    	@XmlElement(nillable = true)
	private String username;
    	@XmlElement(nillable = true)
	private String errorCode;
    	@XmlElement(nillable = true)
	private String errorMessage;
    	@XmlElement(nillable = true)
	private String validationCause;
    	@XmlElement(nillable = true)
	private String hostName;

	@XmlAnyElement(lax = true)
	private T body;

	public ResponseItemMessage() 
	{}

	private ResponseItemMessage(String status) 
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

	public T getBody() 
	{
		return body;
	}

	public void setBody(T body) 
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
	public static final <T extends BaseDTO> ResponseItemMessage<T> create(T body, Status status) 
	{
		String uuid = ThreadContext.get("UUID");
		String request = ThreadContext.get("REQUEST");
		String hostName = ThreadContext.get("HOSTNAME");
//		if (hostName == null) 
//		{
//			hostName = ConfigurationReader.readValue(Constants.HOSTNAME);
//		}
		String username = ThreadContext.get("ADMIN");
		ResponseItemMessage<T> message = new ResponseItemMessage(status.getValue());
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
	public static <T extends BaseDTO> ResponseItemMessage<T> create(T responseObject, Status status, String errorCode, String errorMessage, String validationCause) 
	{
		ResponseItemMessage<T> message = create(responseObject, status);
		message.setErrorCode(errorCode);
		message.setErrorMessage(errorMessage);
		message.setValidationCause(validationCause);
		return message;
	}

	@Override
	public String toString() 
	{
		return "[status: " + status + ", uuid: " + uuid + ", request: " + request + ", host: " + hostName + ", username: " + username + ", errorCode: " + errorCode + ", errorMessage: " + errorMessage + ", validationCause: " + validationCause + ", body" + body +  "]";
	}
}

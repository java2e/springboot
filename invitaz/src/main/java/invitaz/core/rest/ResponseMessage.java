package invitaz.core.rest;

import java.util.List;

import invitaz.core.dto.BaseDTO;



public class ResponseMessage 
{
	
	public static <T extends BaseDTO> ResponseListMessage<T> create(List<T> responseObject, Status status)
	{
		return ResponseListMessage.create(responseObject, status);
	}
	
	public static <T extends BaseDTO> ResponseListMessage<T> create(List<T> responseObject, Status status, String errorCode, String errorMessage, String validationCause)
	{
		return ResponseListMessage.create(responseObject, status, errorCode, errorMessage, validationCause);
	}
	
	public static <T extends BaseDTO> ResponseItemMessage<T> create(T item,Status status)
	{
		return ResponseItemMessage.create(item, status);
	}
	
	public static <T extends BaseDTO> ResponseItemMessage<T> create(T responseObject, Status status, String errorCode, String errorMessage, String validationCause) 
	{
		return ResponseItemMessage.create(responseObject, status, errorCode, errorMessage, validationCause);
	}
}

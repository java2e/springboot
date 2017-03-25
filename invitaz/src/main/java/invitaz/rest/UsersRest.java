package invitaz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import invitaz.core.rest.ResponseItemMessage;
import invitaz.core.rest.ResponseMessage;
import invitaz.core.rest.Status;
import invitaz.dto.CountryDTO;
import invitaz.dto.UserDTO;
import invitaz.service.UsersService;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersRest {
	
	@Autowired
	private UsersService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {
		    "application/json", "application/xml" })
	public  ResponseEntity<ResponseItemMessage<UserDTO>>  add(@RequestBody UserDTO userDTO)
	{
	
	  userService.addUser(userDTO);
	
	 return new ResponseEntity<ResponseItemMessage<UserDTO>>(ResponseMessage.create(userDTO, Status.SUCCESS),	HttpStatus.OK);
		
	}
	

}

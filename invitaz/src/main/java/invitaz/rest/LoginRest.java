package invitaz.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

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
import invitaz.dto.LoginRequestDTO;
import invitaz.dto.LoginResponseDTO;
import invitaz.dto.LogoutRequestDTO;
import invitaz.dto.LogoutResponseDTO;
import invitaz.service.RestSessionService;

/**
 * Rest Login Authorization
 * give token
 * @author mdemircioglu
 *
 */

@RestController
@RequestMapping(value = "/rest/auth",produces={"application/json","application/xml"},consumes={"application/json","application/xml"})
public class LoginRest
{
    @Autowired
    private RestSessionService restSessionService;
       
    public RestSessionService getRestSessionService()
    {
        return restSessionService;
    }
    
    public void setRestSessionService(RestSessionService restSessionService)
    {
        this.restSessionService = restSessionService;
    }
    
    /**
     * Login rest service
     * @param body
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {"application/json", "application/xml" })
    public ResponseEntity<ResponseItemMessage<LoginResponseDTO>> login(@RequestBody LoginRequestDTO body) throws NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException 
    {
    	LoginResponseDTO loginResponseDTO = restSessionService.login(body);	
    	return new ResponseEntity<ResponseItemMessage<LoginResponseDTO>>(ResponseMessage.create(loginResponseDTO, Status.SUCCESS), HttpStatus.OK);
    }
    
    /**
     * Logout rest service
     * @param body
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {"application/json", "application/xml" })
    public ResponseEntity<ResponseItemMessage<LogoutResponseDTO>> logout(@RequestBody LogoutRequestDTO body) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException 
    {
    	LogoutResponseDTO logoutResponseDTO = restSessionService.logout(body);	
    	return new ResponseEntity<ResponseItemMessage<LogoutResponseDTO>>(ResponseMessage.create(logoutResponseDTO, Status.SUCCESS), HttpStatus.OK);
    }
    
}

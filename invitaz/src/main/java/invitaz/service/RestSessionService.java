package invitaz.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import invitaz.dto.LoginRequestDTO;
import invitaz.dto.LoginResponseDTO;
import invitaz.dto.LogoutRequestDTO;
import invitaz.dto.LogoutResponseDTO;

@SuppressWarnings("serial")
@Service
@Transactional
public class RestSessionService implements Serializable
{

	public LoginResponseDTO login(LoginRequestDTO body) {
		// TODO Auto-generated method stub
		return null;
	}

	public LogoutResponseDTO logout(LogoutRequestDTO body) {
		// TODO Auto-generated method stub
		return null;
	}

}

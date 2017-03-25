package invitaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import invitaz.core.converter.dozer.DozerConverter;
import invitaz.core.service.BaseService;
import invitaz.dao.UserDAO;
import invitaz.dto.UserDTO;
import invitaz.entity.Users;

@Service
@Transactional
public class UsersService implements BaseService {

	
	@Autowired 
	private UserDAO userDAO;
	
	
	public UserDTO addUser(UserDTO userDTO)
	{
		DozerConverter<Users, UserDTO> convertToEntity=new DozerConverter<Users, UserDTO>(Users.class, UserDTO.class, null);
		
		Users userEntity=convertToEntity.convertToEntity(userDTO);
		
		userDAO.saveEntity(userEntity);
		
		return userDTO;
		
	}
	
	
}

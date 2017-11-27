package com.frenchies.tennisclub.facade;
import java.util.List;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserCreateDTO;
import com.frenchies.tennisclub.dto.UserDTO;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

public interface UserFacade {
	
	public UserDTO updateUser(UserDTO user);
	
	public Long createUser(UserCreateDTO user, String unHashPassword);
	
	public UserDTO getUserByName(String Name);
	
	public UserDTO getUserById(Long userId);
	
	public boolean authenticate(UserAuthenticateDTO u);

	public boolean isAdmin(UserDTO u);
	
	public List<UserDTO> getAllUsers();
	
//	public UserDTO updatePassword(UserDTO u);
}

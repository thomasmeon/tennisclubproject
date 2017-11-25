package com.frenchies.tennisclub.facade;
import java.util.List;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserDTO;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

public interface UserFacade {
	
	public void deleteUser(Long id);
	public void updateUser(UserDTO user);
	public void createUser(UserDTO user, String unHashPassword);
//	void changePassword(UserDTO user, String newUnHashPassword);
	
	public List<UserDTO> getAllUser();
		
	public UserDTO findUserByName(String Name);
	
	public UserDTO findUserById(Long userId);
	
	public boolean authenticate(UserAuthenticateDTO u);

	public boolean isAdmin(UserDTO u);
	public List<UserDTO> getAllUsers();
	
}

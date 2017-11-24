package cz.fi.muni.pa165.facade;

//import java.util.Collection;
//
//import cz.fi.muni.pa165.dto.UserAuthenticateDTO;
//import cz.fi.muni.pa165.dto.UserDTO;

public interface UserFacade {
	
	void removeUser(Long id);
	void updateUser(UserDTO user);
	void createUser(UserDTO user, String unHashPassword);
//	void changePassword(UserDTO user, String newUnHashPassword);
	
	List<UserDTO> findAllUser();
		
	UserDTO findUserByUserName(String userName);
	
	UserDTO findUserById(Long userId);

	boolean isAdmin(UserDTO u);
	
}

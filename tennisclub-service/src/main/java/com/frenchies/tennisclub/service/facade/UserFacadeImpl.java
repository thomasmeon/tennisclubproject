package com.frenchies.tennisclub.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.facade.UserFacade;
import com.frenchies.tennisclub.mappers.BeanMappingServiceImpl;
import com.frenchies.tennisclub.service.UserService;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

@Service
@Transactional
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private BeanMappingServiceImpl beanMappingService;

    @Override
    public UserDTO findUserById(Long userId) {
        User user = userService.findUserById(userId);
        return (user == null) ? null : beanMappingService.mapTo(user, UserDTO.class);
    }
    
    @Override
    public UserDTO findUserByName(String name) {
        User user = userService.findUserByName(name);
        return (user == null) ? null : beanMappingService.mapTo(user, UserDTO.class);
    }
    
    @Override
    public void createUser(UserDTO userDTO, String unencryptedPassword) {
        User userEntity = beanMappingService.mapTo(userDTO, User.class);
        userService.registerUser(userEntity, unencryptedPassword);
        userDTO.setId(userEntity.getId());
    }
    
    @Override
	public void deleteUser(Long userId) {
		userService.delete(new User(userId));
	}
    
    
    @Override
    public void updateUser(UserDTO userDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
}
    
    @Override
    public List<UserDTO> getAllUsers() {
        return beanMappingService.mapTo(userService.getAllUsers(), UserDTO.class);
    }

    @Override
    public boolean isAdmin(UserDTO u) {
        return userService.isAdmin(beanMappingService.mapTo(u, User.class));
    }
        
    
    @Override
    public boolean authenticate(UserAuthenticateDTO u) {
        return userService.authenticate(
                userService.findUserById(u.getUserId()), u.getPassword());
    }

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

    

}
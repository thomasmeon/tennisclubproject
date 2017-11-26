package com.frenchies.tennisclub.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.dto.UserUpdateDTO;
import com.frenchies.tennisclub.dto.UserUpdatePasswordDTO;
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
    public UserDTO getUserById(Long userId) {
        User user = userService.getUserById(userId);
        return (user == null) ? null : beanMappingService.mapTo(user, UserDTO.class);
    }
    
    @Override
    public UserDTO getUserByName(String name) {
        User user = userService.getUserByName(name);
        return (user == null) ? null : beanMappingService.mapTo(user, UserDTO.class);
    }
    
    @Override
    public void createUser(UserDTO userDTO, String unencryptedPassword) {
        User userEntity = beanMappingService.mapTo(userDTO, User.class);
        userService.registerUser(userEntity, unencryptedPassword);
        userDTO.setId(userEntity.getId());
        userDTO.setDateOfBirth(userEntity.getDateOfBirth());
        userDTO.setEmail(userEntity.getMail());
        userDTO.setName(userEntity.getName());
        userDTO.setSurname(userEntity.getSurname());
        userDTO.setPhone(userEntity.getPhone());
    }
    
    @Override
	public void deleteUser(Long userId) {
		userService.delete(new User(userId));
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
                userService.getUserById(u.getUserId()), u.getPassword());
    }

    @Override
    public UserDTO updateUser(UserUpdateDTO userDTO) {
        User userToUpdate = userService.getUserById(userDTO.getId());
        userToUpdate.setDateOfBirth(userDTO.getDateOfBirth());
        userToUpdate.setMail(userDTO.getEmail());
        userToUpdate.setPhone(userDTO.getPhone());
        userToUpdate.setName(userDTO.getName());
        userToUpdate.setSurname(userDTO.getSurname());
        userToUpdate.setId(userDTO.getId());
        
        userService.update(userToUpdate);
        return getUserById(userToUpdate.getId());
    }
    
    @Override
    public UserDTO updatePassword(UserUpdatePasswordDTO u) {
        User userToUpdate = userService.getUserById(u.getId());
        if (!userService.updatePassword(userToUpdate, u.getOldPassword(), u.getNewPassword())) {
            //throw new InvalidPasswordException(); TODO
        }

        return getUserById(u.getId());
    }
    

}
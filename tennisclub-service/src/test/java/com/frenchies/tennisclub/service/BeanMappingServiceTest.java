//package com.frenchies.tennisclub.service;
//
//import org.junit.Test;
//
//import com.frenchies.tennisclub.dto.UserDTO;
//import com.frenchies.tennisclub.entity.User;
//
//public class BeanMappingServiceTest extends BaseServiceTest {
//
//	@Test
//	public void mapping() {
//		User user = new User();
//		UserDTO userDTO = new UserDTO();
//		user.setName("BOB");
//		userDTO.setName("BOB");
//
//		UserDTO mappedUserDTO = beanMappingService.mapTo(user, UserDTO.class);
//		assertThat(mappedUserDTO).isEqualTo(userDTO);
//		User mappedUser = beanMappingService.mapTo(userDTO, User.class);
//		assertThat(mappedUser).isEqualTo(user);
//	}
//	
//    @Test
//    public void mapUsers(){
//        List<UserDTO> mappedUsers = beanMappingService.mapTo(user, UserDTO.class);
//        assertThat(mappedUsers).hasSize(user.size());
//    }
//	
//}
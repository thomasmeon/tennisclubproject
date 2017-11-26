<<<<<<< HEAD
package com.frenchies.tennisclub.service;

import org.junit.Test;

import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.User;

public class BeanMappingServiceTest extends BaseServiceTest {
=======
<<<<<<< HEAD
package com.frenchies.tennisclub.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
@ContextConfiguration(classes = ServiceConfiguration.class)
public class BeanMappingServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private BeanMappingService beanMappingService;
>>>>>>> 1fa0b8ddf6f8af90736ef987dd39596c6345c3d6

	@Test
	public void mapping() {
		User user = new User();
		UserDTO userDTO = new UserDTO();
		user.setName("BOB");
		userDTO.setName("BOB");

		UserDTO mappedUserDTO = beanMappingService.mapTo(user, UserDTO.class);
<<<<<<< HEAD
		assertThat(mappedUserDTO).isEqualTo(userDTO);
		User mappedUser = beanMappingService.mapTo(userDTO, User.class);
		assertThat(mappedUser).isEqualTo(user);
	}
	
    @Test
    public void mapUsers(){
        List<UserDTO> mappedUsers = beanMappingService.mapTo(user, UserDTO.class);
        assertThat(mappedUsers).hasSize(user.size());
    }
	
}
=======
		Assert.assertEquals(mappedUserDTO, userDTO);
		User mappedUser = beanMappingService.mapTo(userDTO, User.class);
		Assert.assertEquals(mappedUser, user);
	}

}
=======
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
>>>>>>> 487549bb85cdc489faad900a07821dfa070fdca7
>>>>>>> 1fa0b8ddf6f8af90736ef987dd39596c6345c3d6

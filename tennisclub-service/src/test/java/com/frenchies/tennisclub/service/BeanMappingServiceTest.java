//package com.frenchies.tennisclub.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
//import org.springframework.transaction.annotation.Transactional;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.frenchies.tennisclub.dto.UserDTO;
//import com.frenchies.tennisclub.entity.User;
//import com.frenchies.tennisclub.mappers.BeanMappingService;
//import com.frenchies.tennisclub.service.config.ServiceConfiguration;
//
//
//@TestExecutionListeners(TransactionalTestExecutionListener.class)
//@ContextConfiguration(classes = ServiceConfiguration.class)
//@Transactional
//public class BeanMappingServiceTest extends AbstractTestNGSpringContextTests {
//
//	@Autowired
//	private BeanMappingService beanMappingService;
//
//	@Test
//	public void mapping() {
//		User user = new User();
//		UserDTO userDTO = new UserDTO();
//		user.setName("BOB");
//		userDTO.setName("BOB");
//
//		UserDTO mappedUserDTO = beanMappingService.mapTo(user, UserDTO.class);
//		Assert.assertTrue(mappedUserDTO.equals(userDTO));
//		User mappedUser = beanMappingService.mapTo(userDTO, User.class);
//		Assert.assertTrue(mappedUser.equals(user));
//	}
//
//}
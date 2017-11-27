package com.frenchies.tennisclub.facade;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dto.CourtCreateDTO;
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.CourtService;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;
import com.frenchies.tennisclub.service.facade.CourtFacadeImpl;

@ContextConfiguration(classes = ServiceConfiguration.class)
public class CourtFacadeTest {

	@Mock
	private BeanMappingService beanMappingService;

	@Mock
	private CourtService courtService;

	@Autowired
	@InjectMocks
	private CourtFacadeImpl courtFacade;
	//
	private Court validCourt;
	private Court validCourt2;
	//
	// private Ride validRide;
	//
	private CourtCreateDTO courtCreateDTO;
	//
	private CourtDTO validCourtDTO;
	protected CourtType newCourtType;

	@BeforeClass
	void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeMethod
	void init() {

		courtCreateDTO = new CourtCreateDTO();
		courtCreateDTO.setCourtType(CourtType.GRASS);
		courtCreateDTO.setLatitude(45);
		courtCreateDTO.setLongitude(46);
		courtCreateDTO.setStatus(Status.AVAILABLE);
		
	
		validCourt = new Court(Status.AVAILABLE, CourtType.GRASS, 45, 46);
		validCourt.setIdCourt(1L);
		when(beanMappingService.mapTo(courtCreateDTO, Court.class)).thenReturn(validCourt);

//		validCourt2 = new Court(Status.AVAILABLE, CourtType.GRASS, 45, 46);
//		validCourt2.setIdCourt(1L);
//		when(beanMappingService.mapTo(courtCreateDTO, Court.class)).thenReturn(validCourt2);

		validCourtDTO = new CourtDTO();
		validCourtDTO.setIdCourt(1L);
		validCourtDTO.setType(CourtType.GRASS);
		validCourtDTO.setLattitude(45);
		validCourtDTO.setLongitude(46);
		validCourtDTO.setStatus(Status.AVAILABLE);
	
		newCourtType = CourtType.CLAY;
		
		

		//
		// Calendar cal = Calendar.getInstance();
		// cal.set(2010, Calendar.JULY, 25);
		//
		// validRide = new Ride();
		// validRide.setId(1L);
		// validRide.setSeatPrice(10);
		// validRide.setSourcePlace(new Place());
		// validRide.setDestinationPlace(new Place());
		// validRide.setAvailableSeats(4);
		// validRide.setDeparture(cal.getTime());
		// validRide.setDriver(new User());

	}

	@Test
	void testCreateCourt() {
		// Test 1

		 when(courtService.createCourt(validCourt)).thenReturn(validCourt);
		
		 Long createdId = courtFacade.createCourt(courtCreateDTO);
		 verify(courtService).createCourt(validCourt);
		 Assert.assertTrue((createdId).equals(validCourt.getIdCourt()));
	}

//	@Test
//	public void testDeleteCourt() {
//		// test
//
//		doNothing().when(courtService).deleteCourt(any());
//		when(courtService.getCourtById(1L)).thenReturn(validCourt);
//
//		courtFacade.deleteCourt(validCourt.getIdCourt());
//		verify(courtService).createCourt(validCourt);
//	}

	@Test
	public void testGetAllCourts() {
		// when(courtService.getAllCourts()).thenReturn(Arrays.asList(validCourt,
		// validCourt2));
		// List<CourtDTO> courts = courtFacade.getAllCourts();
		//
		// verify(courtService).getAllCourts();
		// verify(beanMappingService).mapTo(validCourt, CourtDTO.class);
		// verify(beanMappingService).mapTo(validCourt2, CourtDTO.class);
		// test 2

		List<Court> listCourts = new ArrayList<>();
		listCourts.add(validCourt);
		when(courtService.getAllCourts()).thenReturn(listCourts);

		List<CourtDTO> listDTOCourt = new ArrayList<>();
		listDTOCourt.add(validCourtDTO);
		when(beanMappingService.mapTo(listCourts, CourtDTO.class)).thenReturn(listDTOCourt);

		List<CourtDTO> resListCourtDTO = new ArrayList<>(courtFacade.getAllCourts());

		verify(courtService).getAllCourts();
		Assert.assertTrue((resListCourtDTO.size())==1);
		Assert.assertTrue(resListCourtDTO.contains(validCourtDTO));
	}

//	@Test
//	void testFindUserById() {
//		when(beanMappingService.mapTo(validCourt, CourtDTO.class)).thenReturn(validCourtDTO);
//		when(courtService.getCourtById(1L)).thenReturn(validCourt);
//
//		CourtDTO resCourtDTO = courtFacade.getCourtById(validCourt.getIdCourt());
//		Assert.assertTrue(resCourtDTO.equals(validCourtDTO));
//		
//		//System.out.println(validCourt.getIdCourt());
//		//System.out.println(resCourtDTO.getIdCourt());
//	}
//
	@Test
	void testChangeTypeCourt() {
		when(courtService.createCourt(validCourt)).thenReturn(validCourt);

		doNothing().when(courtService).changeCourtType(validCourt,newCourtType);
		when(courtService.getCourtById(1L)).thenReturn(validCourt);
		
		//validCourtDTO.setType(newCourtType);
		courtFacade.changeCourtType(courtFacade.createCourt(courtCreateDTO), newCourtType);
		System.out.println(courtFacade.createCourt(courtCreateDTO));
		
		//verify(courtService).changeCourtType(validCourt, newCourtType);
		
		//Assert.assertTrue(validCourt.getType().equals(newCourtType));
		
//		System.out.println(validCourt.getCourtType());
//		System.out.println(newCourtType);
//		System.out.println(validCourtDTO.getType());
		//System.out.println(courtService.getCourtById(1L));
	}
}

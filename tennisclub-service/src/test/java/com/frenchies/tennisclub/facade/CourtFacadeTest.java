package com.frenchies.tennisclub.facade;

import static org.mockito.Matchers.any;

/*
 *  * @author Dore Corentin 473308
 *  
 */

//import static org.mockito.Mockito.doAnswer;
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

/*
 * @Author Dore COrentin 473308
 */

@ContextConfiguration(classes = ServiceConfiguration.class)
public class CourtFacadeTest {

	@Mock
	private BeanMappingService beanMappingService;

	@Mock
	private CourtService courtService;

	@Autowired
	@InjectMocks
	private CourtFacadeImpl courtFacade;

	private Court validCourt;

	private CourtCreateDTO courtCreateDTO;

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

		validCourtDTO = new CourtDTO();
		validCourtDTO.setIdCourt(1L);
		validCourtDTO.setType(CourtType.GRASS);
		validCourtDTO.setLatitude(45);
		validCourtDTO.setLongitude(46);
		validCourtDTO.setStatus(Status.AVAILABLE);

		newCourtType = CourtType.CLAY;

	}

	// GET TEST
	
	@Test
	public void testGetAllCourts() {

		List<Court> listCourts = new ArrayList<>();
		listCourts.add(validCourt);
		when(courtService.getAllCourts()).thenReturn(listCourts);

		List<CourtDTO> listDTOCourt = new ArrayList<>();
		listDTOCourt.add(validCourtDTO);
		when(beanMappingService.mapTo(listCourts, CourtDTO.class)).thenReturn(listDTOCourt);

		List<CourtDTO> resListCourtDTO = new ArrayList<>(courtFacade.getAllCourts());

		verify(courtService).getAllCourts();
		Assert.assertTrue((resListCourtDTO.size()) == 1);
		Assert.assertTrue(resListCourtDTO.contains(validCourtDTO));
	}

	// CREATE/DELETE TEST

	@Test
	public void testCreateCourt() {

		when(courtService.createCourt(validCourt)).thenReturn(validCourt);

		Long createdId = courtFacade.createCourt(courtCreateDTO);
		verify(courtService).createCourt(validCourt);
		Assert.assertTrue((createdId).equals(validCourt.getIdCourt()));

	}

	@Test
	public void testDeleteCourt() {

		doNothing().when(courtService).deleteCourt(any());
		when(courtService.getCourtById(1L)).thenReturn(validCourt);

		courtFacade.deleteCourt(validCourt.getIdCourt());
		verify(courtService).createCourt(validCourt);
	}

	// FIND TEST
	
	@Test
	public void testFindUserById() {
		when(beanMappingService.mapTo(validCourt, CourtDTO.class)).thenReturn(validCourtDTO);
		when(courtService.getCourtById(1L)).thenReturn(validCourt);

		CourtDTO resCourtDTO = courtFacade.getCourtById(validCourt.getIdCourt());
		Assert.assertTrue(resCourtDTO.equals(validCourtDTO));

	}

	// UPDATE TEST
	
	@Test
	void testChangeTypeCourt() {
		doNothing().when(courtService).changeCourtType(validCourt, newCourtType);
		when(courtService.getCourtById(validCourt.getIdCourt())).thenReturn(validCourt);

		validCourtDTO.setType(newCourtType);

		courtFacade.changeCourtType(validCourtDTO.getIdCourt(), newCourtType);

		verify(courtService).changeCourtType(validCourt, newCourtType);
	}

}

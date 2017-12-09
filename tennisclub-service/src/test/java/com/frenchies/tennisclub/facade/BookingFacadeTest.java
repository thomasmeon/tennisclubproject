package com.frenchies.tennisclub.facade;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserCreateDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.enums.Hour24;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.BookingService;
import com.frenchies.tennisclub.service.TimeService;
import com.frenchies.tennisclub.service.UserService;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;
import com.frenchies.tennisclub.service.facade.BookingFacadeImpl;
import com.frenchies.tennisclub.service.facade.UserFacadeImpl;

/*
 * @Author Jacquet Valentin 473362
 */

@ContextConfiguration(classes = ServiceConfiguration.class)
public class BookingFacadeTest {

	@Mock
	private BeanMappingService beanMappingService;

	@Mock
	private UserService userService;

	@Mock
	private BookingService bookingService;
	
	@Mock
	private TimeService timeService;

	@Autowired
	@InjectMocks
	private UserFacadeImpl userFacade;

	@Autowired
	@InjectMocks
	private BookingFacadeImpl bookingFacade;

	private BookingCreateDTO bookingCreateDTO;

	private BookingDTO bookingDTO;
	private Booking booking;

	private UserDTO userDTO1;
	private UserDTO userDTO2;

	private User user1;
	private User user2;

	private Calendar cal1;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	// @BeforeMethod
	// public void userDTOCreation() {
	//
	// }

	public void generateUsers() {
		cal1 = Calendar.getInstance();
		cal1.set(1987, 1, 1);

		// User Inits
		user1 = new User();
		user1.setName("Jean");
		user1.setSurname("Patrick");
		user1.setId(1L);
		user1.setDateOfBirth(cal1.getTime());
		user1.setMail("jean.patrick@mail.com");
		user1.setPhone("+33678787878");
		user1.setAdmin(false);

		user2 = new User();
		user2.setName("Jacques");
		user2.setSurname("Henry");
		user2.setId(2L);
		user2.setDateOfBirth(cal1.getTime());
		user2.setMail("jacques.henry@mail.com");
		user2.setPhone("+33678789090");
		user2.setAdmin(false);

		userDTO1 = new UserDTO();
		userDTO1.setName("Jean");
		userDTO1.setSurname("Patrick");
		userDTO1.setId(1L);
		userDTO1.setDateOfBirth(cal1.getTime());
		userDTO1.setMail("jean.patrick@mail.com");
		userDTO1.setPhone("+33678787878");
		userDTO1.setAdmin(false);

		userDTO2 = new UserDTO();
		userDTO2.setName("Jacques");
		userDTO2.setSurname("Henry");
		userDTO2.setId(2L);
		userDTO2.setDateOfBirth(cal1.getTime());
		userDTO2.setMail("jacques.henry@mail.com");
		userDTO2.setPhone("+33678789090");
		userDTO2.setAdmin(false);
	}

	public void initBooking() {
		Date date1 = timeService.getCurrentTime();

		bookingCreateDTO = new BookingCreateDTO();
		bookingCreateDTO.setIdCourt(1L);
		bookingCreateDTO.setDateOfBooking(date1);
		bookingCreateDTO.setHourOfBooking(Hour24.EIGHT);
		bookingCreateDTO.setUser1(userDTO1);
		bookingCreateDTO.setUser2(userDTO2);

		bookingDTO = new BookingDTO();

		booking = new Booking();
		booking.setIdCourt(1L);
		booking.setDateOfBooking(date1);
		booking.setHourOfBooking(Hour24.EIGHT);
		booking.setUser1(user1);
		booking.setUser2(user2);
		booking.setIdBooking(12L);
		when(beanMappingService.mapTo(bookingCreateDTO, Booking.class)).thenReturn(booking);

		bookingDTO = new BookingDTO();
		bookingDTO.setIdCourt(1L);
		bookingDTO.setDateOfBooking(date1);
		bookingDTO.setHourOfBooking(Hour24.EIGHT);
		bookingDTO.setUser1(userDTO1);
		bookingDTO.setUser2(userDTO2);
		bookingDTO.setIdBooking(12L);

	}

	@BeforeMethod
	public void init() {
		generateUsers();
		initBooking();
	}

	@Test
	public void createBookingTest() {
		when(beanMappingService.mapTo(bookingDTO, Booking.class)).thenReturn(booking);
		when(bookingService.createBooking(booking)).thenReturn(booking);

		Long verifyId = bookingFacade.createBooking(bookingCreateDTO);

		verify(bookingService).createBooking(booking);
		Assert.assertTrue((verifyId).equals(booking.getIdBooking()));

	}

	@Test
	public void deleteBookingTest() {
		Long id = 12L;

		when(bookingService.getBookingById(id)).thenReturn(booking);

		bookingFacade.deleteBooking(id);
		verify(bookingService, times(1)).deleteBooking(booking);
	}

	@Test
	public void getAllBookingTest() {
		List<Booking> allBookings = new ArrayList<>();
        allBookings.add(booking);

        List<BookingDTO> allDtoBookings = new ArrayList<>();
        allDtoBookings.add(bookingDTO);

        when(bookingService.getAllBookings()).thenReturn(allBookings);
        when(beanMappingService.mapTo(allBookings,BookingDTO.class)).thenReturn(allDtoBookings);

        List<BookingDTO> testBookingList = bookingFacade.getAllBookings();

        verify(bookingService).getAllBookings();
        Assert.assertTrue(testBookingList.contains(bookingDTO));

	}

	@Test
    public void getBookingByUserTest(){
		List<Booking> bookingList = new ArrayList<>();
        when(bookingService.getBookingsByUser(user1)).thenReturn(bookingList);

        List<BookingDTO> listFoundBookings = bookingFacade.getBookingsByUser(bookingDTO.getUser1());
        Assert.assertEquals(listFoundBookings,bookingList);
    }
	
	@Test
    public void getBookingBCourtTest(){
		List<Booking> bookingList = new ArrayList<>();
        when(bookingService.getBookingsByCourt(booking.getIdCourt())).thenReturn(bookingList);

        List<BookingDTO> listFoundBookings = bookingFacade.getBookingsByCourt(bookingDTO.getIdCourt());
        Assert.assertEquals(listFoundBookings,bookingList);
    }
	
	@Test
	void getBookingByIdTest() {
		when(beanMappingService.mapTo(booking, BookingDTO.class)).thenReturn(bookingDTO);
		when(bookingService.getBookingById(12L)).thenReturn(booking);

		BookingDTO resBookingDTO = bookingFacade.getBookingById(booking.getIdBooking());
		Assert.assertTrue((resBookingDTO).equals(bookingDTO));
	}
	
	@Test
	public void getAllBookingsLastWeekTest() {
		List<Booking> allBookingsLastWeek = new ArrayList<>();
        allBookingsLastWeek.add(booking);

        List<BookingDTO> allDtoBookingsLastWeek = new ArrayList<>();
        allDtoBookingsLastWeek.add(bookingDTO);

        when(bookingService.getAllBookingsLastWeek()).thenReturn(allBookingsLastWeek);
        when(beanMappingService.mapTo(allBookingsLastWeek,BookingDTO.class)).thenReturn(allDtoBookingsLastWeek);

        List<BookingDTO> testBookingLastWeekList = bookingFacade.getAllBookingsLastWeek();

        verify(bookingService).getAllBookingsLastWeek();
        Assert.assertTrue(testBookingLastWeekList.contains(bookingDTO));
		
	}
	
	@Test
	public void getAllBookingsLastMonthTest() {
		List<Booking> allBookingsLastMonth = new ArrayList<>();
        allBookingsLastMonth.add(booking);

        List<BookingDTO> allDtoBookingsLastMonth = new ArrayList<>();
        allDtoBookingsLastMonth.add(bookingDTO);

        when(bookingService.getAllBookingsLastMonth()).thenReturn(allBookingsLastMonth);
        when(beanMappingService.mapTo(allBookingsLastMonth,BookingDTO.class)).thenReturn(allDtoBookingsLastMonth);

        List<BookingDTO> testBookingLastMonthList = bookingFacade.getAllBookingsLastMonth();

        verify(bookingService).getAllBookingsLastMonth();
        Assert.assertTrue(testBookingLastMonthList.contains(bookingDTO));
		
	}
	
	@Test
	public void getAllBookingsLastYearTest() {
		List<Booking> allBookingsLastYear = new ArrayList<>();
        allBookingsLastYear.add(booking);

        List<BookingDTO> allDtoBookingsLastYear = new ArrayList<>();
        allDtoBookingsLastYear.add(bookingDTO);

        when(bookingService.getAllBookingsLastYear()).thenReturn(allBookingsLastYear);
        when(beanMappingService.mapTo(allBookingsLastYear,BookingDTO.class)).thenReturn(allDtoBookingsLastYear);

        List<BookingDTO> testBookingLastYearList = bookingFacade.getAllBookingsLastYear();

        verify(bookingService).getAllBookingsLastYear();
        Assert.assertTrue(testBookingLastYearList.contains(bookingDTO));
		
	}
	
	@Test
	public void getAllBookingsLastWeekByUserTest() {
		List<Booking> allBookingsLastWeek = new ArrayList<>();
        allBookingsLastWeek.add(booking);

        List<BookingDTO> allDtoBookingsLastWeek = new ArrayList<>();
        allDtoBookingsLastWeek.add(bookingDTO);
        
        User uTemp = new User();
        uTemp.setId(user1.getId());

        when(bookingService.getAllBookingsLastWeekByUser(uTemp)).thenReturn(allBookingsLastWeek);
        when(beanMappingService.mapTo(allBookingsLastWeek,BookingDTO.class)).thenReturn(allDtoBookingsLastWeek);

        List<BookingDTO> testBookingLastWeekList = bookingFacade.getAllBookingsLastWeekByUser(uTemp.getId());

        verify(bookingService).getAllBookingsLastWeekByUser(uTemp);
        Assert.assertTrue(testBookingLastWeekList.contains(bookingDTO));
		
	}
	
	@Test
	public void getAllBookingsLastMonthByUserTest() {
		List<Booking> allBookingsLastMonth = new ArrayList<>();
        allBookingsLastMonth.add(booking);

        List<BookingDTO> allDtoBookingsLastMonth = new ArrayList<>();
        allDtoBookingsLastMonth.add(bookingDTO);
        
        User uTemp = new User();
        uTemp.setId(user2.getId());

        when(bookingService.getAllBookingsLastMonthByUser(uTemp)).thenReturn(allBookingsLastMonth);
        when(beanMappingService.mapTo(allBookingsLastMonth,BookingDTO.class)).thenReturn(allDtoBookingsLastMonth);

        List<BookingDTO> testBookingLastMonthList = bookingFacade.getAllBookingsLastMonthByUser(uTemp.getId());

        //verify(bookingService).getAllBookingsLastMonthByUser(uTemp);
        Assert.assertTrue(testBookingLastMonthList.contains(bookingDTO));
		
	}
	
	@Test
	public void getAllBookingsLastYearByUserTest() {
		List<Booking> allBookingsLastYear = new ArrayList<>();
        allBookingsLastYear.add(booking);

        List<BookingDTO> allDtoBookingsLastYear = new ArrayList<>();
        allDtoBookingsLastYear.add(bookingDTO);
        
        User uTemp = new User();
        uTemp.setId(user1.getId());

        when(bookingService.getAllBookingsLastYearByUser(uTemp)).thenReturn(allBookingsLastYear);
        when(beanMappingService.mapTo(allBookingsLastYear,BookingDTO.class)).thenReturn(allDtoBookingsLastYear);

        List<BookingDTO> testBookingLastYearList = bookingFacade.getAllBookingsLastYearByUser(uTemp.getId());

        //verify(bookingService).getAllBookingsLastYearByUser(uTemp);
        Assert.assertTrue(testBookingLastYearList.contains(bookingDTO));
		
	}
	
}

package com.frenchies.tennisclub.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.facade.UserFacade;

/**
 *
 * @author Valentin JACQUET 473362
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private BookingFacade bookingFacade;
	
	@Autowired
    private UserFacade userFacade;

    final static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userFacade.getAllUsers());
        return "user/list";
    }
    
    @RequestMapping(value = "/stats/{id}", method = RequestMethod.GET)
	public String statistics(@PathVariable long id, Model model) {
		List<BookingDTO> bookings;
		UserDTO uTemp = new UserDTO();
		uTemp.setId(id);
		bookings = bookingFacade.getBookingsByUser(uTemp);
		model.addAttribute("nbBookingsAll",bookings.size());
		bookings = bookingFacade.getAllBookingsLastWeekByUser(id);
		model.addAttribute("nbBookingsLastWeek",bookings.size());
		bookings = bookingFacade.getAllBookingsLastMonthByUser(id);
		model.addAttribute("nbBookingsLastMonth",bookings.size());
		bookings = bookingFacade.getAllBookingsLastYearByUser(id);
		model.addAttribute("nbBookingsLastYear",bookings.size());
		model.addAttribute("user", userFacade.getUserById(id));
		return"user/stats";

	}
}

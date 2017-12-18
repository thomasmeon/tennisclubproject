package com.frenchies.tennisclub.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.facade.BookingFacade;

/**
 * Provides the user mybooking interface.
 *
 * @author Valentin Jacquet 473362
 */
@Controller
@RequestMapping("/mybookings")
public class MyBookingsController {
	final static Logger log = LoggerFactory.getLogger(MyBookingsController.class);

    @Autowired
    private BookingFacade bookingFacade;

    public void setBookingFacade(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public void home() {
    	
    }
    
    /**
     * Shows a list of bookings, filtered by specified filter
     *
     * @param filter selects which bookings should be displayed
     * @param model  data to display
     * @return JSP page name
     */
    @RequestMapping(value = "/show/{filter}/{id}", method = RequestMethod.GET)
    public String list(@PathVariable String filter, @PathVariable long id, Model model) {
        List<BookingDTO> bookings;
        UserDTO uTemp = new UserDTO();
        uTemp.setId(id);
        switch (filter) {
            case "all":
                bookings = bookingFacade.getBookingsByUser(uTemp);
                break;
            case "lastweek":
                bookings = bookingFacade.getAllBookingsLastWeekByUser(id);
                break;
            case "lastmonth":
                bookings = bookingFacade.getAllBookingsLastMonthByUser(id);
                break;
            case "lastyear":
                bookings = bookingFacade.getAllBookingsLastYearByUser(id);
                break;
            default:
                bookings = new ArrayList<>();
                model.addAttribute("alert_danger", "Unknown filter " + filter);
        }
        model.addAttribute("booking", bookings);
        return "mybookings/show";
    }
    
    /**
     * Shows booking detail.
     *
     * @param id    booking id
     * @param model data to display
     * @return JSP page name
     */
    @RequestMapping("/booking/{id}")
    public String booking(@PathVariable long id, Model model) {
        log.debug("booking({})", id);
        model.addAttribute("booking", bookingFacade.getBookingById(id));
        return "mybookings/booking";
    }
}

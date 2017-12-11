package com.frenchies.tennisclub.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    /**
     * Shows all bookings of user.
     * @param id       booking id
     * @param model data to display
     * @return JSP page name
     */
    @RequestMapping("/show/all/{id}")
    public String listAll(@PathVariable long id, Model model) {
        log.debug("showAllBookingsOfUser({})",id);
        UserDTO uTemp = new UserDTO();
        uTemp.setId(id);
        model.addAttribute("booking", bookingFacade.getBookingsByUser(uTemp));
        return "mybookings/show";
    }
    
    /**
     * Shows all last week bookings of user
     * @param id	booking id
     * @param model	date to display
     * @return JSP page name
     */
    @RequestMapping("/show/lastweek/{id}")
    public String listLastWeek(@PathVariable long id, Model model) {
        log.debug("showLastWeekBookingsOfUser({})",id);
        model.addAttribute("booking", bookingFacade.getAllBookingsLastWeekByUser(id));
        return "mybookings/show";
    }
    
    /**
     * Shows all last month bookings of user
     * @param id	booking id
     * @param model	date to display
     * @return JSP page name
     */
    @RequestMapping("/show/lastmonth/{id}")
    public String listLastMonth(@PathVariable long id, Model model) {
        log.debug("showLastMonthBookingsOfUser({})",id);
        model.addAttribute("booking", bookingFacade.getAllBookingsLastMonthByUser(id));
        return "mybookings/show";
    }
    
    /**
     * Shows all last year bookings of user
     * @param id	booking id
     * @param model	date to display
     * @return JSP page name
     */
    @RequestMapping("/show/lastyear/{id}")
    public String listLastYear(@PathVariable long id, Model model) {
        log.debug("showLastYearBookingsOfUser({})",id);
        model.addAttribute("booking", bookingFacade.getAllBookingsLastYearByUser(id));
        return "mybooking/show";
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
        return "shopping/booking";
    }
}

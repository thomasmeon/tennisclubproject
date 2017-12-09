package com.frenchies.tennisclub.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.facade.CourtFacade;

/**
 * Provides the user mybooking interface.
 *
 * @author Valentin Jacquet 473362
 */
@Controller
@RequestMapping("/mybooking")
public class MyBookingController {
	final static Logger log = LoggerFactory.getLogger(MyBookingController.class);

    @Autowired
    private BookingFacade bookingFacade;

    public void setProductFacade(BookingFacade bookingFacade) {
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
        model.addAttribute("booking", bookingFacade.getBookingById(id));
        return "mybooking/show";
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
        model.addAttribute("booking", bookingFacade.getAllBookingsLastWeek());
        return "mybooking/show";
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
        model.addAttribute("booking", bookingFacade.getAllBookingsLastMonth());
        return "mybooking/show";
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
        model.addAttribute("booking", bookingFacade.getAllBookingsLastYear());
        return "mybooking/show";
    }
}

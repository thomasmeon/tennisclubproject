package com.frenchies.tennisclub.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserCreateDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.facade.UserFacade;

/**
 * 
 * @author valentinJacquet 473362
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final static Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserFacade userFacade;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loginUser(Model model, HttpServletRequest request) {

        if(request.getSession().getAttribute("authenticatedUser") != null){
            return "home";
        }

        log.debug("[AUTH] Login");

        model.addAttribute("userLogin", new UserAuthenticateDTO());
        return "/auth/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(Model model, HttpServletRequest request) {
        log.debug("[AUTH] Logout");
        request.getSession().removeAttribute("authenticatedUser");
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("userLogin") UserAuthenticateDTO formBean, BindingResult bindingResult,
        Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, HttpServletRequest request) {
        log.debug("login(userLogin={})", formBean);

        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.debug("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                log.debug("FieldError: {}", fe);
            }
            model.addAttribute("userLogin", new UserAuthenticateDTO());
            return "/auth/login";
        }

        UserDTO matchingUser = userFacade.getUserByEmail(formBean.getUsername());
        if(matchingUser==null) {
            log.warn("no user with nick {}", formBean.getUsername());
            redirectAttributes.addFlashAttribute("alert_warning", "No user with nick: " + formBean.getUsername());
            return "redirect:" + uriBuilder.path("/auth").build().toUriString();
        }

        if (!userFacade.authenticate(formBean)) {
            log.warn("wrong credentials: user={} password={}", formBean.getUsername(), formBean.getPassword());
            redirectAttributes.addFlashAttribute("alert_warning", "Login " + formBean.getUsername() + " failed ");
            return "redirect:" + uriBuilder.path("/auth").build().toUriString();
        }
        request.getSession().setAttribute("authenticatedUser", matchingUser);
        //report success
        redirectAttributes.addFlashAttribute("alert_success", "Login " + formBean.getUsername() + " succeeded ");
        return "redirect:" + uriBuilder.path("/mybookings/show/all/" + matchingUser.getId()).build().toUriString();
    }
}

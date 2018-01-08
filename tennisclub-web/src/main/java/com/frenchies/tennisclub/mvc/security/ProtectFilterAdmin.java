package com.frenchies.tennisclub.mvc.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.facade.UserFacade;

/**
 * Protects administrative part of application.
 *
 * @author valentinjacquet 473362
 */
@WebFilter(urlPatterns = { "/court/*", "/user/*", "/booking/list/*" })
public class ProtectFilterAdmin implements Filter {

	final static Logger log = LoggerFactory.getLogger(ProtectFilterAdmin.class);

	@Override
	public void doFilter(ServletRequest r, ServletResponse s, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) r;
		HttpServletResponse response = (HttpServletResponse) s;
		// get Spring context and UserFacade from it
		UserFacade userFacade = (UserFacade) request.getSession().getAttribute("authenticatedUser");
		UserDTO matchingUser = (UserDTO) request.getSession().getAttribute("authenticatedUser");
		
		if (!userFacade.isAdmin(matchingUser)) {
			log.warn("user not admin {}", matchingUser);
			response.sendRedirect(request.getContextPath() + "/auth");
			return;
		}
		
		if (matchingUser == null) {
			log.debug("User not authorized!");
			response.sendRedirect(request.getContextPath() + "/auth");
			return;
		}
		request.setAttribute("authenticatedUser", matchingUser);
		chain.doFilter(request, response);
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}
}

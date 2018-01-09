package com.frenchies.tennisclub.mvc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.facade.UserFacade;

/**
 * Protects administrative part of application.
 *
 * @author valentinjacquet 473362
 */
@WebFilter(urlPatterns = { "/mybookings/*", "/booking/*", "/user/stats/*"})
public class ProtectFilterUser implements Filter {

	final static Logger log = LoggerFactory.getLogger(ProtectFilterUser.class);

	@Override
	public void doFilter(ServletRequest r, ServletResponse s, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) r;
		HttpServletResponse response = (HttpServletResponse) s;
		
		UserDTO matchingUser = (UserDTO) request.getSession().getAttribute("authenticatedUser");

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

package com.orderprocessor.securityconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 * @author VE00YM341
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 *if error generated like 404 then to handle that
 */
public class SecurityAuthEntryPoint extends BasicAuthenticationEntryPoint {
	

	/**
	* @author VE00YM341
	* @param HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException
	* @return void
	* @throws IOException
	*/
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.setHeader("WWW-Authenticate","Basic realm=\""+ getRealmName()+"\"");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter out = response.getWriter();
		out.print("401-UNAUTHORIZED, contact- Aditi");
	}

	@Override
	public void afterPropertiesSet() {
		setRealmName("YMSLI-APP");
		super.afterPropertiesSet();
	}

}

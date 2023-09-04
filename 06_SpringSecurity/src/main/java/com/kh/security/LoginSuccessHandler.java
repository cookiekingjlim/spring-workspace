package com.kh.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		List<String> roleList = new ArrayList();
		
		authentication.getAuthorities().forEach(auth -> {
			System.out.println("auth : " + auth);
			roleList.add(auth.getAuthority());
		});
		
		if(roleList.contains("ROLE_MEMBER")) {
			response.sendRedirect("/member");
			return;
		}
		
		if(roleList.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			return;
		}
		response.sendRedirect("/all");
	}

}

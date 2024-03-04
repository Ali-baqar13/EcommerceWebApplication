package com.sheryians.major.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sheryians.major.model.Role;
import com.sheryians.major.model.User;
import com.sheryians.major.repository.RoleRepostory;
import com.sheryians.major.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	RoleRepostory roleRepo;

	@Autowired
	UserRepository userRepo;

	public RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override


	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
		System.out.println("working");
		String email = token.getPrincipal().getAttributes().get("email").toString();
		if (userRepo.findByUserEmail(email).isPresent()) {
			System.out.println("for now it is working");

		} else {
			User user = new User();
			user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
			user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
			user.setUserEmail(email);
			List<Role> roles = new ArrayList<>();
			roles.add(roleRepo.findById(2).orElse(null)); 
			user.setRoles(roles);
			userRepo.save(user);
		}
		redirectStrategy.sendRedirect(request, response, "/home");
	}

}

package com.sheryians.major.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpServerErrorException;

import com.sheryians.major.global.GlobalData;
import com.sheryians.major.model.Role;
import com.sheryians.major.model.User;
import com.sheryians.major.repository.RoleRepostory;
import com.sheryians.major.repository.UserRepository;
import com.sheryians.major.service.CustomUserDetailService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Email;

@Controller
public class Login {
	@Autowired
	PasswordEncoder passwordEncoder;
	// PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepostory roleRepo;
	@Autowired
	CustomUserDetailService customservice;

	@GetMapping("/login")
	public String login() {

		GlobalData.cart.clear();

		return "login";

	}

	@GetMapping("/register")
	public String Register() {

		return "register";
	}

	@PostMapping("/register")
	public String register(Model model, @ModelAttribute("users") User user, HttpServletRequest httprequest)
			throws ServletException {

		String password = user.getPassword();
//		user.setPassword(passencode.encode(password));
		String encodedPassword = passwordEncoder.encode(password);
		user.setPassword(encodedPassword);
		List<Role> role = new ArrayList<>();
		role.add(roleRepo.findById(2).get());

		user.setRoles(role);
		userRepo.save(user);
		String email = user.getUserEmail();

		httprequest.login(email, password);

		return "redirect:/home";
	}

}

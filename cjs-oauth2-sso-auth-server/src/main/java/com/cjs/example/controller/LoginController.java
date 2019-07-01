package com.cjs.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/exit")
	public void exit(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, null, null);
		try {
			response.sendRedirect(request.getHeader("referer"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

}

package com.linkedin.javacd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = { "/", "/index.html"})
public class NavigationController {
	
	@GetMapping(path= {"/", "/index.html"})
	public String index() {
		
		return "bookings";
	}
	
	@RequestMapping(path = {"/bookings.html", "/rooms.html", "/guests.html" }, produces = "text/html")
	public Model home(Model model) {
			
		return model;
	}

}

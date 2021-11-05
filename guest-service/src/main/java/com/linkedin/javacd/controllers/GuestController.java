package com.linkedin.javacd.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.javacd.entities.Guest;
import com.linkedin.javacd.services.GuestService;

@RestController
@RequestMapping("/guest")
public class GuestController {

	private GuestService guestService;
	
	
	@Autowired
	public GuestController(GuestService guestService) {
		this.guestService = guestService;
	}


	@GetMapping()
	public ResponseEntity<List<Guest>> requestGuests(){
		return ResponseEntity.ok(this.guestService.list());
	}
	
	@GetMapping(params="ids")
	public ResponseEntity<List<Guest>> requestGuestsById(@RequestParam List<Long> ids){
		return ResponseEntity.ok(this.guestService.list(ids));
	}
	
}

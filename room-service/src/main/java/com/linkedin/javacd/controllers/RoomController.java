package com.linkedin.javacd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.javacd.entities.Room;
import com.linkedin.javacd.services.RoomInventoryService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	//RoomService
	private RoomInventoryService roomService;
	
	@Autowired
	public RoomController(RoomInventoryService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Room>> requestGuests(){
		return ResponseEntity.ok(this.roomService.list());
	}
	
	@GetMapping(params="ids")
	public ResponseEntity<List<Room>> requestGuests(@RequestParam List<Long> ids){
		return ResponseEntity.ok(this.roomService.list(ids));
	}

}

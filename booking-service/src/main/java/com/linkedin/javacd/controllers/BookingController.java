package com.linkedin.javacd.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.linkedin.javacd.controllers.payloads.BookingResponse;
import com.linkedin.javacd.entities.Booking;
import com.linkedin.javacd.services.BookingService;
import com.linkedin.javacd.services.GuestService;
import com.linkedin.javacd.services.RoomService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	private BookingService bookingService;
	
	private GuestService guestService;

	private RoomService roomService;

	@Autowired
	public BookingController(BookingService bookingService, GuestService guestService, RoomService roomService) {
		this.bookingService = bookingService;
		this.guestService = guestService;
		this.roomService = roomService;
	}

	@GetMapping
	public ResponseEntity<List<BookingResponse>> getBookings(){
		
		List<BookingResponse> currentBookings = this.bookingService.list().stream()
				.map(BookingResponse::new)
				.collect(Collectors.toList());
		
		try {
			
			List<Long> guestIds = currentBookings.stream()
					.map(BookingResponse::getBooking)
					.map(Booking::getGuestId)
					.collect(Collectors.toList());

			List<Long> roomIds = currentBookings.stream()
					.map(BookingResponse::getBooking)
					.map(Booking::getRoomId)
					.collect(Collectors.toList());

			ArrayNode roomArray = this.roomService.list(roomIds);
			ArrayNode guestArray = this.guestService.list(guestIds);

			for(JsonNode node : roomArray) {
				Long id = node.get("roomId").asLong();
				currentBookings.stream()
				.filter(bookingResponse -> bookingResponse.getBooking().getRoomId().equals(id))
				.forEach(booking -> booking.setRoom(node));
			}

			for(JsonNode node : guestArray) {
				Long id = node.get("guestId").asLong();
				currentBookings.stream()
				.filter(bookingResponse -> bookingResponse.getBooking().getGuestId().equals(id))
				.forEach(booking -> booking.setGuest(node));
			}
			
		} catch (Exception e) {
			
		}
		
		
		return ResponseEntity.ok(currentBookings);
	
	}

}

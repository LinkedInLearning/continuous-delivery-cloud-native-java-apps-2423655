package com.linkedin.javacd.controllers.payloads;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.linkedin.javacd.entities.Booking;

public class BookingResponse {

	@JsonIgnore
	private Booking booking;
	
	private Long bookingId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="UTC")
	private Instant startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="UTC")
	private Instant endDate;
	
	private  JsonNode room;
	
	private JsonNode guest;

	public BookingResponse(Booking booking) {
		this.booking = booking;
		this.startDate = booking.getStartDate();
		this.endDate = booking.getEndDate();
		this.bookingId = booking.getBookingId();
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public Instant getEndDate() {
		return endDate;
	}

	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}

	public JsonNode getRoom() {
		return room;
	}

	public void setRoom(JsonNode room) {
		this.room = room;
	}

	public JsonNode getGuest() {
		return guest;
	}

	public void setGuest(JsonNode guest) {
		this.guest = guest;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}

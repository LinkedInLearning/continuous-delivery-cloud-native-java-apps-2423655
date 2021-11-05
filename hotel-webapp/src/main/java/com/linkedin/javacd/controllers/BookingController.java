package com.linkedin.javacd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/booking")
public class BookingController {

	private WebClient bookingClient;
	
	@Value("${service.booking.path:/api/booking-service/booking}")
	private String bookingApiPath;

	@Autowired
	public BookingController(@Qualifier("bookingServiceClient") WebClient bookingClient) {
		this.bookingClient = bookingClient;
	}

	@GetMapping
	public Mono<String> bookings() {

		return bookingClient.get()
				.uri(this.bookingApiPath)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(String.class);

	}

}

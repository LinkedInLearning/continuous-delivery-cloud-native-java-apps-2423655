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
@RequestMapping("/room")
public class RoomController {

	private WebClient roomClient;

	@Value("${service.room.path:/api/room-service/room}")
	private String roomApiPath;
	
	@Autowired
	public RoomController(@Qualifier("roomServiceClient") WebClient roomClient) {
		this.roomClient = roomClient;
	}

	@GetMapping
	public Mono<String> rooms() {

		return roomClient.get()
				.uri(this.roomApiPath)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(String.class);

	}
	
}

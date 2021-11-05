package com.linkedin.javacd.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

@Service
public class BasicRoomService implements RoomService {

	private WebClient webClient;
	
	@Value("${service.room.path}")
	private String roomServicePath;

	@Autowired
	public BasicRoomService(@Qualifier("roomServiceClient") WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public ArrayNode list(List<Long> ids) {
		
		String param = ids.stream()
			.map(String::valueOf)
			.collect(Collectors.joining(","));
		

		ArrayNode results = webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path(this.roomServicePath)
						.queryParam("ids", "{ids}")
						.build(param))
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(ArrayNode.class)
				.block();

		return results;
	}
	
}

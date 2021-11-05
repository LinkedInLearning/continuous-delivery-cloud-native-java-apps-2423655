package com.linkedin.javacd.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.node.ArrayNode;

@Service
public class BasicGuestService implements GuestService {

	@Value("${service.guest.path}")
	private String guestServicePath;

	private WebClient webClient;
	
	@Autowired
	public BasicGuestService(@Qualifier("guestServiceClient") WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public ArrayNode list(List<Long> ids) {


		String param = ids.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(","));

		ArrayNode results = webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path(this.guestServicePath)
						.queryParam("ids", "{ids}")
						.build(param))
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(ArrayNode.class)
				.block();

		return results;
	}

}

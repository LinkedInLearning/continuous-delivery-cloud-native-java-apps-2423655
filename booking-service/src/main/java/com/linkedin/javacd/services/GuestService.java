package com.linkedin.javacd.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;

public interface GuestService {
	
		public ArrayNode list(List<Long> ids);
		
}

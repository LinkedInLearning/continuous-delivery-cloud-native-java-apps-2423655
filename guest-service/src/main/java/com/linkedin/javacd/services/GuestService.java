package com.linkedin.javacd.services;

import java.util.List;

import com.linkedin.javacd.entities.Guest;

public interface GuestService {

	
	public List<Guest> list();
	
	public List<Guest> list(List<Long> ids);
	
}

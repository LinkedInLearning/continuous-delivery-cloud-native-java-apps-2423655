package com.linkedin.javacd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.javacd.entities.Guest;
import com.linkedin.javacd.repositories.GuestRepository;

@Service
public class BasicGuestServiceImpl implements GuestService {

	private GuestRepository repository;
	
	@Autowired
	public BasicGuestServiceImpl(GuestRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Guest> list() {
		return this.repository.findAll(); 
	}

	@Override
	public List<Guest> list(List<Long> ids) {
		return this.repository.findAllById(ids); 
	}
	
}

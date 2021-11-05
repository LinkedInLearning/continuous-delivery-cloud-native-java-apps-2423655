package com.linkedin.javacd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.javacd.entities.Room;
import com.linkedin.javacd.repositories.RoomRepository;

@Service
public class BasicRoomInventoryService implements RoomInventoryService {

	private RoomRepository repository;

	private int discount = 0;

	@Autowired
	public BasicRoomInventoryService(RoomRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Room> list() {
		return this.repository.findAll(); 
	}

	@Override
	public List<Room> list(List<Long> ids) {
		return this.repository.findAllById(ids); 
	}
}

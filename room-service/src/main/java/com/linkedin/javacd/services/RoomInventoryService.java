package com.linkedin.javacd.services;

import java.util.List;

import com.linkedin.javacd.entities.Room;

public interface RoomInventoryService {

	public List<Room> list();
	
	public List<Room> list(List<Long> ids);

}

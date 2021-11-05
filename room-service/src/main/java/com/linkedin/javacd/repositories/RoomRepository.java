package com.linkedin.javacd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkedin.javacd.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	public List<Room> findByType(String type);
}

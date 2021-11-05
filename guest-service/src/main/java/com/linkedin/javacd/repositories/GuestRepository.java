package com.linkedin.javacd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkedin.javacd.entities.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

	public List<Guest> findByFirstNameLike(String token);
	
}

package com.linkedin.javacd.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linkedin.javacd.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

	public List<Booking> findByStartDateAfter(Instant start);
	
}

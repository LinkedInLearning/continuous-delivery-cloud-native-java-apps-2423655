package com.linkedin.javacd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.javacd.entities.Booking;
import com.linkedin.javacd.repositories.BookingRepository;

@Service
public class BasicBookingService implements BookingService {

	private BookingRepository bookingRepository;

	@Autowired
	public BasicBookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<Booking> list() {
		return this.bookingRepository.findAll(); 
	}

}

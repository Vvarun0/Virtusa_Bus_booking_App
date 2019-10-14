package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.Booking;
import com.virtusa.travelline.repositories.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(int bookingId) {
		return bookingRepository.findById(bookingId).orElse(null);
	}

	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public boolean deleteBooking(int bookingId) {
		boolean status = false;
		bookingRepository.deleteById(bookingId);
		status = true;
		return status;
	}

	public Booking updateBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	

	
}
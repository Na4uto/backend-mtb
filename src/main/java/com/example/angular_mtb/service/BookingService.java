package com.example.angular_mtb.service;

import java.time.LocalDate;
import java.util.List;

import com.example.angular_mtb.exception.BookingNotFoundException;
import com.example.angular_mtb.model.Booking;

public interface BookingService {
	public Booking addBooking(Booking booking, Integer customerId,Integer showId) throws BookingNotFoundException;

	public List<Booking> viewBookingList() throws BookingNotFoundException;

	public Booking updateBooking(Booking booking) throws BookingNotFoundException;

	public Booking cancelBooking(int bookingid) throws BookingNotFoundException;

	public List<Booking> showAllBookings(int movieid) throws BookingNotFoundException;
	public Booking viewBooking(int bookingid) throws BookingNotFoundException;
	public List<Booking> showAllBookings(LocalDate bookingdate) throws BookingNotFoundException;

	public double calculateTotalCost(int bookingid);
}

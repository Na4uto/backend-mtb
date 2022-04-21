package com.example.angular_mtb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angular_mtb.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}

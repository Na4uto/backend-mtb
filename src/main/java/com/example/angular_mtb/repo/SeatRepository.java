package com.example.angular_mtb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angular_mtb.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

}

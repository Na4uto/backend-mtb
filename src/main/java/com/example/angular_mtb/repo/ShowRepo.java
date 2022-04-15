package com.example.angular_mtb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.angular_mtb.model.Show;

@Repository
public interface ShowRepo extends JpaRepository<Show, Integer> {
//	@Query("select s from Show s where s.theatre.theatreId = :id")
//	List<Show> getAllByTheatreId(@Param("id") int id);
	public Show save(Show show);
}
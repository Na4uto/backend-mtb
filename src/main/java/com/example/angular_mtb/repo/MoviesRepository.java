package com.example.angular_mtb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.angular_mtb.model.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer>{

}

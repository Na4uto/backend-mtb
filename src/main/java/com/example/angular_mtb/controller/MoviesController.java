package com.example.angular_mtb.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular_mtb.exception.MovieNotFoundException;
import com.example.angular_mtb.model.Movies;
import com.example.angular_mtb.service.MoviesService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movies")
public class MoviesController {

	Logger logger = LoggerFactory.getLogger(MoviesController.class);
	@Autowired
	private MoviesService moviesService;

	@PostMapping("/add")
	public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) throws MovieNotFoundException, IOException {
		movie = moviesService.addMovie(movie);
		logger.info("-------Movie Added Successfully---------");
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}

}

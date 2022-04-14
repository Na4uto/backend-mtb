package com.example.angular_mtb.controller;

import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular_mtb.exception.MovieNotFoundException;
import com.example.angular_mtb.model.Show;
import com.example.angular_mtb.service.MoviesService;
import com.example.angular_mtb.service.ShowService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/shows")
public class ShowController {
	Logger logger = LoggerFactory.getLogger(MoviesController.class);
	@Autowired
	private MoviesService moviesService;
	@Autowired
	private ShowService showService;
	
	@PostMapping("/add")
	public ResponseEntity<Show> addMovie(@RequestBody Show show) throws MovieNotFoundException, IOException {
		show = showService.addShow(show);
		logger.info("-------Movie Added Successfully---------");
		return new ResponseEntity<>(show, HttpStatus.CREATED);
	}
}

package com.example.angular_mtb.controller;

import java.io.IOException;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		logger.info("-------Movies Added Successfully---------");
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Movies> updateMovie(@RequestBody Movies movie)
			throws MovieNotFoundException {

		ResponseEntity<Movies> response = null;
		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			movie = moviesService.updateMovie(movie);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			logger.info("-------Movies Updated Successfully---------");
		}
		return response;
	}
	
	@PutMapping("/map")
	public ResponseEntity<Movies> addToShow(@RequestBody Movies movie,@RequestParam(required = false) Integer showId)
			throws MovieNotFoundException {

		ResponseEntity<Movies> response = null;
		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			movie = moviesService.addMovieToShow(movie,showId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			logger.info("-------Movies Updated Successfully---------");
		}
		return response;
	}

	
	
	
	/**
	 * Return's the List of Movies from the Database
	 * 
	 * @return List<Movies>
	 * @throws MovieNotFoundException
	 * @throws AccessForbiddenException
	 */
	@GetMapping("/findall")
	public ResponseEntity<List<Movies>> viewMovieList() throws MovieNotFoundException {

		logger.info("-------Movies List Fetched---------");
		return ResponseEntity.ok(moviesService.viewMovieList());
	}

	/**
	 * Returns the record from the database using identifier - movieId
	 * 
	 * @param movieId
	 * @return Movies
	 * @throws MovieNotFoundException
	 * @throws AccessForbiddenException
	 */
	@GetMapping("/viewMovie/{movieId}")
	public ResponseEntity<Movies> viewMovie(@PathVariable int movieId)
			throws MovieNotFoundException {

		ResponseEntity<Movies> response = null;
		try {
			Movies movie = moviesService.viewMovie(movieId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			logger.info("-------Movies With Movies id " + movieId + " Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new MovieNotFoundException("Movies with " + movieId + " id dosen't exist");
		}
		return response;
		// return ResponseEntity.ok(moviesService.viewMovie(movieId));
	}

	/**
	 * Removes persisted Movies instance from the Database.
	 * 
	 * @param movieId
	 * @return Movies
	 * @throws MovieNotFoundException
	 * @throws AccessForbiddenException
	 */
	@DeleteMapping("/delete/{movieId}")
	public ResponseEntity<Movies> removeMovie(@PathVariable int movieId)
			throws MovieNotFoundException {

		ResponseEntity<Movies> response = null;
		Movies movie = moviesService.viewMovie(movieId);
		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			moviesService.removeMovie(movieId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			logger.info("-------Movies With Movies id " + movieId + " Deleted---------");
		}
		return response;
	}

	/**
	 * Displays List of movies based on the TheatreId.
	 * 
	 * @param theatreId
	 * @return Movies
	 * @throws AccessForbiddenException
	 */
	@GetMapping("/byTheatre/{theatreId}")
	public List<Movies> viewMovieByTheatreId(@PathVariable int theatreId)  {
		logger.info("-------Movies With TheatreId " + theatreId + " Found---------");
		return moviesService.viewMovieList(theatreId);
	}

	/**
	 * Returns the list of Movies based on the Date.
	 * 
	 * @param date
	 * @return Movies
	 * @throws AccessForbiddenException
	 */
	@GetMapping("/byDate/{date}")
	public List<Movies> viewMovieByLocalDate(
			@RequestParam("movieDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		logger.info("-------Movies With Date " + date + " Found---------");
		return moviesService.viewMovieList(date);
	}

}




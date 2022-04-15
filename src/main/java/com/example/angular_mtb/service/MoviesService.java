package com.example.angular_mtb.service;

import java.time.LocalDate;
import java.util.List;

import com.example.angular_mtb.exception.MovieNotFoundException;
import com.example.angular_mtb.model.Movies;
import com.example.angular_mtb.model.Show;

public interface MoviesService {

	public Movies addMovie(Movies movie) throws MovieNotFoundException;

	
	public Movies removeMovie(int movieid) throws MovieNotFoundException;
	
	public Movies updateMovie(Movies movie) throws MovieNotFoundException;
	
	public Movies addMovieToShow(Movies movie, Integer showId) throws MovieNotFoundException;

	public Movies viewMovie(int movieid) throws MovieNotFoundException;

	public List<Movies> viewMovieList() throws MovieNotFoundException;

	public List<Movies> viewMovieList(int theatreid);

	public List<Movies> viewMovieList(LocalDate date);


}

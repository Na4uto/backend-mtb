package com.example.angular_mtb.service;

import com.example.angular_mtb.exception.MovieNotFoundException;
import com.example.angular_mtb.model.Movies;

public interface MoviesService {

	public Movies addMovie(Movies movie) throws MovieNotFoundException;
}

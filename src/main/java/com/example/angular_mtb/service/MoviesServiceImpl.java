package com.example.angular_mtb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_mtb.exception.MovieNotFoundException;
import com.example.angular_mtb.model.Movies;
import com.example.angular_mtb.repo.MoviesRepository;



@Service
public class MoviesServiceImpl implements MoviesService{
	 
	@Autowired
	private MoviesRepository moviesrepository;
	
	
	@Override
	public Movies addMovie(Movies movie) throws MovieNotFoundException {
		if (movie != null) {
			if (moviesrepository.existsById(movie.getMovieId())) {
				throw new MovieNotFoundException("Movie with this id already exists");
			} else {
				
				moviesrepository.saveAndFlush(movie);
			}
		}
		return movie;
	}
}

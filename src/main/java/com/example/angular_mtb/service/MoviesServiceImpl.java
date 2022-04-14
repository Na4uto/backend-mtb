package com.example.angular_mtb.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_mtb.exception.MovieNotFoundException;
import com.example.angular_mtb.model.Movies;
import com.example.angular_mtb.model.Show;
import com.example.angular_mtb.repo.MoviesRepository;
import com.example.angular_mtb.repo.ShowRepo;



@Service
public class MoviesServiceImpl implements MoviesService{
	 
	@Autowired
	private MoviesRepository moviesrepository;
	
	@Autowired
	private ShowRepo showsrepository;
	
	
	@Override
	public Movies addMovie(Movies movie) throws MovieNotFoundException {
		if (movie != null) {
			if (moviesrepository.existsById(movie.getId())) {
				throw new MovieNotFoundException("Movies with this id already exists");
			} else {
				
				moviesrepository.saveAndFlush(movie);
			}
		}
		return movie;
	}
	
	
	
	@Override
	public Movies removeMovie(int movieid) {
		Movies m = moviesrepository.findById(movieid).get();
		List<Show> shows = showsrepository.findAll();
		for (Show show : shows) {
			if (show.getMovie()!=null && show.getMovie().getId() == movieid) {
				show.setMovie(null);
			}
		}
		moviesrepository.delete(m);
		return m;
	}
	
	@Override
	public Movies updateMovie(Movies movie) {
		moviesrepository.saveAndFlush(movie);
		return moviesrepository.getOne(movie.getId());
	}
	
	@Override
	public Movies addMovieToShow(Movies movie,Integer showId) {
		Show show=new Show();
		if (showId != null) {
			show = showsrepository.getOne(showId);
			Set<Show> showlist= new HashSet<>();
			showlist.add(show);
			movie.setShows(showlist);
		}
		moviesrepository.saveAndFlush(movie);
		return moviesrepository.getOne(movie.getId());
	}

	@Override
	public Movies viewMovie(int movieid) {
		return moviesrepository.findById(movieid).get();
	}

	@Override
	public List<Movies> viewMovieList() throws MovieNotFoundException {
		List<Movies> ml = moviesrepository.findAll();
		//if (ml.size() == 0) throw new MovieNotFoundException("Movies dosen't exist");
		return ml;
	}

//	@Override
//	public List<Movies> viewMovieList(int theatreid) {
//		List<Movies> movies = new ArrayList<>();
//		List<Show> shows = showsrepository.findAll();
//		Set<Integer> showIds = new HashSet<>();
//		for (Show s : shows) {
//			if (s.getTheatre().getTheatreId() == theatreid) {
//				showIds.add(s.getShowId());
//			}
//		}
//		for (Integer id : showIds) {
//			movies.add(showsrepository.getOne(id).getMovie());
//		}
//		return movies;
//	}

	@Override
	public List<Movies> viewMovieList(LocalDate date) {
		List<Movies> mvList = new ArrayList<>();
		for (Movies movie : moviesrepository.findAll()) {
			if (movie.getMovieDate() != null && movie.getMovieDate().isEqual(date)) {
				mvList.add(movie);
			}
		}
		return mvList;
	}



	@Override
	public List<Movies> viewMovieList(int theatreid) {
		// TODO Auto-generated method stub
		return null;
	}


}

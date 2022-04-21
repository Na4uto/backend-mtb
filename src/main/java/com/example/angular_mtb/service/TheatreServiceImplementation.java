package com.example.angular_mtb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_mtb.exception.TheatreNotFoundException;
import com.example.angular_mtb.model.Movies;
import com.example.angular_mtb.model.Show;
import com.example.angular_mtb.model.Theatre;
import com.example.angular_mtb.repo.MoviesRepository;
import com.example.angular_mtb.repo.ScreenRepository;
import com.example.angular_mtb.repo.TheatreRepository;

@Service
public class TheatreServiceImplementation implements TheatreService {
	@Autowired
	private TheatreRepository theatrerepository;
	@Autowired
	ScreenRepository screenRepository;
	@Autowired
	private MoviesRepository moviesrepository;

	@Override
	public List<Theatre> getAllTheatres() throws TheatreNotFoundException {
		List<Theatre> the = theatrerepository.findAll();
		//if (the.size() == 0) throw new TheatreNotFoundException("No theatres found");
		return the;
	}

	@Override
	public Theatre findTheatres(int theatreId) {
		// TODO Auto-generated method stub
		if (theatrerepository.findById(theatreId).isPresent()) {
			return theatrerepository.findById(theatreId).get();
		} else
			return null;
	}

	@Override
	public Theatre addTheatre(Theatre m) throws TheatreNotFoundException {
		if (m != null) {
			if (theatrerepository.existsById(m.getTheatreId())) {
				throw new TheatreNotFoundException("Theatre already exists");
			} else {
				theatrerepository.saveAndFlush(m);
			}
		}
		return m;
	}

	@Override
	public List<Theatre> updateTheatre(Theatre m) {
		// TODO Auto-generated method stub
		theatrerepository.saveAndFlush(m);
		return theatrerepository.findAll();
	}

	@Override
	public List<Theatre> deleteTheatreById(int theatreId) {
		// TODO Auto-generated method stub
		theatrerepository.deleteById(theatreId);
		return theatrerepository.findAll();
	}

	@Override
	public List<Theatre> findTheatresByMovie(Integer movieId) throws TheatreNotFoundException {
		List<Theatre> theatreList=new ArrayList<>();
		Movies movie=moviesrepository.findById(movieId).get();
		Set<Show> shows=movie.getShows();
	
		for(Show s:shows) {
			theatreList.add(s.getTheatre());
		}
		
		return theatreList;
	}
}
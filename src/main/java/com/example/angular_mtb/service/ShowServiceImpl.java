package com.example.angular_mtb.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_mtb.model.Screen;
import com.example.angular_mtb.model.Show;

import com.example.angular_mtb.model.Theatre;

import com.example.angular_mtb.repo.ScreenRepository;
import com.example.angular_mtb.repo.ShowRepo;
import com.example.angular_mtb.repo.TheatreRepository;

@Service
public class ShowServiceImpl implements ShowService{
	
	@Autowired
	private ShowRepo showrepository;
	@Autowired
	private TheatreRepository theatreRepository;
	@Autowired
	private ScreenRepository screenRepository;

	@Override
	public Show addShow(Show show)  {
		if (show != null) {
				showrepository.saveAndFlush(show);
		}
		return show;
	}
	
	@Override
	public Show updateShow(Show show, Integer theatreId, Integer screenId) {
		Theatre theatre = new Theatre();
		Screen screen = new Screen();
		if (theatreId != null) {
			theatre = theatreRepository.getOne(theatreId);
			show.setTheatre(theatre);
		}
		if (screenId != null) {
			screen = screenRepository.getOne(screenId);
			show.setScreen(screen);
		}
		showrepository.saveAndFlush(show);
		return show;
	}
	
	@Override
	public Show removeShow(int showid) {
		Show s = showrepository.findById(showid).get();
		showrepository.delete(s);
		return s;
	}

	@Override
	public Show viewShow(int showid) {
		return showrepository.findById(showid).get();
	}

	@Override
	public List<Show> viewAllShows() {
		return showrepository.findAll();
	}

//	@Override
//	public List<Show> viewShowList(int theatreid) {
//		return showrepository.getAllByTheatreId(theatreid);
//		// return null;
//	}

	@Override
	public List<Show> viewShowList(LocalDate date) {
		List<Show> shList = new ArrayList<>();
		for (Show show : showrepository.findAll()) {
			if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
				shList.add(show);
			}
		}
		return shList;
	}

	@Override
	public List<Show> viewShowList(int theatreid) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Show updateShow(Show show, Integer theatreId, Integer screenId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

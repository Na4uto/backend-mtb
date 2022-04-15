package com.example.angular_mtb.service;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> b5a1c8d4cc7186660cf08f13a102cc1a76aac005
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_mtb.exception.ScreenNotFoundException;
import com.example.angular_mtb.model.Screen;
import com.example.angular_mtb.model.Theatre;
import com.example.angular_mtb.repo.ScreenRepository;
import com.example.angular_mtb.repo.TheatreRepository;

<<<<<<< HEAD
=======

>>>>>>> b5a1c8d4cc7186660cf08f13a102cc1a76aac005
@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	private ScreenRepository screenRepository;
	@Autowired
	private TheatreRepository theatreRepository;

	@Override
	public List<Screen> viewScreenList() throws ScreenNotFoundException {
		List<Screen> screen = screenRepository.findAll();
		if (screen.size() == 0)
			throw new ScreenNotFoundException("No screens found");
		return screen;
	}

	/**
	 * @return screen
	 */
	@Override
	public Screen addScreen(Screen screen, Integer theatreId) throws ScreenNotFoundException {
		Theatre theatre = new Theatre();
		if (theatreId != null) {
			if (screenRepository.existsById(screen.getScreenId())) {
				throw new ScreenNotFoundException("Screen already exists");
			} else {
				theatre = theatreRepository.getOne(theatreId);
				screen.setTheatre(theatre);
			}
			screenRepository.saveAndFlush(screen);
		}
		return screen;
	}
	@Override
	public Screen viewScreen(int screenId) throws ScreenNotFoundException {
		return screenRepository.findById(screenId).get();
		}
<<<<<<< HEAD
	
=======
	/**
	 * @return updatedScreen
	 */
>>>>>>> b5a1c8d4cc7186660cf08f13a102cc1a76aac005
	@Override
	public Screen updateScreen(Screen screen, Integer theatreId) {
		Theatre theatre = new Theatre();
		if (theatreId != null) {
			theatre = theatreRepository.getOne(theatreId);
			screen.setTheatre(theatre);
		}
		screenRepository.saveAndFlush(screen);
		return screen;
	}

	@Override
	public Theatre getTheatre(int screenId) throws ScreenNotFoundException {
		Screen screen =screenRepository.findById(screenId).get();
		Theatre theatre=screen.getTheatre();
		return theatre;
	}

<<<<<<< HEAD
=======

>>>>>>> b5a1c8d4cc7186660cf08f13a102cc1a76aac005
}

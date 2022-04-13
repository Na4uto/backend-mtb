package com.example.angular_mtb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular_mtb.model.Theatre;
import com.example.angular_mtb.controller.ScreenController;
import com.example.angular_mtb.exception.ScreenNotFoundException;
import com.example.angular_mtb.model.Screen;
import com.example.angular_mtb.service.ScreenService;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/screens")
public class ScreenController {
	
	Logger logger = LoggerFactory.getLogger(ScreenController.class);

	@Autowired
	private ScreenService screenService;
	
	@PostMapping("/add")
	public ResponseEntity<Screen> addAScreen(@RequestBody Screen screen,
			@RequestParam(required = false) Integer theatreId)
			throws ScreenNotFoundException {
		
		logger.info("-------Screen Successfully added into Theatre " + theatreId + "---------");
		return ResponseEntity.ok(screenService.addScreen(screen, theatreId));
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<Screen>> viewScreenList() throws  ScreenNotFoundException {

		logger.info("-------List Of Screens Fetched Successfully---------");
		return ResponseEntity.ok(screenService.viewScreenList());
	}
	
	@GetMapping("/theatre/{screenId}")
	public ResponseEntity<Theatre>  getTheatreById(@PathVariable int screenId) throws ScreenNotFoundException {
		ResponseEntity<Theatre> response = null;
		try {
			Theatre theatre = screenService.getTheatre(screenId);
			response = new ResponseEntity<>(theatre, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping("/viewScreen/{screenId}")
	public ResponseEntity<Screen> viewScreen(@PathVariable int screenId)
			throws ScreenNotFoundException {
		ResponseEntity<Screen> response = null;
		try {
			Screen screen = screenService.viewScreen(screenId);
			response = new ResponseEntity<>(screen, HttpStatus.OK);
			logger.info("-------Screen Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new ScreenNotFoundException("Screen dosen't exist");
		}
		return response;
	}
	
}

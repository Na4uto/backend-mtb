package com.example.angular_mtb.controller;

import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular_mtb.exception.UserNotFoundException;
//import com.example.angular_mtb.model.Login;
import com.example.angular_mtb.model.User;
import com.example.angular_mtb.repo.UserRepo;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@PersistenceContext
	EntityManager eManager;
	@Autowired
	private UserRepo repo;

	@PostMapping("/user")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return ResponseEntity.ok(repo.save(user));
	}

//	@PostMapping("/login/{username}/{password}")
//	public Login loginUser(@PathVariable String username, @PathVariable String password) throws Exception {
//		return loginWithData(username, password);
//	}
//
//	public Login loginWithData(String username, String password) throws Exception {
//		User user = findByUserName(username);
//		if (!user.getPassword().equals(password))
//			throw new Exception("Login Data Invalid");
//
//		Login logData = new Login();
//		logData.setLoginStatus(true);
//		logData.setUser(user);
//		return logData;
//	}

	public User findByUserName(String username) throws UserNotFoundException {
		TypedQuery<User> qry = eManager.createQuery("select u from User u where u.name like :name", User.class);
		qry.setParameter("name", username);
		List<User> user = qry.getResultList();
		if (user.size() == 0)
			throw new UserNotFoundException("User Not Available !!");
		return user.get(0);
	}

}

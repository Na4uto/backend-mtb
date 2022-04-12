package com.example.angular_mtb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angular_mtb.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	

//User save(User user);

}

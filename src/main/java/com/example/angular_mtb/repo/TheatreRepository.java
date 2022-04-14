package com.example.angular_mtb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angular_mtb.model.Theatre;


@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}

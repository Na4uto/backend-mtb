package com.example.angular_mtb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Movies")
@DynamicUpdate
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String movieName;
	private String movieGenre;
	private String movieHours;
	private String movieLanguage;
	private String movieDescription;
	private String movieRating;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieHours() {
		return movieHours;
	}
	public void setMovieHours(String movieHours) {
		this.movieHours = movieHours;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public String getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}
	public Movies(int movieId, String movieName, String movieGenre, String movieHours, String movieLanguage,
			String movieDescription, String movieRating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieHours = movieHours;
		this.movieLanguage = movieLanguage;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
	}
	public Movies() {
		super();
	}
	
	
}

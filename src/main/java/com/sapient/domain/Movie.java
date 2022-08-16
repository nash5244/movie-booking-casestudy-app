package com.sapient.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private	int movieId;
	private String movieName;
	@Enumerated( EnumType.STRING)
	private Genre genre;
	private int duration;

	private String language;


	@OneToMany(mappedBy = "movie",orphanRemoval = true)
	@JsonManagedReference(value = "show_movie")
	private List<Show> show;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId( int p_movieId ) {
		movieId = p_movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName( String p_movieName ) {
		movieName = p_movieName;
	}



	public Genre getGenre() {
		return genre;
	}

	public void setGenre( Genre p_genre ) {
		genre = p_genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration( int p_duration ) {
		duration = p_duration;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage( String p_language ) {
		language = p_language;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow( List<Show> p_show ) {
		show = p_show;
	}
}

package com.sapient.domain;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="theatre")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	@JsonBackReference(value = "theatre_seat")
	private City city;

	@OneToMany( mappedBy = "theatre" , orphanRemoval = true)
	@JsonManagedReference(value = "show_theatre")
	private List<Show> shows;

	@OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference(value = "theatre_seat")
	private List<TheatreSeat> theatreSeats;

//	@OneToMany(mappedBy = "theatre" )
//	private List<Auditorium> auditoriums;

	public int getId() {
		return id;
	}

	public void setId( int p_id ) {
		id = p_id;
	}
	public String getName() {
		return name;
	}


	public void setName( String p_name ) {
		name = p_name;
	}

	public City getCity() {
		return city;
	}

	public void setCity( City p_city ) {
		city = p_city;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows( List<Show> p_shows ) {
		shows = p_shows;
	}

	public List<TheatreSeat> getTheatreSeats() {
		return theatreSeats;
	}

	public void setTheatreSeats( List<TheatreSeat> p_theatreSeats ) {
		theatreSeats = p_theatreSeats;
	}

	//	public List<Auditorium> getAuditoriums() {
//		return auditoriums;
//	}
//
//	public void setAuditoriums( List<Auditorium> p_auditoriums ) {
//		auditoriums = p_auditoriums;
//	}
}

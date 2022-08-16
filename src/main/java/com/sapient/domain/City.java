package com.sapient.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class City {

	@Id
	@GeneratedValue
	@Column(name = "cityId")
	private int cityId;
	private String name;
	private String state;
	private int zipcode;

	@OneToMany(mappedBy = "city")
	@JsonManagedReference(value = "theatre_seat")
	private List<Theatre> theatres;

	public String getName() {
		return name;
	}

	public void setName( String p_name ) {
		name = p_name;
	}

	public String getState() {
		return state;
	}

	public void setState( String p_state ) {
		state = p_state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode( int p_zipcode ) {
		zipcode = p_zipcode;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId( int p_cityId ) {
		cityId = p_cityId;
	}

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres( List<Theatre> p_theatres ) {
		theatres = p_theatres;
	}
}

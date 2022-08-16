package com.sapient.domain;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showId;
	@Temporal( TemporalType.DATE )
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date showDate;
	private String startTime;
	private int duration;
//	@ManyToOne
//	@JoinColumn(name = "audi_id")
//	private Auditorium auditorium;

	@ManyToOne
	@JoinColumn( foreignKey = @ForeignKey(name = "theatre_id"), name = "theatre_id")
	@JsonBackReference(value = "show_theatre")
	public Theatre theatre;

	@ManyToOne
	@JoinColumn( foreignKey = @ForeignKey(name = "movie_id"), name = "movie_id")
	@JsonBackReference(value = "show_movie")
	private Movie movie;

	@OneToMany(mappedBy = "show", orphanRemoval = true)
	private List<ShowSeat> seats;


	public int getShowId() {
		return showId;
	}

	public void setShowId( int p_showId ) {
		showId = p_showId;
	}



	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate( Date p_showDate ) {
		showDate = p_showDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration( int p_duration ) {
		duration = p_duration;
	}



//	public Auditorium getAuditorium() {
//		return auditorium;
//	}
//
//	public void setAuditorium( Auditorium p_auditorium ) {
//		auditorium = p_auditorium;
//	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie( Movie p_movie ) {
		movie = p_movie;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre( Theatre p_theatre ) {
		theatre = p_theatre;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime( String p_startTime ) {
		startTime = p_startTime;
	}


}

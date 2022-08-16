package com.sapient.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ShowSeat {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE  )
	private int showSeatId;
	private Status seatStatus;
	@OneToOne
	@JoinColumn(name = "theatre_seat_id",referencedColumnName = "seatNumber")
	@JsonManagedReference(value = "show_theatre_seat_reference")
	private TheatreSeat theatreSeat;


	@ManyToOne
	@JoinColumn(name = "show_id")
	private Show show;



	public TheatreSeat getTheatreSeat() {
		return theatreSeat;
	}

	public void setTheatreSeat( TheatreSeat p_theatreSeat ) {
		theatreSeat = p_theatreSeat;
	}
}

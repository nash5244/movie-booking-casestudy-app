package com.sapient.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TheatreSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int seatNumber;
	private SeatType type;

	@ManyToOne
	@JoinColumn
	@JsonBackReference(value = "theatre_seat")
	private Theatre theatre;

	@OneToOne(mappedBy = "theatreSeat")
	@Cascade( {CascadeType.DELETE} )
	@JsonBackReference(value = "show_theatre_seat_reference")
	private ShowSeat showSeat;



	public SeatType getType() {
		return type;
	}

	public void setType( SeatType p_type ) {
		type = p_type;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber( int p_seatNumber ) {
		seatNumber = p_seatNumber;
	}
}

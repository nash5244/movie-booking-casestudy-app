//package com.sapient.domain;
//
//import java.util.List;
//import java.util.Set;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Auditorium {
//	@Id
//	@GeneratedValue
//	private int id;
//
//	@ManyToOne
//	@JoinColumn(name = "theatre_id")
//	private Theatre theatre;
//
//	@OneToMany(mappedBy = "auditorium")
//	private List<Show> shows;
//
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId( int p_id ) {
//		id = p_id;
//	}
//
//	public Theatre getTheatre() {
//		return theatre;
//	}
//
//	public void setTheatre( Theatre p_theatre ) {
//		theatre = p_theatre;
//	}
//
////	public Set<Seat> getSeats() {
////		return seats;
////	}
////
////	public void setSeats( Set<Seat> p_seats ) {
////		seats = p_seats;
////	}
//}

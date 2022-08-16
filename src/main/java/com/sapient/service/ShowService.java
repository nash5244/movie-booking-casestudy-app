package com.sapient.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.sapient.dao.ShowRepository;
import com.sapient.domain.Show;

@Component
public class ShowService {

	@Autowired
	private ShowRepository showRepository;


	public Show saveShow( Show p_show ) {
		return showRepository.save( p_show );
	}
	public List<Show> saveShows( List<Show> p_shows ) {
		return showRepository.saveAll( p_shows );
	}

	public void deleteShow( int showId ) {
		showRepository.deleteById(showId);
	}

	public Show updateShow( int showId,Show p_show ) {
		Show show = showRepository.findById( showId ).orElseThrow( () -> new EntityNotFoundException() );
		show.setDuration( p_show.getDuration() );
		show.setMovie( p_show.getMovie() );
		show.setStartTime( p_show.getStartTime() );
		show.setShowDate( p_show.getShowDate() );
		show.setTheatre( p_show.getTheatre() );
		return showRepository.save( show );
	}


}

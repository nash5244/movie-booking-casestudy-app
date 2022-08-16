package com.sapient.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sapient.dao.ShowRepository;
import com.sapient.dao.TheatreRepository;
import com.sapient.domain.Show;
import com.sapient.domain.Theatre;

@Component
public class TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;
	@Autowired
	private ShowRepository showRepository;
	private List<Theatre> theatresList = new ArrayList<>();

	public List<Theatre> getTheatresList( int p_movieid, Date p_date, int p_cityId) {

		return theatreRepository.getTheatresList(p_cityId,p_movieid,p_date);
	}

	public List<Theatre> insertTheatres( List<Theatre> p_theatreList ) {

		return theatreRepository.saveAll( p_theatreList );
	}
}

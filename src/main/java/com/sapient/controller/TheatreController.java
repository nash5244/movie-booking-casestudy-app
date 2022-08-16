package com.sapient.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.sapient.dao.TheatreRepository;
import com.sapient.domain.Show;
import com.sapient.domain.Theatre;
import com.sapient.service.TheatreService;

@RestController
@RequestMapping(path = "/api/{cityid}/theatres")
public class TheatreController {

	@Autowired
	private TheatreService theatreService;

	@GetMapping("/{movieId}")
	public ResponseEntity<List<Theatre>> getTheatresList(@PathVariable(value = "movieId") int movieId,  @RequestParam(value = "showDate") String
		date, @PathVariable int cityid )
		throws ParseException {
		SimpleDateFormat formatter=new SimpleDateFormat( "dd-MM-yyyy");
		Date showDate = formatter.parse( date );
		List<Theatre> l_list = theatreService.getTheatresList( movieId, showDate, cityid );
		if(l_list.isEmpty()){
			throw new EntityNotFoundException("No Matching theatre/shows found");
		}
		return  ResponseEntity.ok(l_list);
	}

	@PostMapping
	public ResponseEntity<List<Theatre>> insert( @RequestBody List<Theatre> p_theatreList ){
	try {
		return new ResponseEntity<>( theatreService.insertTheatres(p_theatreList), HttpStatus.OK);
	}catch ( Exception ex){
		throw new RuntimeException("Unable to insert Theatre record in db");
	}


	}


}

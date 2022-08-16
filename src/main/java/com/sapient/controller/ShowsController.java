package com.sapient.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.dao.ShowRepository;
import com.sapient.domain.Show;
import com.sapient.service.ShowService;

@RestController
@RequestMapping(path = "/api/theatre/{theatreid}/shows")
public class ShowsController {

	@Autowired
	private ShowService showService;

	/**
	 * @param theatreid
	 * @param shows
	 * @return
	 * Save shows list
	 */
	@PostMapping
	public ResponseEntity<List<Show>> createShows( @PathVariable int theatreid, @RequestBody List<Show> shows ) {
		try {
			List<Show> l_showList = showService.saveShows( shows );
			return new ResponseEntity<>( l_showList, HttpStatus.OK );
		}
		catch ( Exception ex ) {
			return new ResponseEntity<>( null, HttpStatus.INTERNAL_SERVER_ERROR );

		}
	}


	/**
	 * @param showId
	 * @return
	 * Delete a show
	 */
	@DeleteMapping("/{showid}")
	public ResponseEntity<HttpStatus> deleteShow( @PathVariable(value = "showid") int showId ){
		try {
			showService.deleteShow(showId);
		} catch(Exception ex){
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
		}
		return new ResponseEntity<>( HttpStatus.OK );

	}

	@PutMapping("/{showid}")
	public ResponseEntity<Show> updateShow(@PathVariable(value = "showid") int showId,@RequestBody Show show){
		return new ResponseEntity<> (showService.updateShow(showId,show),HttpStatus.OK);
	}




}

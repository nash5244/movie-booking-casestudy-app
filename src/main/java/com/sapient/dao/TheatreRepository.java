package com.sapient.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sapient.domain.Show;
import com.sapient.domain.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
	@Query( value =  "SELECT T FROM Theatre T, Show S  WHERE T.id = S.theatre.id and T.city.cityId = ?1"
					  +" and S.showDate = ?3 and S.movie.movieId = ?2")
	public List<Theatre> getTheatresList( int cityId, int movieId, Date showDate);

}

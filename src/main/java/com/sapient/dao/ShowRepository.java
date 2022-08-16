package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sapient.domain.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {

//	@Modifying
//	@Query("Update Show set showDate")
//	public Show updateShowDetails()

}

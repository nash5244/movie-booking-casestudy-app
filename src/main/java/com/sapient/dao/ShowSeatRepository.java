package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sapient.domain.ShowSeat;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {


}

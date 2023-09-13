package com.deep.mb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.deep.mb.entity.ActorMovieMapping;

@Repository
public interface ActorMovieMappingDAO extends JpaRepository<ActorMovieMapping,Integer>{

	public List<ActorMovieMapping> getActorMovieData(String searchVal);
	
}

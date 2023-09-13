package com.deep.mb.service;

import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorMovieMappingService {
	public String getActorMovieMappingTSVData();
	
	public Map<String,Object> getActorMovieData(String searchVal);
}

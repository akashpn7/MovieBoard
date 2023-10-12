package com.deep.mb.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.deep.mb.entity.Actor;

@Repository
public interface ActorService {
	public String saveActorTSVData(String request);
	
	public List<Actor> getActorByName(String searchVal);
}

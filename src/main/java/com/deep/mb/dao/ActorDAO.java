package com.deep.mb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deep.mb.entity.Actor;

@Repository
public interface ActorDAO extends JpaRepository<Actor,Integer> {

public List<Actor> getActorByName(String searchVal);

public List<Actor> getActorByNconst(String nconst);
	
}

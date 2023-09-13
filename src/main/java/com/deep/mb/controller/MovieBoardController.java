package com.deep.mb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import com.deep.mb.entity.Actor;
import com.deep.mb.service.ActorMovieMappingService;
import com.deep.mb.service.ActorService;
import com.deep.mb.service.MovieService;

@RestController
@RequestMapping("/task")
public class MovieBoardController {

	@Autowired
	ActorService actorService;

	@Autowired
	MovieService movieService;

	@Autowired
	ActorMovieMappingService actorMovieMappingService;

	@GetMapping("/saveActors")
	public String getActors() {
		String response = actorService.getActorTSVData();
		return response;
	}

	@GetMapping("/saveMovies")
	public String getMovies() {
		String response = movieService.getMovieTSVData();
		return response;
	}

	@GetMapping("/saveActorMovieMapping")
	public String getActorMovieMapping() {
		String response = actorMovieMappingService.getActorMovieMappingTSVData();
		return response;
	}

	@GetMapping("/getActorByName")
	public List<Actor> getActorByName(@RequestParam("search") String searchVal) {
		List<Actor> actor = actorService.getActorByName(searchVal);
		return actor;
	}

	@GetMapping("/getActorMovie")
	public Map<String, Object> getActorMovieData(@RequestParam("search") String searchVal) {
		Map<String, Object> actorMovie = actorMovieMappingService.getActorMovieData(searchVal);
		return actorMovie;
	}

}

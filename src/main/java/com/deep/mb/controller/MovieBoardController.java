package com.deep.mb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/saveActors")
	public String getActors(@RequestBody String request) {
		String response = actorService.saveActorTSVData(request);
		return response;
	}

	@PostMapping("/saveMovies")
	public String getMovies(@RequestBody String request) {
		String response = movieService.saveMovieTSVData(request);
		return response;
	}

	@PostMapping("/saveActorMovieMapping")
	public String getActorMovieMapping(@RequestBody String request) {
		String response = actorMovieMappingService.saveActorMovieMappingTSVData(request);
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

package com.deep.mb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deep.mb.dao.ActorDAO;
import com.deep.mb.dao.ActorMovieMappingDAO;
import com.deep.mb.dao.MovieDAO;
import com.deep.mb.entity.Actor;
import com.deep.mb.entity.ActorMovieMapping;
import com.deep.mb.entity.Movie;
import com.deep.mb.service.ActorMovieMappingService;
import com.deep.mb.utility.ParseTSVFile;

@Service
public class ActorMovieMappingServiceImpl implements ActorMovieMappingService {

	@Autowired
	ParseTSVFile parseTSV;

	@Autowired
	ActorMovieMappingDAO actorMovieMappingDAO;

	@Autowired
	ActorDAO actorDAO;

	@Autowired
	MovieDAO movieDAO;

	public String getActorMovieMappingTSVData() {
		try {
			String relationDataFile = ".\\datalib\\title.principals.tsv.gz";
			List<String[]> arr = new ArrayList<String[]>();
			arr = parseTSV.readLinesFromGZ(relationDataFile);
			List<ActorMovieMapping> actorMovieList = new ArrayList<ActorMovieMapping>();
			int i = 1;
			for (String[] arrs : arr) {

				String[] element = arrs;
				try {
					ActorMovieMapping actorMovie = ActorMovieMapping.builder().id(i++).tconst(element[0])
							.ordering(element[1]).nconst(element[2]).category(element[3]).job(element[4])
							.characters(element[5]).build();

					actorMovieList.add(actorMovie);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			actorMovieMappingDAO.saveAll(actorMovieList);
			return "success";
		} catch (Exception e) {
			return "failure";
		}
	}

	public Map<String, Object> getActorMovieData(String searchVal) {
		List<Actor> actor = actorDAO.getActorByNconst(searchVal);
		String movieTitles = "";
		for (Actor act : actor) {
			movieTitles = act.getKnownForTitles();
			System.out.println("Movie Titles :" + movieTitles);
		}
		String[] res = movieTitles.split("[,]", 0);
		String titles = "";
		for (String tit : res) {
			titles = titles + "'" + tit + "',";
		}
		titles = titles.substring(0, titles.length() - 1);
		List<Movie> movie = movieDAO.getMovieByTConst(titles);
		Map<String, Object> map = new HashMap<>();
		map.put("Actor", actor);
		map.put("Movie", movie);
		return map;
	}

}

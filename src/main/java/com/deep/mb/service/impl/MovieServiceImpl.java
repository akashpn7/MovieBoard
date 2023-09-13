package com.deep.mb.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deep.mb.dao.MovieDAO;
import com.deep.mb.entity.Movie;
import com.deep.mb.service.MovieService;
import com.deep.mb.utility.ParseTSVFile;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	ParseTSVFile tsvParse;

	@Autowired
	MovieDAO movieDAO;

	public String getMovieTSVData() {

		try {
			String movieDataFile = ".\\datalib\\title.basics.tsv.gz";
			List<String[]> arr = new ArrayList<String[]>();
			arr = tsvParse.readLinesFromGZ(movieDataFile);
			List<Movie> movieList = new ArrayList<Movie>();
			int i = 1;
			for (String[] arrs : arr) {

				String[] element = arrs;
				try {
					Movie movie = Movie.builder().id(i++).tconst(element[0]).titleType(element[1])
							.primaryTitle(element[2]).originalTitle(element[3]).isAdult(element[4])
							.startYear(element[5]).endYear(element[6]).runtimeMinutes(element[7]).genres(element[8])
							.build();

					movieList.add(movie);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			movieDAO.saveAll(movieList);
			return "success";
		} catch (Exception e) {
			return "failure";
		}

	}
}

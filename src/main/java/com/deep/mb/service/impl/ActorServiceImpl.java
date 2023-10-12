package com.deep.mb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.deep.mb.dao.ActorDAO;
import com.deep.mb.entity.Actor;
import com.deep.mb.service.ActorService;
import com.deep.mb.utility.ParseTSVFile;
import com.deep.mb.utility.impl.ParseTSVFileImpl;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {

	@Autowired
	ParseTSVFile tsvParse;

	@Autowired
	ActorDAO actorDAO;

	public String saveActorTSVData(String request) {

		try {
			//String actorDataFile="/Users/a21093/akash_n7/Spring boot/MovieBoard/datalib/name.basics.tsv.gz";
			//String actorDataFile = ".\\datalib\\name.basics.tsv.gz";
			JSONObject obj = new JSONObject(request);
			String actorDataFile=obj.getString("actorDataFile");
			List<String[]> arr = new ArrayList<String[]>();
			arr = new ParseTSVFileImpl().readLinesFromGZ(actorDataFile);
			List<Actor> actorList = new ArrayList<Actor>();
			int i = 1;
			for (String[] arrs : arr) {
				String[] element = arrs;
				try {
					Actor actor = Actor.builder().id(i++).cconst(element[0]).birthYear(element[2]).deathYear(element[3])
							.primaryName(element[1]).primaryProfession(element[4]).knownForTitles(element[5]).build();
					actorList.add(actor);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			actorDAO.saveAll(actorList);
			return "success";
		} catch (Exception e) {
			return "failure";
		}
	}

	public List<Actor> getActorByName(String searchVal) {
		List<Actor> actorList = actorDAO.getActorByName(searchVal);
		return actorList;
	}

}

package com.deep.mb.service;

import org.springframework.stereotype.Repository;

@Repository
public interface MovieService {
	public String saveMovieTSVData(String request);
}

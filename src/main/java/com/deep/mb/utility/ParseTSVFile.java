package com.deep.mb.utility;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ParseTSVFile {
	public List<String[]> readLinesFromGZ(String filePath);
}

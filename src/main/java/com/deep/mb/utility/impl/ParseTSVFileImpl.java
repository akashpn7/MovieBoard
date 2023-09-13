package com.deep.mb.utility.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.springframework.stereotype.Service;
import com.deep.mb.utility.ParseTSVFile;

@Service
public class ParseTSVFileImpl implements ParseTSVFile {

	public List<String[]> readLinesFromGZ(String filePath) {
		List<String[]> lines = new ArrayList<>();
		File file = new File(filePath);
		try {
			GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(file));
			BufferedReader br = new BufferedReader(new InputStreamReader(gzip));

			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] lineItems = line.split("\t"); // Splitting the line and adding its items in String[]
				if (i != 0) {
					lines.add(lineItems);
				}
				i++;
				if (i == 21) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
		return lines;
	}

}

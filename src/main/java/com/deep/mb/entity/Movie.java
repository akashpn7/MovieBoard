package com.deep.mb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@Column
	private int Id;
	@Column
	private String tconst;
	@Column
	private String titleType;
	@Column
	private String primaryTitle;
	@Column
	private String originalTitle;
	@Column
	private String isAdult;
	@Column
	private String startYear;
	@Column
	private String endYear;
	@Column
	private String runtimeMinutes;
	@Column
	private String genres;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconts(String tconst) {
		this.tconst = tconst;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getIsAdult() {
		return isAdult;
	}

	public void setIsAdult(String isAdult) {
		this.isAdult = isAdult;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(String runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public static MovieBuilder builder() {
		return new MovieBuilder();
	}

	public static class MovieBuilder {

		private Movie movie;

		MovieBuilder() {
			movie = new Movie();
		}

		public MovieBuilder id(int id) {
			movie.setId(id);
			return this;
		}

		public MovieBuilder tconst(String tconst) {
			movie.setTconts(tconst);
			return this;
		}

		public MovieBuilder titleType(String titleType) {
			movie.setTitleType(titleType);
			return this;
		}

		public MovieBuilder primaryTitle(String primaryTitle) {
			movie.setPrimaryTitle(primaryTitle);
			return this;
		}

		public MovieBuilder originalTitle(String originalTitle) {
			movie.setOriginalTitle(originalTitle);
			return this;
		}

		public MovieBuilder isAdult(String isAdult) {
			movie.setIsAdult(isAdult);
			return this;
		}

		public MovieBuilder startYear(String startYear) {
			movie.setStartYear(startYear);
			return this;
		}

		public MovieBuilder endYear(String endYear) {
			movie.setEndYear(endYear);
			return this;
		}

		public MovieBuilder runtimeMinutes(String runtimeMinutes) {
			movie.setRuntimeMinutes(runtimeMinutes);
			return this;
		}

		public MovieBuilder genres(String genres) {
			movie.setGenres(genres);
			return this;
		}

		public Movie build() {
			return movie;
		}

	}

}

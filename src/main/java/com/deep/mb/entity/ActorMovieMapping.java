package com.deep.mb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acotor_movie_mapping")
public class ActorMovieMapping {

	@Id
	@Column
	private int Id;
	@Column
	private String tconst;
	@Column
	private String ordering;
	@Column
	private String nconst;
	@Column
	private String category;
	@Column
	private String job;
	@Column
	private String characters;
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getOrdering() {
		return ordering;
	}

	public void setOrdering(String ordering) {
		this.ordering = ordering;
	}

	public String getNconst() {
		return nconst;
	}

	public void setNconst(String nconst) {
		this.nconst = nconst;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}
	
	public static ActorMovieMappingBuilder builder() {
		return new ActorMovieMappingBuilder();
	}

	public static class ActorMovieMappingBuilder {
		private ActorMovieMapping actorMovieMapping;

		public ActorMovieMappingBuilder() {
			actorMovieMapping = new ActorMovieMapping();
		}

		public ActorMovieMappingBuilder id(int id) {
			actorMovieMapping.setId(id);
			return this;
		}

		public ActorMovieMappingBuilder tconst(String tconst) {
			actorMovieMapping.setTconst(tconst);
			return this;
		}

		public ActorMovieMappingBuilder ordering(String ordering) {
			actorMovieMapping.setOrdering(ordering);
			return this;
		}

		public ActorMovieMappingBuilder nconst(String nconst) {
			actorMovieMapping.setNconst(nconst);
			return this;
		}

		public ActorMovieMappingBuilder category(String category) {
			actorMovieMapping.setCategory(category);
			return this;
		}

		public ActorMovieMappingBuilder job(String job) {
			actorMovieMapping.setJob(job);
			return this;
		}
		
		public ActorMovieMappingBuilder characters(String characters) {
			actorMovieMapping.setCharacters(characters);
			return this;
		}

		public ActorMovieMapping build() {
			return actorMovieMapping;
		}
	}
}

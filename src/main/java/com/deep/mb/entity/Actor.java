package com.deep.mb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {

	@Id
	@Column
	private int Id;
	@Column
	private String nconst;
	@Column
	private String primaryName;
	@Column
	private String birthYear;
	@Column
	private String deathYear;
	@Column
	private String primaryProfession;
	@Column
	private String knownForTitles;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getNconst() {
		return nconst;
	}

	public void setNconst(String nconst) {
		this.nconst = nconst;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}

	public String getPrimaryProfession() {
		return primaryProfession;
	}

	public void setPrimaryProfession(String primaryProfession) {
		this.primaryProfession = primaryProfession;
	}

	public String getKnownForTitles() {
		return knownForTitles;
	}

	public void setKnownForTitles(String knownForTitles) {
		this.knownForTitles = knownForTitles;
	}

	public static ActorBuilder builder() {
		return new ActorBuilder();
	}

	public static class ActorBuilder {
		private Actor actor;

		public ActorBuilder() {
			actor = new Actor();
		}

		public ActorBuilder id(int id) {
			actor.setId(id);
			return this;
		}

		public ActorBuilder cconst(String cconst) {
			actor.setNconst(cconst);
			return this;
		}

		public ActorBuilder primaryName(String primaryName) {
			actor.setPrimaryName(primaryName);
			return this;
		}

		public ActorBuilder primaryProfession(String primaryProfession) {
			actor.setPrimaryProfession(primaryProfession);
			return this;
		}

		public ActorBuilder birthYear(String birthYear) {
			actor.setBirthYear(birthYear);
			return this;
		}

		public ActorBuilder deathYear(String deathYear) {
			actor.setDeathYear(deathYear);
			return this;
		}

		public ActorBuilder knownForTitles(String knownForTitles) {
			actor.setKnownForTitles(knownForTitles);
			return this;
		}

		public Actor build() {
			return actor;
		}

	}

}

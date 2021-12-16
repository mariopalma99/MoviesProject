package com.nttdata.moviesproject.models

public class Searchs {

	private String Title
	private int Year
	private String imdbID
	private String Type
	private String Poster

	String getTitle() {
		return Title
	}
	void setTitle(String title) {
		Title = title
	}

	int getYear() {
		return Year
	}
	void setYear(int year) {
		Year = year
	}

	String getImdbID() {
		return imdbID
	}
	void setImdbID(String imdbID) {
		this.imdbID = imdbID
	}

	String getType() {
		return Type
	}
	void setType(String type) {
		Type = type
	}

	String getPoster() {
		return Poster
	}
	void setPoster(String poster) {
		Poster = poster
	}
}

package com.nttdata.moviesproject.models

public class MediaInfo {
	
	private String Title
	private String Rated
	private String Released
	private String Runtime
	private String Genre
	private String Director
	private String Actors
	private String Plot
	private String Language
	private String Country
	private String Awards
	private int totalSeasons

	String getTitle() {
		return Title
	}
	void setTitle(String title) {
		Title = title
	}

	String getRated() {
		return Rated
	}
	void setRated(String rated) {
		Rated = rated
	}
	
	String getReleased() {
		return Released
	}
	void setReleased(String released) {
		Released = released
	}
	
	String getRuntime() {
		return Runtime
	}
	void setRuntime(String runtime) {
		Runtime = runtime
	}
	
	String getGenre() {
		return Genre
	}
	void setGenre(String genre) {
		Genre = genre
	}
	
	String getDirector() {
		return Director
	}
	void setDirector(String director) {
		Director = director
	}
	
	String getActors() {
		return Actors
	}
	void setActors(String actors) {
		Actors = actors
	}
	
	String getPlot() {
		return Plot
	}
	void setPlot(String plot) {
		Plot = plot
	}
	
	String getLanguage() {
		return Language
	}
	void setLanguage(String language) {
		Language = language
	}
	
	String getCountry() {
		return Country
	}
	void setCountry(String country) {
		Country = country
	}
	
	String getAwards() {
		return Awards
	}
	void setAwards(String awards) {
		Awards = awards
	}
	
	int getTotalSeasons() {
		return totalSeasons
	}
	void setTotalSeasons(int totalSeasons) {
		this.totalSeasons = totalSeasons
	}
}

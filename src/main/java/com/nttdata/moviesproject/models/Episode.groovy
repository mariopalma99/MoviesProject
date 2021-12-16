package com.nttdata.moviesproject.models

class Episode {
	
	private String Title
	private String Released
	private int Episode
	private String imdbRating
	private String imdbID
	
	String getTitle() {
		return Title
	}
	void setTitle(String title) {
		Title = title
	}
	
	String getReleased() {
		return Released
	}
	void setReleased(String released) {
		Released = released
	}
	
	int getEpisode() {
		return Episode
	}
	void setEpisode(int episode) {
		Episode = episode
	}
	
	String getImdbRating() {
		return imdbRating
	}
	void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating
	}
	
	String getImdbID() {
		return imdbID
	}
	void setImdbID(String imdbID) {
		this.imdbID = imdbID
	}
}

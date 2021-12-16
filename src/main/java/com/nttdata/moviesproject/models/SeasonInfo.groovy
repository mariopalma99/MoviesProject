package com.nttdata.moviesproject.models

class SeasonInfo {
	
	private String Title
	private int Season
	private int totalSeasons
	private List<Episode> Episodes
	private String Response
	
	String getTitle() {
		return Title
	}
	void setTitle(String title) {
		Title = title
	}
	
	int getSeason() {
		return Season
	}
	void setSeason(int season) {
		Season = season
	}
	
	int getTotalSeasons() {
		return totalSeasons
	}
	void setTotalSeasons(int totalSeasons) {
		this.totalSeasons = totalSeasons
	}
	
	List<Episode> getEpisodes() {
		return Episodes
	}
	void setEpisodes(List<Episode> episodes) {
		Episodes = episodes
	}
	
	String getResponse() {
		return Response
	}
	void setResponse(String response) {
		Response = response
	}
}

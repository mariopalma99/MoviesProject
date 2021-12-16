package com.nttdata.moviesproject.models

public class SearchInfo {
	
	private List<Searchs> Search
	private int totalResults
	private String Response
	
	List<Searchs> getSearch() {
		return Search
	}
	void setSearch(List<Searchs> search) {
		Search = search
	}
	
	int getTotalResults() {
		return totalResults
	}
	void setTotalResults(int totalResults) {
		this.totalResults = totalResults
	}
	
	String getResponse() {
		return Response
	}
	void setResponse(String response) {
		Response = response
	}
}

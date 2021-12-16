package com.nttdata.moviesproject.test


import org.junit.*
import static com.github.tomakehurst.wiremock.client.WireMock.*

import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.nttdata.moviesproject.api.Methods
import com.nttdata.moviesproject.models.MediaInfo
import com.nttdata.moviesproject.mappers.Values

public class MoviesProjectMockTest {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8050)

	@Before
	public void init() {
		wireMockRule.stubFor(get(urlEqualTo("/?apikey=83001810&t=the+dark+knight&type=movie"))
				.willReturn(aResponse()
				.withHeader("Content-Type", "text/plain")
				.withBodyFile("movieInfo.json")))

		wireMockRule.stubFor(get(urlEqualTo("/?apikey=83001810&t=game+of+thrones&type=series"))
				.willReturn(aResponse()
				.withHeader("Content-Type", "text/plain")
				.withBodyFile("seriesInfo.json")))

		wireMockRule.stubFor(get(urlEqualTo("/?apikey=83001810&s=the+dark+knight&type=movie"))
				.willReturn(aResponse()
				.withHeader("Content-Type", "text/plain")
				.withBodyFile("resultsInfo.json")))

		wireMockRule.stubFor(get(urlEqualTo("/?apikey=83001810&i=tt0468569&plot=full"))
				.willReturn(aResponse()
				.withHeader("Content-Type", "text/plain")
				.withBodyFile("idLongPlotInfo.json")))

	}

	@org.junit.Test
	public void testGetMediaInfoByTitle() {
		Methods method = new Methods(Values.LOCALHOST)
		MediaInfo mediaInfo = method.getMediaInfoByTitle(Values.MEDIA_TITLE, Values.MOVIE_TYPE)
		println(mediaInfo.getTitle())
		assert mediaInfo.getTitle().equals("The Dark Knight")
	}

	@org.junit.Test
	public void testGetNumberOfSeasons() {
		Methods method = new Methods(Values.LOCALHOST)
		int numberOfSeasons = method.getNumberOfSeasons(Values.SERIES_TITLE)
		println(numberOfSeasons)
		assert numberOfSeasons.equals(8)
	}

	@org.junit.Test
	public void testGetMediaResults() {
		Methods method = new Methods(Values.LOCALHOST)
		int numberOfResults = method.getMediaResults(Values.MEDIA_TITLE, Values.MOVIE_TYPE)
		println(numberOfResults)
		assert numberOfResults.equals(57)
	}

	@org.junit.Test
	public void testGetFullPlotById() {
		Methods method = new Methods(Values.LOCALHOST)
		String fullPlot = method.getFullPlotById(Values.MEDIA_ID)
		println(fullPlot)
		assert fullPlot.equals("Set within a year after the events of Batman Begins (2005), Batman, Lieutenant James Gordon, and new District Attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City, until a mysterious and sadistic criminal mastermind known only as \"The Joker\" appears in Gotham, creating a new wave of chaos. Batman's struggle against The Joker becomes deeply personal, forcing him to \"confront everything he believes\" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent, and Rachel Dawes.")
	}

}

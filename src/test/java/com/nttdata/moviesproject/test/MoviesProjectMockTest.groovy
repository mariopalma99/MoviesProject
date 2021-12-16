package com.nttdata.moviesproject.test


import org.junit.*
import static com.github.tomakehurst.wiremock.client.WireMock.*

import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.nttdata.moviesproject.api.Methods
import com.nttdata.moviesproject.models.MediaInfo
import com.nttdata.moviesproject.mappers.Values

public class MoviesProjectMockTest {

	/*@Rule
	public WireMockRule wireMockRule = new WireMockRule(8050)*/
	
	@Rule
	public final WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.wireMockConfig().withRootDirectory("src/test/resources/__files").port(8050));

	@Before
	public void init() {
		
		wireMockRule.stubFor(post(urlEqualTo("/?apikey=83001810&t=the+dark+knight&type=movie"))
				.willReturn(aResponse()
				.withHeader("Content-Type", "text/plain")
				.withBodyFile("prueba.json")))
	}
	
	@org.junit.Test
	public void pruebaFunction() {
	

		Methods method = new Methods(Values.LOCALHOST)
		MediaInfo mediaInfo = method.getMediaInfoByTitle(Values.MEDIA_TITLE, Values.MOVIE_TYPE)
		println(mediaInfo.toString())
		assert mediaInfo.getTitle().equals("The Dark Knight")
	}
}

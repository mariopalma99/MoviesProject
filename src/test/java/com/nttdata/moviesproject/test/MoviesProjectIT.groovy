package com.nttdata.moviesproject.test

import com.nttdata.moviesproject.api.Methods
import com.nttdata.moviesproject.models.MediaInfo
import com.nttdata.moviesproject.mappers.Values

public class MoviesProjectIT {
	
	@org.junit.Test
	public void pruebaFunction() {
	

		Methods method = new Methods(Values.OMDB_URL)
		MediaInfo mediaInfo = method.getMediaInfoByTitle(Values.MEDIA_TITLE, Values.MOVIE_TYPE)
		println(mediaInfo.toString())
		assert mediaInfo.getTitle().equals("The Dark Knight")
	}

}

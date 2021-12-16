package com.nttdata.moviesproject.api

import com.nttdata.moviesproject.mappers.Values
import com.nttdata.moviesproject.models.MediaInfo

public class MoviesProjectAPI {

	static void main(String[] args) {

		Methods method = new Methods()

		/*
		// printMediaInfoByTitle (only returns one result)
		println("Result info:")
		method.printMediaInfoByTitle(Values.MEDIA_TITLE, Values.MOVIE_TYPE)

		// searchMediaByTitle (returns the name and year of all results, not only the ones in first page)
		println("\nList of results:")
		method.searchMediaByTitle(Values.MEDIA_TITLE, Values.MOVIE_TYPE)

		// printFullPlotById
		println("\nFull plot:")
		method.printFullPlotById(Values.MEDIA_ID)

		// writeFile
		//println("\nWriting txt file:")
		//method.writeFile(method.getMediaByTitle(Values.MEDIA_TITLE, Values.MOVIE_TYPE), Values.FILE_PATH)

		// printAllEpisodes
		println("\nAll episodes:")
		int numberOfSeasons = method.getNumberOfSeasons(Values.SERIES_TITLE)
		method.printAllEpisodes(Values.SERIES_TITLE, numberOfSeasons)

		// sendToServer
		//method.sendToServer(Values.FILE_PATH, Values.FILE_PATH)
		*/
		
		
		MediaInfo mediaInfo = method.getMediaInfoByTitle(Values.MEDIA_TITLE, Values.MOVIE_TYPE)
		println(mediaInfo.toString())



	}
}

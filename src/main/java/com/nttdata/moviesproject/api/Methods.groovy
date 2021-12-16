package com.nttdata.moviesproject.api

import com.google.gson.*
import com.nttdata.moviesproject.mappers.Values
import com.nttdata.moviesproject.models.*
import org.apache.commons.net.ftp.FTPClient

class Methods {

	private String host
	
	// Constructor
	public Methods(String host) {
		super();
		this.host = host;
	}

	// getConnection
	HttpURLConnection getConnection(URL url) {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection()
		connection.setRequestMethod(Values.HTTP_GET)
		connection.connect()
		return connection
	}

	// printMediaInfoByTitle
	void printMediaInfoByTitle(String title, String type) {

		URL url = new URL(host + "t=" + title + "&type=" + type)
		HttpURLConnection connection = this.getConnection(url)
		int responseCode = connection.getResponseCode()

		if (responseCode != 200) {

			throw new RuntimeException("HTTP response code: " + responseCode)

		} else {

			InputStream inputStream = new BufferedInputStream(connection.getInputStream())
			Gson gson = new Gson()
			MediaInfo mediaInfo = gson.fromJson(new InputStreamReader(inputStream), MediaInfo.class)
			println("Title: " + mediaInfo.getTitle() + ", " + mediaInfo.getReleased() + " (" +
					mediaInfo.getRated() + ").")
			println("Runtime: " + mediaInfo.getRuntime() + ". Genre: " + mediaInfo.getGenre() +
					". Director: " + mediaInfo.getDirector() + ".")
			println("Actors: " + mediaInfo.getActors() + ".")
			println("Plot: " + mediaInfo.getPlot())
			println("Language: " + mediaInfo.getLanguage() + ". Country: " + mediaInfo.getCountry() + ".")
			println("Awards: " + mediaInfo.getAwards() + ".")
		}
	}

	// getMediaInfoByTitle
	MediaInfo getMediaInfoByTitle(String title, String type) {

		URL url = new URL(host + "t=" + title + "&type=" + type)
		HttpURLConnection connection = this.getConnection(url)
		int responseCode = connection.getResponseCode()

		if (responseCode != 200) {

			throw new RuntimeException("HTTP response code: " + responseCode)

		} else {

			InputStream inputStream = new BufferedInputStream(connection.getInputStream())
			Gson gson = new Gson()
			return gson.fromJson(new InputStreamReader(inputStream), MediaInfo.class)
		}
	}
	
	// searchMediaByTitle
	void searchMediaByTitle(String title, String type) {

		println("There is/are " + this.getMediaResults(title, type) + " result(s) titled " +
				title.replace("+", " ") + ":")

		int page = 1
		int results = 0

		while (results < this.getMediaResults(title, type)) {

			URL url = new URL(host + "s=" + title + "&type=" + type + "&page=" + page)
			page++
			HttpURLConnection connection = this.getConnection(url)
			int responseCode = connection.getResponseCode()

			if (responseCode != 200) {

				throw new RuntimeException("HTTP response code: " + responseCode)

			} else {

				InputStream inputStream = new BufferedInputStream(connection.getInputStream())
				Gson gson = new Gson()
				SearchInfo searchInfo = gson.fromJson(new InputStreamReader(inputStream), SearchInfo.class)
				List<Searchs> search = searchInfo.getSearch()
				results += search.size()
				search.each {
					println(it.getTitle() + " (" + it.getYear() + ")")
				}

			}
		}
	}

	// getMediaResults
	int getMediaResults(String title, String type) {

		URL url = new URL(host + "s=" + title + "&type=" + type)
		HttpURLConnection connection = this.getConnection(url)
		int responseCode = connection.getResponseCode()

		if (responseCode != 200) {

			throw new RuntimeException("HTTP response code: " + responseCode)

		} else {

			InputStream inputStream = new BufferedInputStream(connection.getInputStream())
			Gson gson = new Gson()
			SearchInfo searchInfo = gson.fromJson(new InputStreamReader(inputStream), SearchInfo.class)
			return searchInfo.getTotalResults()

		}
	}

	// printFullPlotById
	void printFullPlotById(String id) {

		URL url = new URL(host + "i=" + id + "&plot=full")
		HttpURLConnection connection = this.getConnection(url)
		int responseCode = connection.getResponseCode()

		if (responseCode != 200) {

			throw new RuntimeException("HTTP response code: " + responseCode)

		} else {

			InputStream inputStream = new BufferedInputStream(connection.getInputStream())
			Gson gson = new Gson()
			MediaInfo mediaInfo = gson.fromJson(new InputStreamReader(inputStream), MediaInfo.class)
			println("Title: " + mediaInfo.getTitle() + ".")
			println("Plot: " + mediaInfo.getPlot())
		}
	}
	
	// getFullPlotById
	String getFullPlotById(String id) {

		URL url = new URL(host + "i=" + id + "&plot=full")
		HttpURLConnection connection = this.getConnection(url)
		int responseCode = connection.getResponseCode()

		if (responseCode != 200) {

			throw new RuntimeException("HTTP response code: " + responseCode)

		} else {

			InputStream inputStream = new BufferedInputStream(connection.getInputStream())
			Gson gson = new Gson()
			MediaInfo mediaInfo = gson.fromJson(new InputStreamReader(inputStream), MediaInfo.class)
			return mediaInfo.getPlot()
		}
	}

	// getMediaByTitle
	List<String> getMediaByTitle(String title, String type) {

		int page = 1
		int results = 0
		List<String> mediaList = new ArrayList<String>()

		while (results < this.getMediaResults(title, type)) {

			URL url = new URL(host + "s=" + title + "&type=" + type + "&page=" + page)
			page++
			HttpURLConnection connection = this.getConnection(url)
			int responseCode = connection.getResponseCode()

			if (responseCode != 200) {

				throw new RuntimeException("HTTP response code: " + responseCode)

			} else {

				InputStream inputStream = new BufferedInputStream(connection.getInputStream())
				Gson gson = new Gson()
				SearchInfo searchInfo = gson.fromJson(new InputStreamReader(inputStream), SearchInfo.class)
				List<Searchs> search = searchInfo.getSearch()
				results += search.size()
				search.each {
					mediaList.add(it.getTitle())
				}
			}
		}
		return mediaList
	}

	// writeFile
	void writeFile(List<String> stringList, String path) {
		File file = new File(path)
		println("Writing file...")
		stringList.each {
			file.append(it + "\n")
		}
		println("File written.")
	}

	// getNumberOfSeasons
	int getNumberOfSeasons(String title) {

		URL url = new URL(host + "t=" + title + "&type=series")
		HttpURLConnection connection = this.getConnection(url)
		int responseCode = connection.getResponseCode()

		if (responseCode != 200) {

			throw new RuntimeException("HTTP response code: " + responseCode)

		} else {

			InputStream inputStream = new BufferedInputStream(connection.getInputStream())
			Gson gson = new Gson()
			MediaInfo mediaInfo = gson.fromJson(new InputStreamReader(inputStream), MediaInfo.class)
			return mediaInfo.getTotalSeasons()
		}
	}

	// printAllEpisodes
	void printAllEpisodes(String title, int numberOfSeasons) {

		for (int i=1; i<=numberOfSeasons; i++) {

			URL url = new URL(host + "t=" + title + "&type=series&season=" + i)
			HttpURLConnection connection = this.getConnection(url)
			int responseCode = connection.getResponseCode()

			if (responseCode != 200) {

				throw new RuntimeException("HTTP response code: " + responseCode)

			} else {

				InputStream inputStream = new BufferedInputStream(connection.getInputStream())
				Gson gson = new Gson()
				SeasonInfo seasonInfo = gson.fromJson(new InputStreamReader(inputStream), SeasonInfo.class)
				List<Episode> episodes = seasonInfo.getEpisodes()
				episodes.each {
					println("Season " + seasonInfo.getSeason() + ", episode " + it.getEpisode() +
							": " + it.getTitle())
				}
			}
		}
	}

	// sendToServer
	void sendToServer(String localFilePath, String remoteFileName) {

		FTPClient client = new FTPClient()

		try {
			client.connect("127.0.0.1", 21)
			client.login("mario", "myPass")
			client.enterLocalPassiveMode()

			File localFile = new File(localFilePath)
			String remoteFile = remoteFileName
			InputStream inputStream = new FileInputStream(localFile)

			boolean completed = client.storeFile(remoteFile, inputStream)
			inputStream.close()

			if (completed) {
				println("File uploaded successfully")
			} else {
				println("Error")
			}

		} catch (IOException exception) {
			exception.printStackTrace()

		} finally {
			try {
				if (client.isConnected()) {
					client.logout()
					client.disconnect()
				}
			} catch (IOException exception) {
				exception.printStackTrace()
			}
		}
	}
}
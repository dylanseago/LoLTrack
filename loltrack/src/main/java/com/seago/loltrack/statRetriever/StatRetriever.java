/* 
 * Project: LOLTrack
 * Developer: Dylan Seago
 * Date: 27/02/2013
 * 
 * This class calls the API's required to obtain the statistics and returns respective objects for called classes
 */

package com.seago.loltrack.statRetriever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

//UNUSED!!
//UNUSED!!
//UNUSED!!
//UNUSED!!
//UNUSED!!

class StatRetriever extends AsyncTask<String, Integer, String> {

    private Gson			gson	= new Gson();

    // Returns the resource for given parameters
	public Object getResource(String resource, String args[]) throws Exception {

		StringBuilder stringUrlBuffer = new StringBuilder();
		stringUrlBuffer.append("http://api.elophant.com/v2/");
		for (String s : args) {
			stringUrlBuffer.append("/").append(s);
		}
        String apiKey = "OznRfLFTUfZf9Mt3eOCR";
        stringUrlBuffer.append("?key=").append(apiKey);
        String TAG = "StatRetriever";
        Log.d(TAG, "stringUrlBuffer = " + stringUrlBuffer.toString());

        UrlDownloader uDown = new UrlDownloader(stringUrlBuffer.toString());
		uDown.beginDownload();

		String stringJsonRaw = uDown.stringInput;

		Log.d(TAG, "stringJsonRaw = " + stringJsonRaw);

		return gson.fromJson(stringJsonRaw, Class.forName("com.seagoApps.loltrack.statRetriever.stat" + resource + "." + resource));
	}

	private class UrlDownloader {
		private static final String	DEBUG_TAG	= "UrlDownloader";
		private String				stringInput;

		public UrlDownloader(String input) {
			this.stringInput = input;
		}

		// When called, calls AsyncTask.
		public void beginDownload() {
			new DownloadWebpageText().execute(stringInput);
		}

		/*Uses AsyncTask to create a task away from the main UI thread. This task takes a 
		URL string and uses it to create an HttpUrlConnection. Once the connection
		has been established, the AsyncTask downloads the contents of the webpage as
		an InputStream. Finally, the InputStream is converted into a string, which is
		displayed in the UI by the AsyncTask's onPostExecute method.*/
		private class DownloadWebpageText extends AsyncTask<String, Integer, String> {
			protected String doInBackground(String... urls) {
				// params comes from the execute() call: params[0] is the url.
				try {
					return downloadUrl(urls[0]);
				} catch (IOException e) {
					return "Unable to retrieve web page. URL may be invalid.";
				}
			}

			// onPostExecute displays the results of the AsyncTask.
			protected void onPostExecute(String result) {
				Log.d(DEBUG_TAG, "onPostExecute.result = " + result);
				Log.d(DEBUG_TAG, "onPostExecute.stringOutput = " + result);
			}
		}

		// Given a URL, establishes an HttpUrlConnection and retrieves
		// the web page content as a InputStream, which it returns as a string.
		private String downloadUrl(String myurl) throws IOException {
			InputStream inputStream = null;
			// Only display the first 500 characters of the retrieved web page content.
			int len = 1024;
			try {
				URL url = new URL(myurl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setReadTimeout(10000 /* milliseconds */);
				connection.setConnectTimeout(15000 /* milliseconds */);
				connection.setRequestMethod("GET");
				connection.setDoInput(true);
				// Starts the query
				connection.connect();
				int response = connection.getResponseCode();
				Log.d(DEBUG_TAG, "The response is: " + response);
				inputStream = connection.getInputStream();

				// Convert the InputStream into a string
				String contentAsString = readIt(inputStream, len);
				Log.d(DEBUG_TAG, "The result is: " + contentAsString);
				Log.d(DEBUG_TAG, "Result Length: " + contentAsString.length());
				return contentAsString;

				// Makes sure that the InputStream is closed after the app is finished using it.
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
			}
		}

		// Reads an InputStream and converts it to a String.
		public String readIt(InputStream stream, int len) throws IOException {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
				StringBuilder buffer = new StringBuilder();
				char[] chars = new char[len];
				int read;
				while ((read = reader.read(chars)) != -1)
					buffer.append(chars, 0, read);
				return buffer.toString();
			} catch (Exception e) {
				return "I/O Error";
			} finally {
				if (reader != null)
					reader.close();
			}
		}
	}

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}

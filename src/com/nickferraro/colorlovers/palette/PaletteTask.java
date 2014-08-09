package com.nickferraro.colorlovers.palette;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import android.os.AsyncTask;

import com.nickferraro.colorlovers.palette.parse.JsonPaletteParser;

public abstract class PaletteTask extends AsyncTask<Void, Boolean, List<Palette>> {
	private final String mBaseUrl;
	private int mNumResults = 50;
	private int mResultOffset = 0;
	private final String mFormat = "json";
	private final String mOrder = "dateCreated";
	private final String mSort = "ASC";
	private Exception mLastError = null;
	
	public PaletteTask(String baseUrl) {
		this(baseUrl, 50, 0);
	}
	public PaletteTask(String baseUrl, int numResults, int resultOffset) {
		mBaseUrl = baseUrl;
		setNumResults(numResults);
		setResultOffset(resultOffset);
	}
	
	public void setNumResults(int numResults) {
		mNumResults = numResults;
	}
	
	public int getNumResults() {
		return mNumResults;
	}
	
	public void setResultOffset(int resultOffset) {
		mResultOffset = resultOffset;
	}
	
	public int getResultOffset() {
		return mResultOffset;
	}
	
	public Exception getLastError() {
		return mLastError;
	}
	
	@Override
	protected List<Palette> doInBackground(Void... params) {
		List<Palette> palettes = new ArrayList<Palette>();
		JsonPaletteParser parser = new JsonPaletteParser();
		
		List<NameValuePair> getParams = new ArrayList<NameValuePair>();
		getParams.add(new BasicNameValuePair("format", mFormat));
		getParams.add(new BasicNameValuePair("numResults", Integer.toString(mNumResults)));
		getParams.add(new BasicNameValuePair("resultOffset", Integer.toString(mResultOffset)));
		getParams.add(new BasicNameValuePair("orderCol", mOrder));
		getParams.add(new BasicNameValuePair("sortBy", mSort));
		
		HttpClient client = new DefaultHttpClient();
		HttpGet getPalettesReq = new HttpGet(mBaseUrl + "?" + URLEncodedUtils.format(getParams, "utf-8"));
		try {
			HttpResponse getPalettesResp = client.execute(getPalettesReq);
			JSONArray palettesArray = new JSONArray(EntityUtils.toString(getPalettesResp.getEntity()));
			
			for( int i = 0; i < palettesArray.length(); ++i ) {
				palettes.add(parser.parsePalette(palettesArray.getJSONObject(i)));
			}
		} catch (Exception e) {
			mLastError = e;
		}
		
		return palettes;
	}
	
	@Override
	public abstract void onPostExecute(List<Palette> palettes);
}

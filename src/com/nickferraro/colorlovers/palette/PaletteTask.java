package com.nickferraro.colorlovers.palette;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public abstract class PaletteTask extends AsyncTask<Void, Boolean, List<Palette>> {
	private int mNumResults = 50;
	private int mResultOffset = 0;
	private final String mFormat = "json";
	private final String mOrder = "dateCreated";
	private final String mSort = "ASC";
	
	public PaletteTask() {}
	public PaletteTask(int numResults, int resultOffset) {
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
	
	@Override
	protected List<Palette> doInBackground(Void... params) {
		List<Palette> palettes = new ArrayList<Palette>();
		
		HttpClient client = new DefaultHttpClient();
		HttpGet getPalettesReq = new HttpGet();
		try {
			HttpResponse getPalettesResp = client.execute(getPalettesReq);
		} catch (IOException e) {
		}
		
		return palettes;
	}
	
	@Override
	public abstract void onPostExecute(List<Palette> palettes);
}

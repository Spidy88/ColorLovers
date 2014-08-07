package com.nickferraro.colorlovers.palette;

import java.util.List;

public class Palette {
	private final String mTitle;
	private final List<String> mColors;
	private final int mViews;
	private final int mComments;
	private final int mLoves;
	
	public Palette(String title, List<String> colors, int views, int comments, int loves) {
		mTitle = title;
		mColors = colors;
		mViews = views;
		mComments = comments;
		mLoves = loves;
	}
	
	public String getTitle() {
		return mTitle;
	}
	
	public List<String> getColors() {
		return mColors;
	}
	
	public int getViews() {
		return mViews;
	}
	
	public int getComments() {
		return mComments;
	}
	
	public int getLoves() {
		return mLoves;
	}
}

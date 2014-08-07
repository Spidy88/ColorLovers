package com.nickferraro.colorlovers.color;

import java.util.Date;

public class Color {
	private final String mId;
	private final String mTitle;
	private final String mDescription;
	private final String mUsername;
	private final int mViewCount;
	private final int mVoteCount;
	private final int mCommentCount;
	private final int mHeartsCount;
	private final int mRank;
	private final Date mDateCreated;
	private final String mHex;
	
	public Color(
			String id,
			String title,
			String description,
			String username,
			int viewCount,
			int voteCount,
			int commentCount,
			int heartsCount,
			int rank,
			Date dateCreated,
			String hex) {
		mId = id;
		mTitle = title;
		mDescription = description;
		mUsername = username;
		mViewCount = viewCount;
		mVoteCount = voteCount;
		mCommentCount = commentCount;
		mHeartsCount = heartsCount;
		mRank = rank;
		mDateCreated = dateCreated;
		mHex = hex;
	}

	public String getId() {
		return mId;
	}

	public String getTitle() {
		return mTitle;
	}

	public String getDescription() {
		return mDescription;
	}

	public String getUsername() {
		return mUsername;
	}

	public int getViewCount() {
		return mViewCount;
	}

	public int getVoteCount() {
		return mVoteCount;
	}

	public int getCommentCount() {
		return mCommentCount;
	}

	public int getHeartsCount() {
		return mHeartsCount;
	}

	public int getRank() {
		return mRank;
	}

	public Date getDateCreated() {
		return mDateCreated;
	}

	public String getHex() {
		return mHex;
	}
}

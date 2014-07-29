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
	private final RGB mRGB;
	private final HSV mHSV;
	private final String mUrl;
	private final String mImageUrl;
	private final String mBadgeUrl;
	private final String mApiUrl;
	
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
			String hex,
			RGB rgb,
			HSV hsv,
			String url,
			String imageUrl,
			String badgeUrl,
			String apiUrl) {
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
		mRGB = rgb;
		mHSV = hsv;
		mUrl = url;
		mImageUrl = imageUrl;
		mBadgeUrl = badgeUrl;
		mApiUrl = apiUrl;
	}

	public String getmId() {
		return mId;
	}

	public String getmTitle() {
		return mTitle;
	}

	public String getmDescription() {
		return mDescription;
	}

	public String getmUsername() {
		return mUsername;
	}

	public int getmViewCount() {
		return mViewCount;
	}

	public int getmVoteCount() {
		return mVoteCount;
	}

	public int getmCommentCount() {
		return mCommentCount;
	}

	public int getmHeartsCount() {
		return mHeartsCount;
	}

	public int getmRank() {
		return mRank;
	}

	public Date getmDateCreated() {
		return mDateCreated;
	}

	public String getmHex() {
		return mHex;
	}

	public RGB getmRGB() {
		return mRGB;
	}

	public HSV getmHSV() {
		return mHSV;
	}

	public String getmUrl() {
		return mUrl;
	}

	public String getmImageUrl() {
		return mImageUrl;
	}

	public String getmBadgeUrl() {
		return mBadgeUrl;
	}

	public String getmApiUrl() {
		return mApiUrl;
	}
}

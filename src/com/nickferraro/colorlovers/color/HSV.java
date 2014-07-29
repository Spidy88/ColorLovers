package com.nickferraro.colorlovers.color;

public class HSV {
	private final int mHue;
	private final int mSaturation;
	private final int mValue;
	
	public HSV(int hue, int saturation, int value) {
		mHue = hue;
		mSaturation = saturation;
		mValue = value;
	}
	
	public int getHue() {
		return mHue;
	}
	public int getSaturation() {
		return mSaturation;
	}
	public int getValue() {
		return mValue;
	}
}

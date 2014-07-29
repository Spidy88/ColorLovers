package com.nickferraro.colorlovers.nav;


public class NavigationItem {
	private final int mLabelRes;
	private final int mIconRes;
	
	public NavigationItem(int labelRes, int iconRes) {
		mLabelRes = labelRes;
		mIconRes = iconRes;
	}
	
	public int getLabelRes() {
		return mLabelRes;
	}
	public int getIconRes() {
		return mIconRes;
	}
}

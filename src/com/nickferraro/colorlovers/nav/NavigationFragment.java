package com.nickferraro.colorlovers.nav;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.nickferraro.colorlovers.R;

public class NavigationFragment extends Fragment {
	public static final NavigationItem NAV_ITEM_PALETTES = new NavigationItem(R.string.nav_palettes, R.drawable.palettes_icon);
	public static final NavigationItem NAV_ITEM_COLORS = new NavigationItem(R.string.nav_colors, R.drawable.colors_icon);
	public static final NavigationItem NAV_ITEM_PATTERNS = new NavigationItem(R.string.nav_patterns, R.drawable.patterns_icon);
	
	private static final ArrayList<NavigationItem> NAVIGATION_ITEMS = new ArrayList<NavigationItem>();
	static {
		NAVIGATION_ITEMS.add(NAV_ITEM_PALETTES);
		NAVIGATION_ITEMS.add(NAV_ITEM_COLORS);
		NAVIGATION_ITEMS.add(NAV_ITEM_PATTERNS);
	}
	
	private ListView mNavigationList = null;
	private NavigationFragmentListener mListener = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_navigation, container, false);
		
		mNavigationList = (ListView)rootView.findViewById(R.id.list_nav);
		mNavigationList.setAdapter(new NavigationAdapter(getActivity(), NAVIGATION_ITEMS));
		mNavigationList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				notifyNavigationItemSelected(NAVIGATION_ITEMS.get(position));
			}
		});
		
		return rootView;
	}
	
	public void setListener(NavigationFragmentListener listener) {
		mListener = listener;
	}
	private void notifyNavigationItemSelected(NavigationItem item) {
		if( mListener != null ) {
			mListener.onNavigationItemSelected(item);
		}
	}
}

package com.nickferraro.colorlovers.palette;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.nickferraro.colorlovers.R;

public class PaletteListFragment extends Fragment implements OnRefreshListener {
	private SwipeRefreshLayout mSwipeRefresh = null;
	private ListView mListPalettes = null;
	private TextView mTextEmpty = null;
	private PaletteAdapter mAdapter = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_palette_list, container, false);
		
		mSwipeRefresh = (SwipeRefreshLayout)rootView.findViewById(R.id.swipe_refresh_layout);
		mListPalettes = (ListView)rootView.findViewById(R.id.list_palettes);
		mTextEmpty = (TextView)rootView.findViewById(R.id.txt_empty);
		
		List<String> colors = new ArrayList<String>();
		colors.add("C0C1C2");
		colors.add("330055");
		colors.add("4512CD");
		List<Palette> palettes = new ArrayList<Palette>();
		palettes.add(new Palette("Sample 1", colors, 10, 3, 23));
		palettes.add(new Palette("Sample 2", colors, 2, 33, 12));
		palettes.add(new Palette("Sample 3", colors, 20, 32, 58));
		
		mAdapter = new PaletteAdapter(getActivity(), palettes);
		mListPalettes.setAdapter(mAdapter);
		mListPalettes.setEmptyView(mTextEmpty);
		
		mSwipeRefresh.setOnRefreshListener(this);
		
		return rootView;
	}

	@Override
	public void onRefresh() {
		mSwipeRefresh.setRefreshing(false);
	}
}

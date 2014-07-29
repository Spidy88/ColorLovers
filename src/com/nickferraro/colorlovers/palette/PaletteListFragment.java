package com.nickferraro.colorlovers.palette;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.nickferraro.colorlovers.R;

public class PaletteListFragment extends Fragment {
	private TextView mTextRefresh = null;
	private ListView mListPalettes = null;
	private TextView mTextEmpty = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_palette_list, container, false);
		
		mTextRefresh = (TextView)rootView.findViewById(R.id.txt_refresh_status);
		mListPalettes = (ListView)rootView.findViewById(R.id.list_palettes);
		mTextEmpty = (TextView)rootView.findViewById(R.id.txt_empty);
		
		mListPalettes.setEmptyView(mTextEmpty);
		
		return rootView;
	}
}

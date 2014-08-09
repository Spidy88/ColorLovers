package com.nickferraro.colorlovers.palette;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nickferraro.colorlovers.R;

public class PaletteListFragment extends Fragment implements OnRefreshListener {
	private SwipeRefreshLayout mSwipeRefresh = null;
	private ListView mListPalettes = null;
	private TextView mTextEmpty = null;
	private PaletteAdapter mAdapter = null;
	
	private GetPalettesTask mGetPalettes = new GetPalettesTask(null);
	private List<Palette> mPalettes = new ArrayList<Palette>();
	private boolean mRefreshing = false;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_palette_list, container, false);
		
		mSwipeRefresh = (SwipeRefreshLayout)rootView.findViewById(R.id.swipe_refresh_layout);
		mListPalettes = (ListView)rootView.findViewById(R.id.list_palettes);
		mTextEmpty = (TextView)rootView.findViewById(R.id.txt_empty);
		
		mAdapter = new PaletteAdapter(getActivity(), mPalettes);
		mListPalettes.setAdapter(mAdapter);
		mListPalettes.setEmptyView(mTextEmpty);
		
		mSwipeRefresh.setOnRefreshListener(this);
		onRefresh();
		
		return rootView;
	}

	@Override
	public void onRefresh() {
		if( !mRefreshing ) {
			mGetPalettes.cancel(true);
			mGetPalettes = new GetPalettesTask(getString(R.string.url_palettes));
			mGetPalettes.execute();
		}
	}
	
	private class GetPalettesTask extends PaletteTask {
		public GetPalettesTask(String baseUrl) {
			super(baseUrl);
		}
		
		public GetPalettesTask(String baseUrl, int numResults, int resultOffset) {
			super(baseUrl, numResults, resultOffset);
		}
		
		@Override
		public void onPreExecute() {
			super.onPreExecute();
			mSwipeRefresh.setRefreshing(true);
			mRefreshing = true;
		}

		@Override
		public void onPostExecute(List<Palette> palettes) {
			mSwipeRefresh.setRefreshing(false);
			mRefreshing = false;
			
			if( palettes.isEmpty() ) {
				Toast.makeText(getActivity(), "Failed to retrieve color palettes", Toast.LENGTH_SHORT).show();
				Exception error = this.getLastError();
				Log.d(GetPalettesTask.class.toString(), String.format("Failed to retrieve color palettes: %1$s", error == null ? "no exception" : error.getMessage()));
				return;
			}
			
			mPalettes.addAll(palettes);
			mAdapter.notifyDataSetChanged();
		}
	}
}

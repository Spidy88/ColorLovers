package com.nickferraro.colorlovers.palette;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nickferraro.colorlovers.R;

public class PaletteAdapter extends ArrayAdapter<Palette> {
	public PaletteAdapter(Context context, List<Palette> objects) {
		super(context, 0, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if( convertView == null ) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.list_item_palette, parent, false);
		}
		
		TextView titleText = (TextView)convertView.findViewById(R.id.palette_title);
		LinearLayout paletteColorsLayout = (LinearLayout)convertView.findViewById(R.id.palette_colors);
		TextView viewsText = (TextView)convertView.findViewById(R.id.palette_views);
		TextView commentsText = (TextView)convertView.findViewById(R.id.palette_comments);
		TextView lovesText = (TextView)convertView.findViewById(R.id.palette_loves);
		
		Palette palette = getItem(position);
		
		titleText.setText(palette.getTitle());
		viewsText.setText(Integer.toString(palette.getViews()));
		commentsText.setText(Integer.toString(palette.getComments()));
		lovesText.setText(Integer.toString(palette.getLoves()));
		paletteColorsLayout.removeAllViews();
		
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
		List<String> colors = palette.getColors();
		for(String color : colors) {
			View colorView = new View(getContext());
			colorView.setBackgroundColor(Color.parseColor("#" + color));
			colorView.setLayoutParams(layoutParams);
			paletteColorsLayout.addView(colorView);
		}
		
		return convertView;
	}
}

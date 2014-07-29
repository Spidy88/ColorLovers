package com.nickferraro.colorlovers.nav;

import java.util.List;

import com.nickferraro.colorlovers.R;
import com.nickferraro.colorlovers.R.id;
import com.nickferraro.colorlovers.R.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationAdapter extends ArrayAdapter<NavigationItem> {
	public NavigationAdapter(Context context, List<NavigationItem> items) {
		super(context, R.layout.list_item_nav, items);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null ) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.list_item_nav, parent, false);
		}
		
		TextView txtLabel = (TextView)convertView.findViewById(R.id.txt_nav_label);
		ImageView imgIcon = (ImageView)convertView.findViewById(R.id.img_nav_icon);
		
		NavigationItem item = getItem(position);
		
		txtLabel.setText(item.getLabelRes());
		imgIcon.setImageResource(item.getIconRes());
		
		return convertView;
	}
}

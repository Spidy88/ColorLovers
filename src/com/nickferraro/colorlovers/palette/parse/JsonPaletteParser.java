package com.nickferraro.colorlovers.palette.parse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.nickferraro.colorlovers.palette.Palette;

public class JsonPaletteParser {
	public static final String KEY_ID = "id";
	public static final String KEY_TITLE = "title";
	public static final String KEY_NUM_VIEWS = "numViews";
	public static final String KEY_NUM_COMMENTS = "numComments";
	public static final String KEY_NUM_HEARTS = "numHearts";
	public static final String KEY_COLORS = "colors";
	
	public Palette parsePalette(JSONObject paletteObject) throws JSONException {
		String id = paletteObject.getString(KEY_ID);
		String title = paletteObject.getString(KEY_TITLE);
		int views = paletteObject.getInt(KEY_NUM_VIEWS);
		int comments = paletteObject.getInt(KEY_NUM_COMMENTS);
		int hearts = paletteObject.getInt(KEY_NUM_HEARTS);
		
		List<String> colors = new ArrayList<String>();
		JSONArray colorsArray = paletteObject.getJSONArray(KEY_COLORS);
		for( int i = 0; i < colorsArray.length(); ++i ) {
			colors.add(colorsArray.getString(i));
		}
		colors = Collections.unmodifiableList(colors);
		
		return new Palette(id, title, colors, views, comments, hearts);
	}
}

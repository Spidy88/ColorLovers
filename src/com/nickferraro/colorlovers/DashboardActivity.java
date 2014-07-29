package com.nickferraro.colorlovers;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.Toast;

import com.nickferraro.colorlovers.nav.NavigationFragment;
import com.nickferraro.colorlovers.nav.NavigationFragmentListener;
import com.nickferraro.colorlovers.nav.NavigationItem;
import com.nickferraro.colorlovers.palette.PaletteListFragment;

public class DashboardActivity extends Activity implements NavigationFragmentListener {
	private NavigationFragment mNavigationFragment = null;
	private DrawerLayout mDrawerLayout = null;
	private ActionBarDrawerToggle mDrawerToggle = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		mNavigationFragment = (NavigationFragment)getFragmentManager().findFragmentById(R.id.frag_navigation);
		mDrawerLayout = (DrawerLayout)findViewById(R.id.nav_drawer);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(
				this,
				mDrawerLayout,
				R.drawable.ic_drawer,
				R.string.navigation_drawer_open,
				R.string.navigation_drawer_close);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		mNavigationFragment.setListener(this);
	}
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
	
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
	}

	@Override
	public void onNavigationItemSelected(NavigationItem item) {
		Toast.makeText(this, getString(item.getLabelRes()), Toast.LENGTH_SHORT).show();
		mDrawerLayout.closeDrawers();
		
		if( NavigationFragment.NAV_ITEM_PALETTES.equals(item) ) {
			PaletteListFragment frag = new PaletteListFragment();
			getFragmentManager()
				.beginTransaction()
				.replace(R.id.container, frag)
				.commit();
		} else if( NavigationFragment.NAV_ITEM_COLORS.equals(item) ) {
			
		} else if( NavigationFragment.NAV_ITEM_PATTERNS.equals(item) ) {
			
		}
	}
}

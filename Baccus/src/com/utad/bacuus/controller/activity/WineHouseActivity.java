package com.utad.bacuus.controller.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.adapter.WineFragmentAdapter;
import com.utad.bacuus.controller.fragment.WineFragment;
import com.utad.bacuus.controller.fragment.WineHouseFragment;
import com.utad.bacuus.model.Wine;


public class WineHouseActivity extends ActionBarActivity {
	
	public static final String EXTRA_WINE_INDEX = "WINE_SELECTED";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_container);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		int wineIndex = getIntent().getIntExtra(EXTRA_WINE_INDEX, 0);
		
		
		FragmentManager manager = getSupportFragmentManager();
	        
        if (manager.findFragmentById(R.id.fragment_placeholder) == null) {
            
	        WineHouseFragment fragment = new WineHouseFragment();
	        Bundle arguments = new Bundle();
	        arguments.putInt(WineHouseFragment.ARG_WINE_INDEX, wineIndex );
	        fragment.setArguments(arguments);
	        
	        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
	        trx.add(R.id.fragment_placeholder, fragment);
	        trx.commit();
        }
	
        
   
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == android.R.id.home){
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
		
	
	
	
	
	
}

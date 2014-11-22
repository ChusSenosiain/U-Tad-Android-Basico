package com.utad.bacuus.controller;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.widget.TabHost.TabSpec;

import com.utad.bacuus.R;
import com.utad.bacuus.model.Wine;
import com.utad.bacuus.model.WineHouse;

public class WineHouseActivity extends ActionBarActivity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wine_house);
		
		FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
		
		WineHouse wineHouse = WineHouse.getInstance();
		
		for (int i = 0; i < wineHouse.getWinesSize(); i++) {
			
			Wine currentWine = wineHouse.getWine(i);
		   
		    Bundle arguments = new Bundle();
		    arguments.putSerializable(WineFragment.ARG_WINE, currentWine);
		    
		    TabSpec tabWine = tabHost.newTabSpec(wineHouse.getWine(i).getName());
			tabWine.setIndicator(wineHouse.getWine(i).getName());
			
			tabHost.addTab(tabWine, WineFragment.class, arguments);
			
		}
		
	}
}

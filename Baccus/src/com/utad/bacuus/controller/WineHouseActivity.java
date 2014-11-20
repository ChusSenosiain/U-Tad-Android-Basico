package com.utad.bacuus.controller;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.utad.bacuus.R;
import com.utad.bacuus.model.Wine;
import com.utad.bacuus.model.WineHouse;
import com.utad.bacuus.model.WineHouseType;

public class WineHouseActivity extends TabActivity {
	
	public static final String WINE_SELECTED = "WINE_SELECTED";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wine_house);
		
		TabHost tabHost = getTabHost();
		
		
		Wine wine = null;
		
		wine = new WineHouse(WineHouseType.VEGAVAL).getWines().get(0);
		
		Intent vegavalIntent = new Intent(this, WineActivity.class);
	    vegavalIntent.putExtra(WINE_SELECTED, wine);
        
       
		TabSpec tabVegaval = tabHost.newTabSpec("Vegaval");
		tabVegaval.setIndicator("Vegaval");
		tabVegaval.setContent(vegavalIntent);
		
		
		wine = new WineHouse(WineHouseType.BEMBIBRE).getWines().get(0);
		
		Intent bembibreIntent = new Intent(this, WineActivity.class);
		bembibreIntent.putExtra(WINE_SELECTED, wine);
		
		TabSpec tabBembibre = tabHost.newTabSpec("Bembibre");
		tabBembibre.setIndicator("Bembibre");
		tabBembibre.setContent(bembibreIntent);
		
		
		tabHost.addTab(tabVegaval);
		tabHost.addTab(tabBembibre);
		
	}
}

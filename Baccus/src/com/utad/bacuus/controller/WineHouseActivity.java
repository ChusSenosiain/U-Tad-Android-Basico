package com.utad.bacuus.controller;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.utad.bacuus.R;

public class WineHouseActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wine_house);
		
		TabHost tabHost = getTabHost();
		
		Intent vegavalIntent = new Intent(this, WineActivity.class);
		
		TabSpec tabVegaval = tabHost.newTabSpec("Vegaval");
		tabVegaval.setIndicator("Vegaval");
		tabVegaval.setContent(vegavalIntent);
		
		
		Intent bembibreIntent = new Intent(this, WineActivity.class);
		
		TabSpec tabBembibre = tabHost.newTabSpec("Bembibre");
		tabBembibre.setIndicator("Bembibre");
		tabBembibre.setContent(bembibreIntent);
		
		
		tabHost.addTab(tabVegaval);
		tabHost.addTab(tabBembibre);
		
	}
}

package com.utad.bacuus.controller.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.fragment.WineHouseFragment;
import com.utad.bacuus.controller.fragment.WineListFragment;
import com.utad.bacuus.model.Constants;

public class WineListActivity extends ActionBarActivity implements WineListFragment.OnWineSelectedListener{
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wine_list);
		 
		FragmentManager manager = getSupportFragmentManager();
		
		if (findViewById(R.id.list_fragment) != null) {
			WineListFragment wineListFragment = (WineListFragment) manager.findFragmentById(R.id.list_fragment);
		    if (wineListFragment == null) {
				wineListFragment = new WineListFragment();
		        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
		        trx.add(R.id.list_fragment, wineListFragment);
		        trx.commit();
		    }
			wineListFragment.setListener(this);		
		}
	    
	   
		if (findViewById(R.id.winehouse_fragment) != null) {
		    
		    if (manager.findFragmentById(R.id.winehouse_fragment) == null) {
		 		 
				WineHouseFragment fragment = new WineHouseFragment();
				
				Bundle arguments = new Bundle();
				SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
				arguments.putInt(WineHouseFragment.ARG_WINE_INDEX, pref.getInt(Constants.PREF_LAST_WINE, 0));
				fragment.setArguments(arguments);
		        
		        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
		        trx.add(R.id.winehouse_fragment, fragment);
		        trx.commit();
		    }
		}
	}

	

	@Override
	public void onWineSelected(int index) {
		
		if (findViewById(R.id.winehouse_fragment) != null) {
			FragmentManager manager = getSupportFragmentManager();
			WineHouseFragment fragment = (WineHouseFragment) manager.findFragmentById(R.id.winehouse_fragment);
			fragment.showWine(index);
		 
		} else {
			Intent wineHouseActivity = new Intent(this, WineHouseActivity.class);
			wineHouseActivity.putExtra(WineHouseActivity.EXTRA_WINE_INDEX, index);
			startActivity(wineHouseActivity);
		}
		
	}
    

}

package com.utad.bacuus.controller.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.fragment.WineListFragment;

public class WineListActivity extends FragmentActivity {
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_container);
		 
		FragmentManager manager = getSupportFragmentManager();
	    
	    if (manager.findFragmentById(R.id.fragment_placeholder) == null) {
		 
			WineListFragment fragment = new WineListFragment();
	        
	        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
	        trx.add(R.id.fragment_placeholder, fragment);
	        trx.commit();
	    }
	}
    
    
    

}

package com.utad.bacuus.controller.activity;

import com.utad.bacuus.R;
import com.utad.bacuus.R.id;
import com.utad.bacuus.controller.fragment.SettingsFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;


public class SettingsActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_fragment_container);
		
		FragmentManager manager = getSupportFragmentManager();
	        
	    if (manager.findFragmentById(R.id.fragment_placeholder) == null) {
	       
	        SettingsFragment fragment = new SettingsFragment();
	         
	        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
	        trx.add(R.id.fragment_placeholder, fragment);
	        trx.commit();
	    }
		
	}
}

package com.utad.bacuus.controller.activity;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.fragment.WebFragment;
import com.utad.bacuus.model.Wine;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebActivity extends ActionBarActivity {
	
	public final static String EXTRA_URL = "com.utad.bacuus.extras.URL";
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_fragment_container);
		String url = getIntent().getStringExtra(EXTRA_URL);
		
	    FragmentManager manager = getSupportFragmentManager();
        
        if (manager.findFragmentById(R.id.fragment_placeholder) == null) {
   	 
			WebFragment fragment = new WebFragment();
	        Bundle arguments = new Bundle();
	        arguments.putString(WebFragment.ARG_URL, getIntent().getStringExtra(EXTRA_URL));
	        fragment.setArguments(arguments);
	        
	        
	        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
	        trx.add(R.id.fragment_placeholder, fragment);
	        trx.commit();
        }
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
		
		
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean defaultValue = super.onOptionsItemSelected(item);
		
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		} else {
			return defaultValue;
		}
	
	}
	
	



}

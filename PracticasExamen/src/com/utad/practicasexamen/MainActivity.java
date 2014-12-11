package com.utad.practicasexamen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
               
        FragmentManager manager = getSupportFragmentManager();
        
        if (manager.findFragmentById(R.id.placeholder_fragment) == null) {
        	Fragment fragment = new MainFragment();
        	manager.beginTransaction()
        	.add(R.id.placeholder_fragment, fragment)
        	.commit();
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
			
		}
		
		return super.onOptionsItemSelected(item);
		
		
	}
    
    
    


}

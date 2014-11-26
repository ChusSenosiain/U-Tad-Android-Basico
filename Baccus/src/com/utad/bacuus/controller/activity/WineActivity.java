package com.utad.bacuus.controller.activity;



import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.fragment.WineFragment;


public class WineActivity extends ActionBarActivity {
	
	private static final String CURRENT_SCALE = "CURRENT_SCALE";
	public static final String EXTRA_WINE = "WINE_SELECTED";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        
        
        FragmentManager manager = getSupportFragmentManager();
        
        if (manager.findFragmentById(R.id.fragment_placeholder) == null) {
            
	        WineFragment fragment = new WineFragment();
	        Bundle arguments = new Bundle();
	        arguments.putSerializable(WineFragment.ARG_WINE, getIntent().getSerializableExtra(EXTRA_WINE));
	        fragment.setArguments(arguments);
	        
	        
	        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
	        trx.add(R.id.fragment_placeholder, fragment);
	        trx.commit();
        }
        
    }

	
	
	
   
}

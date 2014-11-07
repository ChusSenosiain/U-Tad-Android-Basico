package com.utad.bacuus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
	
	ImageView mWineImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mWineImage = (ImageView) findViewById(R.id.wine_image);
         
        Button mBtnWineBembibre = (Button) findViewById(R.id.btnWineBembibre);
        Button mBtnWineVegaval = (Button) findViewById(R.id.btnWineVegaval);
        
    }
    
    
    public void changeImage(View v) {
    	
    	if (v.getId() == R.id.btnWineVegaval) {
    		mWineImage.setImageResource(R.drawable.vegaval);
    	} else {
    		mWineImage.setImageResource(R.drawable.bembibre);
    	}
    	
    }
    
  
   
}

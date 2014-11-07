package com.utad.bacuus;

import com.utad.bacuus.model.Wine;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
	
	ImageView mWineImage;
	
	private Wine vegaval = null;
	private Wine bembibre = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        
        vegaval = new Wine("Vegaval", "Miguel Calatayud", "Tinto", R.drawable.vegaval, 4, "http://www.vegaval.com/es/");
        vegaval.addGrape("Mencía");
        
        bembibre = new Wine("Bembibre", "Dominio de Tares", "Tinto", R.drawable.bembibre, 5, "http://www.dominiodetares.com");
        bembibre.addGrape("Mencía");
        
        
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

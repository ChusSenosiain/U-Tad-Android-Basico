package com.utad.bacuus.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.utad.bacuus.R;
import com.utad.bacuus.model.Wine;


public class WineActivity extends ActionBarActivity {
	
	private Wine mWine = null;
	ImageView mWineImage = null;
	
	//private Wine bembibre = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
//      bembibre = new Wine("Bembibre", "Dominio de Tares", "Tinto", R.drawable.bembibre, 
//      		5, "http://www.dominiodetares.com", "Del Bierzo, no hay nada más que decir");
//      bembibre.addGrape("Mencía");
        
        mWine = new Wine("Vegaval", "Miguel Calatayud", "Tinto", R.drawable.vegaval, 
        		4, "http://www.vegaval.com/es/", "Lorem fistrum llevame al sircoo jarl papaar papaar diodeno pupita a wan ese pedazo de pecador ahorarr amatomaa. A gramenawer te voy a borrar el cerito se calle ustée qué dise usteer te va a hasé pupitaa fistro apetecan. Torpedo qué dise usteer papaar papaar la caidita condemor benemeritaar diodeno a gramenawer. La caidita hasta luego Lucas ese pedazo de se calle ustée. Amatomaa ese hombree mamaar pupita. Ese hombree no puedor a wan te voy a borrar el cerito qué dise usteer a gramenawer condemor tiene musho peligro mamaar. Diodeno amatomaa papaar papaar la caidita hasta luego Lucas va usté muy cargadoo ahorarr benemeritaar por la gloria de mi madre. Mamaar ese pedazo de de la pradera me cago en tus muelas al ataquerl la caidita condemor se calle ustée.");
         
        mWine.addGrape("Mencía");
        mWine.addGrape("Garnacha");
        
        
        mWineImage = (ImageView) findViewById(R.id.wine_image);
        
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvType = (TextView) findViewById(R.id.tv_type);
        TextView tvWinehouse = (TextView) findViewById(R.id.tv_winehouse);
        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        
        Button btnWeb = (Button) findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent webActivity = new Intent(WineActivity.this, WebActivity.class);
				webActivity.putExtra(WebActivity.EXTRA_URL, mWine.getURL());
				startActivity(webActivity);
				
			}
		});
        
        
        
        RatingBar rating = (RatingBar) findViewById(R.id.rating);
        
        LinearLayout grapesContainer = (LinearLayout) findViewById(R.id.grapes);
        for (String grape: mWine.getGrapes()) {
        	TextView text = new TextView(this);
        	text.setText(grape);
        	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        			LinearLayout.LayoutParams.MATCH_PARENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT);
        	text.setLayoutParams(params);
        	
        	grapesContainer.addView(text);
        	
        }
        
        tvName.setText(mWine.getName());
        tvType.setText(mWine.getType());
        tvWinehouse.setText(mWine.getWineHouse());
        tvDescription.setText(mWine.getDescription());
        mWineImage.setImageResource(mWine.getImage());
        
        rating.setRating(mWine.getRating());
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		boolean defaultValue = super.onOptionsItemSelected(item);
		
		if (item.getItemId() == R.id.menu_settings) {
			Intent settingsIntent = new Intent(this, SettingsActivity.class);
			startActivityForResult(settingsIntent, SettingsActivity.REQUEST_SELECT_SCALETYPE);
			return true;
		} else{
			return defaultValue;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		super.onActivityResult(requestCode, resultCode, intent);
		
		if (requestCode == SettingsActivity.REQUEST_SELECT_SCALETYPE && resultCode == RESULT_OK) {
			
			int optionSelected = intent.getIntExtra(SettingsActivity.OPTION_SELECTED, -1);
			if (optionSelected != -1 && optionSelected == SettingsActivity.OPTION_NORMAL) {
				// A la imagen le doy un type normal
				mWineImage.setScaleType(ScaleType.FIT_CENTER);
			}
			else if (optionSelected != -1 && optionSelected == SettingsActivity.OPTION_FIT) {
				// A la imagen le doy un type estirado
				mWineImage.setScaleType(ScaleType.FIT_XY);
				
			}
		}
	}
	
	
	
	
   
}

package com.utad.bacuus;

import com.utad.bacuus.model.Wine;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	private Wine vegaval = null;
	private Wine bembibre = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
//      bembibre = new Wine("Bembibre", "Dominio de Tares", "Tinto", R.drawable.bembibre, 
//      		5, "http://www.dominiodetares.com", "Del Bierzo, no hay nada más que decir");
//      bembibre.addGrape("Mencía");
        
        vegaval = new Wine("Vegaval", "Miguel Calatayud", "Tinto", R.drawable.vegaval, 
        		4, "http://www.vegaval.com/es/", "Lorem fistrum llevame al sircoo jarl papaar papaar diodeno pupita a wan ese pedazo de pecador ahorarr amatomaa. A gramenawer te voy a borrar el cerito se calle ustée qué dise usteer te va a hasé pupitaa fistro apetecan. Torpedo qué dise usteer papaar papaar la caidita condemor benemeritaar diodeno a gramenawer. La caidita hasta luego Lucas ese pedazo de se calle ustée. Amatomaa ese hombree mamaar pupita. Ese hombree no puedor a wan te voy a borrar el cerito qué dise usteer a gramenawer condemor tiene musho peligro mamaar. Diodeno amatomaa papaar papaar la caidita hasta luego Lucas va usté muy cargadoo ahorarr benemeritaar por la gloria de mi madre. Mamaar ese pedazo de de la pradera me cago en tus muelas al ataquerl la caidita condemor se calle ustée.");
         
        vegaval.addGrape("Mencía");
        vegaval.addGrape("Garnacha");

        
        
        ImageView ivWineImage = (ImageView) findViewById(R.id.wine_image);
        
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvType = (TextView) findViewById(R.id.tv_type);
        TextView tvWinehouse = (TextView) findViewById(R.id.tv_winehouse);
        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        
        RatingBar rating = (RatingBar) findViewById(R.id.rating);
        
        LinearLayout grapesContainer = (LinearLayout) findViewById(R.id.grapes);
        for (String grape: vegaval.getGrapes()) {
        	TextView text = new TextView(this);
        	text.setText(grape);
        	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        			LinearLayout.LayoutParams.MATCH_PARENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT);
        	text.setLayoutParams(params);
        	
        	grapesContainer.addView(text);
        	
        }
        
        tvName.setText(vegaval.getName());
        tvType.setText(vegaval.getType());
        tvWinehouse.setText(vegaval.getWineHouse());
        tvDescription.setText(vegaval.getDescription());
        ivWineImage.setImageResource(vegaval.getImage());
        
        rating.setRating(vegaval.getRating());
        
    }
    
    
   
    
  
   
}

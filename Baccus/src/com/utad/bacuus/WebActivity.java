package com.utad.bacuus;

import com.utad.bacuus.model.Wine;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		
		// Accedo a mis vistas
		WebView browser = (WebView) findViewById(R.id.browser);
		final ProgressBar loading = (ProgressBar) findViewById(R.id.loading);
		
		// Creo el modelo		  
        Wine vegaval = new Wine("Vegaval", "Miguel Calatayud", "Tinto", R.drawable.vegaval, 
        		4, "http://www.vegaval.com/es/", "Lorem fistrum llevame al sircoo jarl papaar papaar diodeno pupita a wan ese pedazo de pecador ahorarr amatomaa. A gramenawer te voy a borrar el cerito se calle ustée qué dise usteer te va a hasé pupitaa fistro apetecan. Torpedo qué dise usteer papaar papaar la caidita condemor benemeritaar diodeno a gramenawer. La caidita hasta luego Lucas ese pedazo de se calle ustée. Amatomaa ese hombree mamaar pupita. Ese hombree no puedor a wan te voy a borrar el cerito qué dise usteer a gramenawer condemor tiene musho peligro mamaar. Diodeno amatomaa papaar papaar la caidita hasta luego Lucas va usté muy cargadoo ahorarr benemeritaar por la gloria de mi madre. Mamaar ese pedazo de de la pradera me cago en tus muelas al ataquerl la caidita condemor se calle ustée.");
         
        vegaval.addGrape("Mencía");
        vegaval.addGrape("Garnacha");
        
        
        // Decirle al webView su webClient
        browser.setWebViewClient(new WebViewClient() {

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				loading.setVisibility(View.VISIBLE);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				loading.setVisibility(View.GONE);
			}
        	
        });
        
        // Cargo la página web del modelo
        browser.loadUrl(vegaval.getURL());
        

		
		
		
	}
	
	

}

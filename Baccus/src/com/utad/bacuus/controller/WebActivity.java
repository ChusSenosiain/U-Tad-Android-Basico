package com.utad.bacuus.controller;

import com.utad.bacuus.R;
import com.utad.bacuus.model.Wine;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebActivity extends ActionBarActivity {
	
	public final static String EXTRA_URL = "com.utad.bacuus.extras.URL";
	
	private WebView mBrowser;
	private static final String CURRENT_URL = "CURRENT_URL";
	private static final int MENU_RELOAD = 0;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		
		String url = getIntent().getStringExtra(EXTRA_URL);
		
		// Accedo a mis vistas
		mBrowser = (WebView) findViewById(R.id.browser);
		final ProgressBar loading = (ProgressBar) findViewById(R.id.loading);
		
		  
        
        // Decirle al webView su webClient
        mBrowser.setWebViewClient(new WebViewClient() {

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
        if (savedInstanceState != null && savedInstanceState.containsKey(CURRENT_URL)) {
        	mBrowser.loadUrl(savedInstanceState.getString(CURRENT_URL));
        } else {
        	mBrowser.loadUrl(url);
        }
        
		
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		String currentURL = mBrowser.getUrl();
		outState.putString(CURRENT_URL, currentURL);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		//MenuItem reload = menu.add(Menu.NONE, MENU_RELOAD, 0, R.string.reload);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean defaultValue =  super.onOptionsItemSelected(item);
		if (item.getItemId() == MENU_RELOAD) {
			mBrowser.reload();
			return true;
		} else {
			return defaultValue;
		}
		
	}
	
	
	
	
	
	
	
	

}

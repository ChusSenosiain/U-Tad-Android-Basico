package com.utad.bacuus.controller.fragment;

import com.utad.bacuus.R;
import com.utad.bacuus.model.Wine;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebFragment extends Fragment{
	
	
	public final static String ARG_URL = "com.utad.bacuus.args.URL";
	private static final String CURRENT_URL = "CURRENT_URL";
	private static final int MENU_RELOAD = 0;
	
	private WebView mBrowser;
	

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_web, container, false);
		
		String url = getArguments().getString(ARG_URL);
		
		// Accedo a mis vistas
		mBrowser = (WebView) root.findViewById(R.id.browser);
		final ProgressBar loading = (ProgressBar) root.findViewById(R.id.loading);
		
	      
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
        
      
		return root;
	}


	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		String currentURL = mBrowser.getUrl();
		outState.putString(CURRENT_URL, currentURL);

	}
	
	

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main, menu);
		//MenuItem reload = menu.add(Menu.NONE, MENU_RELOAD, 0, R.string.reload);
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

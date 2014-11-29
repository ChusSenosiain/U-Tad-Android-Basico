package com.utad.bacuus.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.activity.WineActivity;



public class WineHouse {
	
	
	private static final String WINES_URL = "http://baccusapp.herokuapp.com/wines";
	
	private WineHouseType mWineHouseType;
	private List<Wine> mWines;
	
	private static WineHouse sInstance;
	
	public static WineHouse getInstance() {
		if (sInstance == null) {
			sInstance = new WineHouse();
		}
		
		return sInstance;
		
	}
	
	
	@SuppressLint("NewApi") 
	private WineHouse() {
		
		try {
			
			URLConnection conn = new URL(WINES_URL).openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
			JSONArray jsonRoot = new JSONArray(sb.toString());
			for (int i = 0; i < jsonRoot.length(); i ++) {
				JSONObject jsonWine = (JSONObject) jsonRoot.get(i);
				
				if (jsonWine.has("name")) {
					addWine(new Wine(jsonWine));
				}
				
			}
			} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	

	private void addWine(Wine wine) {
		
		if (mWines == null) {
			mWines = new LinkedList<Wine>();
		}
		mWines.add(wine);
	}
	
	public List<Wine> cloneWineList() {
		List<Wine> copy = new LinkedList<Wine>();
		for (Wine wine: mWines) {
			copy.add(wine);
		}
		
		return copy;
	}
	
	
	public Wine getWine(int position) {
		return mWines.get(position);
	}
	
	
	public int getWinesSize() {
		return mWines.size();
	}


	
	
	

	/*
	private Wine createWine(WineHouseType wineHouseType) {
		
		Wine wine = null;
		
		if (wineHouseType == WineHouseType.BEMBIBRE) {
		
			wine = new Wine("Bembibre", "Dominio de Tares", "Tinto", R.drawable.bembibre, 
		    		5, "http://www.dominiodetares.com", "Del Bierzo, no hay nada más que decir");
			wine.addGrape("Mencía");
			
		} else if (wineHouseType == WineHouseType.VEGAVAL) {
			
			wine = new Wine("Vegaval", "Miguel Calatayud", "Tinto", R.drawable.vegaval, 
	        		4, "http://www.vegaval.com/es/", "Lorem fistrum llevame al sircoo jarl papaar papaar diodeno pupita a wan ese pedazo de pecador ahorarr amatomaa. A gramenawer te voy a borrar el cerito se calle ustée qué dise usteer te va a hasé pupitaa fistro apetecan. Torpedo qué dise usteer papaar papaar la caidita condemor benemeritaar diodeno a gramenawer. La caidita hasta luego Lucas ese pedazo de se calle ustée. Amatomaa ese hombree mamaar pupita. Ese hombree no puedor a wan te voy a borrar el cerito qué dise usteer a gramenawer condemor tiene musho peligro mamaar. Diodeno amatomaa papaar papaar la caidita hasta luego Lucas va usté muy cargadoo ahorarr benemeritaar por la gloria de mi madre. Mamaar ese pedazo de de la pradera me cago en tus muelas al ataquerl la caidita condemor se calle ustée.");
	         
	        wine.addGrape("Mencía");
	        wine.addGrape("Garnacha");
		}
		
		return wine;
	}*/
	
	

	

}

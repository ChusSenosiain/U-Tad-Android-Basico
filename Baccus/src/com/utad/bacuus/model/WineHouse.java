package com.utad.bacuus.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.content.Intent;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.WineActivity;

public class WineHouse {
	
	private WineHouseType mWineHouseType;
	private List<Wine> mWines;
	
	private static WineHouse sInstance;
	
	public static WineHouse getInstance() {
		if (sInstance == null) {
			sInstance = new WineHouse();
		}
		
		return sInstance;
		
	}
	
	
	private WineHouse() {
		
		Wine wine = null;
		
		wine = new Wine("Bembibre", "Dominio de Tares", "Tinto", R.drawable.bembibre, 
	    		5, "http://www.dominiodetares.com", "Del Bierzo, no hay nada más que decir");
		wine.addGrape("Mencía");
		
		this.addWine(wine);
		
		
		
		wine = new Wine("Vegaval", "Miguel Calatayud", "Tinto", R.drawable.vegaval, 
        		4, "http://www.vegaval.com/es/", "Lorem fistrum llevame al sircoo jarl papaar papaar diodeno pupita a wan ese pedazo de pecador ahorarr amatomaa. A gramenawer te voy a borrar el cerito se calle ustée qué dise usteer te va a hasé pupitaa fistro apetecan. Torpedo qué dise usteer papaar papaar la caidita condemor benemeritaar diodeno a gramenawer. La caidita hasta luego Lucas ese pedazo de se calle ustée. Amatomaa ese hombree mamaar pupita. Ese hombree no puedor a wan te voy a borrar el cerito qué dise usteer a gramenawer condemor tiene musho peligro mamaar. Diodeno amatomaa papaar papaar la caidita hasta luego Lucas va usté muy cargadoo ahorarr benemeritaar por la gloria de mi madre. Mamaar ese pedazo de de la pradera me cago en tus muelas al ataquerl la caidita condemor se calle ustée.");
         
        wine.addGrape("Mencía");
        wine.addGrape("Garnacha");
        
    	this.addWine(wine);
		
	}
	
	/*
	public WineHouse(WineHouseType wineHouseType) {
		
		this.mWineHouseType = wineHouseType;
		
		if (wineHouseType == WineHouseType.ALL) {
			this.addWine(createWine(WineHouseType.BEMBIBRE));
			this.addWine(createWine(WineHouseType.VEGAVAL));
		} else {
			this.addWine(createWine(wineHouseType));
		}
		
	} */
	
	private void addWine(Wine wine) {
		
		if (mWines == null) {
			mWines = new LinkedList<Wine>();
		}
		mWines.add(wine);
	}
	
	
	
	/*
	public WineHouseType getWineHouseType() {
		return mWineHouseType;
	}

	public void setWineHouseType(WineHouseType wineHouseType) {
		mWineHouseType = wineHouseType;
	}

	public List<Wine> getWines() {
		return mWines;
	}

	public void setWines(List<Wine> wines) {
		mWines = wines;
	}*/
	
	
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

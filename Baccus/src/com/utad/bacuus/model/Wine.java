package com.utad.bacuus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Wine implements Serializable {
	
	private String mName;
	private String mWineHouse;
	private String mType;
	private int mImage;
	private int mRating;
	private String mURL;
	private String mDescription;
	private List<String> mGrapes;
	
	public Wine() {}
	
	
	public Wine(String name, String wineHouse, String type, int image,
			int rating, String URL, String description) {
		super();
		mName = name;
		mWineHouse = wineHouse;
		mType = type;
		mImage = image;
		mRating = rating;
		mGrapes = new LinkedList<String>();
		mURL = URL;
		mDescription = description;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public String getWineHouse() {
		return mWineHouse;
	}

	public void setWineHouse(String wineHouse) {
		mWineHouse = wineHouse;
	}

	public String getType() {
		return mType;
	}

	public void setType(String type) {
		mType = type;
	}

	public int getImage() {
		return mImage;
	}

	public void setImage(int image) {
		mImage = image;
	}

	public int getRating() {
		return mRating;
	}

	public void setRating(int rating) {
		mRating = rating;
	}

	public List<String> getGrapes() {
		return mGrapes;
	}

	public void setGrapes(List<String> grapes) {
		mGrapes = grapes;
	}
	
	public void addGrape(String grape) {
		mGrapes.add(grape);
	}


	public String getURL() {
		return mURL;
	}


	public void setURL(String uRL) {
		mURL = uRL;
	}


	public String getDescription() {
		return mDescription;
	}


	public void setDescription(String description) {
		mDescription = description;
	}


	
	
	
}

package com.utad.bacuus.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;

import com.utad.bacuus.R;

public class Wine implements Serializable {
	
	private String mId;
	private String mName;
	private String mWineHouse;
	private String mType;
	private int mImage;
	private int mRating;
	private String mURL;
	private String mDescription;
	private String mImageURL;
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
	
	public Wine(JSONObject jsonWine) {
		
		mId = jsonWine.optString("_id");
		mName = jsonWine.optString("name");
		mWineHouse = jsonWine.optString("company");
		mType = jsonWine.optString("origin");
		mImage = R.drawable.vegaval;
		mRating = jsonWine.optInt("rating");
		mURL = jsonWine.optString("wine_web");
		mDescription = jsonWine.optString("notes");
		mImageURL = jsonWine.optString("picture");
		
		mGrapes = new LinkedList<String>();
		
		try {
		    JSONArray grapes = jsonWine.getJSONArray("grapes");
			for (int i = 0; i < grapes.length(); i ++) {
				this.addGrape(grapes.getJSONObject(i).optString("grape"));
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@SuppressLint("NewApi") public Bitmap getBitmap(Context context) {
		
		Bitmap bitmap = null;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
	
		try {
			
			File imageFile = new File(context.getCacheDir() + "/" + mId);
			
			if (imageFile.exists()) {
				bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
			} else {
				bitmap = BitmapFactory.decodeStream((InputStream) new URL(mImageURL).getContent());
				
				FileOutputStream fOut = new FileOutputStream(imageFile);
			    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
			    fOut.flush();
			    fOut.close();								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	  
	  return bitmap;
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


	@Override
	public String toString() {
		return mName;
	}


	
	
}

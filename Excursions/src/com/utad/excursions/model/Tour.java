package com.utad.excursions.model;

import java.util.ArrayList;



public class Tour {
	
	private Integer tourID;
	private TourType tourType;
	private String tourName;
	private String tourDescription;
	private ArrayList<Tourist> tourTourists;
	
	public Tour(){}

	public Tour(Integer tourID, TourType tourType, String tourName, String tourDescription, ArrayList<Tourist> tourTourists) {
		super();
		this.tourID = tourID;
		this.tourType = tourType;
		this.tourName = tourName;
		this.tourDescription = tourDescription;
		this.tourTourists = tourTourists;
	}

	public Integer getTourID() {
		return tourID;
	}

	public void setTourID(Integer tourID) {
		this.tourID = tourID;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}

	public TourType getTourType() {
		return tourType;
	}

	public void setTourType(TourType tourType) {
		this.tourType = tourType;
	}

	public ArrayList<Tourist> getTourTourists() {
		return tourTourists;
	}

	public void setTourTourist(ArrayList<Tourist> tourTourists) {
		this.tourTourists = tourTourists;
	}
	
	
	public void addTourTourist(Tourist tourist) {
		
		if (this.tourTourists == null) {
			this.tourTourists = new ArrayList<Tourist>();
		}
		
		this.tourTourists.add(tourist);
	}
	
	
	
	
	
	
	

}

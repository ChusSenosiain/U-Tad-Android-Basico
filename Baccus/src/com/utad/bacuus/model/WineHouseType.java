package com.utad.bacuus.model;

public enum WineHouseType {
	VEGAVAL(1, "Vegaval"),
	BEMBIBRE(2, "Bembibre"),
	ALL(3, "Varios");
	

	private Integer mWineHouseID;
	private String mWineHouseName;
	
	WineHouseType(Integer wineHouseID, String wineHouseName) {
		this.mWineHouseID = wineHouseID;
		this.mWineHouseName = wineHouseName;
	}

	public Integer getWineHouseID() {
		return mWineHouseID;
	}


	public String getWineHouseName() {
		return mWineHouseName;
	}

}

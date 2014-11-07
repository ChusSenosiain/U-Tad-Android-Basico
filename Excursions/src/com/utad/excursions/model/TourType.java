package com.utad.excursions.model;

public enum TourType {
	ADVENTURE (1, "Viaje de aventuras"),
	ROMANTIC(2, "Escapada romántica"),
	SPORT(3, "Escápate y disfruta de tu deporte favorito"),
	BUSSINESS(4, "Viaje de negocios"),
	OTHERS(5, "Otros");
	
	private String tourTypeDescription;
	private Integer tourTypeID;
	
	
	TourType(Integer tourTypeID, String tourTypeDescription) {
		this.tourTypeID = tourTypeID;
		this.tourTypeDescription = tourTypeDescription;
	}
	
	
	public String getTourTypeDescription() {
		return tourTypeDescription;
	}
	
	public Integer getTourTypeID() {
		return tourTypeID;
	}
	
}

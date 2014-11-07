package com.utad.excursions.model;

public class Tourist<T> {
	
	T tourist;
	
	public Tourist(T tourist) {
		this.tourist = tourist;
	}
	
	public T getTourist() {
		return this.tourist;
	}
	
	public void setTourist(T tourist) {
		this.tourist = tourist;
	}
	
	public Integer getTouristID() {
		
		Integer touristID = null;
		
		if (tourist.getClass() == Person.class) {
			touristID = ((Person) tourist).getPersonID();
		} else if (tourist.getClass() == Employee.class) {
			touristID = ((Employee) tourist).getPersonID();
		}
		
		return touristID;
	}

}

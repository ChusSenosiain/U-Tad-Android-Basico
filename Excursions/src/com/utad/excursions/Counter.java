package com.utad.excursions;

public class Counter {
	
	private static Integer tourID = 0;
	private static Integer personID = 0;
	
	public static Integer newTourID() {
		tourID++;
		return tourID;
	}
	
	public static Integer newPersonID() {
		personID++;
		return personID;
	}

}

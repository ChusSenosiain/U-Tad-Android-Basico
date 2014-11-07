package com.utad.excursions.model;


public class Person {
	protected Integer personID;
	protected String personName;
	protected String personSurname;
	protected Integer personAge;
	protected String personDNI;
	protected String personImageURL;
	
	public Person(){}
	
	public Person(Integer personID, String personName, String personSurname,
			Integer personAge, String personDNI, String personImageURL) {
		this.personID = personID;
		this.personName = personName;
		this.personSurname = personSurname;
		this.personAge = personAge;
		this.personDNI = personDNI;
		this.personImageURL = personImageURL;
	}
	
	public Integer getPersonID() {
		return personID;
	}
	public void setPersonID(Integer personID) {
		this.personID = personID;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonSurname() {
		return personSurname;
	}
	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}
	public Integer getPersonAge() {
		return personAge;
	}
	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}
	public String getPersonDNI() {
		return personDNI;
	}
	public void setPersonDNI(String personDNI) {
		this.personDNI = personDNI;
	}

	public String getPersonImageURL() {
		return personImageURL;
	}

	public void setPersonImageURL(String personImageURL) {
		this.personImageURL = personImageURL;
	}
	

}

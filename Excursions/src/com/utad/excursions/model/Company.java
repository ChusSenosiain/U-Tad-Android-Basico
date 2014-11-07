package com.utad.excursions.model;

public class Company {
	
	private Integer companyID;
	private String companyName;
	
	public Company() {}
	
	public Company(Integer companyID, String companyName) {
		this.companyID = companyID;
		this.companyName = companyName;
	}

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

}

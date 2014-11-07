package com.utad.excursions.model;


public enum DepartmentType {
	RRHH(1, "Recursos humanos"),
	AC(2, "Atención al cliente"),
	ID(3, "I+D"),
	OTHERS(4, "Otros");

	private Integer departmentID;
	private String departmentName;
	
	DepartmentType(Integer departmentID, String departmentName) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}
	
	
	public String getDepartmenyTypeDescription() {
		return departmentName;
	}
	
	public Integer getDepartmentTypeID() {
		return departmentID;
	}
	
	
}


 
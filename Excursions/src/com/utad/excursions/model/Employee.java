package com.utad.excursions.model;

public class Employee extends Person {

	private DepartmentType employeeDepartmentType;
	private Company employeeCompany;
	
	public Employee() {
		super();
	}

	public Employee(Integer personID, String personName, String personSurname,
			Integer personAge, String personDNI, String personImageURL, 
			DepartmentType employeeDepartmentType, Company employeeCompany) {
		super(personID, personName, personSurname, personAge, personDNI, personImageURL);
		this.employeeDepartmentType = employeeDepartmentType;
		this.employeeCompany = employeeCompany;
	}


	public DepartmentType getEmployeeDepartmentType() {
		return employeeDepartmentType;
	}

	public void setEmployeeDepartmentType(DepartmentType employeeDepartmentType) {
		this.employeeDepartmentType = employeeDepartmentType;
	}

	public Company getEmployeeCompany() {
		return employeeCompany;
	}

	public void setEmployeeCompany(Company employeeCompany) {
		this.employeeCompany = employeeCompany;
	}

	
	
	
	
}

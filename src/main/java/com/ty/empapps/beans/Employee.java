package com.ty.empapps.beans;

public class Employee {
 
	private String empName;
	private String empEmail;
	private String empDateOfBirth;
	private int empAge;
	private double empSalary;
	private boolean empStatus;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpDateOfBirth() {
		return empDateOfBirth;
	}
	public void setEmpDateOfBirth(String empDateOfBirth) {
		this.empDateOfBirth = empDateOfBirth;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public boolean isEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(boolean empStatus) {
		this.empStatus = empStatus;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empEmail=" + empEmail + ", empDateOfBirth=" + empDateOfBirth
				+ ", empAge=" + empAge + ", empSalary=" + empSalary + ", empStatus=" + empStatus + "]";
	}
	
		
}

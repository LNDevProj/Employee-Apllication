package com.ty.empapps.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empapp_table")
public class EmployeeDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empNumber;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_email")
	private String empEmail;
	
	@Column(name =  "emp_dob")
	private LocalDate empDateOfBirth;
	
	@Column(name = "emp_age")
	private int empAge;
	
	@Column(name = "emp_salary")
	private double empSalary;
	
	@Column(name = "emp_status")
	private boolean empStatus;
	
	
	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

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

	public LocalDate getEmpDateOfBirth() {
		return empDateOfBirth;
	}

	public void setEmpDateOfBirth(LocalDate empDateOfBirth) {
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
		return "EmployeeDto [empNumber=" + empNumber + ", empName=" + empName + ", empEmail=" + empEmail
				+ ", empDateOfBirth=" + empDateOfBirth + ", empAge=" + empAge + ", empSalary=" + empSalary
				+ ", empStatus=" + empStatus + "]";
	}

	

}


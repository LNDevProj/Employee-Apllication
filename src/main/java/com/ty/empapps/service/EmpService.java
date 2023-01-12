package com.ty.empapps.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.empapps.beans.Employee;
import com.ty.empapps.dao.EmpDao;
import com.ty.empapps.dto.EmployeeDto;

@Service
public class EmpService {
	
	@Autowired
	public EmpDao empDao;

	public EmployeeDto saveEmployee(Employee employee) {
		
		EmployeeDto employeeDto = new EmployeeDto();
	
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setEmpEmail(employee.getEmpEmail());
		employeeDto.setEmpDateOfBirth(LocalDate.parse(employee.getEmpDateOfBirth()));
		employeeDto.setEmpAge(LocalDate.now().getYear() - LocalDate.parse(employee.getEmpDateOfBirth()).getYear());
		employeeDto.setEmpSalary(employee.getEmpSalary());

		employeeDto.setEmpStatus(employee.isEmpStatus());

//		if(employee.isEmpStatus() == true) {
//			employeeDto.setEmpStatus("Active");
//		}else {
//			employeeDto.setEmpStatus("InActicve");
//		}
		
		return empDao.insertEmployee(employeeDto);
	}

	public List<EmployeeDto> getAllEmployees() {

		return empDao.getAllEmployees();
	}


	public EmployeeDto updateEmployee(Employee employee, int empNumber) {
		
		EmployeeDto employeeDto= new EmployeeDto();
		
		employeeDto.setEmpNumber(empNumber);
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setEmpEmail(employee.getEmpEmail());
//		LocalDate empDateOfBirth = LocalDate.parse(employee.getEmpDateOfBirth());
//		employeeDto.setEmpAge(employee.getEmpAge());
//		employeeDto.setEmpAge(LocalDate.now().getYear() - LocalDate.parse(employee.getEmpDateOfBirth()).getYear());
		
		employeeDto.setEmpDateOfBirth(LocalDate.parse(employee.getEmpDateOfBirth()));
		employeeDto.setEmpAge(LocalDate.now().getYear() - LocalDate.parse(employee.getEmpDateOfBirth()).getYear());
		employeeDto.setEmpSalary(employee.getEmpSalary());
		employeeDto.setEmpStatus(employee.isEmpStatus());
//		if(employee.isEmpStatus() == true) {
//			employeeDto.setEmpStatus("Active");
//		}else {
//			employeeDto.setEmpStatus("InActicve");
//		}
//	
//		employeeDto.setEmpStatus(employee.isEmpStatus());
		
		
		return empDao.updateEmployee(employeeDto);
	}

	public EmployeeDto deleteEmployee(int employeeNumber) {
		
		
		EmployeeDto allEmployee= empDao.searchEmployee(employeeNumber);
		
		if (allEmployee == null) {
			return null;
		}else {
			return empDao.deleteEmployee(allEmployee);
		}


	}

	public EmployeeDto searchEmployee(int employeeNumber) {
		return empDao.searchEmployee(employeeNumber);
	}

}

package com.ty.empapps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.empapps.dto.EmployeeDto;

@Repository
public class EmpDao {
	
	@Autowired
	private EntityManagerFactory factory;

	public EmployeeDto insertEmployee(EmployeeDto newEmployeeDto) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(newEmployeeDto);
			transaction.commit();
			return newEmployeeDto;
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			return null;

		}
		
	}

	public List<EmployeeDto> getAllEmployees() {
	
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM EmployeeDto");
		return query.getResultList();
	}

	public EmployeeDto searchEmployee(int empNumber) {

		EntityManager manager = factory.createEntityManager();
		return manager.find(EmployeeDto.class, empNumber);
	}

	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
	
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.merge(employeeDto);
			transaction.commit();
			return employeeDto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	
	}

	public EmployeeDto deleteEmployee(EmployeeDto employeeDto) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			EmployeeDto employeeDto2= manager.merge(employeeDto);
			manager.remove(employeeDto2);
			transaction.commit();
			return employeeDto2;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	
	}
	
}

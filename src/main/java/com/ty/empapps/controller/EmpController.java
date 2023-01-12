package com.ty.empapps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.empapps.beans.Employee;
import com.ty.empapps.dto.EmployeeDto;
import com.ty.empapps.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/home")
	public ModelAndView getHomePage(ModelAndView modelAndView) {
		
		modelAndView.setViewName("index");
		return modelAndView;
		
	}
	
	@GetMapping("/add-employee")
	public ModelAndView getAddEmployeeFormPage(ModelAndView modelAndView) {
		
		modelAndView.setViewName("add-employee-form");
		return modelAndView;

	}
	
	@PostMapping("/employees")
	public String saveEmployee(Employee employee, Model model) {
		
		System.out.println(employee);
		EmployeeDto savedEmployee = empService.saveEmployee(employee);
		
		if (savedEmployee != null) {
			model.addAttribute("msg", "Employee Added");
			return "display-employee";
			
		} else {
			return "redirect://add-employee";
		}
		
	}
	
	@GetMapping("/display-all")
	public ModelAndView viewAllEmployees(ModelAndView modelAndView, Model model) {

		List<EmployeeDto> allEmployees = empService.getAllEmployees();
		System.out.println(allEmployees);
		model.addAttribute("employees", allEmployees);
		modelAndView.setViewName("display-all-employees");
		return modelAndView;
		
	}
	
	@GetMapping("/search-employee")
	public ModelAndView getSearchPageForm(ModelAndView modelAndView) {
		
		modelAndView.setViewName("search-employee-form");
		return modelAndView;
		
	}
	
	
	@GetMapping("/search-employees")
	public ModelAndView searchEmployee(@RequestParam("empNumber") int empNumber, Model model, ModelAndView modelAndView) {
		EmployeeDto employeeDto = empService.searchEmployee(empNumber);
		if (employeeDto != null) {
			model.addAttribute("msg", employeeDto);
		} else {
			model.addAttribute("msg", "Employee Data Not found for Employee Number"+empNumber);
		}
		modelAndView.setViewName("display-employee");
		return modelAndView;
		
	}
	
	@GetMapping("/edit/{empNumber}")
	public ModelAndView getEditEmployeePage(ModelAndView modelAndView,Model model, @PathVariable("empNumber") int empNumber) {
		EmployeeDto searchedEmployee = empService.searchEmployee(empNumber);
		if(searchedEmployee == null) {
			model.addAttribute("msg", "Update Cannot be done because Data not found for tarin number "+empNumber);
			modelAndView.setViewName("display-all");
		} else {
			model.addAttribute("employee", searchedEmployee);
			modelAndView.setViewName("edit-employee-page");
		}
		return modelAndView;
	}
	
	@PostMapping("/update-employee")
	public String updateEmployee(Employee employee,ModelAndView modelAndView,@RequestParam("empNumber") int empNumber) {
		System.out.println(employee);
		EmployeeDto employeeDto = empService.updateEmployee(employee,empNumber);
		System.out.println(employeeDto);
		return "redirect:/display-all";
		
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("empNumber") int empNumber, Model model) {
		EmployeeDto  deletedEmployee =empService.deleteEmployee(empNumber);
		if (deletedEmployee==null) {
			model.addAttribute("msg","Deleted can't be done becaz data not found for the train Number"+empNumber);
			return "display-employee";
		} else {
			return "forward:/display-all";
		}
		
	}

	
}

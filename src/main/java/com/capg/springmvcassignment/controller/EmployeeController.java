package com.capg.springmvcassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capg.springmvcassignment.dto.EmployeeInfoBean;
import com.capg.springmvcassignment.service.EmployeeService;
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	

	@GetMapping("/searchEmp")
	public String searchEmployee(@RequestParam(name = "empId") int empIdVal, ModelMap modelMap) {
		EmployeeInfoBean bean = employeeService.getEmployeeByid(empIdVal);
		if (bean != null) {
			modelMap.addAttribute("empInfo", bean);
		} else {
			modelMap.addAttribute("errmsg", "Employee Details not found");

		}
		return "searchEmployee";
	}


	@PostMapping("/addEmp")
	public String addEmployee(EmployeeInfoBean bean, ModelMap modelMap) {

		boolean isAdded = employeeService.addEmployee(bean);

		if (isAdded) {
			modelMap.addAttribute("msg", "Employee Added succesfully");

		} else {
			modelMap.addAttribute("errMsg", "Unable to Add Employee Details");
		}
		return "addEmployee";
	}


	@GetMapping("/updateEmp")
	public String updateEmployee(EmployeeInfoBean bean, ModelMap modelMap) {

		boolean updated = employeeService.updateEmployee(bean);
		if (updated) {
			modelMap.addAttribute("msg", "EmployeeDetails Updated");
		} else {
			modelMap.addAttribute("errMsg", "EmployeeDetails not Updated");
		}
		return "updateEmployee";
	}


	@GetMapping("/deleteEmp")
	public String deleteEmployee(int empId ,ModelMap modelMap) {
			
		boolean updated=employeeService.deleteEmployee(empId);
		if(updated) {
			modelMap.addAttribute("msg", "EmployeeDetails deleted");
		}
		else {
			modelMap.addAttribute("errMsg", "EmployeeDetails not deleted");
		}
		return "updateEmployee";
	
	}



	@GetMapping("/allEmp")
	public String allEmployee(EmployeeInfoBean bean,ModelMap modelMap) {
			
		List<EmployeeInfoBean> bean1=employeeService.getAllEmployees();
	
		if(bean1!=null && !bean1.isEmpty()) {
			modelMap.addAttribute("msg", bean1);
		}
		else {
			modelMap.addAttribute("errMsg", "EmployeeDetails not deleted");
		}
		return "allEmployeeDetails";
	
	}

}

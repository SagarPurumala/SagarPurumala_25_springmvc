package com.capg.springmvcassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springmvcassignment.dao.EmployeeDAO;
import com.capg.springmvcassignment.dto.EmployeeInfoBean;
@Service
public class EmployeeServiceJDBCImp implements EmployeeService{
	@Autowired
	EmployeeDAO empdao;
	@Override
	public EmployeeInfoBean getEmployeeByid(int id) {
		// TODO Auto-generated method stub
		return empdao.getEmployeeByid(id);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return empdao.addEmployee(bean);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return empdao.updateEmployee(bean);
	}

	@Override
	public boolean deleteEmployee(int Id) {
		// TODO Auto-generated method stub
		return empdao.deleteEmployee(Id);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		// TODO Auto-generated method stub
		return empdao.getAllEmployees();
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		// TODO Auto-generated method stub
		return empdao.authenticate(empId, password);
	}
	

}

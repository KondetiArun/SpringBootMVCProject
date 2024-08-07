package com.nt.service;

import com.nt.entity.Employee;

public interface IEmpService 
{
	
	public Iterable<Employee> showAllEmployees();
	
	public String registerEmployee(Employee emp);
	
	public Employee fetchEmployeeByNo(int no);
	
	public String updateEmployee(Employee emp);
	
	public String deleteEmpById(int no);

}

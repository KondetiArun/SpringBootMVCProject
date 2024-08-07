package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service
public class IEmpServiceImp implements IEmpService 
{
	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public Iterable<Employee> showAllEmployees()
	{
		return empRepo.findAll();
	}
	
	@Override
	public String registerEmployee(Employee emp) 
	{
		int idVal = empRepo.save(emp).getEmpno();
		
		return "Employee is saved eith id value::"+idVal;
	}
	
	@Override
	public Employee fetchEmployeeByNo(int no)
	{
		return empRepo.findById(no).orElseThrow(()->new IllegalArgumentException("Invalid employee id"));
	}
	
	@Override
	public String updateEmployee(Employee emp) 
	{
		//load object
		Optional<Employee> opt = empRepo.findById(emp.getEmpno());
		if(opt.isPresent())
		{
			//update
			empRepo.save(emp);
			return emp.getEmpno()+" employee details are updated";
		}
		return emp.getEmpno()+" Employee is not found";
	}
	
	@Override
	public String deleteEmpById(int no) 
	{
		//load object
		//Optional<Employee> opt = empRepo.findById(no);
		boolean flag=empRepo.existsById(no);
		if(flag)
		{
			empRepo.deleteById(no);
			return no+" Employee found and deleted";
		}
		return no+" employee is not found and not deleted";
	}
}

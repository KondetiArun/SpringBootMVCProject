package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController 
{
	@Autowired
	private IEmpService empService;
	
	
	@GetMapping("/")
	public String showHomePage()
	{
		return "welcome";
	}
	
	@GetMapping("/report")
	public String showAllEmployeesReport(Map<String,Object> map)
	{
		Iterable<Employee> emp = empService.showAllEmployees();
		
		map.put("empsData", emp);
		return "show_report";
	}
	
	@GetMapping("/register")
	public String showAddEmployeeFormPage(@ModelAttribute("emp") Employee emp)
	{
		
		//return LVN
		return "register_form";
	}
	//problem pages refresh again
	/*@PostMapping("/register")// to launch add employee form page
	public String registerEmployee(Map<String,Object> map, @ModelAttribute("emp") Employee emp)
	{
		String msg = empService.registerEmployee(emp);
		Iterable<Employee> it = empService.showAllEmployees();
		
		//Keep in Shared Memory
		map.put("resultMsg", msg);
		map.put("empsData", it);
		
		return "show_report";
	}*/
	
	//refresh browser msg gone
	/*@PostMapping("/register")// to launch add employee form page
	public String registerEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp)
	{
		String msg = empService.registerEmployee(emp);
		
		//Keep in Shared Memory
		attrs.addFlashAttribute("resultMsg", msg);
		
		return "redirect:report";
	}*/
	
	
	@PostMapping("/register")
	public String registerEmployee(HttpSession sess, @ModelAttribute("emp") Employee emp)
	{
		String msg = empService.registerEmployee(emp);
		
		//Keep in Shared Memory
		sess.setAttribute("resultMsg", msg);
		
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("no") int no,
									@ModelAttribute("emp") Employee emp)
	{
		//use srvice
		Employee emp1 = empService.fetchEmployeeByNo(no);
		//copy data to model class obj
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit_form";
	}
	
	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attr)
	{
		//use Service
		String msg = empService.updateEmployee(emp);
		//keep result in flash attributes
		attr.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no")int no,
									RedirectAttributes attr)
	{
		//use service
		String msg=empService.deleteEmpById(no);
		attr.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}
	
	
	
	
	
	
	
	
	
}

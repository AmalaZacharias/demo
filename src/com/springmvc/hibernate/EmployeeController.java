package com.springmvc.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {
	
	
    @Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/employeeForm")  
    public ModelAndView showform(){  
         
		 return new ModelAndView("employeeForm","command",new EmployeeBean());  
    }  
    @RequestMapping(value="/saveEmployee",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("employeeBean") EmployeeBean employeeBean){  
      
        System.out.println(employeeBean.getName()+" "+employeeBean.getSalary()+" "+employeeBean.getDesignation());   
       
      //transfer the data from bean to entity
      		EmployeeEntity employeeEntity = new EmployeeEntity();
      		employeeEntity.setEmployeeName(employeeBean.getName());
      		employeeEntity.setEmployeeSalary(employeeBean.getSalary());
      		employeeEntity.setEmployeeDesignation(employeeBean.getDesignation());
      		
      		employeeService.saveEmployee(employeeEntity);
      		
      		
      		
      		return new ModelAndView("success");// will redirect to viewemp request mapping
        
        
       
    }  
      
    
    }  

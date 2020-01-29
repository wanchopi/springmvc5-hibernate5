package com.wanchopi.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wanchopi.spring.entity.Employee;
import com.wanchopi.spring.service.IEmployeeService;

/**
 * Controller
 * @author Wanchopi
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	@RequestMapping("/")
	public String findAllEmployees(Model model) {
		List<Employee> employees = service.getAllEmployees();
		model.addAttribute("employees", employees);
		return "index";
	}
	
	@GetMapping("/form")
	public String showForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "employee-form";
		} else {
			service.saveEmployee(employee);
			return "redirect:/";
		}
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long id) {
		service.deleteEmployee(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("id") long id, Model model) {
		Employee employee = service.getEmployee(id);
		model.addAttribute("employee", employee);
		return "employee-update-form";
	}

}

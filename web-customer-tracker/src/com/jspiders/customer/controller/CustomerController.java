package com.jspiders.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.customer.entity.Customer;
import com.jspiders.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> list = customerService.getCustomers();
		theModel.addAttribute("customers", list);

		return "list-customers";
	}

	@GetMapping("/addForm")
	public String addForm(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "addForm";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "addForm";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id )
	{	
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}

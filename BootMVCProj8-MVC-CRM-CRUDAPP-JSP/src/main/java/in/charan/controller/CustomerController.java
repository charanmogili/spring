package in.charan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.charan.model.Customer;
import in.charan.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/list")
	public String listCustomers(Map<String, Object> model) {
		System.out.println("Implementation class is :: " + service.getClass().getName());
		List<Customer> customers = service.getCustomers();
		System.out.println("Inside list customers handler method");
		customers.forEach(System.out::println);
		model.put("customers", customers);
		System.out.println("Inside list customers handler method");
		return "list-customers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Map<String, Object> model) {
		Customer customer = new Customer();
		System.out.println("Inside showForm method");
		model.put("customer", customer);
		System.out.println("Inside showForm method");
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println("Inside the save Customer handler method");
		System.out.println(customer);
		service.saveCustomer(customer);
		System.out.println("Inside the save Customer handler method");
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam Integer customerId, Map<String, Object> model) {
		Customer customer = service.getCustomer(customerId);
		System.out.println("inside showFormForUpdate handler method");
		System.out.println(customer);
		model.put("customer", customer);
		System.out.println("inside showFormForUpdate handler method");
		return "customer-form";
	}

	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam Integer customerId) {
		System.out.println("inside showFormForDelete handler method");
		service.deleteCustomer(customerId);
		System.out.println("inside showFormForDelete handler method");
		return "redirect:/customer/list";
	}

}

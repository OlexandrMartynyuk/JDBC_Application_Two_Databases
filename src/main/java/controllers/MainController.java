package controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import dao.interfaces.CustomerCRUD;
import dao.interfaces.TelevisionCRUD;
import dao.models.Customer;
import dao.models.Television;


@RestController 
public class MainController {
	@Autowired 
	private CustomerCRUD customerCRUD;
	
	@Autowired 
	private TelevisionCRUD televisionCRUD;
	
	
	//Customer controller
	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public List<Customer> getAllCustomers () {
		return customerCRUD.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
	public Customer getCustomer(@PathVariable Integer id) {
		return customerCRUD.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	public String addCustomer(@RequestBody Customer customer) {
		customerCRUD.add(customer);
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/customers")
	public String updateCustomer(@RequestBody Customer customer) {
		customerCRUD.update(customer);
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		customerCRUD.remove(id);
		return "Success";
	}
	
	
	//Television controller
	@RequestMapping(method = RequestMethod.GET, value = "/televisions")
	public List<Television> getAllTelevisions () {
		return televisionCRUD.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/televisions/{id}")
	public Television getTelevision(@PathVariable Integer id) {
		return televisionCRUD.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/televisions")
	public String addTelevision(@RequestBody Television television) {
		televisionCRUD.add(television);
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/televisions")
	public String updateTelevision(@RequestBody Television television) {
		televisionCRUD.update(television);
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/televisions/{id}")
	public String deleteTelevision(@PathVariable Integer id) {
		televisionCRUD.remove(id);
		return "Success";
	}	
	
}

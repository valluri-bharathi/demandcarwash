package com.example.demandcarwash.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;
import com.example.demandcarwash.service.CustomerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/login")
public class Customer {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CustomerDetails checkUser(@RequestBody CustomerDetails customer) throws ProgramException {
		String uName = customer.getUserName();

		CustomerDetails result;
		try {
			
			result=customerService.login(customer);
		} catch (Exception e) {
			throw new ProgramException("Error Occurred");
			
		}
		return result;
	}

@RequestMapping(value = "/details", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
public String addDetails(@RequestBody CustCarDetails details) throws ProgramException {

	try {
		
		customerService.addDetails(details);
	}
	catch(Exception e) {
		throw new ProgramException("please try again");
	}
	return "Added Successfully";
	
}

@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
public String addUser(@RequestBody CustomerDetails customer) throws ProgramException {


	try {

		System.out.println(customer.getPassword());
		 if(customerService.register(customer)!=null);
	} catch (Exception e) {
		throw new ProgramException("User Already Exists");
	}
	return " Registered Successfully";
}
@RequestMapping(value = "/view", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
public List<CustCarDetails> viewDetails(@RequestBody CustCarDetails details)throws ProgramException{
	List<CustCarDetails> result=customerService.viewDetails(details);
    System.out.println("car");
		if(result==null) {
			throw new ProgramException("No Records found");
		}
	return result;
}

}

package com.example.demandcarwash.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.service.CustomerService;


@RestController
@RequestMapping(value = "/login")
public class Customer {

	@Autowired
	private CustomerService custService;

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
	public String checkUser(@RequestBody CustomerDetails customer) throws Exception {
		System.out.println("bharathi");

		String uName = customer.getUserName();

		try {
			System.out.println(uName);
			custService.login(customer);
		} catch (Exception e) {
			throw new Exception("Error Occurred");
		}
		return "Logged In Successfully";
	}
}


package com.example.demandcarwash.service;

import java.util.List;

import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;

public interface CustomerService {

	CustomerDetails login(CustomerDetails customer) throws ProgramException;
	boolean addDetails(CustCarDetails details) throws ProgramException;
	CustomerDetails register(CustomerDetails customer) throws ProgramException;
	List<CustCarDetails> viewDetails(CustCarDetails details) throws ProgramException;


}

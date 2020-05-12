package com.example.demandcarwash.dao;

import java.util.List;

import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;

public interface CustomerDao {
	
	public CustomerDetails findUser(CustomerDetails customer) throws ProgramException;
	public boolean addDetails(CustCarDetails details) throws ProgramException;
	public CustomerDetails addUser(CustomerDetails customer) throws ProgramException;
	public List<CustCarDetails> viewDetails(CustCarDetails details) throws ProgramException;
}
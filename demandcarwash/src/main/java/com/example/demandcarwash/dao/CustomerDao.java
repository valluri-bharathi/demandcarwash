package com.example.demandcarwash.dao;

import com.example.demandcarwash.entity.CustomerDetails;

public interface CustomerDao {
	
	public boolean findUser(CustomerDetails customer) throws Exception;
}
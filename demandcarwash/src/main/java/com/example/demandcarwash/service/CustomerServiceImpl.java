package com.example.demandcarwash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demandcarwash.dao.CustomerDao;
import com.example.demandcarwash.entity.CustomerDetails;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao custDao;

	public void setLoginDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	@Override
	public boolean login(CustomerDetails custDetails) throws Exception {

		System.out.println("service entered");
		boolean result = custDao.findUser(custDetails);
		if (!result) {
			throw new Exception("error");

		}
		return true;

	}

}
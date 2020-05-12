package com.example.demandcarwash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demandcarwash.dao.CustomerDao;
import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	
	private CustomerDao custDao;

	public void setLoginDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	@Override
	public CustomerDetails login(CustomerDetails custDetails) throws ProgramException {
	
		CustomerDetails result = custDao.findUser(custDetails);
		if (result==null) {
			throw new ProgramException("error");
		}
		return result;

	}

	@Override
	public boolean addDetails(CustCarDetails details) throws ProgramException {
		
		boolean result ;
		if(details.getCarName()!=null&&details.getPackAge()!=null&&details.getDate()!=null&&details.getPaymentDetails()!=null&&details.getTime()!=null) { 
		result=custDao.addDetails(details);
		}
		else
		{
			throw new ProgramException("fill details");
		}
		return result;
	}
	@Override
	public CustomerDetails register(CustomerDetails customer) throws ProgramException {
		
		
		CustomerDetails addUser = custDao.addUser(customer);
		return addUser;
	}
	@Override
	public List<CustCarDetails> viewDetails(CustCarDetails details) throws ProgramException {
		List<CustCarDetails> viewDetails= custDao.viewDetails(details);
		
		return viewDetails;
	}
}




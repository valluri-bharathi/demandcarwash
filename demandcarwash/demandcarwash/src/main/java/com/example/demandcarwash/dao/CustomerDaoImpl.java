package com.example.demandcarwash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demandcarwash.entity.CustCarDetails;
import com.example.demandcarwash.entity.CustomerDetails;
import com.example.demandcarwash.exception.ProgramException;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private MongoTemplate mongoTemplate;
//	Query query = new Query();
	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public CustomerDetails findUser(CustomerDetails user) throws ProgramException {
		Query query = new Query();
		Query query1 = new Query();
		String uName = user.getUserName();
		String pwd = user.getPassword();
		try {
		
			
			query = query.addCriteria(Criteria.where("userName").is(uName).andOperator(Criteria.where("password").is(pwd)));
			query1=query1.addCriteria(Criteria.where("userName").is(uName));
			boolean dataExists = mongoTemplate.exists(query, "customerDetails");
			if (dataExists) {
				System.out.println("12345");
				return mongoTemplate.findOne(query1, CustomerDetails.class);
			}
		} catch (Exception e) {
			throw new ProgramException("reposit error");
		}
		return null;

	}

	@Override
	public boolean addDetails(CustCarDetails details) throws ProgramException {
		Query query= new Query();
		String uName= details.getUserName();
		query.addCriteria(Criteria.where("userName").is(uName));
		try {
			CustCarDetails dataExists = mongoTemplate.insert(details, "custCarDetails");
	
			if(dataExists!=null) {
	
				
				return true;
			}
		}catch(Exception e) {
			throw new ProgramException("error occurred");
			
		}
		
	
		return false;
	}
	@Override
	public CustomerDetails addUser(CustomerDetails customer) throws ProgramException {
		Query query = new Query();
		String uName = customer.getUserName();
		String pwd = customer.getPassword();
		CustomerDetails addedUser=null;
		try {
			

			query = query.addCriteria(Criteria.where("userName").is(uName));
			boolean dataExists = mongoTemplate.exists(query, "customerDetails");

			if (dataExists!=true) {
				addedUser = mongoTemplate.insert(customer, "customerDetails");
			} else {
				throw new ProgramException("User Already Exists");
			}
		} catch (Exception e) {
			throw new ProgramException("reposit error");
		}
		mongoTemplate.save(customer,"customer");
		return addedUser;
	}
	
	@Override
	public List<CustCarDetails> viewDetails(CustCarDetails details) throws ProgramException {
		Query query = new Query();
		String uName=details.getUserName();
		query = query.addCriteria(Criteria.where("userName").is(uName));
		boolean dataExists = mongoTemplate.exists(query, "custCarDetails");
		System.out.println(dataExists);
		try{
			if (dataExists) {
				List<CustCarDetails> list=mongoTemplate.find(query, CustCarDetails.class);

				return list;
		}
	} catch (Exception e) {
		throw new ProgramException("reposit error");
	}
		return null;
	}

}




package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Employee;

public interface DAOCustomer {
	
	public ArrayList<Customer> getAllCustomers();
	public boolean updateCustomer(Customer customer);
	public boolean insertCustomer(Customer customer);

}

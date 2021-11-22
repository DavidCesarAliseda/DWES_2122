package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Payment;

public class DAOCustomerImpl implements DAOCustomer {

	public DAOCustomerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {

		ArrayList<Customer> customerList = new ArrayList<>();
		
		try {

			String sql = "select * from customers";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Customer customer = new Customer();
				
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));
				
				customerList.add(customer);
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return customerList;

	}

	@Override
	public boolean updateCustomer(Customer customer) {
		int resultado = 0;

		try {

			String sql = "update customers set customerNumber=?, customerName=?, contactLastName=?, contactFirstName=?, phone=?, addressLine1=?, addressLine2=?, city=?, state=?, postalCode=?, country=?, salesRepEmployeeNumber=?, creditLimit=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			statement.setInt(1, customer.getCustomerNumber());
			statement.setString(2, customer.getCustomerName());
			statement.setString(3, customer.getContactLastName());
			statement.setString(4, customer.getContactFirstName());
			statement.setString(5, customer.getPhone());
			statement.setString(6, customer.getAddressLine1());
			statement.setString(7, customer.getAddressLine2());
			statement.setString(8, customer.getCity());
			statement.setString(9, customer.getState());
			statement.setString(10, customer.getPostalCode());
			statement.setString(11, customer.getCountry());
			statement.setInt(12, customer.getSalesRepEmployeeNumber());
			statement.setDouble(13, customer.getCreditLimit());
			
			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean insertCustomer(Customer customer) {
		int resultado = 0;

		try {

			String sql = "insert into customers values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			statement.setInt(1, customer.getCustomerNumber());
			statement.setString(2, customer.getCustomerName());
			statement.setString(3, customer.getContactLastName());
			statement.setString(4, customer.getContactFirstName());
			statement.setString(5, customer.getPhone());
			statement.setString(6, customer.getAddressLine1());
			statement.setString(7, customer.getAddressLine2());
			statement.setString(8, customer.getCity());
			statement.setString(9, customer.getState());
			statement.setString(10, customer.getPostalCode());
			statement.setString(11, customer.getCountry());
			statement.setInt(12, customer.getSalesRepEmployeeNumber());
			statement.setDouble(13, customer.getCreditLimit());
			
			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

}

package org.iesalixar.servidor.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class DAOEmployeeImpl implements DAOEmployee {

	@Override
	public ArrayList<Employee> getAllEmployees() {

		ArrayList<Employee> employeeList = new ArrayList<>();
		PoolDB pool = new PoolDB();
		Connection con = pool.getConnection();

		try {

			String sql = "select * from employees";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employee employee = new Employee();

				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				employeeList.add(employee);
			}

			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(employeeList);
		return employeeList;

	}

	@Override
	public boolean updateEmployee(Employee employee) {
		int resultado = 0;
		PoolDB pool = new PoolDB();
		Connection con = pool.getConnection();
		try {

			String sql = "update employees set employeeNumber=?, lastName=?, firstName=?, extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=?";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employee.getEmployeeNumber());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getExtension());
			statement.setString(5, employee.getEmail());
			statement.setString(6, employee.getOfficeCode());
			statement.setInt(7, employee.getReportsTo());
			statement.setString(8, employee.getJobTitle());
			
			
			resultado = statement.executeUpdate();

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		int resultado = 0;
		PoolDB pool = new PoolDB();
		Connection con = pool.getConnection();
		
		try {

			String sql = "insert into employees values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employee.getEmployeeNumber());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getExtension());
			statement.setString(5, employee.getEmail());
			statement.setString(6, employee.getOfficeCode());
			statement.setInt(7, employee.getReportsTo());
			statement.setString(8, employee.getJobTitle());
			
			
			
			resultado = statement.executeUpdate();

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}

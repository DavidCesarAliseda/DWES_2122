package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Office;


public class DAOOfficeImpl implements DAOOffice {

	@Override
	public ArrayList<Office> getAllOffices() {
		ArrayList<Office> officeList = new ArrayList<>();
		
		
		PoolDB pool = new PoolDB();
		Connection con = pool.getConnection();
		
		try {

			String sql = "select * from offices";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {
				Office oficina = new Office();
				oficina.setOfficeCode(rs.getString("officeCode"));
				oficina.setCity(rs.getString("city"));
				oficina.setPhone(rs.getString("phone"));
				oficina.setAddressLine1(rs.getString("addressLine1"));
				oficina.setAddressLine2(rs.getString("addressLine2"));
				oficina.setState(rs.getString("state"));
				oficina.setCountry(rs.getString("country"));
				oficina.setPostalCode(rs.getString("postalCode"));
				oficina.setTerritory(rs.getString("territory"));
				
				officeList.add(oficina);
			}

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(officeList);
		return officeList;
	}

	@Override
	public Office getOffice(String city) {
		Office oficina = null;
		PoolDB pool = new PoolDB();
		Connection con = pool.getConnection();

		try {

			String sql = "select * from offices where city=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, city);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {
				oficina = new Office();
				oficina.setOfficeCode(rs.getString("officeCode"));
				oficina.setCity(rs.getString("city"));
				oficina.setPhone(rs.getString("phone"));
				oficina.setAddressLine1(rs.getString("addressLine1"));
				oficina.setAddressLine2(rs.getString("addressLine2"));
				oficina.setState(rs.getString("state"));
				oficina.setCountry(rs.getString("country"));
				oficina.setPostalCode(rs.getString("postalCode"));
				oficina.setTerritory(rs.getString("territory"));

			}

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return oficina;
	}

}

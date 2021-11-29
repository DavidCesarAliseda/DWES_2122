package org.iealixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.models.Office;

public class DAOOfficeImpl implements DAOOffice {

	@Override
	public List<Office> getAllOffices() {
		ArrayList<Office> officeList = new ArrayList<>();

		PoolDB pool = new PoolDB();
		Connection con = pool.getConnection();

		try {

			String sql = "select * from offices";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Office office = new Office();

				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setTerritory(rs.getString("territory"));

				officeList.add(office);

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return officeList;
	}

	@Override
	public boolean updateOffice(Office office) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOffice(Office office) {
		// TODO Auto-generated method stub
		return false;
	}

}

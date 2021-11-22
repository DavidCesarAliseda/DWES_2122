package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.models.Product;

public class DAOProductImpl implements DAOProduct {

	@Override
	public Product getProduct(String productName) {

		Product product = null;

		try {

			String sql = "select * from products where  productName=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, productName);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return product;

	}

	public String echo() {
		return "echo";
	}

	@Override
	public boolean updateProduct(Product product) {
int resultado=0;
		
		try {

			String sql = "update payments set productName= ?, productCode=?, productLine= ?, quantityInStock=?, buyPrice= ?  where productCode = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1,product.getProductName());
			statement.setString(2, product.getProductCode());
			statement.setString(3, product.getProductLine());
			statement.setInt(4, product.getQuantityInStock());
			statement.setDouble(5, product.getBuyPrice());
			statement.setString(6, product.getProductCode());

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);
	
	}
	

	@Override
	public boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> productList = new ArrayList<>();
		Product product;

		try {

			String sql = "select * from products";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				
				productList.add(product);
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productList;
	}

}

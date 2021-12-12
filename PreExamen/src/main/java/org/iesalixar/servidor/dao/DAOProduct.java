package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;

public interface DAOProduct {
	
	public boolean updateProduct(Product product);
	public ArrayList<Product> getAllProducts();
	Product getProduct(String productName);

}

package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;

public interface DAOProduct {
	
	public ArrayList<Product> getAllProducts(String productLine);

}

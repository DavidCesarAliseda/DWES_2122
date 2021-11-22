package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import org.iesalixar.servidor.models.Product;

public interface DAOProduct {
	
	public Product getProduct(String productName);
	public boolean updateProduct(Product product);
	public boolean insertProduct(Product product);
	public ArrayList<Product> getAllProducts();

}

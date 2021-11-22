package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.OrderDetails;

public interface DAOOrderDetails {
	
	public List<OrderDetails> getAllOrderDetails();
	public boolean updateOrderDetails(OrderDetails orderDetails);
	public boolean insertOrderDetails(OrderDetails orderDetails);
}

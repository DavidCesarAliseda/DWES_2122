package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Order;

public interface DAOOrder {
	public ArrayList<Order> getAllOrders();
	public boolean updateOrder(Order order);
	public boolean insertOrder(Order order);
}

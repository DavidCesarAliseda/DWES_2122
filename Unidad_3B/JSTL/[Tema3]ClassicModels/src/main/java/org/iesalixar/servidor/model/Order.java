package org.iesalixar.servidor.model;

public class Order {
	private int orderNumber;
	private String orderDate;
	private String requiredDate;
	private String shippedDateDate;
	private String status;
	private String comments;
	private int customerNumber;
	
	public Order(int orderNumber, String orderDate, String requiredDate, String shippedDateDate, String status,
			String comments, int customerNumber) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDateDate = shippedDateDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	public String getShippedDateDate() {
		return shippedDateDate;
	}
	public void setShippedDateDate(String shippedDateDate) {
		this.shippedDateDate = shippedDateDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	
	
}

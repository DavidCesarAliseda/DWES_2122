package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Office;

public interface DAOOffice {
	public ArrayList<Office> getAllOffices();
	public Office getOffice(String city);
	
}

package org.iealixar.servidor.dao;



import java.util.List;

import org.iesalixar.servidor.models.Office;

public interface DAOOffice {
	public List<Office> getAllOffices();
	public boolean updateOffice(Office office);
	public boolean insertOffice(Office office);
}

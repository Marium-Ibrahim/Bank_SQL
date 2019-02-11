package Interface;

import java.sql.SQLException;
import java.util.List;

import Entity.Customer;

public interface ICustomer {
	
	//Task 1
	public List<Customer> customerNames() throws SQLException;

}

package Repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import Entity.Customer;
import Interface.ICustomer;

public class ICustomerRepo implements ICustomer {
	
	DBConnect instance= new DBConnect();
	Connection con=instance.createConnection();
	ResultSet res= null;
	
	public List<Customer> customerNames() throws SQLException {
		List<Customer>cust_list= new ArrayList<Customer>();
		
		String query = "g1_names_customer";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		res=preparedStatement.executeQuery();
		
		while(res.next()) {			
			String s= res.getString(1);
			Customer cus = new Customer();
			cus.setCustomer_name(s);
			cust_list.add(cus);
		}
		
		return cust_list;
		
	}
	
	
	

	
	
	

}

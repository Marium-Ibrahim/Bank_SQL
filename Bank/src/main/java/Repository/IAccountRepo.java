package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import Entity.*;
import Interface.IAccount;

public class IAccountRepo  implements IAccount{
	

	DBConnect instance= new DBConnect();
	Connection con=instance.createConnection();
	ResultSet res= null;

	public List<Account> accNumBlGt700() throws SQLException {
		
		List<Account>cust_list= new ArrayList<Account>();
		String query = "g1_account_balance";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		res = preparedStatement.executeQuery();
		
		while(res.next()) {
			String account_num = res.getString(1);
			Account account = new Account();
		    account.setAccount_number(account_num);
		    cust_list.add(account);
		}
		return cust_list;
	}

	public List<Account> brightonBalance() throws SQLException {
		
		List<Account>cust_list= new ArrayList<Account>();
		String query = "g1_brighton_balance";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		res = preparedStatement.executeQuery();
		
		while(res.next()) {
			Account account = new Account();
			String account_num = res.getString(1);
			account.setAccount_number(account_num);
			
			double balance = res.getDouble(2);
			account.setBalance(balance);
			
		    cust_list.add(account);
		}
		return cust_list;
	}

}

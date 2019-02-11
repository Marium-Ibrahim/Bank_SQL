package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import Entity.Account;
import Entity.Dep_Acc_Cus;
import Interface.IDep_Acc_Cus;

public class IDep_Acc_CusRepo implements IDep_Acc_Cus{
	
	DBConnect instance= new DBConnect();
	Connection con=instance.createConnection();
	ResultSet res= null;

	public List<Dep_Acc_Cus> depDetail() throws SQLException
	{
		List<Dep_Acc_Cus>cust_list= new ArrayList<Dep_Acc_Cus>();
		String query = "g1_custname_accnum_balance";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		res = preparedStatement.executeQuery();
		
		while(res.next()) {
			
			Dep_Acc_Cus dep_acc_cus = new Dep_Acc_Cus();
			
			String name = res.getString(1);
			String account_num = res.getString(2);
			double balance= res.getDouble(3);
			
			dep_acc_cus.setName(name);
			dep_acc_cus.setAcc_num(account_num);
			dep_acc_cus.setBalance(balance);   
		    cust_list.add(dep_acc_cus);
		}
		return cust_list;
		
	}

	public List<Dep_Acc_Cus> depWithLessBl() throws SQLException
	{
		List<Dep_Acc_Cus>cust_list= new ArrayList<Dep_Acc_Cus>();
		String query = "g1_custname_accnum_less_balance";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		res = preparedStatement.executeQuery();
		
		while(res.next()) {
			
			Dep_Acc_Cus dep_acc_cus = new Dep_Acc_Cus();
			
			String name = res.getString(1);
			String account_num = res.getString(2);
			double balance= res.getDouble(3);
			
			dep_acc_cus.setName(name);
			dep_acc_cus.setAcc_num(account_num);
			dep_acc_cus.setBalance(balance);   
		    cust_list.add(dep_acc_cus);
		}
		return cust_list;
		
	}

}

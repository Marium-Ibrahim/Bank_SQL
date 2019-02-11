package Repository;


import Interface.ILoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import Entity.Loan;



public class ILoanRepo implements ILoan {
	DBConnect instance= new DBConnect();
	Connection con=instance.createConnection();
	ResultSet res= null;
	
	
	public List<Loan> branchNameExceptDuplicates() throws SQLException {
		
		List<Loan>loan_list= new ArrayList<Loan>();
		
		String query = "g1_unique_branchname";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		res=preparedStatement.executeQuery();
		
		while(res.next()) {			
			String s= res.getString(1);
			Loan loan = new Loan();
			loan.setBranch_name(s);
			loan_list.add(loan);
		}
		
		return loan_list;
	}

	

}

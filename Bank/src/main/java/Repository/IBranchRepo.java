package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import Entity.Branch;
import Interface.IBranch;

public class IBranchRepo implements IBranch{
	
	DBConnect instance= new DBConnect();
	Connection con=instance.createConnection();
	ResultSet res= null;

	
	
	
	
	
	public List<Branch> showBranchTable() throws SQLException {
		
		List<Branch>brn_list= new ArrayList<Branch>();
		
		String query = "g1_entire_branch";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		res=preparedStatement.executeQuery();
		
		while(res.next()) {			
			Branch brnch = new Branch();
			
			String brn_name= res.getString(1);
			brnch.setBranch_name(brn_name);
			
			String brn_city= res.getString(2);
			brnch.setBranch_city(brn_city);
			
			double asset= res.getDouble(3);
			brnch.setAssets(asset);
			
			brn_list.add(brnch);
			
		}
		
		return brn_list;
			
	}

	
	
	
	
	public List<Branch> branchNameWithAsset1to4() throws SQLException{
		
		List<Branch>brn_list= new ArrayList<Branch>();
		
		String query = "g1_branch_assets";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		res=preparedStatement.executeQuery();
		
		while(res.next()) {			
			Branch brnch = new Branch();
			
			String brn_name= res.getString(1);
			brnch.setBranch_name(brn_name);
			
			
			brn_list.add(brnch);
			
		}
		
		return brn_list;
		
		
	}

}

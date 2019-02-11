package Interface;

import java.sql.SQLException;
import java.util.List;

import Entity.Dep_Acc_Cus;

public interface IDep_Acc_Cus {
	
	//Task 8 
	public List<Dep_Acc_Cus> depDetail() throws SQLException;
	
	//Task 9 
	public List<Dep_Acc_Cus> depWithLessBl() throws SQLException;
	

}

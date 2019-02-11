package Interface;
import java.sql.SQLException;
import java.util.List;

import Entity.*;

public interface IBranch  {
	
	//Task 3
	public List<Branch> showBranchTable() throws SQLException;
	
	//Task 7
	public List<Branch> branchNameWithAsset1to4()throws SQLException;
}

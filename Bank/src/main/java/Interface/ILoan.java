package Interface;
import java.sql.SQLException;
import java.util.List;

import Entity.Loan;

public interface ILoan {

	//Task 2
	public List<Loan> branchNameExceptDuplicates() throws SQLException;
}

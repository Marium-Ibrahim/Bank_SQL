package Interface;

import java.sql.SQLException;
import java.util.List;

import Entity.Account;

public interface IAccount {
	
	//Task 4
	public List<Account> accNumBlGt700() throws SQLException;
	
	//Task 5
	public List<Account> brightonBalance() throws SQLException;

}

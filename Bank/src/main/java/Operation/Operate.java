package Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DB.DBConnect;
import Entity.*;
import Interface.*;
import Repository.*;

public class Operate {
	
	

	public static void main(String[] args) {
		
		DBConnect instance= new DBConnect();
		Connection con=instance.createConnection();
		
		ICustomer iCusRepo = new ICustomerRepo();
		ILoan iLoan = new ILoanRepo();
		IBranch iBrn = new IBranchRepo();
		IAccount iAcc = new IAccountRepo();
		IDep_Acc_Cus iDep_Acc_Cus= new IDep_Acc_CusRepo();
		
			
		if(con==null) {
			System.out.println("Connection failed!");
			return;
		}
			
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Task Number: ");
		int taskNum;
		taskNum=sc.nextInt();
		
		try {
			if(taskNum==1) {
				List<Customer>cust_list=iCusRepo.customerNames();
				for(Customer cus: cust_list)
					System.out.println(cus.getCustomer_name());		
			}
			else if(taskNum==2) {
				List<Loan>loan_list=iLoan.branchNameExceptDuplicates();
				for(Loan loan: loan_list)
					System.out.println(loan.getBranch_name());		
			}
			else if(taskNum==3) {
				List<Branch>brn_list = iBrn.showBranchTable();
				System.out.println("Branch Name--City--Assets");
				System.out.println("___________________________");
				for(Branch brnch: brn_list) 
					System.out.println(brnch.getBranch_name()+"--"+brnch.getBranch_city()+"--"+ brnch.getAssets());;
				
			}
			else if(taskNum==4) {
				List<Account>acc_list = iAcc.accNumBlGt700();
				for(Account acc: acc_list)
					System.out.println(acc.getAccount_number());
			}
			
			else if(taskNum==5) {
				List<Account>acc_list = iAcc.brightonBalance();
				for(Account acc: acc_list)
					System.out.println(acc.getAccount_number()+" "+acc.getBalance());
			}
			else if(taskNum==7) {
				List<Branch>brn_list = iBrn.branchNameWithAsset1to4();
				System.out.println("Branch Name");
				System.out.println("___________");
				for(Branch brnch: brn_list) 
					System.out.println(brnch.getBranch_name());
				
			}
			else if(taskNum==8) {
				List<Dep_Acc_Cus>list = iDep_Acc_Cus.depDetail();
				for(Dep_Acc_Cus dpAcCs: list)
					System.out.println(dpAcCs.getName()+"--"+dpAcCs.getAcc_num()+"--"+dpAcCs.getBalance());;
			}
			else if(taskNum==9) {
				List<Dep_Acc_Cus>list = iDep_Acc_Cus.depWithLessBl();
				for(Dep_Acc_Cus dpAcCs: list)
					System.out.println(dpAcCs.getName()+"--"+dpAcCs.getAcc_num()+"--"+dpAcCs.getBalance());;
			}
			else
				System.out.println("Invalid Task Number");
			
			
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		
	}

}

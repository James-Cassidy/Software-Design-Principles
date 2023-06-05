package gradedGroupProject;

import java.text.SimpleDateFormat;
import java.util.List;


public class BankAdmin extends Person{

	private String name = "Y";

	public BankAdmin(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public Boolean verifyAccount(int clientID, Account account, String choice) {
		System.out.print("Account number = "+account.getAccountNum()+",");
		if(choice.equals("1")) {
			
			System.out.print(" verified: true");
			System.out.println();
			account.setAccountVerified(true);
			
			return true;
			//Send Message to client confirming account
		}
		if(choice.equals("2")) {
			System.out.print(" verified: false");
			System.out.println();
			account.setAccountVerified(false);
			//accountsToVerify.remove(account);
			return false;
			//Send Message to client asking to create another account
		}	
		
		return null;
	}
	

}

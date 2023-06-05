package gradedGroupProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VerifyAccountTransaction {
	
	private String choice;
	public void verifyAccountTransaction(BankAdmin bankAdmin) {
		
		List<Account> accountsToVerify =  new ArrayList<Account>();		
		
		for(BankClient client : BankClientDictionarySingleton.getInstance().getList()) {

			for(int j = 0; j < client.getClientAccounts().size(); j++) {
				if (!client.getClientAccounts().get(j).getAccountVerified()) {
					accountsToVerify.add(client.getClientAccounts().get(j));
				}
			}
		}
		
		if (accountsToVerify.size() == 0) {
			System.out.println("There are no Accounts to verify");
			return;
		}
			
				
		
		for(int i=0;i<BankClientDictionarySingleton.getInstance().getList().size();i++) {
			displayAccount(accountsToVerify.get(i),BankClientDictionarySingleton.getInstance().getList().get(i));
			choice=confirmAccount();
			String error=checkVerifyAccountTransaction();
			if(error!=null) {
				printErrorMessage(error);
			}
			else executeVerifyAppointmentTransaction(BankClientDictionarySingleton.getInstance().getList().get(i).getClientID(),accountsToVerify.get(i),bankAdmin);
		}
		
	}

	private String confirmAccount() {
		String choice=null;
		System.out.println("Confirm opening of this Account");
		System.out.println("1. Verify the opening");
		System.out.println("2. Do not verify the opening");
		KeyInput input= new KeyInput();
		choice= input.read("choice");
		return choice;
	}

	private void printErrorMessage(String label) {
		System.err.println(label);
	}

	private void displayAccount(Account account,BankClient client) {
		client.toPrint();
		//System.out.println("Account No: "+account.getAccountNum());
	    // client.toPrintAccount(account.getAccountNum());
	}

	
	private String checkVerifyAccountTransaction() {
		if(choice.isEmpty()) {
			return "Error: No input detected";
		}
		if(!choice.equals("1")&&!choice.equals("2")){
			return "Error: Choose option 1 or 2";
		}
		else 
			return null;
		}

	private void executeVerifyAppointmentTransaction(int clientID ,Account account, BankAdmin admin) {
		admin.verifyAccount(clientID,account,choice);
		System.out.println("Account Verified");
		
		
	}

	
}
	
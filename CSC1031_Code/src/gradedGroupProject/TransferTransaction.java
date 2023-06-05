package gradedGroupProject;

import java.util.ArrayList;
import java.util.List;

public class TransferTransaction {

	private int pos;
	private int accountNoTransferor;
	private int accountNoTransferee;
	private double transferAmount;
	
	public void transferTransaction( BankClient loggedInClient ) {
		
		displayAccounts(loggedInClient);
		
		provideTransferDetails();
		
		String error = checkTransactionStructure( loggedInClient );
		
		if( error != null ) printErrorMessage( error );
		
		else executeTransferTransaction( loggedInClient );
	}
	
	
	private void provideTransferDetails() {
		
		KeyInput KeyInput = new KeyInput();

		accountNoTransferor = Integer.parseInt(KeyInput.read( "from account number" ));
		
		accountNoTransferee =  Integer.parseInt(KeyInput.read( "to acount number" ));
		
		transferAmount= Double.parseDouble(KeyInput.read( "amount" ));


	}
	
	private String checkTransactionStructure(BankClient loggedInClient ) {
        int checkAccounts=0;
		for( pos = 0; pos < loggedInClient.getClientAccounts().size(); ++pos ) {
			if( loggedInClient.getClientAccounts().get( pos ).getAccountNum() == accountNoTransferor ) {
				checkAccounts++;
			}
			if( loggedInClient.getClientAccounts().get( pos ).getAccountNum() == accountNoTransferee ) {
				checkAccounts++;
			}
			if(checkAccounts==2) break;
		}
		if( pos < 0 || pos >= loggedInClient.getClientAccounts().size() ) return "Invalid Account Number Entered";

		return null;
	}
	
	private void displayAccounts( BankClient loggedInClient ) {
		loggedInClient.printAccounts();
	}
	
	
	private void printErrorMessage( String message ) {

		System.err.println( message );
	}
	
	private void executeTransferTransaction(BankClient loggedInClient) {
		loggedInClient.transfer(accountNoTransferor,accountNoTransferee,transferAmount);
		System.out.println();
	}

	
}

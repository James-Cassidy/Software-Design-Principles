package gradedGroupProject;

import java.util.List;

public class DeleteBankAccount {

	private String confirm;
	private int accountNum;
	private int pos;
	
	public void deleteBankClient( BankClient loggedInClient) {

		
		provideChoice(loggedInClient);
		provideVerification();

		String error = checkTransactionStructure(loggedInClient) ;


		if( error != null ) printErrorMessage( error );

		else executeDeleteTransaction( loggedInClient );
	}
	
	private void provideChoice(BankClient loggedInClient) {
		loggedInClient.printAccounts();
		KeyInput KeyInput = new KeyInput();
		System.out.println("Enter the Account Number of the account you wish to delete?");
		accountNum= Integer.parseInt( KeyInput.read( "Account Num" ) );
	}
	

	private void provideVerification() {
		KeyInput KeyInput = new KeyInput();
		System.out.println("Are you sure you want to delete this account?");
		System.out.println("Enter 'Y' or 'N'");
		confirm= KeyInput.read("Choice");

		
	}

	private String checkTransactionStructure(BankClient loggedInClient) {

		
		for( pos = 0; pos < loggedInClient.getClientAccounts().size(); ++pos ) if( loggedInClient.getClientAccounts().get( pos ).getAccountNum() == accountNum ) break;

		if( pos < 0 || pos >= loggedInClient.getClientAccounts().size()) return"Account not found";
		
		if(!confirm.equals("Y") && !confirm.equals("N")) {
			
			return "Invalid selection";
		}
		return null;
	}

	private void printErrorMessage( String message ) {

		System.err.println( message );
	}

	private void executeDeleteTransaction(BankClient loggedInClient ) {
		BankClientDictionarySingleton.getInstance().delete(loggedInClient.getClientID());

	}
}

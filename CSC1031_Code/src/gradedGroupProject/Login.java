package gradedGroupProject;

import java.util.List;

public class Login {
	private int pos;
	private String username;
	private String password;
	private BankClient loggedInClient;
	
	
	public BankClient executeLoginDetails() {
		
		provideLoginDetails();
		
		String error = checkLoginTransactionStructure( );
		
		if( error != null ) {
			printErrorMessage(error);
			loggedInClient=null;
			System.out.println("Bank client credentials were not found.");
		}
		
		else  {
			executeLoginTransaction();
		}
		return loggedInClient;
	}
	

	private String checkLoginTransactionStructure() {
		if(username == null || password == null) return "Error with Login";
		
		pos = 0;
		
		for( pos = 0; pos < BankClientDictionarySingleton.getInstance().size(); ++pos ) if( BankClientDictionarySingleton.getInstance().get(pos).getProfile().getUsername().equals( username ) && BankClientDictionarySingleton.getInstance().get(pos).getProfile().getPassword().equals( password ) ) break;

		if( pos < 0 || pos >= BankClientDictionarySingleton.getInstance().size() ) return "Invalid username or password" ;
		
		return null;
		
	}

	private void executeLoginTransaction() {
		
		BankClientDictionarySingleton.getInstance().get( pos ).toPrint();
		loggedInClient=BankClientDictionarySingleton.getInstance().get(pos);
	}

	private void printErrorMessage(String message) {
		System.err.println(message);
		
	}
	private void provideLoginDetails() {
		KeyInput KeyInput = new KeyInput();
		username = KeyInput.read("username");
		password = KeyInput.read("password");
		
	}
}

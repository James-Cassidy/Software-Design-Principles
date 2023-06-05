package gradedGroupProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChangeBankAccountDetails extends TemplateTransaction {
	private int pos;
	private int id;
	private String name;
	private String address;
	private String username;
	private String password;
	private Date birthDate;
	private BankClient loggedInClient;
	

	@Override
	protected void provideDetails() {
		boolean flag=false;
		
		KeyInput KeyInput = new KeyInput();
		username = KeyInput.read("username");
		password = KeyInput.read("password");
		name = KeyInput.read("name");
		address = KeyInput.read( "address" );
	
		while(!flag) {
			try {
				birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(KeyInput.read("Date of Birth in the format dd/MM/yyyy: "));
				flag=true;
			} catch (ParseException e) {		
				System.err.println("Invalid Date");
			}
		}	
	}
	@Override
	protected void printErrorMessage(String message) {
		System.err.println(message);
		
	}
	@Override
	protected String checkTransactionStructure( ) {

		if( address == null || name == null || username == null || password == null || birthDate== null) return "Error change client details transaction";
 
	    else return null;
	}
	@Override
	protected Profile executeTransaction() {
		
		return new Profile(name, address, birthDate, username, password);
		
	}

}

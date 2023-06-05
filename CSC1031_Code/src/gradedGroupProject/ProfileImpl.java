package gradedGroupProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ProfileImpl extends TemplateTransaction {// implements ProfileImplInterface{

	
	// put here username and password
	// move these values to profile class
	private String username;
	private String password;	
	private String name;
	private String address;
	private Date birthDate;
	
	
	public Profile executeTransaction() {
		return new Profile(name, address, birthDate, username, password);
	}
	
	public void provideDetails() {
		KeyInput KeyInput = new KeyInput();		
		name = KeyInput.read("full Name: ");
		address = KeyInput.read("full Address: ");
		boolean flag = false;
		while(!flag) {
			try {
				birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(KeyInput.read("Date of Birth in the format dd/MM/yyyy: "));
				flag=true;
			} catch (ParseException e) {		
				System.err.println("Invalid Date");
			}
		}
		username = KeyInput.read("username");
		password = KeyInput.read("password");
	}
	
	public String checkTransactionStructure() {
		if(name == null || address == null || birthDate == null || username == null || password == null)
			return "Missing Profile Information";
		else			
			return null;
	}
	
	public void printErrorMessage(String error) {
		System.out.println(error);
	}
	
	
}

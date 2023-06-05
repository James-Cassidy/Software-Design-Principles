package gradedGroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class BankClientUI {

	public static void main(String[] args)  throws ParseException {		
		
		BankClient client1= new BankClient();
		BankClient client2= new BankClient();
		BankClient client3= new BankClient();
		client1.setClientProfile( new Profile("James","23 FGHJ",new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2000"),"A1","123"));
		client2.setClientProfile( new Profile("Michael","25 asrg",new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2000"),"B1","456"));
		client3.setClientProfile( new Profile("David","12 v dkgns",new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2000"),"C1","789"));
		Account client1Primary= new PrimaryAccount("primary",657, true);
		Account client2Primary= new PrimaryAccount("primary",347, true);
		Account client3Primary= new PrimaryAccount("primary",127, true);
		Account client1Secondary= new SecondaryAccount("secondary",456, true);
		Account client2Secondary= new SecondaryAccount("secondary",127, true);
		Account client3Secondary= new SecondaryAccount("secondary",401, true);
		client1.getClientAccounts().add(client1Primary);
		client1.getClientAccounts().add(client1Secondary);
		client2.getClientAccounts().add(client2Primary);
		client2.getClientAccounts().add(client2Secondary);
		client3.getClientAccounts().add(client3Primary);
		client3.getClientAccounts().add(client3Secondary);
		BankClient loggedInClient=null;
		KeyInput KeyInput = new KeyInput();
		
		BankClientDictionarySingleton.getInstance().addBankClient(client1);
		BankClientDictionarySingleton.getInstance().addBankClient(client2);
		BankClientDictionarySingleton.getInstance().addBankClient(client3);
	

		String adminName = "X", employeeName = "Y";
		List<String> employeeNames =new ArrayList<>();
		employeeNames.add(employeeName);


		while( true ){

			BankClientDictionarySingleton.getInstance().printBankClients();

			System.out.println( "\n0. Exit" );
			System.out.println( "1. Register" ); //--> Create Profile --> Create Account --> Create Further Accounts
			System.out.println( "2. Login" );
			
			String choice = read( "choice" );


			if( choice.equals( "0" ) ) break;

			else if( choice.equals( "1" ) ) {
			
					BankClient newClient;				
					do {
						RegistrationInterface rI = new RegistrationImpl();						
						newClient = rI.registerBankClient();								
					}
					while(newClient==null);
									
					do {
						ProfileImpl pI = new ProfileImpl();
						newClient.setClientProfile(pI.processTransaction());
					}
					while(newClient.getClientProfile()==null);
					BankClientDictionarySingleton.getInstance().addBankClient(newClient);//*****
					while( true ){

						AddAccountImpl Aa = new AddAccountImpl();
						newClient.getClientAccounts().add(Aa.createBankAccount());
						
						System.out.println( "\n0. NO extra account" );
						System.out.println( "1. Extra account" );
						String choice2 = KeyInput.read( "choice" );

						if( choice2.equals( "0" ) ) break;

				}
				
			}

			else if( choice.equals( "2" ) ) {

				int pos = 0;
				Login loginClass = new Login();
				
				loggedInClient=loginClass.executeLoginDetails();
				if(loggedInClient!=null) {	
				do {
					BankClientDictionarySingleton.getInstance().printBankClients();
					System.out.println("Logged in as: "+loggedInClient.getProfile().getUsername());
					System.out.println( "\n0. Exit" );
					System.out.println( "5. Change Bank Client Details" );
					System.out.println( "6. Delete Bank Account" );
					System.out.println( "7. Money transfer" );;
					System.out.println( "8. Book Appoinment" );
					choice = read( "choice" );

					if( choice.equals("0")) {
						break;
					}
					
					if( choice.equals( "5" ) ) { 
						
						TemplateTransaction changeDetails = new ChangeBankAccountDetails();
						loggedInClient.setClientProfile(changeDetails.processTransaction());
						
					}
					
					else if( choice.equals( "6" ) ) {
						
						DeleteBankAccount deleteAccount = new DeleteBankAccount();
						deleteAccount.deleteBankClient(loggedInClient);
					}

					else if( choice.equals( "7" ) ) {
						
						TransferTransaction object = new TransferTransaction();
						object.transferTransaction( loggedInClient );
					}

					else if( choice.equals( "8" ) ) {	
						BookTransaction object = new BookTransaction();
						object.bookTransaction(employeeNames,loggedInClient);
					}
				}while(true);
			}
			
		}
	
	}
}
		
	public static String read( String label ) {

		System.out.println( "\nProvide your " + label + ":" );

		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {
			value = input.readLine();
		}
		catch (IOException ex) { ex.printStackTrace(); }
		return value;
	}


}
	


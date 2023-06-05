package gradedGroupProject;

import java.util.ArrayList;
import java.util.List;

public class BankClientDictionarySingleton {

	private static BankClientDictionarySingleton singletonInstance;
	private List<BankClient> bankClients = new ArrayList<BankClient>();
	
	// private constructor
	private BankClientDictionarySingleton() {
		// code to fill in list??? or is it just left empty
	}
	
	public static BankClientDictionarySingleton getInstance() {
		if (singletonInstance == null)
			singletonInstance = new BankClientDictionarySingleton();
		
		return singletonInstance;
	}
	
    public void addBankClient( BankClient bankClient ) {
    	bankClients.add(bankClient);
    }
    
    public void printBankClients() {
		System.out.println( "Bank Clients:\n" );

		for( int i = 0; bankClients != null && i < bankClients.size(); ++i ) bankClients.get( i ).toPrint();
    }
    
    // this method takes in the username and password from the user and returns position of bank client
    public int searchBankClient( String username, String password ) {
    	
    	for(int i = 0; i < bankClients.size()-1;i++) {
    		if(bankClients.get(i).getProfile().getUsername().equals(username) && bankClients.get(i).getProfile().getPassword().equals(password))
    			return i;
    	}
    	
    	return -1;
    	
    }
    
    // this method returns the size of the list of users
    public int size() {
    	return bankClients.size();
    }
    
    // this method returns a bank client object from the position passed in
    public BankClient get( int position ) {//position of the BankClient object in the list of BankClient objects
    	return bankClients.get(position);
    	
    }
    
    public void delete( int ID ) {//the ID of the Bank Client
    	for(int i = 0; i < bankClients.size()-1;i++) {
    		if(bankClients.get(i).getClientID() == ID)
    			bankClients.remove(i);
    	}
    }
    
    public List<BankClient> getList(){
    	return bankClients;
    }
	
}

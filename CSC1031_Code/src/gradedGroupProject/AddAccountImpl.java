package gradedGroupProject;

public class AddAccountImpl {
	private boolean flag = false;
	private String choice = "";
	private String type;
	private double balance;
	
	// returns either a valid account or null value for cancelled transaction
	public Account createBankAccount() {	
		
		provideClientInformation();
		
		if(!checkClientInformation())
			printErrorMessage();
		
		return executeCreateBankAccountTransaction();
	}
	
	private Account executeCreateBankAccountTransaction() {
		if(type.equals("primary"))
			return createPrimaryAccount();
		else if (type.equals("secondary"))
			return createSecondaryAccount();
		else {
			System.out.println(type);
			return null;
		}
	}
	
	//*****
	private Account createPrimaryAccount() {
		Account primary= new PrimaryAccount(type, balance, true);
		System.out.println("Account number "+primary.getAccountNum()+", verified: true, balance:"+primary.getAccountBalance());
		return primary;
	}
	
	private Account createSecondaryAccount() {
		Account secondary= new SecondaryAccount(type, balance, true);
		System.out.println("Account number "+secondary.getAccountNum()+", verified: true, balance:"+secondary.getAccountBalance());
		return new SecondaryAccount(type, balance, true);
	}
	private void provideClientInformation() {
		
		KeyInput KeyInput = new KeyInput();	
		do {
			System.out.println("1. Add Primary Account"
					+ "\n2. Add Secondary Account");
			choice = KeyInput.read("preferred option");
			
			switch(choice) {
			case "1":
				flag = true;
				type = "primary";
				balance = Double.parseDouble(KeyInput.read("Account Balance"));
				System.out.println(balance);
				break;
			case "2":
				flag = true;
				type = "secondary";
				balance = Double.parseDouble(KeyInput.read("Account Balance"));
				break;
			default:
				System.out.println("\nNot Valid Input!\n");
			}			

		}
		while(!flag);
	}
	
	private boolean checkClientInformation() {
		if(type == null || balance < 0.00)
			return false;
		else
			return true;
	}
	
	private void printErrorMessage() {
		System.out.println(invalidInformation());
	}
	
	private String invalidInformation() {
		return "Invalid Information Provided";
	}
}

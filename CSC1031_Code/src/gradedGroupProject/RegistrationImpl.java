package gradedGroupProject;


public class RegistrationImpl implements RegistrationInterface{
	
	public BankClient registerBankClient()
	{
		System.out.println("Register New Client");
		return executeTransactionStructure();
	}
	
	public BankClient executeTransactionStructure() {
		return new BankClient();
	}	

}

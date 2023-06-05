package gradedGroupProject;

public class SecondaryAccount extends Account{

	public SecondaryAccount(String type, double balance, boolean verified) {
		super(type, balance, verified);
	}
	
	public SecondaryAccount(String type, double balance) {
		super(type, balance);
	}

}

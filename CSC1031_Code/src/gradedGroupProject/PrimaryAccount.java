package gradedGroupProject;

public class PrimaryAccount extends Account{

	public PrimaryAccount(String type, double balance, boolean verified) {
		super(type, balance, verified);
	}
	
	public PrimaryAccount(String type, double balance) {
		super(type, balance);
	}
	
}

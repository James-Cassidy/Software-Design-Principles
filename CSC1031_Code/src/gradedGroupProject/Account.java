package gradedGroupProject;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Account {

	public static final AtomicInteger accountCount = new AtomicInteger( 0 );
	protected int accountNum;
	protected String accountType;
	protected boolean accountVerified;
	protected double balance;
	
	public Account(String type, double balance, boolean verified) {
		accountNum = accountCount.incrementAndGet();
		this.accountType = type;
		this.balance=balance;
		this.accountVerified = verified;
	}
	
	// constructor used in code
	public Account(String type, double balance) {
		accountNum = accountCount.incrementAndGet();
		this.accountType = type;
		accountVerified = false;
		this.balance = balance;
	}
	
	public void confirmVerification() {
		accountVerified = true;
	}

	public String getAccountType() {
		return accountType;
	}

	protected void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountNum() {
		return accountNum;
	}

	protected void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public double getAccountBalance() {
		return balance;
	}

	public void setAccountBalance(double accountBalance) {
		this.balance = accountBalance;
	}
	
	public boolean getAccountVerified() {
		return this.accountVerified;
	}
	protected void setAccountVerified(boolean accountVerified ) {
		this.accountVerified=accountVerified;
	}

	
}



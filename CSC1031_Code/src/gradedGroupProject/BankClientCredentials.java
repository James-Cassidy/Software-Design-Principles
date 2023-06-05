package gradedGroupProject;

public class BankClientCredentials {
	
	private String username;
	private String password;
	
	public BankClientCredentials(String username, String password) {
		if( username == null || password == null ) System.err.println( "Error: Missing Username or Password" ); 
		if( username.substring(0,1).equals("$")) System.err.println("Error: Fake username");
		if( password.substring(password.length()-1).equals(".")) System.err.println("Error: Fake password");
		else
		{
			this.username = username;
			this.password = password;
		}
	}
	
	public void setUsername(String username) {
		if( username.substring(0,1).equals("$")) {
			this.username = "invalid";
		}
		else {
			this.username=username;
		}
	}
	
	public void setPassword(String password) {
		if( password.substring(password.length()-1).equals(".")) {
			this.password = "invalid";
		}
		else {
			this.password=password;	
		}
		
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
}


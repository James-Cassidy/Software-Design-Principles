package gradedGroupProject;

import java.util.Date;

public class Profile implements ProfileInterface {
		private String name;
		private String address;
		private Date birthDate;
		private String username;
		private String password;
		
		public Profile(String name, String address, Date birthDate, String username, String password) {
			try {
				setName(name);
				setAddress(address);
				setBirthDate(birthDate);
				
				setUsername(username);
				setPassword(password);
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		public void changeClientProfileDetails( String name, String address, Date birthDate, String username, String password){
			this.name = name;
			this.address = address;
			this.birthDate=birthDate;
			this.username = username;
			this.password = password;
		}
		
		public void toPrint() {
			System.out.println();
			System.out.println("Profile Details: \n -----------------------");
			if ( name != null) System.out.println("name = " + name);
			if ( address != null) System.out.println("address = " + address);
			if ( birthDate != null) System.out.println("birthDate = " + birthDate);
			if ( username != null) System.out.println("username = " + username);
			if ( password != null) System.out.println("password = "+ password);
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public void setName(String name)
		{
			 this.name=name;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
		
		public void setBirthDate(Date birthDate) throws Exception{
			Date currentDate = new Date();
			
			if(birthDate.after(currentDate)) {
				throw new Exception("Invalid Birth Date");
			}
			else {
				this.birthDate = birthDate;
			}
		}		

		public String getUsername() {
			return username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setUsername(String username) throws Exception{
			if( username.substring(0,1).equals("$") || username == null) 
				throw new Exception("Invalid Username - Fake or NULL");
			else
				this.username= username;
		}
		
		public void setPassword(String password) throws Exception{
			if( password.substring(password.length()-1).equals(".") || password == null)
				throw new Exception("Invalid Password - Fake or NULL");
			else
				this.password= password;
		}
		
	}


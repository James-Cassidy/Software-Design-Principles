package gradedGroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class BankEmployeeUI {
		public static void main( String[] args ) throws ParseException {
		
			BankEmployee bankEmployee = new BankEmployee("Y");

			BankClient client1 = new BankClient(  );
			Account client1Primary= new PrimaryAccount("primary",657);
			Account client1Secondary= new SecondaryAccount("secondary",590);
		    client1.getClientAccounts().add(client1Primary);
			client1.getClientAccounts().add(client1Secondary);
			client1.setClientProfile(new Profile("Jeff"," 56 tree place" ,new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/12/2000" ), "u1", "p1" ));
		    Appointment client1Appointment1 = new Appointment("Y", new SimpleDateFormat( "dd/MM/yyyy" ).parse( "23/10/2021" ), true, client1.getClientID());
			client1.getClientAppointments().add(client1Appointment1);
		    BankClientDictionarySingleton.getInstance().addBankClient(client1);
		    Appointment client1Appointment2 = new Appointment( "Y", (new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/02/2021" )), false, client1.getClientID()); 
			bankEmployee.getAppointments().add(client1Appointment2);
		
			BankClient client2 = new BankClient(  );
			Account client2Primary= new PrimaryAccount("primary",347);
			Account client2Secondary= new SecondaryAccount("secondary",127);
			Appointment client2Appointment = new Appointment("Y", new SimpleDateFormat( "dd/MM/yyyy" ).parse( "10/12/2021" ), true, client2.getClientID());
			
			client2.getClientAppointments().add(client2Appointment);
		    client2.getClientAccounts().add(client2Primary);
			client2.getClientAccounts().add(client2Secondary);
			client2.setClientProfile(new Profile("Geoff"," 23 tree place" ,new SimpleDateFormat( "dd/MM/yyyy" ).parse( "22/05/2000" ) , "u2", "p2" ));
			BankClientDictionarySingleton.getInstance().addBankClient(client2);
			Appointment client2Appointment2 = new Appointment( "Y", (new SimpleDateFormat( "dd/MM/yyyy" ).parse( "22/02/2021" )), false, client2.getClientID()); 
			bankEmployee.getAppointments().add( client2Appointment2 );//**


			
			List<Appointment> clientAppointments =  new ArrayList<Appointment>();		
			
			for(BankClient client : BankClientDictionarySingleton.getInstance().getList()) {

				for(int j = 0; j < client.getClientAppointments().size(); j++) {
					if (!client.getClientAppointments().get(j).getBooked()) {
						clientAppointments.add(client.getClientAppointments().get(j));
					}
				}
			}
			
			BankClientDictionarySingleton.getInstance().printBankClients();
		
		while(true) {

	    System.out.println("n0:Exit");
		System.out.println( "1.Validate Appointments" );
		String choice = read( "choice" );
		
			if( choice.equals( "0" ) ) break;
	
			else if( choice.equals( "1" ) ){ 
				ValidateAppointmentTransaction object=new ValidateAppointmentTransaction();
				
				object.validateAppointmentTransaction(bankEmployee,bankEmployee.getAppointments());
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


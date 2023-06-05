package gradedGroupProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookTransaction {
	
	private String employeeName;
	private Date appointmentDate;
	
	
	public void bookTransaction(List<String> employeeNames,BankClient loggedInClient) {
		
		provideBookingInformation();
		
		String error = checkTransactionStructure(employeeNames);
		
		if( error != null ) printErrorMessage( error );
		
		else executeBookingTransaction(loggedInClient);
		
	}
	
	private String checkTransactionStructure(List<String> employeeNames) {
		int pos;
		
			for(  pos = 0; pos < employeeNames.size(); ++pos ) if( employeeNames.get( pos ).equals(employeeName)) break;

			if( pos < 0 || pos >= employeeNames.size() ) return "Invalid Employee name";

			//return null;
			//Might need moved about
			if(appointmentDate==null) return "No Date entered";
			
			Date currentDate=new Date();
			
			if(appointmentDate.before(currentDate)) return"Invalid Date";
		    return null;
	}
	
	private void executeBookingTransaction(BankClient loggedInClient) {
		
		
		boolean scheduled = loggedInClient.askForSchedulingAppointment( appointmentDate, employeeName );

		if( scheduled ) {
			loggedInClient.bookAppointment( appointmentDate, employeeName,scheduled );
			System.out.println("Apppointment booked");
		}

		else System.err.println( "The appointment has not been booked" );
		
		
	}
	
	private void provideBookingInformation() {
		KeyInput KeyInput = new KeyInput();

		employeeName = KeyInput.read( "Name of Employee" );
		
		try {
			 appointmentDate= new SimpleDateFormat("dd/MM/yyyy").parse(KeyInput.read("appointment date in the format dd/MM//yyyy"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void printErrorMessage( String message ) {

		System.err.println( message );
	}
	
	
	
	
}

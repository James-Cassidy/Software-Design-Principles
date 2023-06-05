package gradedGroupProject;

import java.util.Date;
import java.util.List;

public class ValidateAppointmentTransaction {
	
	private String choice;

	public void validateAppointmentTransaction(BankEmployee employee,List<Appointment> clientAppointment){

		for(int i=0;i<BankClientDictionarySingleton.getInstance().getList().size();i++) {
			displayAppointment(clientAppointment.get(i),BankClientDictionarySingleton.getInstance().getList().get(i));
			choice=confirmAppointment();
			String error=checkVerifyAppointmentTransaction();
			if(error!=null) {
				printErrorMessage(error);
			}
			else executeVerifyAppointmentTransaction(clientAppointment.get(i),BankClientDictionarySingleton.getInstance().getList().get(i),employee);
		}
		
	}
	
	private String confirmAppointment() {
		String choice=null;
		System.out.println("Confirm this Appointment?");
		System.out.println("1. Book this appointment");
		System.out.println("2. Do not book this appointment");
		KeyInput input= new KeyInput();
		choice= input.read("choice");
		return choice;
	}
	
	private void printErrorMessage(String label) {
		System.err.println(label);
	}
	
	private void displayAppointment(Appointment appointment,BankClient client) {
			System.out.println("Date of Appointment: "+appointment.getAppointmentDate()+" with client = "+client.getName());
	}
	
	private String checkVerifyAppointmentTransaction() {
		if(choice.isEmpty()) {
			return "Error: No input detected";
		}
		if(!choice.equals("1")&&!choice.equals("2")){
			return "Error: Select option 1 or 2";
		}
		else 
			return null;
	}
	
	private void executeVerifyAppointmentTransaction(Appointment appointment,BankClient client,BankEmployee employee) {
		employee.verifyAppointment(appointment,client,choice);
	}


}

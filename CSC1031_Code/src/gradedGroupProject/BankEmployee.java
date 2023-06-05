package gradedGroupProject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BankEmployee extends Person{

	
    private String name;
	private List<Appointment> appointments = new ArrayList<Appointment>();

		public BankEmployee(String name) {
			this.name=name;
		}
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name=name;
		}
	
		public Boolean verifyAppointment(Appointment appointment, BankClient client, String choice) {
			System.out.print("Appointment date "+ appointment.getAppointmentDate() +",");
			if(choice.equals("1")) {
				System.out.print(" scheduled: true");
				appointment.setAppointmentBooked(true);
				System.out.println();
				return true;
				//Send Message to client confirming appointment
			}
			if(choice.equals("2")) {
				System.out.print(" scheduled: false");
				appointment.setAppointmentBooked(false);
				System.out.println();
				return false;
				//Send Message to client asking to reschedule appointment
			}	
			return null;
		}


		public List<Appointment> getAppointments() {
			return appointments;
		}


		public void setAppointmentDates(List<Appointment> appointments) {
			this.appointments = appointments;
		}
	}


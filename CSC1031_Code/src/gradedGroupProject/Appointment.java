package gradedGroupProject;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Appointment {
	
	public static final AtomicInteger appointmentCount = new AtomicInteger( 0 );
	private int appointmentId;
	private int clientID;
	private Date appointmentDate;
	private String employeeName;
	private boolean booked;
	
	public Appointment(String employeeName,Date appointmentDate, boolean booked,int clientID) {
		this.setEmployeeName(employeeName);
		 Date currentDate=new Date();
			
			if(appointmentDate.before(currentDate)) {
				System.err.println("Error: Invalid Date");
			}
			else {
				this.setAppointmentDate(appointmentDate);
			}
		this.clientID=clientID;
		this.setAppointmentBooked(booked);
		setAppointmentId(appointmentCount.incrementAndGet());	
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public int getClientID() {
		return clientID;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	
	public boolean getBooked() {
		return booked;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setAppointmentBooked(boolean booked) {
		this.booked=booked;
	}

	
	
	
	
}

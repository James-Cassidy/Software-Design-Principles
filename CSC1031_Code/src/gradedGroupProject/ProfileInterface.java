package gradedGroupProject;

import java.util.Date;

public interface ProfileInterface {

	public void changeClientProfileDetails( String name, String address, Date birthDate, String username, String password);
	public void toPrint();
}

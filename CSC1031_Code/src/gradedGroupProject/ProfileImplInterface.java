package gradedGroupProject;

import java.text.ParseException;

// ngl this isn't going to be needed probably
public interface ProfileImplInterface {

	public ProfileInterface createBankClientProfile();
	public abstract Profile executeCreateBankClientProfileTransaction();
	public abstract void provideClientInformation() throws ParseException;
	public abstract boolean checkClientInformation();
	public abstract void printErrorMessage();
	public abstract String invalidInformation();
}

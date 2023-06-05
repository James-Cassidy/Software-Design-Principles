package gradedGroupProject;

public abstract class TemplateTransaction {
	
	public Profile processTransaction(){
		provideDetails(); 
		String error = checkTransactionStructure(); 
		if( error!=null ) printErrorMessage(error); 
		else return executeTransaction(); 
		return null;
	} 

	protected  abstract void provideDetails(); 
	protected  abstract String checkTransactionStructure(); 
	protected  abstract void printErrorMessage(String message); 
	protected  abstract Profile executeTransaction();
}


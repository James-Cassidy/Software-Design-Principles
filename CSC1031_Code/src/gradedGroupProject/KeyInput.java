package gradedGroupProject;

import java.util.Scanner;

public class KeyInput {

	public String read( String label ) {
		
		System.out.println( "\nProvide " + label + ":" );

		System.out.println( ">" );

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner( System.in );

		String value = scanner.nextLine();

		return value;
	}
}

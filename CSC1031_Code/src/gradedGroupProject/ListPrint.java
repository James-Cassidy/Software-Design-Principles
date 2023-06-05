package gradedGroupProject;

import java.util.List;

public class ListPrint {
	public void print(List<BankClient> bankClients) {

		for (int i = 0; bankClients != null && i < bankClients.size(); ++i)
			bankClients.get(i).toPrint();
	}
}

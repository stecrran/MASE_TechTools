package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();
			TextConverter textConverterService = (TextConverter) registry.lookup("UpperCaseService");

			String returnString = textConverterService.convertToUpper("blank text");
			String returnReverseString = textConverterService.reverseString("blank text");
			System.out.println(returnString);
			System.out.println(returnReverseString);
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}

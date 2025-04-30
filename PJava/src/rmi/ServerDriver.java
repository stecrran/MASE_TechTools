package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerDriver {
	
	public static void main(String[] args) {
		TextConverter textConverter = new TextConverterService();
		
		try {
			TextConverter stub = (TextConverter) UnicastRemoteObject.exportObject(textConverter, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("UpperCaseService", stub);

		}
		catch(RemoteException e) {
			e.printStackTrace();
		}
	}

}

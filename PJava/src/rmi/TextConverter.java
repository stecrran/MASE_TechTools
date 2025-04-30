package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextConverter extends Remote {
	
	public String convertToUpper(String string) throws RemoteException;
	
	public String reverseString(String string) throws RemoteException;

}

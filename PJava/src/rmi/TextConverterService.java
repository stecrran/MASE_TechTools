package rmi;

import java.rmi.RemoteException;

public class TextConverterService implements TextConverter {

	@Override
	public String convertToUpper(String string) throws RemoteException {
		return string.toUpperCase();
	}

	@Override
	public String reverseString(String string) throws RemoteException {
		StringBuilder stringBuilder = new StringBuilder(string.length());
		for (int i = string.length()-1; i >= 0; i--) {
			stringBuilder.append(string.charAt(i));
		}
		return stringBuilder.toString();
	}

}

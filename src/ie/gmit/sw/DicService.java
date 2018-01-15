package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DicService extends Remote{
	
	// Adapted from the FileServer lab
	// Setting up an array list to store the dictionary
	public ArrayList<String> loadDic() throws RemoteException;
	// A method with the word to be searched
	public String lookup(String wordsearch) throws RemoteException;

}

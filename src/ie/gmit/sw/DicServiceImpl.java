package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DicServiceImpl extends UnicastRemoteObject implements DicService{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> dic = new ArrayList<String>();
	
	public DicServiceImpl() throws RemoteException{
		super();
	}
	

	@Override
	public ArrayList<String> loadDic() throws RemoteException {
		Scanner scan;
		// If the dictionary is empty read in the file and add to the array
		if(dic.isEmpty() == true){
			try{
				scan = new Scanner(new File("dic.txt"));
				while(scan.hasNextLine()){
					dic.add(scan.nextLine());
					}
				scan.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return dic;
	}
	
	@Override
	public String lookup(String wordsearch) throws RemoteException{
		String ans = "Sorry, couldn't find this word :(";
	
		// If the line in the dictionary starts with that word, the answer is that line
		for(String line: dic){
			if(line.startsWith(wordsearch + ":")){
				ans = line;
			}
		}
		// return the answer
		return ans;
	}	

}

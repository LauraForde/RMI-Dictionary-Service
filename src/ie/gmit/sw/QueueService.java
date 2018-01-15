package ie.gmit.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Queue;

public class QueueService implements Runnable{
	
	// Setting up String queues for the in and out results
	private Queue<String> in;
	private Queue<String> out;
	private String returnMsg;
	
	// Creating two linked lists of the queues and adding the words to the in queue
	public QueueService(String word){
		in = new LinkedList<>();
		out = new LinkedList<>();
		in.add(word);
	}

	public void request() throws MalformedURLException, RemoteException, NotBoundException{
		// If the in queue is not empty
		if(!in.isEmpty()){
			// Find and add the return message to the out queue
			DicService ds = (DicService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
			this.returnMsg = ds.lookup(in.poll().toUpperCase());
			out.add(returnMsg);
		
		}
	}
	
	public String response(){
		return out.poll();
	}
	@Override
	public void run() {
		// Run the request method
		try {
			request();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

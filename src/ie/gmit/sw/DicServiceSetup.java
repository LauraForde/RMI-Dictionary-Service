package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DicServiceSetup {

	public static void main(String[] args) throws Exception{
		
		// Adapted from the FileServer lab 
		DicService dicService = new DicServiceImpl();
		dicService.loadDic();
		// Start on port 1099
		LocateRegistry.createRegistry(1099);
		Naming.rebind("dicService", dicService);
		//Print server is ready
		System.out.println("Server ready.");
	}
		

}

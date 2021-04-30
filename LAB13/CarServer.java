package lab13;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class CarServer {

public CarServer() {	
	
	try {
		
		Car obj = new CarImplement();
		Registry registry = LocateRegistry.createRegistry(2099);
		registry.rebind("CarService", obj);
		System.out.println("CarService bound in registry");
		
	}catch(Exception e) {
		System.err.println("Error is: " + e);
		System.exit(1);
	}
		
}

public static void main(String args[]) {
	new CarServer();
	System.out.println("Car Server is running");
}


	
}

package lab13;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Car extends Remote {

	String registerCar(Car c) throws RemoteException;
	
}

package lab13;
import java.rmi.RemoteException;
public class CarImplement extends java.rmi.server.UnicastRemoteObject implements Car  {

	public CarImplement()throws RemoteException{
		super();
	}
	
	public String registerCar(Car c) throws RemoteException{
		return  " " + c.hashCode() + " ";
	}
}

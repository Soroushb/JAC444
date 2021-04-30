package lab13;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class CarClient {

	public static void main(String[] args) {
		try {
		
		
		CarClass car = new CarClass("Tesla", "Gold", 50.00);
		
		System.out.println("Initial Information");
		System.out.println(car.toString());
		
		Car c = (Car) Naming.lookup("rmi://localhost:2099/CarService");
		car.setPlate(c.registerCar(c));
		
		System.out.println("\nRegistering the car...");
		System.out.println("\nNew information");
		System.out.println(car.toString());
		
		}catch(MalformedURLException murle) {
			System.out.println("MalformedURLException");
			System.out.println(murle);
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println("NotBoundException");
			System.out.println(nbe);
		} catch (ArithmeticException ae) {
			System.out.println("ArithmeticException");
			System.out.println(ae);
		}
	}
}

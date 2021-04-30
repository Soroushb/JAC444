package lab13;

public class CarClass implements java.io.Serializable {

	private String model;
	private String color;
	private double mileage;
	private String plate;
	
	public CarClass() throws java.rmi.RemoteException {
		super();
	}
	
	public CarClass(String model, String color, double mileage) {
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.plate = "UNDIFINED";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	@Override
	public String toString() {
		return "Model: " + getModel() + "\nColor: "+ getColor() + "\nMileage: "
				+ this.getMileage() + "\nPlate: " + this.getPlate();
	}
}

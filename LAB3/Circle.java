package shapes;
import java.text.DecimalFormat;

public class Circle implements Shape {

	private double radius;
    private ShapeProperty object = () -> getRadius() * getRadius() * Math.PI  ;

	public Circle(double rad) throws Exception{
		if(rad > 0.00) {
			radius = rad;
		}else {
			throw new Exception("Invalid Radius!");
		}
	}
	

	public double getRadius() {
		return radius;
	}
	

	public void setRadius(double rad) throws Exception{
		if(rad > 0.00) {
			radius = rad;
		}else {
			throw new Exception("Radius must be more than 0");
		}
	}
	
	
	
	@Override
	public double perimeter() {
		return radius * 2 * Math.PI;
	}
	
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {r=" + getRadius() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter()) + " --- Area = " + new DecimalFormat("0.00000").format(object.area()) ;
	}
}

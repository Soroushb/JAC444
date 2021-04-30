package shapes;

import java.text.DecimalFormat;

public class Rectangle extends Parallelogram {

	double height;
	double width;
	private ShapeProperty object = () -> getWidth() * getHeight();
	
	public Rectangle(double height, double width) throws Exception{
		super(height, width);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {w=" + getWidth() + " h=" + getHeight() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter())
				+ " --- Area = " + new DecimalFormat("0.00000").format(object.area());
	}
	
	
	
}

package shapes;
import java.text.DecimalFormat;

public class Square extends Rectangle {
	
	public Square(double side) throws Exception {
		super(side, side);
	}

	private ShapeProperty object = () -> getWidth() * getWidth();
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {s=" + getWidth() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter())
				+ " --- Area = " + new DecimalFormat("0.00000").format(object.area());
	}
	
	@Override
	public void setWidth(double width) throws Exception{
		
		if(width > 0 && width == this.getHeight()) {
			super.setWidth(width);
		}else {
			throw new Exception("invalid width");
		}
	}
}

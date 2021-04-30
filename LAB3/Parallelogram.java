package shapes;
import java.text.DecimalFormat;

public class Parallelogram implements Shape{

	private double height;
	private double width;

	public Parallelogram(double width, double height) throws Exception{

		if(height > 0 && width > 0) {
			this.height = height;
			this.width = width;
		}else {
			throw new Exception("Invalid side!");
		}
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public void setHeight(double height) throws Exception{

		if(height > 0) {
			this.height = height;
		}else {
			throw new Exception("Invalid height");
		}
	}

	public void setWidth(double width) throws Exception{

		if(width > 0) {
			this.width = width;
		}else {
			throw new Exception("Invalid width");
		}
	}

	@Override
	public double perimeter() {
		return (width + height) * 2;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter());
	}

}

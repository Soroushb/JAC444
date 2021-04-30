package shapes;
import java.text.DecimalFormat;

public class Triangle implements Shape{

	private double sideX;
	private double sideY;
	private double sideZ;

	public Triangle(double x, double y, double z) throws Exception{

		if(x > 0.00 && y > 0.00 && z > 0.00 && x < (y + z) && y < (x + z) && z < (x + y)){
			sideX = x;
			sideY = y;
			sideZ = z;
		}else {
			throw new Exception("Invalid side(s)!");
		}
	}

	public double getSideX() {
		return sideX;
	}

	public double getSideY() {
		return sideY;
	}

	public double getSideZ() {
		return sideZ;
	}

	public void setSideX(double x) throws Exception{

		if(x > 0) {
			this.sideX = x;
		}else {
			throw new Exception("Invalid side!");
		}
	}

	public void setSideY(double y) throws Exception{

		if(y > 0) {
			this.sideY= y;
		}else {
			throw new Exception("Invalid side!");
		}
	}

	public void setSideZ(double z) throws Exception{

		if(z > 0) {
			this.sideZ = z;
		}else {
			throw new Exception("Invalid side!");
		}
	}

	@Override
	public double perimeter() {
		return sideX + sideY + sideZ;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {s1=" + getSideX() + ", s2=" + getSideY() + ", s3=" + getSideZ() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter());
	}
	}


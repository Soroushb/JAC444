
public class FirstLab {
	public static void main(String[] args) {

		int x = 1;

		for(int rows = 1; rows <= 8; rows++) {
			for(int i = 8; i >= rows; i--) {
				System.out.print("   ");
			}
		for(int j = 0; j < rows; j++) {
		System.out.print(x);
		System.out.print("  ");
		x *= 2;
		}
		x = x/2;
		for(int k = 1; k < rows; k++){
		x = x/2;
		System.out.print(x);
		System.out.print("  ");

		}
		System.out.println("");
		}

		}
}

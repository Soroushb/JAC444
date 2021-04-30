package secondProgram;

public class Palindrome {

	
	public static void main(String args[]) {

		String arr = args[0];
		
		if(isPalindrome(arr))
			System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");
	}
	
	public static boolean isPalindrome(String arr) {

		Stack obj = new Stack(arr.length());
		for(int i = 0; i < arr.length(); i++) {
			obj.push(arr.charAt(i));
		}
		
		for(int i = 0; i < arr.length(); i++) {
			if(arr.charAt(i) != obj.pop()) {
				return false;
			}
		}
		return true;
	}

	
}

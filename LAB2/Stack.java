package secondProgram;

public class Stack {

	private char[] string;
	private int last;
	
	public void push(char character) {
		string[++last] = character;
	}
	
	public char pop() {
		return string[last--];
	}
	
	public Stack(int size) {
		string = new char[size];
		last = -1;
	}
	
}

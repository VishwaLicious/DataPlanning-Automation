package in.licious.test;

public class IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a, b;
		a = 10;
		b = 20;
		if (a > b) {
			//Below statement will be executed ONLY when 'a' is greater than b
			System.out.println("a is greater than b");
		} else {
			//Below statement will be executed ONLY when 'b' is greater than 'a' or Equal to 'a'
			System.out.println("b is greater than a");
		}

	}

}

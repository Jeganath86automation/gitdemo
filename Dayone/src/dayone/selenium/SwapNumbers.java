package dayone.selenium;

public class SwapNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=100;
		int b=200;
		
		System.out.println("Before Swap:");
		System.out.println("First number is:" + a);
		System.out.println("Second number is:" + b);
		int c=a;
		a=b;
		b=c;
		System.out.println("After Swap:");
		System.out.println("First number is:" + a);
		System.out.println("Second number is:" + b);
		

	}

}

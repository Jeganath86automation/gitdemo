package dayone.selenium;

public class WrapperClass {

	public static void main(String[] args) {

		String s="100";
		System.out.println(s+50);
		
		//to convert string to Int we use wrapper class
		//to convert string to double
		
		int i=Integer.parseInt(s);
		System.out.println(i+50);
		
		String t="12.33";
		System.out.println(t+10);
		double d=Double.parseDouble(t);
		System.out.println(d+10);
		
		String v="100A";
		int j=Integer.parseInt(v);
		System.out.println(j+10);
	}

}

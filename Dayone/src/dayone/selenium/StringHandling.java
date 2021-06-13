package dayone.selenium;

public class StringHandling {

	public static void main(String[] args) {
		String s1="Hello Jegan";
		String s2=s1.concat("athan");
		System.out.println(s2);
		String s3="";
		char[] chr=s2.toCharArray();
		for(int i=s2.length()-1;i>=0;i--){
			s3 +=chr[i];
		}
		System.out.println("Reverse string is:  " + s3);

		
	}

}

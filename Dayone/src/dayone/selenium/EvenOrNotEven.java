package dayone.selenium;

import java.util.Scanner;

public class EvenOrNotEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader=new Scanner(System.in);
		System.out.println("Enter the number: ");
		int i=reader.nextInt();
		if (i % 2 == 0){
				System.out.println("It is an even number");
		}else{
				System.out.println("Not an even number");
		}
	
	}

}

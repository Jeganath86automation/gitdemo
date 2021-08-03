package dayone.selenium;

import java.util.Scanner;

public class PrintNumberEnteredByUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader=new Scanner(System.in);
		System.out.println("Enter the number:");
		
		int number =reader.nextInt();
		System.out.println("The entered number is:" +number);

	}

}

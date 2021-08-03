package dayone.selenium;

import java.util.Scanner;

public class CheckVowelOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter an alphabet: ");
		char ch = reader.next().charAt(0);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			System.out.println("It is an vowel");
		else
			System.out.println("It is not a vowel");

	}

}

package dayone.selenium;

public class StaticAndNonStatic {

	static int i = 60;
	static int j = 70;

	public static void main(String[] args) {
		StaticAndNonStatic sns = new StaticAndNonStatic();
		StaticAndNonStatic.total();
		// sns.i=50;
		sns.sum();

	}

	public static void total() {

	}

	public static void sum() {
		//StaticAndNonStatic sns = new StaticAndNonStatic();

		//int i = 50;
		//int j = 50;
		//System.out.println(sns.i + sns.j);
		System.out.println(i+j);
	}

}

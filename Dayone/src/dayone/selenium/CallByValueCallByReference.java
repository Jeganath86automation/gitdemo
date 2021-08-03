package dayone.selenium;

public class CallByValueCallByReference {

	int p=30;
	int q=40;
	
	public static void main(String[] args) {

		//Call by value
		int x=25;
		int y=35;
		sum(x, y);
		
		//call by reference
		CallByValueCallByReference obj =new CallByValueCallByReference();
		System.out.println("Before Swap");
		System.out.println(obj.p);
		System.out.println(obj.q);
		swap(obj);
		
		
	}
	
	public static int sum(int a, int b){
		int c;
		c=a+b;
		System.out.println(c);
		return c;
	}
	
	public static void swap(CallByValueCallByReference t){
		int temp;
		temp=t.p;
		t.p=t.q;
		t.q=temp;
		System.out.println("After Swap");
		System.out.println(t.p);
		System.out.println(t.q);
	}

}

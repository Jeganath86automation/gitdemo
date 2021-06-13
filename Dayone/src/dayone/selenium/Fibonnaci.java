package dayone.selenium;

public class Fibonnaci {

	public static void main(String[] args) {
    int n1=0;
    int n2=1;
    int n3;
    int count=10;
    int i;
    for (i=0;i<=count;++i){
        n3=n1+n2;
        System.out.println(n3);
        n1=n2;
        n2=n3;
	
    }
	}

}

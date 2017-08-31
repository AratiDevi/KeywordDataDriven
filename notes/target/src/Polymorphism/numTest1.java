package Polymorphism;

public class numTest1 {
	
	void sal(int a)
	{
		System.out.println("a:  "+a);
		
	}
	
	
	void sal(int a, int b, int c)
	{
		System.out.println("a,b,c:" + a + "," +b + "," + c);
	}
	
	
	double sal(double a)
	{
		System.out.println("double a:" +a);
		return a*a*a;
	}
}
	
   
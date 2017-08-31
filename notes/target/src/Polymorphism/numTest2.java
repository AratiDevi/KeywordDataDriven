package Polymorphism;

public class numTest2 {

	public static void main(String[] args) {
		
		numTest1 obj = new numTest1();
		double result;
		obj.sal(10);
		obj.sal(10,20,30);
		
		result=obj.sal(5.5);
		System.out.println("Result=" +result);

	}

}

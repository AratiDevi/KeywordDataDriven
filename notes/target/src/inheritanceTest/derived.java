package inheritanceTest;

public class derived extends single{
	
	derived()
	{
		str=str.concat("world");
	}

	void display()
	{
		System.out.println(str);
	}
	
	
	public static void main(String[] args) {
		
	      derived d=new derived();
	      d.display();
		}
}

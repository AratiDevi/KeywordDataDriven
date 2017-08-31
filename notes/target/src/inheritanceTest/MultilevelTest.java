package inheritanceTest;

 class MultilevelTest1 extends multilevel

{ 
	MultilevelTest1()
	{
	
		str = str.concat("R");
	
	}
	}
 
 
   class MultilevelTest2 extends MultilevelTest1
   {
	
	   MultilevelTest2()
	 {
		str = str.concat("A");
	 }
   }
	
	
class MultilevelTest3 extends MultilevelTest2
	{
		MultilevelTest3() 
		
		{
		str = str.concat("TI");
	}
		
		
		void display()
		{
			System.out.println(str);
		}
}
	
    class MultilevelTest
     {
	 
    	public static void main(String[] args) {
		
		MultilevelTest3 ob= new MultilevelTest3();
		ob.display();
	}

}

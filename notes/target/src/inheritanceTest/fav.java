package inheritanceTest;

public class fav extends book

{
	String author;
	int pages;
	
	void attributesbook()
	
	{
	
				
		System.out.println("Author of the book: " + author);
		System.out.println("Pages of the book: " + pages);
		
	}
	
	public static void main(String[] args)
	
	{
		fav a1= new fav();
		
		a1.name= "Little Things";
		a1.price= 200;
		a1.author= "Arundhati Roy";
		a1.pages= 100;
		a1.attributes();
		a1.attributesbook();

	}

}

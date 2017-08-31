package inheritanceTest;


   interface first
 
  {
	 String str1= "Arati ";
  }
  
  
   interface second
   
  {
 	  String str2= "Devi";
  }
  
  

  class multiple implements first,second
  {
	  String str;
	  
	  multiple()
	  {
		  str= str1.concat(str2);
	  }
	  
	
	

	public String display()
	 {
		
		System.out.println(str);
		
		return(null);
	}

  }



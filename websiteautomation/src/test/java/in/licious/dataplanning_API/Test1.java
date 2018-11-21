package in.licious.dataplanning_API;

public class Test1 {

/*  //Java For-each loop example which prints the  
  //elements of the array  
 // public class ForEachExample {  
  public static void main(String[] args) {  
      //Declaring an array  
      int arr[]={12,23,44,56,78};  
      //Printing array using for-each loop  
      for(int i:arr){  
          System.out.println(i);  
      }
	
  }
  */
	
	// String array
	
	public static void main(String[] args) {
	   // String[] arrData = {"Alpha", "Beta", "Gamma", "Delta", "Sigma"};
		String arrData[] = {"Alpha", "Beta", "Gamma", "Delta", "Sigma"};
	    //The conventional approach of using the for loop
	    System.out.println("Using conventional For Loop:");
	    for(int i=0; i< arrData.length; i++){
	      System.out.println(arrData[i]);
	    }
	    System.out.println("\nUsing Foreach loop:");
	    //The optimized method of using the for loop - also called the foreach loop
	    for (String strTemp : arrData){
	      System.out.println(strTemp);
	    }
	  }
		
	}
	
	
  



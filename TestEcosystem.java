import java.util.Scanner;



public class TestEcosystem {
	

	 public static void main (String[] args)
	   {
	      River pp = new River ();						//� create new river object
	      Scanner keyboard = new Scanner (System.in);	// � use my keyboard to control raunds

	      
	      for (int k = 0; k < 400; k++)       			//for loop for move to all animals
	      {
	         System.out.println (pp);
	         pp.move();
	         keyboard.nextLine();						//press enter the next raund
	      }
	      
	      
	      

	     
	   }
	 
	
	 
}

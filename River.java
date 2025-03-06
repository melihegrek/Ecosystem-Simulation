
import java.security.SecureRandom;

public class River {
	public static final int    Row          = 10;
	public static final int    Column         = 50;
    public static final int    BeginnigFish  = 30;
	public static final int    BeginningBear = 30;
	public static final int    BeginninngCrocodile= 20;


	private SecureRandom random = new SecureRandom();

	private Animal[][] anArray;     //to make ecosystem 
	
    private int fishCount = 0;      //for printig counts 
    private int bearCount = 0;   
    private int croCount=0;
    
    public River() {
    	
    	anArray = new  Animal[Row][Column];

        // Add Fish to random locations in our ecosystem:
        while (fishCount < BeginnigFish)                         //create animals thanks to attributes
        {
           fishCount += addAnimal (new Fish() );				 //30 times
        }

        // Add Bear to random locations in our ecosystem:
        while (bearCount < BeginningBear)
        {
           bearCount += addAnimal (new Bear() );				//20times
        }
        
        while (croCount < BeginninngCrocodile)
        {
           croCount += addAnimal (new Crocodile() );			//20 twenty times
        }
        
    	
    	
    }
    @Override
    public String toString()
    {
       String outStr = "";

       for (int x = 0; x < Row; x++)
       {
          for (int y = 0; y < Column; y++)
          {
             if (anArray[x][y] == null)
             {
                outStr += ".";
             }
             else if (anArray[x][y] instanceof Fish)
             {
                outStr += "F";
             }
             else if (anArray[x][y] instanceof Bear)
             {
                outStr += "B";
             }
             else if (anArray[x][y] instanceof Crocodile) {
            	 outStr+="C";
             }
          }
          outStr += "\n";
       }

       outStr += "Fish :"+ fishCount +"\t"+"Bear:"+bearCount+"\t"+"Crocodile:"+croCount;

       return outStr;
    }

	
    protected int addAnimal (Animal RandomAnimal) {
    	int Count = 0;                                       //ý use count to calculate  number of animal produce 

        int totalplaces = fishCount + bearCount+croCount;    // It have to check  there is enough spaces
        
        if(totalplaces<Row*Column) {                          //if there is enough place , produce new animal
        	
        	while(Count==0) {
        		
        		int x = random.nextInt (Row);  							// 0 <= x < WIDTH       //I use random coordinates
                int y = random.nextInt (Column); 						// 0 <= y < HEIGHT		//I random coordinates
        		
                if (anArray[x][y]==null) {								//I checked this random coordinate is empty 
                	
                	anArray[x][y]=RandomAnimal;                         //if it is empty animal placed here
                	Count++;											//for count and to stop method
                	
                	}
                }
        }
        return Count;
        
        
    	
    }
   
    
    public void move() {
    	
   	 for (int x=0 ; x<Row ; x++) {								//I use nested for loop to scan all places 
   		 
   		 for(int y= 0 ; y<Column; y++) {
   			 
   			 if(anArray[x][y]!=null) {							//it choose animal object to move
   				 
   				int chance = random.nextInt(2);					//in assignment there is %50 change to move  random operator produce 0 and 1
   				
   				
   				if(chance==0) {									//change = 0 move 	
   					
   					int xchange=random.nextInt(3)-1;  			//-1,0,1   -1 is one unit left , 0 is stay , 1 is 1 unit right
   					int ychange=random.nextInt(3)-1;			//-1,0,1	-1 is one unit bottom , 0 is stay , 1 is 1 unit top
   					
   					if(xchange==0&&ychange==0) {				// ý check  0  0 because it means stay same place 
   						continue;
   					}
   					
   					int xNew =x+xchange;
   					int yNew=y+ychange;
   					
   					boolean xDirection =  false;       			//I used boolean direction because I have to find Final coordinates x and y , if it is change with true animal move this direction 
   					boolean yDirection = false;					// if it is not change animal dont have new point on x or y , ý have to use initial x or y
   					
   					if(xchange!=0 && xNew < Row && xNew>=0) {        //to control animal where is going . it must be in borders.
   						xDirection=true;
   						
   					}
   					if(ychange!=0 && yNew < Column && yNew>=0) {
   						yDirection=true;
   						
   					}
   					
   					int xFinal;
   					int yFinal;
   					
   					if(xDirection==true) {
   						xFinal=xNew;										//new x component
   						
   					}
   					else {
   						xFinal=x;											//new x component
   						
   					}
   					if(yDirection==true) {
   						yFinal=yNew;										//new y component
   						
   					}
   					else
   						yFinal=y;											//new y component
   					
   					
   					
   					
   					if(anArray[xFinal][yFinal]==null) {                     //first Case
   						
   						if(anArray[x][y].getClass().getName().equals ("Bear") == true) {
   							
   							
							anArray[xFinal][yFinal]=anArray[x][y];				//animal changed its location
							anArray[x][y]=null; 								//old location is now null
							anArray[xFinal][yFinal].anMove();					//for example movement increased 1
							
							if(anArray[xFinal][yFinal].getStrength()==0) {     	//thanks to this code ý checked animal is alive
								anArray[xFinal][yFinal] = null;					//animal die when its strength come 0
								bearCount--;									//count is decreased by 1 unit
							}
   						}
   						else if (anArray[x][y].getClass().getName().equals ("Fish") == true) {
								
								
								anArray[xFinal][yFinal]=anArray[x][y];			//animal changed its location
								anArray[x][y]=null;
								
								
							}
   						else if(anArray[x][y].getClass().getName().equals ("Crocodile") == true) {
								
								
								anArray[xFinal][yFinal]=anArray[x][y];			//animal changed its location
								anArray[x][y]=null;								//old location is now null
								anArray[xFinal][yFinal].anMove();				//for example movement increased 1
								
								if(anArray[xFinal][yFinal].getStrength()==0) {	//thanks to this code ý checked animal is alive
									croCount--;									//animal die when its strength come 0
									anArray[xFinal][yFinal] = null;				//count is decreased by 1 unit
								}
								
								
							}
   							
							

   						
   							
   						
   						
   						
   					}
   					else if(anArray[x][y].getClass()==anArray[xFinal][yFinal].getClass() && anArray[x][y].getGender()!=anArray[xFinal][yFinal].getGender()) {//Second case
   					 // Create baby fish or bear or crocodile
   						
   						if (anArray[x][y].getClass().getName().equals ("Fish") == true)  //create fish
                            fishCount += addAnimal (new Fish() );
   						
   						else if (anArray[x][y].getClass().getName().equals ("Bear") == true)  // create bear
   							bearCount += addAnimal (new Bear() );
   						
   						else if (anArray[x][y].getClass().getName().equals ("Crocodile") == true)  //create crocodile 
                         croCount += addAnimal (new Crocodile() );
   					}
   					
   					else if((anArray[x][y].getClass()==anArray[xFinal][yFinal].getClass() && anArray[x][y].getGender()==anArray[xFinal][yFinal].getGender())) {  //Third Case
   						
   						
   						if(anArray[x][y].getStrength()<anArray[xFinal][yFinal].getStrength()) {   //same types battle 
   							
   							if(anArray[x][y].getClass().getName().equals ("Bear") == true) {
   								bearCount--;
   								anArray[x][y]=null;                                                 //to disappear
   							}
   							else if(anArray[x][y].getClass().getName().equals ("Fish") == true) {
   								fishCount--;
   								anArray[x][y]=null;													//to disappear
   							}
   							else if(anArray[x][y].getClass().getName().equals ("Crocodile") == true) {
   								croCount--;
   								anArray[x][y]=null;													//to disappear
   								
   							}
   						}
   						else if(anArray[x][y].getStrength()>anArray[xFinal][yFinal].getStrength()) {
   							
   							if(anArray[x][y].getClass().getName().equals ("Bear") == true) {
   								bearCount--;														//count decrease				
   								anArray[xFinal][yFinal] = null;										//lower strength animal lose battle
   								anArray[xFinal][yFinal]=anArray[x][y];								//more strengthful moved to loser place
   								anArray[x][y]=null; 												//null the previous place
   								anArray[xFinal][yFinal].anMove();									//movement attributes increase by one
   								
   								if(anArray[xFinal][yFinal].getStrength()==0) {						// checking strength if 0 will die
   									anArray[xFinal][yFinal] = null;									// disappear 
   								}
   								
   							}
   							else if (anArray[x][y].getClass().getName().equals ("Fish") == true) {
   								fishCount--;
   								anArray[xFinal][yFinal] = null;
   								anArray[xFinal][yFinal]=anArray[x][y];
   								anArray[x][y]=null;
   								
   							}
   							else if(anArray[x][y].getClass().getName().equals ("Crocodile") == true) {
   								croCount--;
   								anArray[xFinal][yFinal] = null;
   								anArray[xFinal][yFinal]=anArray[x][y];
   								anArray[x][y]=null;
   								anArray[xFinal][yFinal].anMove();
   								if(anArray[xFinal][yFinal].getStrength()==0) {
   									anArray[xFinal][yFinal] = null;
   								}
   								
   								
   							}
   							
   						}
   						 
   							
   						         
   						
   					}
   					
   					
   					else if (anArray[x][y].getClass() != anArray[xFinal][yFinal].getClass() ) {   //Fourth case   different type
   						
   						if (anArray[x][y].getClass().getName().equals ("Fish") == true && anArray[xFinal][yFinal].getClass().getName().equals ("Crocodile")==true)//subcase 1
                        {
   							anArray[xFinal][yFinal].eatingFish();						//eat this fish
   							
                           if (fishCount > 0)											//checking the counts of fish , if it is greater than 0 decrease by 1
                           {
                              anArray[x][y] = null;										//this fish die , its place must be null 
                              fishCount--;												//decrease by 1
                           }
                        }
   						else if (anArray[x][y].getClass().getName().equals ("Crocodile") == true && anArray[xFinal][yFinal].getClass().getName().equals ("Fish")==true) //subcase 2
                        {
   							anArray[x][y].eatingFish();										//eat this fish
   							
                           if (fishCount > 0)												//checking the counts of fish , if it is greater than 0 decrease by 1
                           {
                              anArray[xFinal][yFinal] = null;   //fish is dead  			//this fish die , its place must be null 
                              fishCount--;													//decrease by 1
                              anArray[xFinal][yFinal]=anArray[x][y];						//crocodile moved its next place 
                              anArray[x][y]=null;               							//crocodiles previous space is become null
                              
                              anArray[xFinal][yFinal].anMove();								//movement attributes increase by one and it lose energy if movement variable 10
                              
                              if(anArray[xFinal][yFinal].getStrength()==0) {				// checking strength if 0 will die
                            	  anArray[xFinal][yFinal]=null;								// disappear 
                            	  
                            	  
                              }
                              
                           }
                        }
   						else if (anArray[x][y].getClass().getName().equals ("Bear") == true && anArray[xFinal][yFinal].getClass().getName().equals ("Fish")==true)//subcase 3
                        {
   							anArray[x][y].eatingFish();
   							
   							if (fishCount > 0)
                           {
                              anArray[xFinal][yFinal] = null;
                              fishCount--;
                              anArray[xFinal][yFinal]=anArray[x][y];
                              anArray[x][y]=null;  //Bear has moved
                              anArray[xFinal][yFinal].anMove();
                              
                              if(anArray[xFinal][yFinal].getStrength()==0) {
                            	  anArray[xFinal][yFinal]=null;
                            	  
                            	  
                              }
                              
                              
                              
                           }
                        }
   						else if (anArray[x][y].getClass().getName().equals ("Fish") == true && anArray[xFinal][yFinal].getClass().getName().equals ("Bear")==true) //subcase 4
                        {
   							anArray[xFinal][yFinal].eatingFish();									//got energy from fish
   							
                           if (fishCount > 0)
                           {
                              anArray[x][y] = null;
                              fishCount--;
                           }
                        }
   						
   						else if (anArray[x][y].getClass().getName().equals ("Bear") == true && anArray[xFinal][yFinal].getClass().getName().equals ("Crocodile")==true ) {//subcase 5
   							
   							int dieChange=random.nextInt(2);                            // 0 and 1  for 0 bear is alive , for 1 crocodile is alive
   							
   							if (dieChange==0) {											//bear killed crocodile
   								croCount--;												//crocodile count decrease
   								
   								anArray[xFinal][yFinal] = null;							//crocodile's space is null
   								
   								anArray[xFinal][yFinal]=anArray[x][y];					//bear moved crocodile's empty space
                                anArray[x][y]=null;  									//Bear's previous space is null rigth now
                                anArray[xFinal][yFinal].anMove();						//movement attributes increase by one and it lose energy if movement variable 10
                                
                                if(anArray[xFinal][yFinal].getStrength()==0) {			// checking strength if 0 it  will die
                              	  anArray[xFinal][yFinal]=null;							// disappear
                              	  
                              	  
                                }
                                
                                
   								
   								
   							}
   							else if(dieChange==1)										// if crocodile is alive 
   								bearCount--;											//bear dead and it's count decrease
   								anArray[x][y] = null;									//and bear's space become null
   							    
   								
   							
   							
   						}
   						else if (anArray[x][y].getClass().getName().equals ("Crocodile") == true && anArray[xFinal][yFinal].getClass().getName().equals ("Bear")==true ) { //subcase 6
   							
   							int dieChange=random.nextInt(2);// 0 and 1  for 0 bear is alive , for 1 crocodile is alive
   							
   							if (dieChange==1) {											// crocodile is alive
   								
   								bearCount--;											//bear dead and it's count decrease
   								anArray[xFinal][yFinal] = null;							//and bear's space become null
   								
   								anArray[xFinal][yFinal]=anArray[x][y];					//crocodile moved bear's empty place
                                anArray[x][y]=null;  									//crocodile's previous place is empty right now
                                anArray[xFinal][yFinal].anMove();						//movement attributes increase by one and it lose energy if movement variable 15
                                if(anArray[xFinal][yFinal].getStrength()==0) {			// checking strength if 0 it  will die
                                	  anArray[xFinal][yFinal]=null;						//if its power became 0 after movement it will be disappear
                                	  
                                	  
                                  }
   								
   							}
   							else
   								croCount--;												//bear is alive but no any movement and crocodile count ddecrease by 1
   								anArray[x][y] = null;									//crocodile's space came null
   								
   								
   								
   							
   							
   						}
   						
   						
   						

                        
   					}
   					
   				}
   				
   			 }
   		 }
   	 }
   	
   }
	

	
}

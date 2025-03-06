import java.security.SecureRandom;

public   class Animal  {
	private int movement = 0;
	private int strength;
	private SecureRandom random = new SecureRandom();
	
	
	
	 public Animal(){
	        this.strength = random.nextInt(5);
	        
	    }
	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
		
	}

	public void eatingFish() {
		
	}
	
	public void anMove() {
		
	}

	public String  getGender() {
		return null;
	}
		
	
		

	public int getStrength() {
		return strength;
	}

	@Override
	public String toString() {
		return "Animal [getGender()=" + getGender() + "]";
	}




	public void setStrength(int str) {
		
	}
	
		
	

}

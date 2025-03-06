import java.security.SecureRandom;

public class Crocodile extends Animal{
	private int movement=0;
	protected int  strength=0;
	protected String gender=null;
	private SecureRandom random = new SecureRandom();
	
	

	public Crocodile( ) {
		
		this.setStrength(strength);
		this.setGender(gender);
		
	}

	
	
	@Override
	public void eatingFish() {
		this.setStrength(2);
	}
	
	

	@Override
	public void anMove() {
		
		if(this.movement==15){
            this.movement=0;
            this.strength--;
          
        }
        else{
            this.movement++;
        }
	}



	public void setStrength(int strength) {
		
		if (strength==0) {
			
			this.strength= random.nextInt(11)+5;
			
		}
		
	}
	public void setGender(String gender) {
		int gend;
		if (gender==null) {
			
			gend =random.nextInt(2);
			
			if(gend==0) {
				
				this.gender="Female";
				
				}
			
			else {
				this.gender="Male";
				
			}
		}
	}
	public String getGender() {
		return gender;
	}
	public int getStrength() {
		return strength;
	}



	@Override
	public String toString() {
		return "Crocodile [strength=" + strength + ", gender=" + gender +  "]";
	}



}

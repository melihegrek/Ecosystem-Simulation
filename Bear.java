import java.security.SecureRandom;

public class Bear extends Animal{
	
	private int movement = 0;
	private SecureRandom random = new SecureRandom();
	protected int  strength=0;
	protected String gender=null; 
	
	

	

	public Bear() {
		this.setStrength(strength);
		this.setGender(gender);
		
	}
	
	@Override
	public void eatingFish() {
		
		this.setStrength(3);
		
	}
	
	
	@Override
	public void anMove() {
		
		if(this.movement==10){
            this.movement=0;
            this.strength--;
        }
        else{
            this.movement++;
        }
	}

	public void setStrength(int str) {
		
		if (this.strength==0) {
			
			this.strength= random.nextInt(11)+10;
			
		}
		else
			this.strength=this.strength+str;
		
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
	public int getStrength() {
		
		return strength;
	}
	public String getGender() {
		return gender;
	}
	

	@Override
	public String toString() {
		return "Bear [ strength=" + strength + ", gender=" + gender + "]";
	}


	


}

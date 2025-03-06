import java.security.SecureRandom;

public class Fish extends Animal{
	protected int  strength=0;
	protected String gender=null;
	private SecureRandom random = new SecureRandom();
	
	

	public Fish( ) {
		this.setStrength(strength);
		this.setGender(gender);
		
	}



	public void setStrength(int strength) {
		
		if (this.strength==0) {
			
			this.strength= random.nextInt(10)+30;
			
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
		return "Fish [strength=" + strength + ", gender=" + gender +  "]";
	}


}

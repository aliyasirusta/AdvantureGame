import java.util.Random;

public class Obstacle {
	private String name;
	private int damage,award,healty,maxNumber;
	public Obstacle(String name, int damage,  int healty,int award, int maxNumber) {		
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.healty = healty;
		this.maxNumber = maxNumber;
	}	
	public int count() {
		Random r = new Random();
		return r.nextInt(this.maxNumber)+1;
		}	
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
	public int getHealty() {
		return healty;
	}
	public void setHealty(int healty) {
		this.healty = healty;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	
	

	
}


public abstract class BattleLoc extends Location{
	protected Obstacle obstacle;
	protected String award;
	BattleLoc(Player player,String name,Obstacle obstacle,String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
		
	}
	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println();
		System.out.println("You are here now: " + this.getName());
		System.out.println("Be careful! "+ obsCount + " "+ obstacle.getName()+ " live here.");
		System.out.println("\n");
		System.out.print("<A> ATTACK OR <S> STAND BACK ");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if(selCase.equals("A")) {
			if(combat(obsCount)) {
				System.out.println("You have cleared all enemies in the "+this.getName()+" location!");
				if(this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award+" you won. Congratulations.");
					player.getInv().setFood(true);
				}
				else if(this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award+" you won. Congratulations.");
					player.getInv().setWater(true);
				}
				else if(this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award+" you won. Congratulations.");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			
			if(player.getHealty() <=0) {
				System.out.println(" YOU DIE ");
				return false;
			}
		}
		
		
		return true;
	}
	public boolean combat(int obsCount) {
		for(int i=0; i<obsCount; i++) {
			int defObsHelth=obstacle.getHealty();
			playerStats();
			enemyStats();
			while(player.getHealty()>0 && obstacle.getHealty()>0) {
				System.out.print("<H> HİT OR <S> STAND BACK ");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if(selCase.equals("H")) {
					System.out.println("\n");
					System.out.println("YOU HIT! ");
					obstacle.setHealty(obstacle.getHealty()-player.getTotalDamage());
					afterHit();
					if(obstacle.getHealty() > 0) {						
						System.out.println("THE MONSTER HIT YOU! ");
						player.setHealty(player.getHealty()-(obstacle.getDamage()-player.getInv().getArmor()));
						afterHit();
					}					
				}
				else {
					return false;
				}			
			}
			if(obstacle.getHealty() < player.getHealty()) {
				System.out.println("YOU KILLED THE ENEMY! ");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("Your current money: "+ player.getMoney());
				obstacle.setHealty(defObsHelth);
			}else {
				return false;
			}			
		}
		return true;
	}
	public void playerStats() {
		System.out.println("\n");
		System.out.println("Player values: \n---------------");
		System.out.println("Health: "+ player.getHealty());
		System.out.println("Damage: "+ player.getTotalDamage());
		System.out.println("Money: "+ player.getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Weapon: "+player.getInv().getwName());
		}
		if(player.getInv().getArmor()>0) {
			System.out.println("Armor: "+player.getInv().getaName());
		}
	}
	public void enemyStats( ) {
		System.out.println("\n"+obstacle.getName()+" values:\n---------------");
		System.out.println("Health: "+obstacle.getHealty());
		System.out.println("Damage: "+obstacle.getDamage());
		System.out.println("Prize: "+obstacle.getAward());
		System.out.println("\n");
	}
	
	public void afterHit() {
		System.out.println("Player health: "+player.getHealty());
		System.out.println(obstacle.getName()+" Monster health: "+ obstacle.getHealty());
		System.out.println("");
	}
}

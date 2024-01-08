
public class SafeHouse extends NormalLoc {

	SafeHouse(Player player ) {
		super(player, "Safe House");
		
	}
	public boolean getLocation() {
		player.setHealty(player.getrHealthy());
		System.out.println("Your health has improved...");
		System.out.println("You are now in the safe house.");
		return true;
	}

}

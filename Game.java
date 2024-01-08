import java.util.Scanner;

public class Game {	
		Player player;
		Location location;
		Scanner scan = new Scanner(System.in);	
		
		public void login() {
			Scanner scan= new Scanner(System.in);
			System.out.println("WELCOME TO ADVENTURE GAME");
			System.out.print("Enter your name before starting the game: ");
			String playerName = scan.nextLine();
			player = new Player(playerName);
			player.selectCha();
			start();
		}
		
		public void start(){
			while(true) {
				System.out.println();
				System.out.println("*********************************************");
				System.out.println();
				System.out.println("LOCATIONS");
				System.out.println("1. Safe House ---> A safe place for you, no enemies!");
				System.out.println("2. Cave ---> You may encounter zombies!");
				System.out.println("3. Forest ---> You may encounter vampires!");
				System.out.println("4. River ---> You may come across a bear!");
				System.out.println("5. Shop ---> You can buy Weapons or Armor!");				
				int selLoc;
	            do {
	                System.out.print("Select the location you want to go to (1-5): ");
	                while (!scan.hasNextInt()) {
	                    System.out.println("Please enter a valid number!");
	                    scan.next(); 
	                }
	                selLoc = scan.nextInt();
	            } while (selLoc < 1 || selLoc > 5);

				switch (selLoc) {
				case 1: 
					location = new SafeHouse(player); 	
					break;
				case 2:
					location = new Cave(player);
					break;
				case 3:
					location = new Forest(player);
					break;
				case 4:
					location = new River(player);
					break;
				case 5:
					location = new ToolStore(player);
					break;
				default:
					location = new SafeHouse(player);
				}
				if(location.getClass().getName().equals("SafeHouse")) {
					if(player.getInv().isFirewood() && player.getInv().isWater() && player.getInv().isFood()) {
						System.out.println(player.getName()+" CONGRATULATIONS! YOU WON THE GAME ");
						break;
					}
				}
				if(!location.getLocation()) {
				System.out.println(" GAME OVER");
				break;
			}
			
		}
		}
		
		public Player getPlayer() {
			return player;
		}
		
		public void setPlayer(Player player) {
			this.player = player;
		}
		
	

}

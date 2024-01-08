
public class ToolStore extends NormalLoc {
	 
	ToolStore(Player player) {
		super(player, "Shop");
		
	}
	public  boolean getLocation() {
		System.out.println("Money: " + player.getMoney());
		System.out.println("1. Weaponry");
		System.out.println("2. Armors");
		System.out.println("3. Exit");
		System.out.println("Your choice: ");
		int selTool = scan.nextInt();
		int selItemID;
		switch(selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
			default:
				break;
		}
		return true;
	}
	
	public int armorMenu() {
		System.out.println("1. Light \t <Money : 15 - Damage : 1>");
		System.out.println("2. Middle \t <Money : 25 - Damage : 3>");
		System.out.println("3. Heavy \t <Money : 40 - Damage : 5>");
		System.out.println("4. Exit");
		System.out.println("Please choose armor: ");
		int selArmorID = scan.nextInt();
		return selArmorID;
		
	}
	
	public void buyArmor(int itemID ) {
		int avoid=0,price=0;
		String aName = null;
		switch(itemID) {
		case 1:
			avoid = 1;
			aName = "Light armor";
			price = 15;
			break;
		case 2:
			avoid = 3;
			aName = "Middle armor";
			price = 25;
			break;
		case 3:
			avoid = 5;
			aName = "Heavy armor";
			price = 40;
			break;
		case 4:
			System.out.println("Checking out...");
		default:
			System.out.println("Invalid transaction");
			break;
	 }
		if(price >0) {
			
			if(player.getMoney()>= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney()- price);
				System.out.println(aName+" you bought it, damage blocked: "+ player.getInv().getArmor());
				System.out.println("Remaining money: "+ player.getMoney());
				}
				else {
					System.out.println("Not enough money!");
				}
		}
	}
	public int weaponMenu() {
		System.out.println("1. Gun\t   <Money : 25 - Damage : 2>");
		System.out.println("2. Sword\t <Money : 35 - Damage : 3>");
		System.out.println("3. Rifle\t <Money : 45 - Damage : 7>");
		System.out.println("4. Exit");
		System.out.println("Please select weapon: ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}
	public void buyWeapon(int itemID) {
		int damage=0,price=0;
		String wName = null;
		switch(itemID) {
		case 1:
			damage =2;
			wName = "Gun";
			price = 25;
			break;
		case 2:
			damage =3;
			wName = "Sword";
			price = 35;
			break;
		case 3:
			damage =7;
			wName = "Rifle";
			price = 45;
			break;
		case 4:
			System.out.println("Checking out...");
		default:
			System.out.println("Invalid transaction!");
			break;
	 }
		if(price >0) {
			
			if(player.getMoney()> price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney()- price);
				System.out.println(wName+" you bought it. Previous damage: "+ player.getDamage() + ", New damage: "
				+ player.getTotalDamage());
				System.out.println("Remaining money: "+ player.getMoney());
				}
				else {
					System.out.println("Not enough money!");
				}		
    	}
	}
}

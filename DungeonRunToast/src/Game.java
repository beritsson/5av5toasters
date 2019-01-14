import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
//import java.io.IOException;
import java.util.Scanner;


public class Game {
	int mapSize;
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) { 
		
		Game game = new Game();
	
		while (true) {
			menulogo();
			System.out.println(
							  "     											                \n"	
					        + "     											                \n"	
							+ "					 		  	╔══════════════════════════════════╗\n"
							+ "							  	║              GAME MENU           ║\n"
							+ "							  	╚══════════════════════════════════╝\n"
							+ "							  	╔══════════════════════════════════╗\n"
							+ "							  	║                                  ║\n"
							+ "							  	║             [N]ew Game           ║\n"
							+ "							  	║                                  ║\n"
							+ "							  	║             [L]oad Game          ║\n"
							+ "							  	║                                  ║\n"
							+ "							  	║              [E]xit              ║\n"
							+ "							  	║                                  ║\n"
							+ "							  	╚══════════════════════════════════╝\n"

					);

			String choice =input.next();

			if (choice.equalsIgnoreCase("N")) { // START GAME
				System.out.println("NEW GAME");
				game.newgamemenu(input);
				
			} else if (choice.equalsIgnoreCase("L")) { // LOAD GAME
				game.loadmenu();
				
			} else if (choice.equalsIgnoreCase("E")) { // EXIT
				System.out.println("Have a nice day!");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {}
				System.out.println("\tBye....");
				//say "Bye..." again ?
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {}
				System.out.println("\t\tBye....");
				System.exit(0);
//			} else if (choice.equalsIgnoreCase("A")) {
			} else {
				System.out.println("Invalid choice, returning to Menu...\n");				
			}


			
		}
		
	}
	
	public void loadmenu() {
		while (true)  {
		System.out.println(
				  "     											     \n"			
				+ "					 		  	╔══════════════════════════════════╗\n"
				+ "							  	║         PLEASE ENTER NAME        ║\n"
				+ "							  	╚══════════════════════════════════╝\n"

		);
		
		
		String pname = input.next();
		 
		if (pname.equalsIgnoreCase("PLAYERS")) { //----------------------------------------------------INSERT CHECK IF PLAYER NAME EXIST 
			System.out.println("You're load has been found");
			//Start game EASY MAP
			break;
			
		} else  { // MEDIUM
			System.out.println("Error not found");
				}
		}
	}

public static void menulogo() {
	System.out.println("\n\n\n\n");

	int width = 150;
	int height = 30;

	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	g.setFont(new Font("SansSerif", Font.PLAIN, 17));

	Graphics2D graphics = (Graphics2D) g;
	graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	graphics.drawString("Toast Adventure", 15, 20);

	for (int y = 0; y < height; y++) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < width; x++) {

			sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

		}

		if (sb.toString().trim().isEmpty()) {
			continue;
		}

		System.out.println(sb);
	}
}

public void newgamemenu(Scanner scanner) {

	System.out.println(
			  "     											     \n"			
			+ "					 		  	╔══════════════════════════════════╗\n"
			+ "							  	║         PLEASE ENTER NAME        ║\n"
			+ "							  	╚══════════════════════════════════╝\n"

	);
	String pname =input.next();
	
	while (true)  {
		System.out.println(
				  "                                                                                                                   \n"			
	+ "                                                                ╔════════════════════════════════════╗                                      \n"
	+ "                                                                ║         CHOOSE A CHARACTER         ║                                      \n"
	+ "                                                                ╚════════════════════════════════════╝                                      \n"
	+ "                          ╔════════════════════════════════════╗╔════════════════════════════════════╗╔════════════════════════════════════╗\n"
	+ "                          ║             [K]night               ║║              [W]izard              ║║               [T]hife              ║\n"
	+ "                          ║                                    ║║                                    ║║                                    ║\n"
	+ "                          ║   Special abillites: Shieldblock   ║║   Special abillites: Light Rail    ║║   Special abillites: Critical Hit  ║\n"
	+ "                          ║                                    ║║                                    ║║                                    ║\n"
	+ "                          ║           Initiative: 5            ║║           Initiative: 6            ║║           Initiative: 7            ║\n"
	+ "                          ║           Health: 9                ║║           Health: 4                ║║           Health: 5                ║\n"
	+ "                          ║           Attack: 6                ║║           Attack: 9                ║║           Attack: 5                ║\n"
	+ "                          ║           Flexibility: 4           ║║           Flexibility: 5           ║║           Flexibility: 7           ║\n"
	+ "                          ║                                    ║║                                    ║║                                    ║\n"
	+ "                          ║                                    ║║                                    ║║                                    ║\n"
	+ "                          ╚════════════════════════════════════╝╚════════════════════════════════════╝╚════════════════════════════════════╝\n"
	
		);
		String character =input.next();
		
		if (character.equalsIgnoreCase("K")) { // KNIGHT
			Knight knight = new Knight(pname);
			knight.characterAttribute();
			break;
	
			
		} else if (character.equalsIgnoreCase("W")) { // WIZARD
			Wizard wizard = new Wizard(pname);
			wizard.characterAttribute();
			break;
	
			
		} else if (character.equalsIgnoreCase("T")) { // THIEF
			Thief thief = new Thief(pname);
			thief.characterAttribute();
			break;
			
			
		} else {
			System.out.println("Invalid choice, try again...\n");	
		}
		
	}
	Map map = new Map(mapmenu());
	menu(scanner, map);
	gameLoop(scanner, map);
	
	
}


	
	public int mapmenu(){
		while (true)  {
			System.out.println(
					  "     											     \n"			
								+ "					 		  	╔═════════════════════════════════════╗\n"
								+ "							  	║       Choose youre diffuculity      ║\n"
								+ "							  	╚═════════════════════════════════════╝\n"
								+ "					 		  	╔═══════════╗╔═══════════╗╔═══════════╗\n"
								+ "							  	║   [E]asy  ║║ [M]edium  ║║  [H]ard   ║\n"
								+ "							  	║  Map 4x4  ║║  Map 5x5  ║║  Map 8x8  ║\n"
								+ "							  	╚═══════════╝╚═══════════╝╚═══════════╝\n"
	
			);
			
			String diffuculity =input.next();
			
			if (diffuculity.equalsIgnoreCase("E")) { // EASY
				System.out.println("You have choosen EASY");
				return 4;
				
				
				
			} else if (diffuculity.equalsIgnoreCase("M")) { // MEDIUM
				System.out.println("You have choosen MEDIUM");
				return 5;
				
				
				
			} else if (diffuculity.equalsIgnoreCase("H")) { // HARD
				System.out.println("You have choosen HARD");
				return 8;
				
				
			} else {
				System.out.println("Invalid choice, try again...\n");	
			}
		
		}
		
		
	}
	public void menu(Scanner scanner, Map map) {
		

		boolean menuing = true;
		while(menuing) {;
			System.out.println("Which corner would you like to start in?");
			System.out.println("[L]eft upper corner \n"
					+ "[R]ight upper corner \n" + "[LB] left bottom corner\n" + "[RB]Right bottom corner");
			String menuchoice = scanner.nextLine().toLowerCase();
			
			
			switch (menuchoice) {
			case "l":
			System.out.println("Start position left upper corner");
			map.setPlayerlocation(map.getNw());
				menuing = false;
				break;
			case "r":
				System.out.println("Start position right upper corner");
				map.setPlayerlocation(map.getNe());
				menuing = false;
				break;
			case "lb":
				System.out.println("Start position left bottom corner");
				map.setPlayerlocation(map.getSe());
				menuing = false;
				break;
			case "rb":
				System.out.println("Start position right bottom corner");
				map.setPlayerlocation(map.getSw());
				menuing = false;
				break;
			}
				continue;
		}
	}
	
	public void gameLoop(Scanner scanner, Map map) {
		String command = "";
		while(true) {
			if(!command.equals("map") || !command.equals("i")) {
			map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].monsterinroom();
			map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].tresureinroom();
			}
			System.out.println("Where do you want to go? South, East, North, West, Map");
			command =scanner.nextLine().toLowerCase();
			
			switch(command) {
			 
			
			case "south":
			map.goSouth();
			break;
			case "east":
			map.goEast();
			break;
			case "west":
			map.goWest();
			break;
			case "north":
			map.goNorth();
			break;
			case "map":
			map.drawMap();
			break;
			default:
				System.out.println("I didnt quite get that");
				command = "i";
			}

		}
	}

}

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;


public class Game {
	

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) { 
		Game game = new Game();
		
		//game.Maps(5); exempel på att tillkala mapparna
	
		while (true) {
			menulogo();
			System.out.println(
							  "     											                \n"	
					        + "     											                \n"	
							+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
							+ "							  	â•‘              GAME MENU           â•‘\n"
							+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"
							+ "							  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
							+ "							  	â•‘                                  â•‘\n"
							+ "							  	â•‘             [N]ew Game           â•‘\n"
							+ "							  	â•‘                                  â•‘\n"
							+ "							  	â•‘             [L]oad Game          â•‘\n"
							+ "							  	â•‘                                  â•‘\n"
							+ "							  	â•‘              [E]xit              â•‘\n"
							+ "							  	â•‘                                  â•‘\n"
							+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

					);
			Scanner scanner = new Scanner(System.in);
			String choice =scanner.next();

			if (choice.equalsIgnoreCase("N")) { // START GAME
				System.out.println("NEW GAME");
				newgamemenu();
				
			} else if (choice.equalsIgnoreCase("L")) { // LOAD GAME
				loadmenu();
				
			} else if (choice.equalsIgnoreCase("E")) { // EXIT
				System.out.println("Have a nice day!");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					System.out.printf("Somthing went wrong:(", e);
					e.printStackTrace();
				}
				System.out.println("\tBye....");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					System.out.printf("Somthing went wrong:(", e);
					e.printStackTrace();
				}
				System.out.println("\t\tBye....");
				System.exit(0);
			} else if (choice.equalsIgnoreCase("A")) {
			} else if (!choice.equalsIgnoreCase("A") && !choice.equalsIgnoreCase("S")
					&& !choice.equalsIgnoreCase("C")) {
				System.out.println("Invalid choice, returning to Menu...\n");
				
			}


			
		}
		
	}
	
	public static void loadmenu() {
		
		System.out.println(
				  "     											     \n"			
				+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
				+ "							  	â•‘         PLEASE ENTER NAME        â•‘\n"
				+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

		);
		
		Scanner inputPName = new Scanner(System.in);
		String pname =inputPName.next();
		 
		if (pname.equalsIgnoreCase("PLAYERS USERNAME FOUND")) { //----------------------------------------------------INSERT CHECK IF PLAYER NAME EXIST 
			System.out.println("You're load has been found");
			//Start game EASY MAP
			
		} else  { // MEDIUM
			System.out.println("Error not found");
			return;

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

public static void newgamemenu() {
	
	System.out.println(
			  "     											     \n"			
			+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
			+ "							  	â•‘         PLEASE ENTER NAME        â•‘\n"
			+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

	);
	Scanner inputPName = new Scanner(System.in);
	String pname =inputPName.next();
	
	
	System.out.println(
			  "                                                                                                                   \n"			
+ "                                                                â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—                                      \n"
+ "                                                                â•‘         CHOOSE A CHARACTER         â•‘                                      \n"
+ "                                                                â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�                                      \n"
+ "                          â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
+ "                          â•‘             [K]night               â•‘â•‘              [W]izard              â•‘â•‘               [T]hife              â•‘\n"
+ "                          â•‘                                    â•‘â•‘                                    â•‘â•‘                                    â•‘\n"
+ "                          â•‘   Special abillites: Shieldblock   â•‘â•‘   Special abillites: Light Rail    â•‘â•‘   Special abillites: Critical Hit  â•‘\n"
+ "                          â•‘                                    â•‘â•‘                                    â•‘â•‘                                    â•‘\n"
+ "                          â•‘           Initiative: 5            â•‘â•‘           Initiative: 6            â•‘â•‘           Initiative: 7            â•‘\n"
+ "                          â•‘           Health: 9                â•‘â•‘           Health: 4                â•‘â•‘           Health: 5                â•‘\n"
+ "                          â•‘           Attack: 6                â•‘â•‘           Attack: 9                â•‘â•‘           Attack: 5                â•‘\n"
+ "                          â•‘           Flexibility: 4           â•‘â•‘           Flexibility: 5           â•‘â•‘           Flexibility: 7           â•‘\n"
+ "                          â•‘                                    â•‘â•‘                                    â•‘â•‘                                    â•‘\n"
+ "                          â•‘                                    â•‘â•‘                                    â•‘â•‘                                    â•‘\n"
+ "                          â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

	);
	Scanner inputcharacter = new Scanner(System.in);
	String character =inputcharacter.next();
	
	if (character.equalsIgnoreCase("K")) { // KNIGHT
		System.out.println("You have choosen the Knight");

		
	} else if (character.equalsIgnoreCase("W")) { // WIZARD
		System.out.println("You have choosen the Wizard");

		
	} else if (character.equalsIgnoreCase("T")) { // THIEF
		System.out.println("You have choosen the Thife");
	}
	mapmenu();
}


	
	static void mapmenu(){
		
		System.out.println(
				  "     											     \n"			
							+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
							+ "							  	â•‘       Choose you're diffuculity     â•‘\n"
							+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"
							+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
							+ "							  	â•‘   [E]asy  â•‘â•‘ [M]edium  â•‘â•‘  [H]ard   â•‘\n"
							+ "							  	â•‘  Map 4x4  â•‘â•‘  Map 5x5  â•‘â•‘  Map 8x8  â•‘\n"
							+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

		);
		
		Scanner inputdiff = new Scanner(System.in);
		String diffuculity =inputdiff.next();
		
		if (diffuculity.equalsIgnoreCase("E")) { // EASY
			System.out.println("You have choosen EASY");

			//Start game EASY MAP
		
			
			
			
		} else if (diffuculity.equalsIgnoreCase("M")) { // MEDIUM
			System.out.println("You have choosen MEDIUM");

			//Start game MEDIUM MAP
			
		} else if (diffuculity.equalsIgnoreCase("H")) { // HARD
			System.out.println("You have choosen HARD");
			//Start game HARD MAP
		}
		
		
		
	}

	
	public Room[][] Maps(int x){
		Room map[][] = new Room[x][x];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				map[i][j] = new Room(); 
				map[i][j].setPosition(i, j);
				map[i][j].showPosition();
				map[i][j].monster();
				map[i][j].tresure();
			}
		}
		return map;
	}

	

		

}

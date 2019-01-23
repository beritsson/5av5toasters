import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
//import java.io.IOException;
import java.util.Scanner;


public class Game {
	int mapSize;

	public Character c;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) { 

		Game game = new Game();

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

			String choice =input.next();

			if (choice.equalsIgnoreCase("N")) { // START GAME
				System.out.println("NEW GAME");
				game.newgamemenu();

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
							+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
							+ "							  	â•‘            [L]oad Save           â•‘\n"
							+ "							  	â•‘                                  â•‘\n"
							+ "							  	â•‘           [C]omputer AI          â•‘\n"
							+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

					);


			String loadchoose = input.next();

			if (loadchoose.equalsIgnoreCase("L")) { // Load menu
				loadname();
				break;


			} else if (loadchoose.equalsIgnoreCase("C")) { // Load Computer AI

				break;


			} else {
				System.out.println("Invalid choice, try again...\n");	
			}
		}
	}

	public void loadname() {
while(true) {
		System.out.println(
				"     											     \n"			
						+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
						+ "							  	â•‘         PLEASE ENTER NAME        â•‘\n"
						+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

				);

		String pname = input.next();
		
		if(IoSystem.CheckSave(pname)) {
			 try {
				c = IoSystem.LoadChar(pname);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Map map = new Map(mapmenu());
			menu(map);
			gameLoop(map);
			break;
		}else if(pname.equals("exit")) {
			
			System.out.println("Exiting to menu");
			break;
		}else {
			System.out.println("File not found");
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
	
	
	public String chooseName() {
		System.out.println(
				"     											     \n"			
						+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
						+ "							  	â•‘         PLEASE ENTER NAME        â•‘\n"
						+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

				);
		String pname =input.next();
		return pname;
	}

	
	public void newgamemenu() {
		String pname = chooseName();
		while (true)  {
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
			String character =input.next();

			if (character.equalsIgnoreCase("K")) { // KNIGHT
				c = new Knight(pname);
				c.characterAttribute();
				try {
					IoSystem.save(c);
				} catch (IOException e) {
					System.out.println("Auto saving faild");
				}
				break;


			} else if (character.equalsIgnoreCase("W")) { // WIZARD
				c = new Wizard(pname);
				c.characterAttribute();
				try {
					IoSystem.save(c);
				} catch (IOException e) {
					System.out.println("Auto saving faild");
				}
				break;


			} else if (character.equalsIgnoreCase("T")) { // THIEF
				c = new Thief(pname);
				c.characterAttribute();
				try {
					IoSystem.save(c);
				} catch (IOException e) {
					System.out.println("Auto saving faild");
				}
				break;


			} else {
				System.out.println("Invalid choice, try again...\n");	
			}

		}
		Map map = new Map(mapmenu());
		menu(map);
		gameLoop(map);


	}



	public int mapmenu(){
		while (true)  {
			System.out.println(
					"     											     \n"			
							+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
							+ "							  	â•‘       Choose youre diffuculity      â•‘\n"
							+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"
							+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
							+ "							  	â•‘   [E]asy  â•‘â•‘ [M]edium  â•‘â•‘  [H]ard   â•‘\n"
							+ "							  	â•‘  Map 4x4  â•‘â•‘  Map 5x5  â•‘â•‘  Map 8x8  â•‘\n"
							+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"

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



	public static void EndMenu() {

		System.out.println(
				"     											     \n"			
						+ "					 		  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
						+ "							  	â•‘             GAME OVER            â•‘\n"
						+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"
						+ "                                                                 \n"
						+ "                                                                     You're score is:" + " SCORE INT \n"
						+ "                                                                 \n"
				);

		System.out.println(							
				"							  	â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—\n"
						+ "							  	â•‘                                  â•‘\n"
						+ "							  	â•‘              [M]enu              â•‘\n"
						+ "							  	â•‘                                  â•‘\n"
						+ "							  	â•‘              [E]xit              â•‘\n"
						+ "							  	â•‘                                  â•‘\n"
						+ "							  	â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�\n"
				);
		Scanner input2 = new Scanner(System.in);

		String endchoice =input2.next();

		if (endchoice.equalsIgnoreCase("M")) { // START GAME
			System.out.println("Returning to Menu...");
		} 

		else if (endchoice.equalsIgnoreCase("E")) { // EXIT
			System.out.println("Have a nice day!");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}
			System.out.println("\tBye....");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}
			System.out.println("\t\tBye....");
			System.exit(0);
		} else {
			System.out.println("Invalid choice, returning to Menu...\n");				
		}

	}


	public void menu(Map map) {


		boolean menuing = true;
		while(menuing) {

			System.out.println("Which corner would you like to start in?");
			System.out.println("[L]eft upper corner \n"
					+ "[R]ight upper corner \n" + "[LB] left bottom corner\n" + "[RB]Right bottom corner");
			String menuchoice = input.next().toLowerCase();

			switch (menuchoice) {
			case "l":
				System.out.println("Start position left upper corner");
				map.setPlayerlocation(map.getNw());
				int i = map.playerlocation[0];
				int j = map.playerlocation[1];
				map.visitedRooms[i][j] = true;
				menuing = false;
				break;
			case "r":
				System.out.println("Start position right upper corner");
				map.setPlayerlocation(map.getNe());
				int ii = map.playerlocation[0];
				int jj = map.playerlocation[1];
				map.visitedRooms[ii][jj] = true;
				menuing = false;
				break;
			case "lb":
				System.out.println("Start position left bottom corner");
				map.setPlayerlocation(map.getSe());
				int iii = map.playerlocation[0];
				int jjj = map.playerlocation[1];
				map.visitedRooms[iii][jjj] = true;
				menuing = false;
				break;
			case "rb":
				System.out.println("Start position right bottom corner");
				map.setPlayerlocation(map.getSw());
				menuing = false;
				int iiii = map.playerlocation[0];
				int jjjj = map.playerlocation[1];
				map.visitedRooms[iiii][jjjj] = true;
				break;
			}
			continue;
		}
	}

	public void gameLoop(Map map) {
		String command = "";
		while(true) {
			if(!command.equals("map") || !command.equals("i")) {
				map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].monsterinroom(c);
				map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].getTreasure(c);		

				System.out.println("Where do you want to go? South, East, North, West, Map, Save, Score");
				command =input.nextLine().toLowerCase();

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
				case "save":
					try {
						IoSystem.save(c);
						System.out.println("You saved the game");
					} catch (IOException e) {
						System.out.println("Saving faild");
					
					}
					break;
				case "score":
					System.out.println("You have a score of " + c.getTreasurePoint() );
				default:
					System.out.println("I didnt quite get that");
					command = "i";
				}

			}
		}

	}
}

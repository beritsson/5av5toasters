import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
							+ "					 		  	╔══════════════════════════════════╗\n"
							+ "							  	║              GAME MENU           ║\n"
							+ "							  	╚══════════════════════════════════╝\n"
							+ "							  	╔══════════════════════════════════╗\n"
							+ "							  	║                                  ║\n"
							+ "							  	║             [N]ew Game           ║\n"
							+ "							  	║                                  ║\n"
							+ "							  	║             [L]oad Game          ║\n"
							+ "							  	║                                  ║\n"
							+ "							  	║              [A]I Game           ║\n"
							+ "							  	║                                  ║\n"
							+ "							  	║               [E]xit             ║\n"
							+ "							  	║                                  ║\n"
							+ "							  	╚══════════════════════════════════╝\n"

					);

			String choice =input.next();

			if (choice.equalsIgnoreCase("N")) { // START GAME
				System.out.println("NEW GAME");
				game.newgamemenu();

			} else if (choice.equalsIgnoreCase("L")) { // LOAD GAME
				game.loadname();

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
			} else if (choice.equalsIgnoreCase("A")) {
				game.AIgamemenu();
			} else {
				System.out.println("Invalid choice, returning to Menu...\n");				
			}



		}

	}



	public void loadname() {
		while(true) {
			System.out.println(
					"     											     \n"			
							+ "					 		  	╔══════════════════════════════════╗\n"
							+ "							  	║         PLEASE ENTER NAME        ║\n"
							+ "							  	╚══════════════════════════════════╝\n"
	
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
				EndMenu();
				return;
				
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
						+ "					 		  	╔══════════════════════════════════╗\n"
						+ "							  	║         PLEASE ENTER NAME        ║\n"
						+ "							  	╚══════════════════════════════════╝\n"

				);
		String pname =input.next();
		return pname;
	}

	
	public void chooseCharacter(String pname) {
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
	}
	
	
	public void newgamemenu() {
		String pname = chooseName();
		chooseCharacter(pname);			
		Map map = new Map(mapmenu());
		menu(map);
		gameLoop(map);
		EndMenu();
	}

	public void AIgamemenu() {
		chooseCharacter("AI");	
		Map map = new Map(mapmenu());
		AI ai = new AI(map);
		ai.go();
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
				System.out.println(
						"     											     \n"			
								+ "					 		  	╔════════════════════════════════════╗\n"
								+ "							  	║        You have choosen EASY       ║\n"
								+ "							  	╚════════════════════════════════════╝\n"
									);
				return 4;



			} else if (diffuculity.equalsIgnoreCase("M")) { // MEDIUM
				System.out.println(
						"     											     \n"			
								+ "					 		  	╔════════════════════════════════════╗\n"
								+ "							  	║       You have choosen MEDIUM      ║\n"
								+ "							  	╚════════════════════════════════════╝\n"
									);
				return 5;



			} else if (diffuculity.equalsIgnoreCase("H")) { // HARD
				System.out.println(
						"     											     \n"			
								+ "					 		  	╔════════════════════════════════════╗\n"
								+ "							  	║        You have choosen HARD       ║\n"
								+ "							  	╚════════════════════════════════════╝\n"
									);
				return 8;


			} else {
				System.out.println("Invalid choice, try again...\n");	
			}

		}


	}



	public void EndMenu() {

		System.out.println(
				"     											     \n"			
						+ "					 		  	╔══════════════════════════════════╗\n"
						+ "							  	║             GAME OVER            ║\n"
						+ "							  	╚══════════════════════════════════╝\n"
						+ "                                                                 \n"
						+ "                                                                         You're score is: " +c.getTreasurePoint() +" \n"
						+ "                                                                 \n"
				);

		System.out.println(							
				"							  	╔══════════════════════════════════╗\n"
						+ "							  	║                                  ║\n"
						+ "							  	║              [M]enu              ║\n"
						+ "							  	║                                  ║\n"
						+ "							  	║              [E]xit              ║\n"
						+ "							  	║                                  ║\n"
						+ "							  	╚══════════════════════════════════╝\n"
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
			System.out.println(
					"     											     \n"
							+ "                                                                 \n"
							+ "                                                                 \n"
							+ "                                                                 \n"
							+ "                                                                 \n"
							+ "					 		      ╔════════════════════════════════════════╗\n"
							+ "							      ║Which corner would you like to start in?║\n"
							+ "							      ╚════════════════════════════════════════╝\n"
					);
			
			
			System.out.println(
					"     											     \n"			
							+ "					 	╔═══════════════╗╔═══════════════╗╔═══════════════╗╔═══════════════╗\n"
							+ "						║     [L]eft    ║║    [R]ight    ║║   [LB] Left   ║║   [RB] Right  ║\n"
							+ "						║  upper corner ║║  upper corner ║║ bottom corner ║║ bottom corner ║\n"
							+ "						╚═══════════════╝╚═══════════════╝╚═══════════════╝╚═══════════════╝\n"
							);
			
			
			String menuchoice = input.next().toLowerCase();

			switch (menuchoice) {
			case "l":
				System.out.println(
						"     											     \n"			
								+ "					 		  	╔════════════════════════════════════╗\n"
								+ "							  	║  Start position left upper corner  ║\n"
								+ "							  	╚════════════════════════════════════╝\n\n\n"
									);
				map.setPlayerlocation(map.getNw());
				int i = map.playerlocation[0];
				int j = map.playerlocation[1];
				map.visitedRooms[i][j] = true;
				menuing = false;
				break;
			case "r":
				System.out.println(
						"     											     \n"			
								+ "					 		  	╔════════════════════════════════════╗\n"
								+ "							  	║  Start position right upper corner ║\n"
								+ "							  	╚════════════════════════════════════╝\n\n\n"
									);
				map.setPlayerlocation(map.getNe());
				int ii = map.playerlocation[0];
				int jj = map.playerlocation[1];
				map.visitedRooms[ii][jj] = true;
				menuing = false;
				break;
			case "lb":
				System.out.println(
						"     											     \n"			
								+ "					 		  	╔════════════════════════════════════╗\n"
								+ "							  	║  Start position left bottom corner ║\n"
								+ "							  	╚════════════════════════════════════╝\n\n\n"
									);
				map.setPlayerlocation(map.getSe());
				int iii = map.playerlocation[0];
				int jjj = map.playerlocation[1];
				map.visitedRooms[iii][jjj] = true;
				menuing = false;
				break;
			case "rb":
				System.out.println(
						"     											     \n"			
								+ "					 		  	╔════════════════════════════════════╗\n"
								+ "							  	║ Start position right bottom corner ║\n"
								+ "							  	╚════════════════════════════════════╝\n\n\n"
									);
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

				System.out.println("\n\nWhere do you want to go?[S]outh, [E]ast, [N]orth, [W]est, Map, Save, Score, Exit");
				command =input.next().toLowerCase();

				switch(command) {


				case "s":
					map.goSouth();
					break;
				case "e":
					map.goEast();
					break;
				case "w":
					map.goWest();
					break;
				case "n":
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
					break;
				case "exit":
					return;
				
				default:
					System.out.println("I didnt quite get that");
					command = "i";
				}

			}
		}

	}
	
}

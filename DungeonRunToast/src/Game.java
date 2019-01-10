
import java.util.Scanner;

public class Game {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean loggedIn = false;
		
		while(!loggedIn) {
			System.out.println("\tWelcome to Toastmaster Dungeon");
			System.out.println("\t[N]ew Game");
			System.out.println("\t[L]oad game");
			System.out.println("\t[E]xit game");
			System.out.print("\tEnter: ");
			String choice = input.next().toLowerCase();
			
			switch (choice) {
			case "n":
				System.out.print("\tEnter you heros name: ");
				String userName = input.next();
				System.out.println("\tWhat hero do you want to be? \n\t[K]night [W]izard [T]hief");
				System.out.print("\tEnter: ");
				String heroChoice = input.next().toLowerCase();
				switch (heroChoice) {
				case "k":
					Character heroK = new Knight(userName);
					heroK.characterAttribute();
					loggedIn = true;
					break;
				case "w":
					Character heroW = new Wizard(userName);
					heroW.characterAttribute();
					loggedIn = true;
					break;
				case "t":
					Character heroT = new Thief(userName);
					heroT.characterAttribute();
					loggedIn = true;
				default:
					break;
				}
				chooseMap();
				break;
			case "l":
				break;
			case "e":
				System.out.println("\tWelcome back!");
				System.exit(0);
			default:
				System.out.println("\tNot a valid choice, try again");
				break;
			}
		}
		
	}
	
	static void chooseMap(){
		System.out.print("\tChoose your map: \n\t[S]mall [M]edium [B]ig ");
		System.out.print("\tEnter: ");
		String map = input.next().toLowerCase();
		switch (map) {
		case "s":
			Maps(4);
			break;
		case "m":
			Maps(5);
			break;
		case "b":
			Maps(8);
		default:
			break;
		}
	}

	static Room[][] Maps(int x){
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

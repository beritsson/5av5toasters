import java.util.Scanner;

public class Walk {
	Scanner scanner = new Scanner(System.in);
	
	
public Walk() {
	//Default constructor
}

	
	
public void easymenu() {
	Maps(4);
	
	
	
	
	
	boolean menuing = true;
	while(menuing) {;
		System.out.println("Which corner would you like to start in?");
		System.out.println("[L]eft upper corner \n"
				+ "[R]ight upper corner \n" + "[LB] left bottom corner\n" + "[RB]Right bottom corner");
		String menuchoice = scanner.nextLine().toLowerCase();
		
		switch (menuchoice) {
		case "l":
			
		
		System.out.println("Start position left upper corner");
		
		
		
			menuing = true;
			break;
		case "r":
			System.out.println("Start position right upper corner");
			menuing = true;
			break;
		case "lb":
			System.out.println("Start position left bottom corner");
			menuing = true;
			break;
		case "rb":
			System.out.println("Start position right bottom corner");
			menuing = true;
			break;
		}
			continue;
	}
}


public Room[][] Maps(int x){
	Room map[][]   = new Room[x][x];
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < x; j++) {
			map[i][j] = new Room(); 
			map[i][j].setPosition(i, j);
			map[i][j].showPosition();
			map[i][j].monster();
			map[i][j].tresure();
			map[i][j].monsterinroom();
		}
	}
	return map;
}


}

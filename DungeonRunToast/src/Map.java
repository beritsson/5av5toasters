import java.awt.Point;
import java.util.Scanner;

public class Map {
	Scanner scanner = new Scanner(System.in);
	Point playerlocation = new Point();
	Point lastvisited = new Point();
	Point sw = new Point();
	Point se = new Point();
	Point ne = new Point();
	Point nw = new Point();
	Room map[][]   = null;
	
	public Point getLastvisited() {
		return lastvisited;
	}


	public void setLastvisited(Point lastvisited) {
		this.lastvisited = lastvisited;
	}


	public Room[][] getMap() {
		return map;
	}


	public void setMap(Room[][] map) {
		this.map = map;
	}


	public Point getSw() {
		return sw;
	}


	public void setSw(Point sw) {
		this.sw = sw;
	}


	public Point getSe() {
		return se;
	}


	public void setSe(Point se) {
		this.se = se;
	}


	public Point getNe() {
		return ne;
	}


	public void setNe(Point ne) {
		this.ne = ne;
	}


	public Point getNw() {
		return nw;
	}


	public void setNw(Point nw) {
		this.nw = nw;
	}


	public Point getPlayerlocation() {
		return playerlocation;
	}


	public void setPlayerlocation(Point playerlocation) {
		this.playerlocation = playerlocation;
	}

	// Set corner coodinates 
//public Map() {
//	//Default constructor
//	Point sw = new Point();
//	Point se = new Point();
//	Point ne = new Point();
//	Point nw = new Point();
//	
//}

	
	
public void menu() {
	

	boolean menuing = true;
	while(menuing) {;
		System.out.println("Which corner would you like to start in?");
		System.out.println("[L]eft upper corner \n"
				+ "[R]ight upper corner \n" + "[LB] left bottom corner\n" + "[RB]Right bottom corner");
		String menuchoice = scanner.nextLine().toLowerCase();
		
		switch (menuchoice) {
		case "l":
		System.out.println("Start position left upper corner");
		playerlocation = nw;
			menuing = false;
			break;
		case "r":
			System.out.println("Start position right upper corner");
			playerlocation = ne;
			menuing = false;
			break;
		case "lb":
			System.out.println("Start position left bottom corner");
			playerlocation = sw;
			menuing = false;
			break;
		case "rb":
			System.out.println("Start position right bottom corner");
			playerlocation = se;
			System.out.println(getPlayerlocation());
			menuing = false;
			break;
		}
			continue;
	}
}


public Room[][] mapSize(int x){
	
	Room map[][]   = new Room[x][x];
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < x; j++) {
			map[i][j] = new Room(); 
			map[i][j].setPosition(i, j);
			map[i][j].showPosition();
			map[i][j].monster();
			map[i][j].tresure();
			//map[i][j].monsterinroom();
			sw.move(x,0);
			se.move(x, x);
			ne.move(0, x);
			nw.move(0, 0);
			
		}
	}
	return map;
}


}

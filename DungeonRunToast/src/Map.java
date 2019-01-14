import java.awt.Point;
import java.util.Scanner;

public class Map {
	Scanner scanner = new Scanner(System.in);
	int []playerlocation;
	int []lastvisited;
	
	Room map[][]   = null;
	private int []sw = {0,0};
	private int []se = {0,0};
	private int []ne = {0,0};
	private int []nw = {0,0};
	private int Size;
	
	
	public Map() {
		//overload
	}
	public Map(int x) {
		Size = x;
		Room map[][]   = new Room[x][x];
		sw[0]= x;
		se[0] = x;
		se[1] = x;
		ne[1] = x;

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				map[i][j] = new Room(); 
				map[i][j].monsterinroom();
				map[i][j].tresureinroom();
				
			}
		}
	
		
	}
	
	
	
	
	public int[] getLastvisited() {
		return lastvisited;
	}


	public void setLastvisited(int[] lastvisited) {
		this.lastvisited = lastvisited;
	}


	public Room[][] getMap() {
		return map;
	}


	public void setMap(Room[][] map) {
		this.map = map;
	}


	public int[] getSw() {
		return sw;
	}


	public void setSw(int[] sw) {
		this.sw = sw;
	}


	public int[] getSe() {
		return se;
	}


	public void setSe(int[] se) {
		this.se = se;
	}


	public int[] getNe() {
		return ne;
	}


	public void setNe(int[] ne) {
		this.ne = ne;
	}


	public int[] getNw() {
		return nw;
	}


	public void setNw(int[] nw) {
		this.nw = nw;
	}


	public int[] getPlayerlocation() {
		return playerlocation;
	}


	public void setPlayerlocation(int[] playerlocation) {
		this.playerlocation = playerlocation;
	}


	public void goSouth() {
		
		if(Size>this.playerlocation[1]+1 && this.playerlocation[1]+1 >= 0 ) {
			lastvisited=this.playerlocation;
			playerlocation[1]+=1;
			//map[playerlocation[0]][playerlocation[1]].monsterinroom();
			System.out.println("You are now at room: [" + this.playerlocation[0]+ "," + this.playerlocation[1] + "]");

			
		}
		else {
			System.out.println("No path in that direction");
		}
	}

	public void goWest() {
		if(Size >this.playerlocation[0]-1 &&this.playerlocation[0]-1 >= 0 ) {
			lastvisited=this.playerlocation;
			playerlocation[0]-=1;
			System.out.println("You are now at room: [" + this.playerlocation[0]+ "," + this.playerlocation[1] + "]");
		}
		else {
			System.out.println("No path in that direction");
		}
	}
	
	public void drawMap() {
		for (int i = 0; i < Size; i++) {
			for (int j = 0; j < Size; j++) {
				if(playerlocation[0]==j&&playerlocation[1]==i) {
					System.out.print("[O]");
				}
				else {
					System.out.print("[X]");
				}
				
			}
			System.out.println();
		}
	}
	

	public void goEast() {
		if(Size>this.playerlocation[0]+1 &&this.playerlocation[0]+1 >= 0) {
			lastvisited=this.playerlocation;
			playerlocation[0]+=1;
			System.out.println("You are now at room: [" + this.playerlocation[0]+ "," + this.playerlocation[1] + "]");

		}
		else {
			System.out.println("No path in that direction");
		}
	}

	public void goNorth() {
		if(Size>this.playerlocation[1]-1 &&this.playerlocation[1]-1 >= 0 ) {
			lastvisited=this.playerlocation;
			playerlocation[1]-=1;
			System.out.println("You are now at room: [" + this.playerlocation[0]+ "," + this.playerlocation[1] + "]");

		}
		else {
			System.out.println("No path in that direction");
		}
	}
	

//end
}

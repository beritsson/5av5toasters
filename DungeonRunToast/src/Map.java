import java.awt.Point;
import java.util.Scanner;

public class Map {
	Scanner scanner = new Scanner(System.in);
	int []playerlocation;
	int []lastvisited;
	boolean [][] visitedRooms = null;

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
		sw[1]= x-1;
		sw[0]= x-1;
		se[1] = x-1;
		ne[0] = x-1; //

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				map[i][j] = new Room(); 
				
			}
		}
		setMap(map);
		
		boolean visitedRooms [][]= new boolean[x][x];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				visitedRooms[i][j] = false; 
				
			}
		}
		setVisitedRooms(visitedRooms);
		
	}
	
	public boolean[][] getVisitedRooms() {
		return visitedRooms;
	}
	public void setVisitedRooms(boolean[][] visitedRooms) {
		this.visitedRooms = visitedRooms;
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
		
		int i = this.playerlocation[0];
		int j = this.playerlocation[1];
		if(Size>this.playerlocation[1]+1 && this.playerlocation[1]+1 >= 0 && visitedRooms[i][j+1] ==false  ) {
			lastvisited=this.playerlocation;
			playerlocation[1]+=1;
			System.out.println("You are now at room: [" + this.playerlocation[0]+ "," + this.playerlocation[1] + "]");
			int ii = this.playerlocation[0];
			int jj = this.playerlocation[1];
			visitedRooms[ii][jj] = true; 

		}
		else if(Size>this.playerlocation[1]+1 &&this.playerlocation[1]+1 >= 0 && visitedRooms[i][j+1] ==true) {
			playerlocation[1]+=1;
			System.out.println("You have allready visited this room");
		}
		
		else {
			System.out.println("No path in that direction");
		}
	}

	public void goWest() {
		int i = this.playerlocation[0];
		int j = this.playerlocation[1];
		if(Size >this.playerlocation[0]-1 &&this.playerlocation[0]-1 >= 0 && visitedRooms[i-1][j] ==false) {
			lastvisited=this.playerlocation;
			playerlocation[0]-=1;
			System.out.println("You are now at room: [" + this.playerlocation[0]+ "," + this.playerlocation[1] + "]");
			int ii = this.playerlocation[0];
			int jj = this.playerlocation[1];
			visitedRooms[ii][jj] = true; 
		}
		else if(Size>this.playerlocation[0]-1 &&this.playerlocation[0]-1 >= 0 && visitedRooms[i-1][j] ==true) {
			playerlocation[0]-=1;
			System.out.println("You have allready visited this room");
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
		int i = this.playerlocation[0];
		int j = this.playerlocation[1];
		if(Size>this.playerlocation[0]+1 &&this.playerlocation[0]+1 >= 0 && visitedRooms[i+1][j] ==false) {
			lastvisited=this.playerlocation;
			playerlocation[0]+=1;
			System.out.println("You are now at room: [" + this.playerlocation[0]+ "," + this.playerlocation[1] + "]");
			int ii = this.playerlocation[0];
			int jj = this.playerlocation[1];
			visitedRooms[ii][jj] = true; 

		}
		else if(Size>this.playerlocation[0]+1 &&this.playerlocation[0]+1 >= 0 && visitedRooms[i+1][j] ==true) {
			playerlocation[0]+=1;
			System.out.println("You have allready visited this room");
			
		}
		else {
			System.out.println("No path in that direction");
		}
	}

	public void goNorth() {
		int i = this.playerlocation[0];
		int j = this.playerlocation[1];
		if(Size>this.playerlocation[1]-1 &&this.playerlocation[1]-1 >= 0 && visitedRooms[i][j-1] ==false) {
			lastvisited=this.playerlocation;
			playerlocation[1]-=1;
			System.out.println("You are now at room: [" + this.playerlocation[0]+ "," + this.playerlocation[1] + "]");
			int ii = this.playerlocation[0];
			int jj = this.playerlocation[1];
			visitedRooms[ii][jj] = true; 
		}
		else if(Size>this.playerlocation[1]-1 &&this.playerlocation[1]-1 >= 0 && visitedRooms[i][j-1] ==true) {
			playerlocation[1]-=1;
			System.out.println("You have allready visited this room");
	
		}
		
		
		else {
			System.out.println("No path in that direction");
		}
	}
	

//end
}

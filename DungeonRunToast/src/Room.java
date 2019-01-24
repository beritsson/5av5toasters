import java.util.ArrayList;

public class Room {
	
	private int x;
	private int y;
	CombatSystem fight;
	CombatSystem combat;
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	ArrayList<Treasure> treasureList = new ArrayList<Treasure>();
	boolean door = false;
	
	
	public Room() {
		monster();
		treasure();	
		
	}
	
	public boolean isDoor() {
		return door;
	}

	public void setDoor(boolean door) {
		this.door = door;
	}

	void setPosition(int x, int y){
		this.x = x +1;
		this.y = y +1;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	ArrayList<Monster> monster(){

		Monster gs = new GiantSpider();
		Monster s = new Skeleton();
		Monster o = new Orc();
		Monster t = new Troll();
		gs.addMonster(monsterList);
		s.addMonster(monsterList);
		o.addMonster(monsterList);
		t.addMonster(monsterList);
		return monsterList;
	}

	
	
	ArrayList<Treasure> treasure () {

		LooseMoney l = new LooseMoney();
		Purse p = new Purse();
		GoldJewelry gj = new GoldJewelry();
		Gemstone g = new Gemstone();
		TreasureChest tc = new TreasureChest();
		l.addTreasure(treasureList);
		p.addTreasure(treasureList);
		gj.addTreasure(treasureList);
		g.addTreasure(treasureList);
		tc.addTreasure(treasureList);	
		return treasureList;
	}

	public boolean monsterinroom(Character c, Map map) {
		Monster temp = null;
		if(monsterList.size()>0) {
			System.out.println("\nMonster:");
			for (Monster monster : monsterList) {
				monster.attributes();
				combat = new CombatSystem(c, monster, map);
				combat.startFight(map);
				temp = monster;
			}
		
			
			this.monsterList.remove(temp);
			return true;
		}		
		else {
		System.out.println("\nNo monsters in this room");}
		return false;}
	
	
	public boolean treasureinroom() {
		if(treasureList.size()>0) {
			System.out.println("\nTreasure:");
			for (Treasure treasure : treasureList) {
				treasure.attributes();
			}
			return true;
		}	
		else {
		System.out.println("\nNo treasure in this room");}
		return false;}
	
	
	public void getTreasure(Character character){
		treasureinroom();
		int point = 0;
		for (Treasure treasure : treasureList) {
			point += treasure.getValue();
		}
		character.setTreasurePoint(character.getTreasurePoint()+point);
		System.out.println("You get "+character.getTreasurePoint()+" points");
		treasureList.clear();
	}


	 void showPosition() {
		 System.out.println("Returning to previous room");
		 System.out.println("\nRoom [x=" + x + ", y=" + y + "]");
		 //monsterinroom();
		 
	}
	
	
}

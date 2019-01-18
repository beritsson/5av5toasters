import java.util.ArrayList;

public class Room {
	
	private int x;
	private int y;
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	ArrayList<Treasure> treasureList = new ArrayList<Treasure>();
	
	
	public Room() {
		monster();
		treasure();	
		
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

		GiantSpider gs = new GiantSpider();
		Skeleton s = new Skeleton();
		Orc o = new Orc();
		Troll t = new Troll();
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
	

	public boolean monsterinroom() {
		if(monsterList.size()>0) {
			System.out.println("\nMonster:");
			for (Monster monster : monsterList) {
				monster.attributes();
			}
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


	 void showPosition() {
		 System.out.println("\nRoom [x=" + x + ", y=" + y + "]");
		 //monsterinroom();
		 
	}
	
	
}

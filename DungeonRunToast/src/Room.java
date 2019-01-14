import java.util.ArrayList;

public class Room {
	
	private int x;
	private int y;
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	ArrayList<Tresure> tresureList = new ArrayList<Tresure>();
	
	void setPosition(int x, int y){
		this.x = x +1;
		this.y = y +1;
	}
	void choosemap() {
		
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
	
	
	ArrayList<Tresure> tresure () {

		LooseMoney l = new LooseMoney();
		Purse p = new Purse();
		GoldJewelry gj = new GoldJewelry();
		Gemstone g = new Gemstone();
		TreasureChest tc = new TreasureChest();
		l.addTresure(tresureList);
		p.addTresure(tresureList);
		gj.addTresure(tresureList);
		g.addTresure(tresureList);
		tc.addTresure(tresureList);	
		return tresureList;
	}
	

public boolean monsterinroom() {
		if(monsterList.size()>0) {
			System.out.println("\nMonster:");
			for (Monster monster : monsterList) {
				monster.attributes();
				return true;
			}
		}		
		else {
		System.out.println("\nNo monsters in this room");}
		return false;}


public boolean tresureinroom() {
	if(tresureList.size()>0) {
		System.out.println("\nTresure:");
		for (Tresure tresure : tresureList) {
			tresure.attributes();
			return true;
		}
	}	
	else {
	System.out.println("\nNo tresure in this room");}
	return false;}


	 void showPosition() {
		 System.out.println("\nRoom [x=" + x + ", y=" + y + "]");
		 //monsterinroom();
		 
	}
	
	
}

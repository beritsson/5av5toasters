import java.util.ArrayList;

public class Room {
	
	private int x;
	private int y;
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	ArrayList<Tresure> tresureList = new ArrayList<Tresure>();
	
	void setPosition(int x, int y){
		this.x = x;
		this.y = y;
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
		
		for (Monster monster : monsterList) {
			monster.attributes();
		}

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
		
		for (Tresure tresure : tresureList) {
			tresure.attributes();
		}
		
		return tresureList;
	}
	

public boolean monsterinroom() {
		if(monsterList.size()>0) {
			for (Monster monster : monsterList) {
				monster.attributes();
				return true;
			}
		}
		
		else {
		System.out.println("No monsters in this room");}
		return false;}


	 void showPosition() {
		 System.out.println("Room [x=" + x + ", y=" + y + "]");
//		 if (monsterList.size() == 0) {
//			 System.out.println("No monster in this room!");
//		 }
//		 if (tresureList.size() == 0) {
//			 System.out.println("No tresure in this room!");
//		 }
	}
	
	
}

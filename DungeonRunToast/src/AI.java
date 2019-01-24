
import java.util.Collections;
import java.util.Comparator;

public class AI {
	Map map;
	Character character;
	int GiantSpider = 0;
	int Skeleton = 0;
	int Orc = 0;
	int Troll = 0;
	
	

	public AI(Map map, Character character) {
		this.map = map;
		this.character = character;
	}
	
	void go(){
		map.setPlayerlocation(map.getNw());
		map.drawMap();
		fightloop(map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]]);
		
		if (character.getResistance() > 0) {
			map.visitedRooms[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]] = true;
			
			while (!map.clearMap()) {

					int number = (int)(Math.random()*4);
					switch(number) {
					case 0:
						map.goSouth();
						break;
					case 1:
						map.goEast();
						break;
					case 2:
						map.goWest();
						break;
					case 3:
						map.goNorth();
						break;				
					}
					map.drawMap();
					if(map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].monsterList.size()>0
							&& character.getResistance() == 1) {
						flee();
					}else {
						fightloop(map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]]);
					}
					if(character.getResistance() <= 0) {break;}
			}
				
		}
		if((character.getResistance() > 0)) {
			System.out.println("\n\nYou clear this map, you win!");
		}
		System.out.println("\nVisited room :  ");
		map.drawMap();
		System.out.println("Killed GiantSpider : "+ GiantSpider);
		System.out.println("Killed Skeleton : "+ Skeleton);
		System.out.println("Killed Orc : " + Orc);
		System.out.println("Killed Troll : "+ Troll);
		System.out.println("Your treasurePoint is : "+ character.getTreasurePoint());
	}
	

	void fightSequence(Room room){	
		character.setFightnumber();		
				
		for (Monster monster : room.monsterList) {
			monster.setFightnumber();
		}
		Collections.sort(room.monsterList,new Comparator<Monster>(){
			public int compare(Monster m1, Monster m2) {
		        if(m1.getFightnumber() > m2.getFightnumber()){
		            return 1;
		        }else if(m1.getFightnumber() == m2.getFightnumber()) {
		            return 0;
		        }else{
		            return -1;
		        }
		    }
		});
	}
	
	
	void fightloop(Room room){
		fightSequence(room);
		over:for (int i = room.monsterList.size()-1; i >= 0 ; i--) {
			Monster monster = room.monsterList.get(i);			
			monster.attributes();
			boolean noAttack = true;  //knight skill
			System.out.println("your initiativ point :"+character.getFightnumber());
			System.out.println(monster.getName()+"'s initiativ point :"+monster.getFightnumber());			
			System.out.println("Fight begin!");
			if (character.getFightnumber() >= monster.getFightnumber()) {
				while(character.getResistance()>0) {
					activeAttack(monster);
					
					if(monster.getResistance()>0) {
						if(character.getCharacterName() == "Knight" && noAttack){  //knight skill
							System.out.println("Knight missed first attack!");
							noAttack = false;
						}else {
							beAttacked(monster);
						}						
					}else {
						break;
					}
				}
			}else {
				while(monster.getResistance()>0) {
					
					if(character.getCharacterName() == "Knight" && noAttack){  //knight skill
						System.out.println("Knight missed first attack!");
						noAttack = false;
					}else {
						beAttacked(monster);
					}
					
					if(character.getResistance()>0) {
						activeAttack(monster);
					}else {
						break;
					}	
					
				}
			}
			
			if (character.getResistance() > 0) {				
				System.out.println(monster.getName()+" is dead. "+"you win! ");
				deadMonster(monster);
				room.monsterList.remove(i);
			}else {
				System.out.println("you are dead, game over!");
				break over;
			}
		}
		if((character.getResistance() > 0)) {
			System.out.println("Monster clear!");
			room.getTreasure(character);
		}
	}
	
	void activeAttack(Monster monster){		
			//character attack
			System.out.println("you attack--");
			character.setFightAttack();
			monster.setFightflexibility();
			System.out.println("your attack point is: "+character.getFightAttack());
			System.out.println(monster.getName()+"'s flexibility point is: "+monster.getFightflexibility());
			if(character.getFightAttack() > monster.getFightflexibility()) {
				monster.setResistance(monster.getResistance()-1);
				System.out.println(monster.getName()+" lost 1 blood");
				if(character.getCharacterName() == "Thief"){
					thiefAbility(monster);
				}
				System.out.println("You have "+character.getResistance()+" blood left");
				System.out.println(monster.getName()+" have "+monster.getResistance()+" blood left");
			}else {
				System.out.println("Missed attack");
			}		
	}
	
	void beAttacked(Monster monster){
		//monster attack
		System.out.println(monster.getName()+" attack--");
		monster.setFightAttack();
		character.setFightflexibility();
		System.out.println(monster.getName()+"'s attack point is: "+monster.getFightAttack());
		System.out.println("your flexibility point is: "+character.getFightflexibility());
		if(monster.getFightAttack() > character.getFightflexibility()) {
			character.setResistance(character.getResistance()-1);
			System.out.println("you lost 1 blood");
			System.out.println("You have "+character.getResistance()+" blood left");
			System.out.println(monster.getName()+" have "+monster.getResistance()+" blood left");
		}else {
			System.out.println("Missed attack");
		}
	}
	
	void flee(){
		if((int)(Math.random()*100) < character.getFlexibility()*10){
			System.out.println("You succesfully escaped!");
		}else if(character.getCharacterName() == "Wizard" && (int)(Math.random()*100) < 80) {
			System.out.println("Wizard succesfully escaped!");
		}else {
			System.out.println("you kan not escape, the fight continues!");
			fightloop(map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]]);
		}
	}
	
	void thiefAbility(Monster monster){
		if((int)(Math.random()*100) < 25){
			monster.setResistance(monster.getResistance()-1);
			System.out.println("Thief's double injury!");
			System.out.println(monster.getName()+" lost 1 blood again");
		}
	}
	
	void wizardAbility(){
		if((int)(Math.random()*100) < 80){
			System.out.println("Wizard flee sucessfully!");
		}else {
			System.out.println("Fails to flee!");
		}
	}
	
	void deadMonster(Monster monster){
		switch(monster.getName()) {
		case "GiantSpider":
			GiantSpider+=1;
			break;
		case "Skeleton":
			Skeleton+=1;
			break;
		case "Orc":
			Orc+=1;
			break;
		case "Troll":
			Troll+=1;
			break;				
		}
	}
	
}


import java.util.Collections;
import java.util.Comparator;

public class AI {
	Map map;
	Character character;
	

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
//			for (int j2 = 0; j2 < 200; j2++) {

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
					fightloop(map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]]);
					if(character.getResistance() <= 0) {break;}
			}
				
		}
		if((character.getResistance() > 0)) {
			System.out.println("You clear this map, you win!");
			System.out.println("Your final point is : "+ character.getTreasurePoint());
		}
	}
	

	void goo(){
		
		map.setPlayerlocation(map.getNw());
		int i = map.playerlocation[0];
		int j = map.playerlocation[1];
		map.drawMap();
		fightloop(map.getMap()[i][j]);
		
		if (character.getResistance() > 0) {
			map.visitedRooms[i][j] = true;
	        int x = map.getSize();	        

	        gameOver:for (i = 0; i < x; i++) {
				if (i%2 == 0) {
					for (j = 0; j < x-1; j++) {
						map.goEast();
						map.drawMap();
						fightloop(map.getMap()[i][j]);
						if(character.getResistance() <= 0) {break gameOver;}						
					}
				}else {
					for (j = 0; j < x-1; j++) {
						map.goWest();
						map.drawMap();
						fightloop(map.getMap()[i][j]);
						if(character.getResistance() <= 0) {break gameOver;}
					}
				}
				if (i != x-1) {
					map.goSouth();
					map.drawMap();
					fightloop(map.getMap()[i][j]);
					if(character.getResistance() <= 0) {break gameOver;}
				}
				
			}
		}
		if((character.getResistance() > 0)) {
			System.out.println("You clear this map, you win!");
			System.out.println("Your final point is : "+ character.getTreasurePoint());
		}
		
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
				room.monsterList.remove(i);
				System.out.println(monster.getName()+" is dead. "+"you win! ");
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
	
}

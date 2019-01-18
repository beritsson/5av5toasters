
import java.util.Collections;
import java.util.Comparator;

public class AI {
	Room room;
	Character character;

	public AI(Room room, Character character) {
		this.room = room;
		this.character = character;
	}


	void fightSequence(){	
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
	
	
	void fightloop(){
		fightSequence();
		over:for (int i = room.monsterList.size()-1; i >= 0 ; i--) {
			Monster monster = room.monsterList.get(i);			
			monster.attributes();
			System.out.println("your initiativ point :"+character.getFightnumber());
			System.out.println(monster.getName()+"'s initiativ point :"+monster.getFightnumber());			
			System.out.println("Fight begin!");
			if (character.getFightnumber() >= monster.getFightnumber()) {
				while(character.getResistance()>0) {
					activeAttack(monster);
					if(monster.getResistance()>0) {
						beAttacked(monster);
					}else {
						break;
					}
				}
			}else {
				while(monster.getResistance()>0) {
					beAttacked(monster);
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
			getTreasure();
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
	
	
	void getTreasure(){
		room.treasureinroom();
		int point = 0;
		for (Treasure treasure : room.treasureList) {
			point += treasure.getValue();
		}
		character.setTreasurePoint(character.getTreasurePoint()+point);
		System.out.println("You get "+character.getTreasurePoint()+" points");
		room.treasureList.clear();
	}

	public static void main(String[] args) {
		Room room = new Room();
		Knight k = new Knight("Test");
		AI ai = new AI(room, k);
		ai.fightloop();
	}

}

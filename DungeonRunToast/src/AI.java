
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
			@Override
			public int compare(Monster o1, Monster o2) {
		        if(o1.getFightnumber() > o2.getFightnumber()){
		            return 1;
		        }else if(o1.getFightnumber() == o2.getFightnumber()) {
		            return 0;
		        }else{
		            return -1;
		        }
		    }
		});
		
//		for(int i = room.monsterList.size()-1; i >= 0 ; i--) {
//			Monster m = room.monsterList.get(i);
//	        System.out.println("monsternumber :"+m.getFightnumber()+" monstertype : "+m.getName());
//	      }
	}
	
	void fightloop(){
		fightSequence();
		over:for (int i = room.monsterList.size()-1; i >= 0 ; i--) {
			Monster monster = room.monsterList.get(i);
			System.out.println("yournumber :"+character.getFightnumber());
			monster.attributes();
			System.out.println("monsternumber :"+monster.getFightnumber());			
			System.out.println("Fight begin!");
			if (character.getFightnumber() >= monster.getFightnumber()) {
				while(character.getResistance()>0 && monster.getResistance()>0) {
					activeAttack(monster);
					beAttacked(monster);
				}
			}else {
				while(character.getResistance()>0 && monster.getResistance()>0) {
					beAttacked(monster);
					activeAttack(monster);					
				}
			}
			
			if (character.getResistance() > 0) {
				System.out.println(monster.getName()+" is dead. "+"you win! ");
			}else {
				System.out.println("you are dead, game over!");
				break over;
			}
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
			}else {
				System.out.println(monster.getName()+" missed the attack");
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
		}else {
			System.out.println("you missed the attack");
		}
	}

	public static void main(String[] args) {
		Room room = new Room();
		Knight k = new Knight("Test");
		AI ai = new AI(room, k);
		ai.fightloop();
	}

}

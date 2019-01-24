import java.util.Scanner;

public class CombatSystem {
	boolean flee = true;
	Monster m;
	Character c;
	Map map;
	Scanner input;
	boolean block;
	
	public CombatSystem(Character c, Monster m, Map map) {
		
		this.c = c;
		this.m = m;
		block = false;
		this.map = map;
		
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	public void startFight(Map map) {
		c.setFightnumber();
		m.setFightnumber();

		System.out.println("(" + c.userName + " rolls: " + c.getFightnumber() + ")");
		System.out.println("(" + m.name + " rolls: " + m.getFightnumber() + ")");


		if(c.getFightnumber() > m.getFightnumber() && flee == true) {
			System.out.println("\n-------------->>" + c.userName + " makes the first move!");
			while (m.getResistance() > 0 && c.getResistance() > 0) {
				fightC(map);
				fightM();
			}
		}
		else {
			System.out.println("\n-------------->>" + m.name + " makes the first move!");
			while (m.getResistance() > 0 && c.getResistance() > 0) {
				fightM();
				fightC(map);
			}
		}
	}
	
	public void fightC(Map map) {
		
		
		if(flee) {
		c.setFightAttack();
		m.setFightflexibility();
		input = new Scanner(System.in);
		System.out.println("Your turn! What do you want to do?");
		System.out.println("[A]ttack\n[F]lee");
		String combatChoice = input.next().toUpperCase();
		
		switch (combatChoice) {
		case "A":
			System.out.println("\n-------->" + c.userName + " attack rolls: " + c.getFightAttack());
			System.out.println("-------->" + m.name + " defence rolls: " + m.getFightflexibility());

			if (c.getFightAttack() > m.getFightflexibility()) {
				System.out.println("\n-------->Its a direct hit!");
				if(c.getClass() == Thief.class) {
					if (Math.random()*100 < 25) {
						System.out.println("[---------------CRITICAL HIT! DOUBLE DAMAGE----------------]");
						m.setResistance(m.getResistance()-2);
						System.out.println("\n" + m.name + " current HP is " + m.getResistance());
					}
					else {
						m.setResistance(m.getResistance()-1);
						System.out.println("(" + m.name + " current hp: " + m.getResistance() + ")");
					}
				}
				else {
					m.setResistance(m.getResistance()-1);
					System.out.println("(" + m.name + " current hp: " + m.getResistance() + ")");
				}
			}
			else {
				System.out.println("\n---------------Attack missed!---------------------");
			}
			if(m.getResistance() <= 0) {
				System.out.println("\n[-------" + m.name + " is dead! You won this fight!------]");
				System.out.println("(" + c.userName + " has " + c.getResistance() + "hp left!)");
				this.flee = false;
				break;
			
			}
			break;
		case "F":
		    fleeBattle(map);
//			map.getPlayerlocation()[0] =	map.getLastvisited()[0];
//			map.getPlayerlocation()[1] =	map.getLastvisited()[1];
				//map.getMap()[i][j].monsterinroom(c, map);
			//map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].monsterinroom(c, map);
				//map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].treasureinroom();
		default:
			break;
		}
	}

}
	
	public void fightM() {
		m.setFightAttack();
		c.setFightflexibility();
		if(m.getResistance() > 0 && flee == true) {
			System.out.println("\n-------->" + m.name + " attack rolls: " + m.getFightAttack());
			System.out.println("-------->" + c.userName + " defence rolls: " + c.getFightflexibility());
			
			if (m.getFightAttack() > c.getFightflexibility() && flee == true) {
				System.out.println("\n---------------ITS A DIRECT HIT!---------------------");
				if(c.getClass() == Knight.class) {
					if (isBlock()) {
						c.setResistance(c.getResistance()-1);
						System.out.println("(" + c.userName + " current hp is " + c.getResistance() + ")");
					}
					else if(!isBlock()) {
						System.out.println("\n" + c.userName + " BLOCKS THE DAMAGE! ZERO DAMAGE TAKEN!");
						setBlock(true);
					}
				}
				else {
					c.setResistance(c.getResistance()-1);
					System.out.println("(" + c.userName + " current hp is " + c.getResistance() + ")");
				}

			}
			else {
				System.out.println("\n---------------Attack missed!---------------------");
			}
			if(c.getResistance() == 0) {
				Game.EndMenu();
				
			}
////			if (!flee) {
//				System.out.println("u ecapppeeeeed");
//			}
			
		}

	}
	
	public void fleeBattle(Map map) {
		if (c.getClass() == Wizard.class) {
			if(Math.random()*100 < c.getFightflexibility()*80) {
				System.out.println("You succesfully escaped!");
//				map.getPlayerlocation()[0] =	map.getLastvisited()[0];
//				map.getPlayerlocation()[1] =	map.getLastvisited()[1];
//					//map.getMap()[i][j].monsterinroom(c, map);
////					map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].monsterinroom(c, map);
//					map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].treasureinroom();
				map.playerlocation = map.lastvisited;
				this.flee = false;
			}
			else {
				System.out.println(m.name + " did not let you flee, the fight continues");
			}
		}
		else if(Math.random()*100 < c.getFlexibility()*10) {
			System.out.println("You succesfully escaped!");
			map.playerlocation = map.lastvisited;
//			map.getPlayerlocation()[0] =	map.getLastvisited()[0];
//			map.getPlayerlocation()[1] =	map.getLastvisited()[1];
//				//map.getMap()[i][j].monsterinroom(c, map);
////				map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].monsterinroom(c, map);
//				map.getMap()[map.getPlayerlocation()[0]][map.getPlayerlocation()[1]].treasureinroom();
			this.flee = false;
			//Game.gameLoop(map, input);
		}
		else {
			System.out.println(m.name + " did not let you flee, the fight continues");
		}
	}

}


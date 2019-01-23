import java.util.Scanner;

public class CombatSystem {
	
	Monster m;
	Character c;
	Scanner input;
	boolean block;
	
	public CombatSystem(Character c, Monster m) {
		
		this.c = c;
		this.m = m;
		block = false;
		
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	public void startFight() {
		c.setFightnumber();
		m.setFightnumber();
		System.out.println("\n-------->" + c.userName + " rolls: " + c.getFightnumber());
		System.out.println("\n-------->" + m.name + " rolls: " + m.getFightnumber());

		if(c.getFightnumber() > m.getFightnumber()) {
			System.out.println("\n" + c.userName + " makes the first move!");
			while (m.getResistance() > 0 && c.getResistance() > 0) {
				fightC();
				fightM();
			}
		}
		else {
			System.out.println("\n" + m.name + " makes the first move!");
			while (m.getResistance() > 0 && c.getResistance() > 0) {
				fightM();
				fightC();
			}
		}
	}
	
	public void fightC() {
		
		c.setFightAttack();
		m.setFightflexibility();
		
		input = new Scanner(System.in);
		System.out.println("Your turn! What do you want to do?");
		System.out.println("[A]ttack\n[F]lee");
		String combatChoice = input.next().toUpperCase();
		
		switch (combatChoice) {
		case "A":
			System.out.println("\n-------->" + c.userName + " attack rolls: " + c.getFightAttack());
			System.out.println("\n-------->" + m.name + " defence rolls: " + m.getFightflexibility());

			if (c.getFightAttack() > m.getFightflexibility()) {
				System.out.println("\n-------->Its a direct hit!");
				if(c.getClass() == Thief.class) {
					if (Math.random()*100 < 25) {
						System.out.println("CRITICAL HIT! DOUBLE DAMAGE");
						m.setResistance(m.getResistance()-2);
						System.out.println("\n" + m.name + " current HP is " + m.getResistance());
					}
					else {
						m.setResistance(m.getResistance()-1);
						System.out.println(m.name + " current hp: " + m.getResistance());
					}
				}
				else {
					m.setResistance(m.getResistance()-1);
					System.out.println(m.name + " current hp: " + m.getResistance());
				}
			}
			else {
				System.out.println("\n---------------Attack missed!---------------------");
			}
			if(m.getResistance() <= 0) {
				System.out.println("\n" + m.name + " is dead! You won this fight!");
				System.out.println("\n" + c.userName + " has " + c.getResistance() + "hp left!");
				break;
			}
			break;
		case "F":
			fleeBattle();
			break;
		default:
			break;
		}
	}
	
	public void fightM() {
		m.setFightAttack();
		c.setFightflexibility();
		if(m.getResistance() > 0) {
			System.out.println("\n------------------>" + m.name + " attack rolls: " + m.getFightAttack());
			System.out.println("\n-------------------->" + c.userName + " defence rolls: " + c.getFightflexibility());
			
			if (m.getFightAttack() > c.getFightflexibility()) {
				System.out.println("---------------->Its a direct hit!");
				if(c.getClass() == Knight.class) {
					if (isBlock()) {
						c.setResistance(c.getResistance()-1);
						System.out.println("\nCurrent hp on " + c.userName + " is " + c.getResistance());
					}
					else if(!isBlock()) {
						System.out.println("\n" + c.userName + " blocks the hit! No damage is taken");
						setBlock(true);
					}
				}
				else {
					c.setResistance(c.getResistance()-1);
					System.out.println("\nCurrent hp on " + c.userName + " is " + c.getResistance());
				}

			}
			else {
				System.out.println("\n---------------Attack missed!---------------------");
			}
			if(c.getResistance() == 0) {
				System.out.println(c.userName + " died a painfull death! GAME OVER!");
				System.exit(0);
			}
			
		}

	}
	
	public boolean fleeBattle() {
		if (c.getClass() == Wizard.class) {
			if(Math.random()*100 < c.getFightflexibility()*80) {
				System.out.println("You succesfully escaped!");
				return true;
			}
			else {
				System.out.println(m.name + " did not let you flee, the fight continues");
				return false;
			}
		}
		else if(Math.random()*100 < c.getFlexibility()*10) {
			System.out.println("You succesfully escaped!");
			return true;
		}
		else {
			System.out.println(m.name + " did not let you flee, the fight continues");
			return false;
		}
	}
}

import java.util.Scanner;

public class CombatSystem {
	
	Monster m;
	Character c;
	Scanner input;
	
	public CombatSystem(Character c, Monster m) {
		
		this.c = c;
		this.m = m;
		c.setFightflexibility();
		c.setFightAttack();
		m.setFightflexibility();
		m.setFightAttack();
		
	}
	
	public void startFight() {

		System.out.println(c.userName + " rolls: " + c.getFightflexibility());
		System.out.println(m.name + " rolls: " + m.getFightflexibility());
		if(c.getFightflexibility() > m.getFightflexibility()) {
			System.out.println(c.userName + " makes the first move!");
			while (m.getResistance() > 0 && c.getResistance() > 0) {
				fightC();
				fightM();
			}
		}
		else {
			System.out.println(m.name + " makes the first move!");
			while (m.getResistance() > 0 && c.getResistance() > 0) {
				fightM();
				fightC();
			}
		}
	}
	
	public void fightC() {
		input = new Scanner(System.in);
		System.out.println("Your turn! What do you want to do?");
		System.out.println("[A]ttack\n[F]lee");
		String combatChoice = input.next().toUpperCase();
		
		switch (combatChoice) {
		case "A":
			System.out.println(c.userName + " attack rolls: " + c.getFightAttack());
			System.out.println(m.name + " defence rolls: " + m.getFightflexibility());
			if (c.getFightAttack() > m.getFightflexibility()) {
				System.out.println(m.getResistance());
				m.setResistance(m.getResistance()-1);
				System.out.println(m.name + " current hp: " + m.getResistance());
				if(m.getResistance() == 0) {
					System.out.println(m.name + " is dead! You won this fight!");
				}
			}
			else {
				System.out.println("Attack missed!");
			}
			break;

		default:
			break;
		}

	}
	
	public void fightM() {
		System.out.println(m.name + " attack rolls: " + m.getFightAttack());
		System.out.println(c.userName + " defence rolls: " + c.getFightflexibility());
		if (m.getFightAttack() > c.getFightflexibility()) {
			System.out.println(c.getResistance());
			c.setResistance(c.getResistance()-1);
			System.out.println("Current hp on hero: " + c.getResistance());
			if(c.getResistance() == 0) {
				System.out.println(c.userName + " died a painfull death! GAME OVER!");
			}
		}
		else {
			System.out.println("Attack missed!");
		}
	}

}

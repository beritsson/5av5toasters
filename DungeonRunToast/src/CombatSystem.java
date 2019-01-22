import java.util.Random;
import java.util.Scanner;

public class CombatSystem {
	
	Monster m;
	Character c;
	Scanner input;
	Random rand;
	
	public CombatSystem(Character c, Monster m) {
		
		this.c = c;
		this.m = m;
	}
	
	public void startFight() {
		c.setFightnumber();
		m.setFightnumber();
		System.out.println("\n-------->" + c.userName + " rolls: " + c.getFightnumber());
		try {
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		
		this.c.setFightAttack();
		this.m.setFightflexibility();
		
		input = new Scanner(System.in);
		System.out.println("Your turn! What do you want to do?");
		System.out.println("[A]ttack\n[F]lee");
		String combatChoice = input.next().toUpperCase();
		
		switch (combatChoice) {
		case "A":
			System.out.println("\n-------->" + c.userName + " attack rolls: " + c.getFightAttack());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n-------->" + m.name + " defence rolls: " + m.getFightflexibility());

			if (c.getFightAttack() > m.getFightflexibility()) {
				System.out.println("---------------->Its a direct hit!");
				if(c.getClass() == Thief.class) {
					if (c.getAttack() > ((int)Math.random()*100)) {
						System.out.println("CRITCAL HIT! DOUBLE DAMAGE");
						m.setResistance(m.getResistance()-2);
						System.out.println(m.name + " current HP is " + m.getResistance());
					}
				}
				else {
					m.setResistance(m.getResistance()-1);
					System.out.println(m.name + " current hp: " + m.getResistance());
				}
				if(m.getResistance() <= 0) {
					System.out.println(m.name + " is dead! You won this fight!");
					System.out.println(c.userName + " has " + c.getResistance() + "hp left!");
				}
			}
			else {
				System.out.println("---------------Attack missed!---------------------");
			}
			break;

		default:
			break;
		}

	}
	
	public void fightM() {
		
		m.setFightAttack();
		c.setFightflexibility();
		
		System.out.println("\n" + m.name + " attack rolls: " + m.getFightAttack());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n" + c.userName + " defence rolls: " + c.getFightflexibility());
		
		int count = 0;
		if (m.getFightAttack() > c.getFightflexibility()) {
			System.out.println("---------------->Its a direct hit!");
			if(c.getClass() == Knight.class && count == 0) {
				count++;
				System.out.println(c.userName + " blocks the hit! No damage is taken");
			}
			else {
				c.setResistance(c.getResistance()-1);
				System.out.println("Current hp on " + c.userName + " is " + c.getResistance());
			}

			if(c.getResistance() == 0) {
				System.out.println(c.userName + " died a painfull death! GAME OVER!");
				System.exit(0);
			}
		}
		else {
			System.out.println("Attack missed!");
		}
	}
	
	public void fleeBattle() {
		
		rand = new Random();
		
	}

}


public class Wizard extends Character{
	
	public Wizard(String username) 
	{
		userName = username;
		characterName = "Wizard";
		initiativ = 6;
		resistance = 4;
		attack = 9;
		flexibility = 5;
	}
	
	void characterAttribute() 
	{
		System.out.println("\n\t\tHERO");
		System.out.println("\tWizard " + "[" + userName + "]" + " attributes");
		System.out.println("\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tflexibility: " + flexibility);
		System.out.println("(Special abilitie: Blinde the enemy for a better chance to flee the battle)");
	}


}

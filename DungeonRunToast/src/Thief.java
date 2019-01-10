
public class Thief extends Character{
	
	public Thief(String username) 
	{
		userName = username;
		characterName = "Thief";
		initiativ = 5;
		resistance = 9;
		attack = 6;
		flexibility = 4;
	}
	
	void characterAttribute() 
	{
		System.out.println("\n\t\tHERO");
		System.out.println("\tThief " + "[" + userName + "]" + " attributes");
		System.out.println("\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tflexibility: " + flexibility);
		System.out.println("(Special abilitie: Critical hit! 25% chance to do double the damage on every hit)");
	}

}

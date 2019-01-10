
public class Knight extends Character{
	
	public Knight(String username) 
	{
		userName = username;
		characterName = "Knight";
		initiativ = 5;
		resistance = 9;
		attack = 6;
		flexibility = 4;
	}
	
	void characterAttribute() 
	{
		System.out.println("\n\t\tHERO");
		System.out.println("\tKnight " + "[" + userName + "]" + " attributes");
		System.out.println("\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tflexibility: " + flexibility);
		System.out.println("(Special abiltie: Shield Block, no damage the first hit)");
	}

}

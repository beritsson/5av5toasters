
public class Troll extends Monster{
	
	public Troll() 
	{
		initiativ = 2;
		resistance = 4;
		attack = 7;
		flexibility = 2;
		commonness = 5;
	}
	
	void attributes() 
	{
		System.out.println("\n-------Troll Attributes-------");
		System.out.println("\n\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tFlexibility: " + flexibility);
		System.out.println("\tCommoness: " + commonness + "%");
	}

}


public class Orc extends Monster{
	
	public Orc() 
	{
		initiativ = 6;
		resistance = 3;
		attack = 4;
		flexibility = 4;
		commonness = 10;
	}
	
	void attributes() 
	{
		System.out.println("\n-------Orc Attributes-------");
		System.out.println("\n\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tFlexibility: " + flexibility);
		System.out.println("\tCommoness: " + commonness + "%");
	}

}

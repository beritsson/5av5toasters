
public class Skeleton extends Monster{

	public Skeleton() 
	{
		initiativ = 4;
		resistance = 2;
		attack = 3;
		flexibility = 3;
		commonness = 15;
	}

	void attributes() 
	{
		System.out.println("\n-------Skeleton Attributes-------");
		System.out.println("\n\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tFlexibility: " + flexibility);
		System.out.println("\tCommoness: " + commonness + "%");
	}

}

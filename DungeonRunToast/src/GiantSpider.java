
public class GiantSpider extends Monster{
	
	public GiantSpider() 
	{
		initiativ = 7;
		resistance = 1;
		attack = 2;
		flexibility = 3;
		commonness = 20;
	}
	
	void attributes() 
	{
		System.out.println("\n-------Giant Spider Attributes-------");
		System.out.println("\n\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tFlexibility: " + flexibility);
		System.out.println("\tCommoness: " + commonness + "%");
	}

}

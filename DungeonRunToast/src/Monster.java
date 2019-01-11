import java.util.ArrayList;

public class Monster {



	protected int initiativ;

	protected int resistance;

	protected int attack;

	protected int flexibility;

	protected int commonness;



	void attributes() 

	{

		System.out.println("-------Creatures Attribute-------");

		System.out.println("\tInitiativ: " + initiativ);

		System.out.println("\tResistance: " + resistance);

		System.out.println("\tAttack: " + attack);

		System.out.println("\tFlexibility: " + flexibility);

		System.out.println("\tCommoness: " + commonness + "%");

	}



	public void showAttribute(ArrayList<Monster> monsterList)

	{

		for (Monster monster : monsterList) {



			monster.attributes();

		}

	}



	public int getInitiativ() {

		return initiativ;

	}



	public void setInitiativ(int initiativ) {

		this.initiativ = initiativ;

	}



	public int getResistance() {

		return resistance;

	}



	public void setResistance(int resistance) {

		this.resistance = resistance;

	}



	public int getAttack() {

		return attack;

	}



	public void setAttack(int attack) {

		this.attack = attack;

	}



	public int getFlexibility() {

		return flexibility;

	}



	public void setFlexibility(int flexibility) {

		this.flexibility = flexibility;

	}



	public int getCommonness() {

		return commonness;

	}



	public void setCommonness(int commonness) {

		this.commonness = commonness;

	}

	

	

	ArrayList<Monster> addMonster(ArrayList<Monster> monsterList){

		if (this.commonness > (int)(Math.random()*100)){

			monsterList.add(this);

		}	

		return monsterList;

	}



}
import java.util.ArrayList;

public class Monster {
	protected String name;
	protected int initiativ;
	protected int resistance;
	protected int attack;
	protected int flexibility;
	protected int commonness;
	protected int fightnumber;
	protected int fightAttack;
	protected int fightflexibility;

	void attributes() 
	{
		System.out.println("---------" + name + " attributes---------");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
	public int getFightnumber() {
		return fightnumber;
	}

	public void setFightnumber() {
		this.fightnumber = this.initiativ*((int)(Math.random()*6)+1);
	}

	
	public int getFightAttack() {
		return fightAttack;
	}

	public void setFightAttack() {
		this.fightAttack = this.attack*((int)(Math.random()*6)+1);
	}

	public int getFightflexibility() {
		return fightflexibility;
	}

	public void setFightflexibility() {
		this.fightflexibility = this.flexibility*((int)(Math.random()*6)+1);
	}

	ArrayList<Monster> addMonster(ArrayList<Monster> monsterList){
		if (this.commonness > (int)(Math.random()*100)){
			monsterList.add(this);
		}	
		return monsterList;
	}



}

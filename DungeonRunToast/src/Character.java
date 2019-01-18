import java.util.ArrayList;

public class Character {
	
	protected String userName;
	protected String characterName;
	protected int initiativ;
	protected int resistance;
	protected int attack;
	protected int flexibility;
	protected String specialAbiltie;
	protected int treasurePoint;
	protected int fightnumber;
	protected int fightAttack;
	protected int fightflexibility;
	
	void characterAttribute() 
	{
		System.out.println(userName + " the mighty " + characterName);
		System.out.println("\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tflexibility" + flexibility);
		System.out.println(specialAbiltie);
	}
	
	public int getTreasurePoint() {
		return treasurePoint;
	}

	public void setTreasurePoint(int treasurePoint) {
		this.treasurePoint = treasurePoint;
	}

	public void showAttribute(ArrayList<Character> characterList)
	{
		for (Character character : characterList) {
			
			character.characterAttribute();
		}
	}
	
	public String getUserName() {
		return userName;
	}
	protected void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCharacterName() {
		return characterName;
	}
	protected void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public int getInitiativ() {
		return initiativ;
	}
	protected void setInitiativ(int initiativ) {
		this.initiativ = initiativ;
	}
	public int getResistance() {
		return resistance;
	}
	protected void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public int getAttack() {
		return attack;
	}
	protected void setAttack(int attack) {
		this.attack = attack;
	}
	public int getFlexibility() {
		return flexibility;
	}
	protected void setFlexibility(int flexibility) {
		this.flexibility = flexibility;
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
	
}

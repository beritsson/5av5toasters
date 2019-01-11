import java.util.ArrayList;

public class Character {
	
	protected String userName;
	protected String characterName;
	protected int initiativ;
	protected int resistance;
	protected int attack;
	protected int flexibility;
	protected String specialAbiltie;
	
	void characterAttribute() 
	{
		System.out.println(userName + " the mighty " + characterName);
		System.out.println("\tInitiativ: " + initiativ);
		System.out.println("\tResistance: " + resistance);
		System.out.println("\tAttack: " + attack);
		System.out.println("\tflexibility" + flexibility);
		System.out.println(specialAbiltie);
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
}

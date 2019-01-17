import java.util.ArrayList;

public class Treasure {
	protected String type;
	protected int value;
	protected int commonness;
	
	void attributes() 
	{
		System.out.println("\n-------"+ type +" Attributes-------");
		System.out.println("\n\tValue: " + value);
		System.out.println("\tCommoness: " + commonness + "%");
	}
		
	
	ArrayList<Treasure> addTreasure(ArrayList<Treasure> treasureList){
		if (this.commonness > (int)(Math.random()*100)){
			treasureList.add(this);
		}	
		return treasureList;
	}
	
//	public int getValue() {
//		return value;
//	}
//
//
//
//	public void setValue(int value) {
//		this.value = value;
//	}
//
//
//
//	public int getCommonness() {
//		return commonness;
//	}
//
//
//
//	public void setCommonness(int commonness) {
//		this.commonness = commonness;
//	}



//	public String getType() {
//		return type;
//	}
//
//
//
//	public void setType(String type) {
//		this.type = type;
//	}


	
//	public void showAttributes(ArrayList<Treasure> treasureList0)
//	{
//		for (Treasure treasure : treasureList0) {
//
//			treasure.attributes();
//		}
//	}
//	

}

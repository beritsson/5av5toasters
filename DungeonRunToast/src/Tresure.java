import java.util.ArrayList;
import java.util.Random;

public class Tresure {

	protected String type;

	protected int value;

	protected int commonness;

	

	void attributes() 

	{

		System.out.println("\n-------"+ type +" Attributes-------");

		System.out.println("\n\tValue: " + value);

		System.out.println("\tCommoness: " + commonness + "%");

	}

		

	

	ArrayList<Tresure> addTresure(ArrayList<Tresure> tresureList){

		if (this.commonness > (int)(Math.random()*100)){

			tresureList.add(this);

		}	

		return tresureList;

	}

	

public int getValue() {

return value;

}

//

//

//



//

//

//

public int getCommonness() {

	return commonness;

}

//

//

//



public String getType() {

return type;

}





	

public void showAttributes(ArrayList<Tresure> tresureList0)

{

for (Tresure tresure : tresureList0) {



tresure.attributes();

}

}

//	



}

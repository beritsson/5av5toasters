import java.io.*;

public class GameSave {

	
			
	static void SaveGame(){
      Game e = new Game();
    //System.out.println(Game.pname);
      //e.address = "Phokka Kuan, Ambehta Peer";
      //e.SSN = 11122333;
      //e.number = 101;
      
      try {
         FileOutputStream fileOut =
         new FileOutputStream("/tmp/employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /tmp/employee.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
      
   }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;




public class IoSystem {

	
	

	
	public static boolean CheckSave(String Name) {
		 Name = "saves/" + Name + ".txt";
		File file =new File(Name);
		return file.exists();
	}
	
	
	

	
	  public static String load(String Files)throws IOException{
		     
		  Files = "saves/" + Files + ".txt";

		   
		//reads the file from the disk

		File file =new File(Files); //makes the file path 
		    		
		  if(file.exists()){ //checks if the file is present in the path given 
		      BufferedReader reader = new BufferedReader(new FileReader(Files)); // Creates the reader 
		      StringBuilder sb = new StringBuilder();
		      String text = reader.readLine();

		      
		      
		      //reads from the file by reading line per line
		    while (text != null) {
		        sb.append(text);
		        sb.append(System.lineSeparator()); //Separates the lines and adds line breaks
		        text = reader.readLine();
		        
		        
		         
		    }
		 
		    String prin = sb.toString(); //converts it to a normal string 
		    reader.close();
		     return prin; 
		     
		         } 
		 
		        else{
		        	
		          
		           System.out.println("The file was not found");
		           
		        }
		       
		  
		  
		     return Files; //returns the filename if the file was not found
		    }
	



	  

	  
	  public static Character LoadChar(String SaveName) throws IOException{

		File file = new File("saves/"+SaveName+".txt"); 
		if(file.exists()){ 
		           
		                                    
		            String value[] = load(SaveName).split("\\r\\n|\\n|\\r"); 
		         	
		            
		            try{      
		            
		            	if(value[0].equals("Knight")){
		            		Character k = new Knight(SaveName);
		            		k.setTreasurePoint(Integer.parseInt(value[1]));
		            	
		            		return k;
		            		
		            	}else if (value[0].equals("Thief")){
		            		Character k = new Thief(SaveName);
		            		k.setTreasurePoint(Integer.parseInt(value[1]));
		            	
		            		return k;
		            		
		            	}else if (value[0].equals("Wizard")){
		            		Character k = new Wizard(SaveName);
		            		k.setTreasurePoint(Integer.parseInt(value[1]));
		            	
		            		return k;
		            		
		            	}else {
		            		System.out.println("No klass with the ID " + value[0] +" was found.\n Using defualt: Knight");
		            	
		            		
		            	}
		            	
		            	
		            	
		            	
		            }catch(ArrayIndexOutOfBoundsException exception){
		            	System.out.println(exception);
		            	
		    
		            }   
		}
		
		            
		Character k = new Knight(SaveName);
	
    	return k;          
		  
		            
		                      
		                 
		        
	
		   
		}
	  

		
	    public static void save( Character p) throws IOException  {
	        

	    	
	    	
	  String  content = p.getCharacterName() + "\n" + String.valueOf(p.getTreasurePoint());
	



	 Writer writer = null;
	//Tries to write the file
	try {
	    writer = new BufferedWriter(new OutputStreamWriter(
	          
	            new FileOutputStream("saves/"+p.getUserName()+".txt"), "utf-8")); // unicode formated
	    
	    writer.write(content);
	    

	    
	//catches any errors 
	} catch (IOException ex) {
	  
	    System.out.println("Woops, something went wrong. Please contact the system admin.\n" + ex);

	} finally {
	   
	    try {writer.close();} catch (Exception ex) {
	    System.out.println("Woops, something went wrong. Please contact the system admin.\n" + ex);
	    
	    }
	}
	        
	}
	    
	
	
	
	    
	    
	
	
	
	
	
	
}

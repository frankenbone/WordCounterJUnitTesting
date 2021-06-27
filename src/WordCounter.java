import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javafx.scene.control.Button;
import javafx.stage.Stage;


public class WordCounter 
{
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		//file location 
		File fin = new File("src/Raven");

		//Setup a Scanner to read the file
		Scanner fileScan = new Scanner(fin);

		//setup a HashMap with String, Integer
		Map<String,Integer> map = new HashMap<String, Integer>(); 

		while (fileScan.hasNext())
		{
			String val = fileScan.next(); 
			if(map.containsKey(val) == false) // if string is not inserted in the map yet, insert by setting the frequency as 1
				map.put(val,1);//val of 1

			else //or set val to 1
			{
				int count = (int)(map.get(val)); // find frequency of word
				map.remove(val);  // remove the entry from map
				map.put(val,count+1); // re-inserting word and increase frequency by 1 increment
			}

		}

		//Retrieve map 
		Set<Map.Entry<String, Integer>> set = map.entrySet(); 
		//Make ArrayList and initialize ArrayList 
		List<Map.Entry<String, Integer>> sortList = new ArrayList<Map.Entry<String, Integer>>(set);
		//Sort ArrayList
		Collections.sort( sortList, new Comparator<Map.Entry<String, Integer>>() 

		{
			public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) 

			{
				// sortList in descending order 
				return ( b.getValue()).compareTo( a.getValue() );

			}

		} );

		//Print out the list
		for(Map.Entry<String, Integer> i:sortList){
			System.out.println("The word: " + i.getKey()+" - occurs this many times: "+ i.getValue());
		}
	}

	public void start(Stage arg0) throws Exception {
		Stage primaryStage = null;
		primaryStage.setTitle("The Raven Word Count");
		
		Button button = new Button();
		button.setText("Click this button");
		
		
		
		
		
	}

	
		
	}

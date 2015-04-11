package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class GraphSolver {
	
	public static String fileName = "grandpaTransitInput";
	private int townNumber;
	private int pathNumber;
	public static Map<Character, Queue<String>> paths = new HashMap<Character, Queue<String>>();

	private void fileOpener(String Filename){
		try {
			Scanner in = new Scanner(new FileReader(Filename + ".txt"));

			
			String lineNumber = in.nextLine();
			String[] numbers = lineNumber.split(" ");
			this.townNumber = Integer.parseInt(numbers[0]);
			System.out.println(townNumber);
			this.pathNumber = Integer.parseInt(numbers[1]);
			
			
			while (in.hasNextLine()){
				String hold = in.nextLine();
				mapMaker(hold);
			}
			
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		
	}
	
	private void mapMaker(String path){
		path.replaceAll("\\s+","");
		char[] hold = path.toCharArray();
		
		Queue<String> queueHolder = new PriorityQueue();
		
		
		if (!this.paths.containsKey(hold[0])){
			queueHolder.add(path);
			this.paths.put(hold[0], queueHolder);
		}
		
		else if (this.paths.containsKey(hold[0])){
			queueHolder = paths.get(hold[0]);
			queueHolder.add(path);
			this.paths.put(hold[0], queueHolder);
		}
			
		}
	
	
	public static void main(String[] args) {
		GraphSolver gs = new GraphSolver();
		gs.fileOpener(fileName);

	}

}

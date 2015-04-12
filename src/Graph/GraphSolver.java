package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphSolver {
	
	private String fileName = "grandpaTransitInput";
	private int townNumber;
	private int pathNumber;
	private Stack<String> desiredPath = new Stack<String>();
	public Map<Character, Queue<String>> paths = new HashMap<Character, Queue<String>>();

	private void fileOpener(String Filename){
		try {
			Scanner in = new Scanner(new FileReader(Filename + ".txt"));

			
			String lineNumber = in.nextLine();
			String[] numbers = lineNumber.split(" ");
			this.townNumber = Integer.parseInt(numbers[0]);
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
		path = path.replaceAll(" ","");
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
		//RouteFinder rf = new RouteFinder();
		
		Stack<String> answer = new Stack<String>();
		
		gs.fileOpener(gs.fileName);
		gs.desiredPath.push(gs.paths.get('A').peek());
		answer = gs.pathFinder(gs.paths.get('A').remove());
		
		for (String way : answer){
			System.out.println(way);
		}

	}

	public Stack<String> pathFinder(String direction){
		Queue<String> path = new PriorityQueue(); // these will store the looked at strings and return them to the queue on the map.
		char[] currentPath = direction.toCharArray();
		char[] comparePath = paths.get(currentPath[1]).peek().toCharArray();

		System.out.println(direction + "," + desiredPath.size());///////////////////////////
		if (currentPath[1] == 'i'){
			return desiredPath;
		}
		
		//else if (desiredPath.contains(direction)){
			//System.out.println("1");///////////////////////////////////////////
			//desiredPath.pop();
			
		//	path = paths.get(currentPath[0]);
			//path.remove();
			
		//	paths.put(currentPath[0], new PriorityQueue());
		//	paths.put(currentPath[0], path);
			
		//	return pathFinder(desiredPath.peek());
		//}
		
		else if( paths.get(currentPath[1]).isEmpty()){
			System.out.println("2");///////////////////////////////////////////////////////////////////////
			desiredPath.pop();
			return (pathFinder(desiredPath.peek()));
		}
		
		else if( currentPath[2] == comparePath[2] || currentPath[3] == comparePath[3] ){
			System.out.println("3"+ "," + desiredPath.size());///////////////////////////////////////////////////////////
			desiredPath.push(direction);
			return pathFinder(paths.get(currentPath[0]).remove());
		}
		
		else if( currentPath[2] != comparePath[2] && currentPath[3] != comparePath[3] ){
			System.out.println( paths.get(currentPath[1]).peek());///////////////////////////////////////////////////
			
			for (String searched : paths.get(currentPath[1])){
				System.out.println("4");//////////////////////////////////////////////////////////
				System.out.println(searched);/////////////////////////////////////////////////////
					return pathFinder(searched);
			}
		}
		
		System.out.println(desiredPath.peek());
		desiredPath.pop();
		return pathFinder(desiredPath.peek());
	}

}

package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import org.jgrapht.alg.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.DirectedGraph;


public class GraphSolver {
	
	private String fileName = "grandpaTransitInput";
	private int townNumber;
	private int pathNumber;
	private HashMap<String, String> paths = new HashMap<String, String>();
	private DirectedGraph<String, DefaultEdge> graph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
	
	public void fileOpener(String Filename){
		try {
			Scanner in = new Scanner(new FileReader(Filename + ".txt"));
			
			String lineNumber = in.nextLine();
			String[] numbers = lineNumber.split(" ");
			
			this.townNumber = Integer.parseInt(numbers[0]);
			this.pathNumber = Integer.parseInt(numbers[1]);
			
			while (in.hasNextLine()){
				String hold = in.nextLine().replaceAll(" ","");
				char[] path = hold.toCharArray();
				String key = "" + path[1] + path[0]; 
				String value = "" + path[2] + path[3];
				paths.put(key, value);
				key = "" + path[0] + path[1];
				paths.put(key, value);
				
				
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void graphMaker(){
		for (HashMap.Entry<String, String> currentPath : paths.entrySet()){
			for (HashMap.Entry<String, String> nextPath : paths.entrySet()){
				if(currentPath.getKey() != nextPath.getKey()){
					
					char[] current = currentPath.getKey().toCharArray();
					char[] next = nextPath.getKey().toCharArray();
					
					if(current[0] != next[1] && current[1] == next[0]){
						current = currentPath.getValue().toCharArray();
						next = nextPath.getValue().toCharArray();
						
						if(current[1] == next[1] || current[0] == next[0]){
		
							if(!graph.containsVertex(currentPath.getKey())){
								graph.addVertex(currentPath.getKey());
							}
							graph.addVertex(nextPath.getKey());
							graph.addEdge(currentPath.getKey(), nextPath.getKey());
						}
						
					}
				
				
			}
			}
		}
	}
	
	

    
	public static void main(String[] args) {
		GraphSolver gs = new GraphSolver();
		gs.fileOpener(gs.fileName);
		gs.graphMaker();
		DijkstraShortestPath<String, DefaultEdge> ds = new DijkstraShortestPath(gs.graph,"AB","ij");
		System.out.println(ds.getPathLength());
		System.out.println(ds.getPathEdgeList().toString());


	}
	
	
}

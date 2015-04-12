package Graph;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class RouteFinder {
/*private Stack<String> desiredPath = new Stack<String>();
GraphSolver gs = new GraphSolver();

public Stack<String> pathFinder(String direction){
	Queue<String> path = new PriorityQueue(); // these will store the looked at strings and return them to the queue on the map.
	char[] currentPath = direction.toCharArray();
	char[] comparePath = gs.paths.get(currentPath[1]).peek().toCharArray();

	
	if (currentPath[0] == 'i'){
		return desiredPath;
	}
	
	if (desiredPath.contains(direction)){
		desiredPath.pop();
		
		path = gs.paths.get(currentPath[0]);
		path.remove();
		
		gs.paths.put(currentPath[0], new PriorityQueue());
		gs.paths.put(currentPath[0], path);
		
		return pathFinder(desiredPath.peek());
	}
	
	if( gs.paths.get(currentPath[1]).isEmpty()){
		desiredPath.pop();
		return (pathFinder(desiredPath.peek()));
	}
	
	if( currentPath[3] == comparePath[3] || currentPath[4] == comparePath[4] ){
		desiredPath.push(direction);
		return pathFinder(gs.paths.get(currentPath[0]).remove());
	}
	
	if( currentPath[3] != comparePath[3] && currentPath[4] != comparePath[4] ){
		int fullCheck = 0;
		int full = gs.paths.get(currentPath[1]).size();
		
		for (String searched : gs.paths.get(currentPath[1])){
			fullCheck++;
			if(currentPath[3] == comparePath[3] || currentPath[4] == comparePath[4]){
				return pathFinder(searched);
			}
		}
	}
	
	desiredPath.pop();
	return pathFinder(desiredPath.peek());
}



	
	*/
		
		
	}

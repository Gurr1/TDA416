
import java.util.*;

public class DirectedGraph<E extends Edge> {
	List<List<E>> graph;
	public DirectedGraph(int noOfNodes) {
		graph = new ArrayList<>(noOfNodes);
		for(int i = 0; i < noOfNodes; i++) {
			graph.add(new ArrayList<>());
		}

	}

	public void addEdge(E e) {
		int from = e.getSource();
		graph.get(from).add(e);
	}

	public Iterator<E> shortestPath(int from, int to) {
	    List<Integer> visitedNodes = new ArrayList<>();
		PriorityQueue<CompDijkstraPath> paths = new PriorityQueue<>();
		paths.add(new CompDijkstraPath<>(from, 0, new ArrayList<E>()));
		while(!paths.isEmpty()){
		    CompDijkstraPath currentWeightedPath = paths.poll();
		    if(visitedNodes.contains(currentWeightedPath.getNode())){
		        if(currentWeightedPath.getNode() == to){
                     return currentWeightedPath.getPath().iterator();
                }
                else{
		            visitedNodes.add(currentWeightedPath.getNode());
		            for(E edge : graph.get(currentWeightedPath.getNode())){
		                if(!visitedNodes.contains(edge.getDest())){
		                    paths.add(new CompDijkstraPath(edge.getDest(), currentWeightedPath.getCost() + edge.getWeight(), currentWeightedPath.getPath().add(edge)))
                        }
                    }
                }
            }
        }
	}
		
	public Iterator<E> minimumSpanningTree() {
		return null;
	}

}
  


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

    /**
     * Calculates the shortest path from node A to node B
     * @param from Node A
     * @param to Node B
     * @return An iterator containing the edges that constitute the shortest path
     */
	public Iterator<E> shortestPath(int from, int to) {
	    List<Integer> visitedNodes = new ArrayList<>();
		PriorityQueue<CompDijkstraPath> paths = new PriorityQueue<>();  //Paths to explore
		paths.add(new CompDijkstraPath<>(from, 0, new ArrayList<E>())); //First path = just the first node
		while(!paths.isEmpty()){    
            CompDijkstraPath dijkstra = paths.poll();   //Gets the dijkstra object with the shortest unexplored path
		    int currentNode = dijkstra.getCurrentNode();
		    List<E> currentPath = dijkstra.getPath();
            if(!(visitedNodes.contains(currentNode))){
		        if(currentNode == to){  //Reached goal
                     return currentPath.iterator();
                }
                else{
		            visitedNodes.add(currentNode); 
		            for(E edge : graph.get(currentNode)){   //Adds all paths from the current node to pq
		                if(!visitedNodes.contains(edge.getDest())){
		                	List<E> list = new ArrayList<>(currentPath);
		                	list.add(edge);
		                    paths.add(new CompDijkstraPath(edge.getDest(), dijkstra.getCost() + edge.getWeight(), list));
                        }
                    }
                }
            }
        }
        return null;
	}

    /**
     * Calculates the minimum set of edges that with the minimum cost connects all the nodes to each other
     * @return An iterator containing the edges mentioned above
     */
	public Iterator<E> minimumSpanningTree() {
	    List <List<E>> cc = new ArrayList<>();
        PriorityQueue<CompKruskalEdge> pq = new PriorityQueue<>();

        for(List<E> neighbours : graph) { //Adds all the edges as comparable Kruskal edges to the priority queue
            for (E edge : neighbours) {
                pq.add(new CompKruskalEdge(edge.getSource(), edge.getDest(), edge.getWeight()));
            }
			cc.add(new ArrayList<>());  //Adds one empty list for each node to cc
        }

		int nRepointed = 0; //To make it possible to see when all the pointers in cc points to the same list
        while(!pq.isEmpty() && nRepointed < (cc.size() - 1)){
            CompKruskalEdge e = pq.poll();      //Get shortest edge in pq
            List<E> from = cc.get(e.getFrom());
            List<E> to = cc.get(e.getTo());
            if(from != to){     //If nodes on edge not already connected ...
            	if(from.size() > to.size()){
                    repoint(to, from, cc);
                    from.add((E) e);
                } else {
                    repoint(from, to, cc);
                    to.add((E) e);
                }
                nRepointed++;
            }
        }
        return cc.get(0).iterator();
    }

    /**
     * Redirects every pointer in a list of lists pointing at the old list to pointing at the new list
     * @param old The old list
     * @param newListPointer The new list
     * @param cc The list of lists
     */
    private void repoint(List<E> old, List<E> newListPointer, List<List<E>> cc) {
        newListPointer.addAll(old);
        for(int i = 0; i < cc.size() ; i++){
            if(cc.get(i) == old){
                cc.set(i, newListPointer);
            }
        }
    }


}
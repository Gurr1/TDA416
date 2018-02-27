
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
		    if(!(visitedNodes.contains(currentWeightedPath.getNode()))){
		        if(currentWeightedPath.getNode() == to){
                     return currentWeightedPath.getPath().iterator();
                }
                else{
		            visitedNodes.add(currentWeightedPath.getNode());
		            for(E edge : graph.get(currentWeightedPath.getNode())){
		                if(!visitedNodes.contains(edge.getDest())){
		                	List<E> list = new ArrayList<>(currentWeightedPath.getPath());
		                	list.add(edge);
		                    paths.add(new CompDijkstraPath(edge.getDest(), currentWeightedPath.getCost() + edge.getWeight(), list));
                        }
                    }
                }
            }
        }
        return null;
	}
		
	public Iterator<E> minimumSpanningTree() {
	    List <List<E>> cc = new ArrayList<>();
        PriorityQueue<CompKruskalEdge> pq = new PriorityQueue<>();
        for(List<E> neighors : graph) {
            for (E node : neighors) {
                pq.add(new CompKruskalEdge(node.getSource(), node.getDest(), node.getWeight(), ""));
                cc.add(new ArrayList<>());
            }
        }
        while(!pq.isEmpty()){
            CompKruskalEdge e = pq.poll();
            if(cc.get(e.getFrom()) != cc.get(e.getTo())){
                if(cc.get(e.getFrom()).size() > cc.get(e.getTo()).size()){
                    cc.get(e.getFrom()).addAll(cc.get(e.getTo()));
                    List<E> reference = cc.get(e.getTo());
                    for(int i = 0; i < cc.size() ; i++){
                        if(cc.get(i) == reference){
                            cc.add(cc.get(e.getFrom()));
                        }
                    }
                    cc.get(e.getFrom()).add((E) e);
                }
                else{
                    cc.get(e.getTo()).addAll(cc.get(e.getFrom()));
                    List<E> reference = cc.get(e.getFrom());
                    for(int i = 0; i < cc.size() ; i++){
                        if(cc.get(i) == reference){
                            cc.add(cc.get(e.getTo()));
                        }
                    }
                    cc.get(e.getTo()).add((E) e);
                }
                }
            }
        return cc.get(0).iterator();

    }
	}
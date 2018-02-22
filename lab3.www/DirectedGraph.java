
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
	    List <E>[]cc = new ArrayList[graph.size()];
        PriorityQueue<CompKruskalEdge> pq = new PriorityQueue<>();
        for(List<E> neighors : graph) {
            for (E node : neighors) {
                pq.add(new CompKruskalEdge(node.getSource(), node.getDest(), node.getWeight()));
            }
        }
        while(!pq.isEmpty() && cc.length>1){
            CompKruskalEdge e = pq.poll();
            if(cc[e.getFrom()] != cc[e.getTo()]){
                if(cc[e.getFrom()].size() > cc[e.getTo()].size()){
                    cc[e.getFrom()].addAll(cc[e.getTo()]);
                    List<E> reference = cc[e.getTo()];
                    for(int i = 0; i < cc.length ; i++){
                        if(cc[i] == reference){
                            cc[i] = cc[e.getFrom()];
                        }
                    }
                    cc[e.getFrom()].add((E) e);
                }
                else{
                    cc[e.getTo()].addAll(cc[e.getFrom()]);
                    List<E> reference = cc[e.getFrom()];
                    for(int i = 0; i < cc.length ; i++){
                        if(cc[i] == reference){
                            cc[i] = cc[e.getTo()];
                        }
                    }
                    cc[e.getTo()].add((E) e);
                }

                }

            }
        System.out.println(cc[0]);
        return cc[0].iterator();

    }
	}

  

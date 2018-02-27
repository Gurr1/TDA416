import java.util.List;

public class CompDijkstraPath <E extends Edge> implements Comparable<CompDijkstraPath>{
    private int currentNode;
    private double cost;
    /**
     * The Path that has been taken thus far.
     */
    private List<E> path;
    CompDijkstraPath(int node, double cost, List<E> path){
        this.currentNode = node;
        this.cost = cost;
        this.path = path;
    }

    /**
     * Compares which of two CompDijsktraObjects has the least cost to move to each of the nodes.
     * @param c an CompDijkstraPath object to compare to.
     * @return -1 if the first dijkstra path has the least cost. 0 if they have equal cost. 1 if the second has smallest cost.
     */
    @Override
    public int compareTo(CompDijkstraPath c) {
        if(this.cost < c.cost){
            return -1;
        }
        else if(this.cost > c.cost){
            return 1;
        }
        return 0;
    }

    public int getCurrentNode() {
        return currentNode;
    }

    public double getCost() {
        return cost;
    }

    public List<E> getPath() {
        return path;
    }
}

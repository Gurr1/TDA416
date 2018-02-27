import java.util.List;

public class CompDijkstraPath <E extends Edge> implements Comparable<CompDijkstraPath>{
    private int currentNode;
    private double cost;
    private List<E> path;
    CompDijkstraPath(int node, double cost, List<E> path){
        this.currentNode = node;
        this.cost = cost;
        this.path = path;
    }

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

import java.util.List;

public class CompDijkstraPath <E extends Edge> implements Comparable<CompDijkstraPath>{
    private int node;
    private double cost;
    private List<E> path;
    CompDijkstraPath(int node, double cost, List<E> path){
        this.node = node;
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

    public int getNode() {
        return node;
    }

    public double getCost() {
        return cost;
    }

    public List<E> getPath() {
        return path;
    }
}

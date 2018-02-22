public class CompKruskalEdge extends Edge implements Comparable<CompKruskalEdge>{
    private double weight;
    CompKruskalEdge(int from, int to, double weight) {
        super(from, to);
        this.weight = weight;
    }

    @Override
    public int compareTo(CompKruskalEdge kruscalEdge) {
        if(this.weight < kruscalEdge.weight){
            return -1;
        }
        else if(this.weight > kruscalEdge.weight){
            return 1;
        }
        return 0;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }
}

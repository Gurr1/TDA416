public class CompKruskalEdge extends BusEdge implements Comparable<CompKruskalEdge>{
    private double weight;
    CompKruskalEdge(int from, int to, double weight) {
        super(from, to, weight, "");
        this.weight = weight;
    }

    @Override
    public int compareTo(CompKruskalEdge kruscalEdge) {     // only used by the priority-queue, compares the weight of different paths.
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

    @Override
    public String toString() {
        return "CompKruskalEdge{" + from + "-" + to + " " +
                "weight=" + weight +
                '}' + "\n";
    }
}

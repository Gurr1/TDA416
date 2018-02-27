public class CompKruskalEdge extends BusEdge implements Comparable<CompKruskalEdge>{
    private double weight;
    CompKruskalEdge(int from, int to, double weight, String s) {
        super(from, to, weight, s);
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

    @Override
    public String toString() {
        return "CompKruskalEdge{" + from + "-" + to + " " +
                "weight=" + weight +
                '}' + "\n";
    }
}

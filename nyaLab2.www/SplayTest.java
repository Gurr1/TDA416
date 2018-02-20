public class SplayTest {

    public static void main(String[] args) {
        new SplayTest().program();
    }

    private void program() {
        SplayWithGet<Integer> tree = new SplayWithGet<>();

        tree.add(5);
        tree.add(3);
        tree.add(6);
        tree.add(9);
        tree.add(1);
        tree.add(-2);

        System.out.println(tree.toString());

        tree.get((Integer) 1);

        System.out.println(tree.toString());
    }
}

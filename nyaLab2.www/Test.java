public class Test {

    public static void main(String[] args) {
        new Test().program();
    }

    private void program() {
        SplayWithGet<Integer> tree = new SplayWithGet<>();

        tree.add(5);
        tree.add(3);
        tree.add(6);
        tree.add(9);
        tree.add(1);
        tree.add(-2);
        tree.add(-100);
        tree.add(-72);
        tree.add(13);
        tree.add(23);
        tree.add(-110);
        tree.add(88);
        tree.add(89);
        tree.add(90);

        System.out.println(tree.toString());


        System.out.println("23-->");
        tree.get(23);
        System.out.println(tree);
        System.out.println("1-->");
        tree.get(1);
        System.out.println(tree);
        System.out.println("-110-->");
        tree.get(-110);
        System.out.println(tree);
        System.out.println("1-->");
        tree.get(1);
        System.out.println(tree);

    }
}

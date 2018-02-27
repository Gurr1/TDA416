import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Main {


    public void main(String[] cheese) {
        Scanner in = new Scanner(System.in);
        System.out.println("antal siffror");
        int number = in.nextInt();
        System.out.println("var n:te");
        int nte = in.nextInt();
        Node firstNode = new Node(0);
        Node <Integer> lastNode = firstNode;
        for (int i = 0; i < number - 1; i++) {
            Node<Integer> node = new Node<>(i + 1);
            node.setPreviousNode(lastNode);
            lastNode = node;
        }
        Node <Integer> finishNode = new Node(number);
        finishNode.setPreviousNode(lastNode);
    }
}

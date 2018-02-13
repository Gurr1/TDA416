import java.util.Stack;

public class SplayWithGet <E extends Comparable<? super E>> extends BinarySearchTree<E> implements CollectionWithGet<E>{
    enum Direction{
        LEFT, RIGHT, ROOT;
    }
    Stack <Direction> directions = new Stack<>();
    @Override
    public E get(E e) {
        int i = 0;
        Entry node = find(e, root);
        if(node == null){
            return null;
        }
   /*     while(!directions.isEmpty()){
            Direction parent = directions.pop();
            Direction grandparent = Direction.ROOT;
            if(!directions.isEmpty()){
                grandparent = directions.pop();
            }
            if(parent.equals(Direction.LEFT)){
                if(grandparent.equals(Direction.LEFT)){
                    zagZag(node.parent.parent);
                    node = node.parent.parent;
                    continue;
                }
                if(grandparent.equals(Direction.RIGHT)){
                    zagZig(node.parent.parent);
                    node = node.parent.parent;
                    continue;
                }
                zig(node.parent);

            }
            if(parent.equals(Direction.RIGHT)){

            }
        }*/
        while(node.parent != null && node.parent.parent != null) {
            i++;
            Entry grandParent = node.parent.parent;
            if(grandParent.right != null && node.equals(grandParent.right.right)){
                //System.out.println("zigzig");
                zigZig(grandParent);
            }
            else if(grandParent.right != null && node.equals(grandParent.right.left)){
                //System.out.println("zigzag");
                zigZag(grandParent);
            }
            else if(grandParent.left != null && node.equals(grandParent.left.right)){
                //System.out.println("zagzig");
                zagZig(grandParent);
            }
            else if(grandParent.left != null && node.equals(grandParent.left.left)){
                //System.out.println("zagzag");
                zagZag(grandParent);
            }
            node = grandParent;
        }
            if (node.parent != null) {
                Entry parent = node.parent;
                if (node.equals(parent.right)) {
                    zig(parent);
                }
                if (node.equals(parent.left)) {
                    zag(parent);
                }
            }
            if(!(e.equals(node.element))){
                return null;
            }
        return node.element;
    }
    public Entry find(E element, Entry root){
            if ( root == null )
                return null;
            else {
                int jfr = element.compareTo( root.element );
                if ( jfr  < 0 ) {
                    directions.push(Direction.LEFT);
                    if(root.left == null) {
                        return root;
                    }
                    return find(element, root.left);
                }
                else if ( jfr > 0 ) {
                    directions.push(Direction.RIGHT);
                    if(root.right == null){
                        return root;
                    }
                    return find(element, root.right);
                }
                else
                    return root;
            }
        }  //   find
    private void zagZig( Entry x ) {
        Entry y = x.left,
                z = x.left.right;
        E e = x.element;
        x.element = z.element;
        z.element = e;
        y.right = z.left;
        if (y.right != null)
            y.right.parent = y;
        z.left = z.right;
        z.right = x.right;
        if (z.right != null)
            z.right.parent = z;
        x.right = z;
        z.parent = x;
    }
    private void zag( Entry x ) {
        Entry y = x.left;
        E temp = x.element;
        x.element = y.element;
        y.element = temp;
        x.left = y.left;
        if (x.left != null)
            x.left.parent = x;
        y.left = y.right;
        y.right = x.right;
        if (y.right != null)
            y.right.parent = y;
        x.right = y;
    }
    private void zig( Entry x ) {
        Entry y = x.right;
        E temp = x.element;
        x.element = y.element;
        y.element = temp;
        x.right = y.right;
        if (x.right != null)
            x.right.parent = x;
        y.right = y.left;
        y.left = x.left;
        if (y.left != null)
            y.left.parent = y;
        x.left = y;
    }
    private void zigZag( Entry x ) {
        Entry y = x.right,
                z = x.right.left;
        E e = x.element;
        x.element = z.element;
        z.element = e;
        y.left = z.right;
        if (y.left != null)
            y.left.parent = y;
        z.right = z.left;
        z.left = x.left;
        if (z.left != null)
            z.left.parent = z;
        x.left = z;
        z.parent = x;
    }
    private void zigZig(Entry z){
        Entry y = z.right;
        Entry x = z.right.right;
        E temp = x.element;
        x.element = z.element;
        z.element = temp;
        z.right = x.right;
        if(z.right != null){
            z.right.parent = z;
        }
        y.right = x.left;
        if(y.right != null) {
            y.right.parent = y;
        }
        x.right = y.left;
        if(x.right != null){
            x.right.parent = x;
        }
        x.left = z.left;
        if(x.left != null){
            x.left.parent = x;
        }
        y.left = x;
        x.parent = y;
        z.left = y;
        y.parent = z; 
    }
    private void zagZag(Entry z){
        Entry y = z.left;
        Entry x = z.left.left;
        E temp = x.element;
        x.element = z.element;
        z.element = temp;
        z.left = x.left;
        if(z.left != null){
            z.left.parent = z;
        }
        y.left = x.right;
        if(y.left != null) {
            y.left.parent = y;
        }
        x.left = y.right;
        if(x.left != null){
            x.left.parent = x;
        }
        x.right = z.right;
        if(x.right != null){
            x.right.parent = x;
        }
        y.right = x;
        x.parent = y;
        z.right = y;
        y.parent = z;
    }
}

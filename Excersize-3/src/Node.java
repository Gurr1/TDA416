public class Node <E>{
    private Node nextNode;
    private Node previousNode;
    private E content;
    public Node(E content){
        this.content = content;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }
    public void setPreviousNode(Node previousNode){
        this.previousNode = previousNode;
    }
    public Node getNextNode(){
        return nextNode;
    }
    public E getContent() {
        return content;
    }
    public Node getPreviousNode(){
        return previousNode;
    }
}

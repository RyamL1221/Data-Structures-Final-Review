public class Queue<T> {

    private LinkedList<T> linkedList;

    //size of linked list 
    private int n;

    // default constructor
    public Queue() {
        linkedList = new LinkedList<T>();
    }
    
    public boolean isEmpty() { 
        if(n == 0) return true;
        return false;
    }
    
    public void enqueue(Node<T> node) {
        linkedList.add(node);
    }

    public Node<T> dequeue() {
        return linkedList.delete(n);
    }

    public Node<T> peek() {
        return linkedList.search(0);
    }

    public int size() {
        return n;
    }
}

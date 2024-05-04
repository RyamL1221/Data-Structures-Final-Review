public class Stack<T> {
    private LinkedList<T> linkedList;
    private int n;

    public Stack() {
        linkedList = new LinkedList<T>();
    }
    
    public boolean isEmpty() {
        if (n == 0) return true;
        return false;
    }

    public void push(Node<T> node) {
        linkedList.addToFront(node);
        n++;
    }

    public Node<T> pop() {
        return linkedList.delete(0);
    }

    public Node<T> peek() {
        return linkedList.search(0);
    }

    public int size() {
        return n;
    }
}

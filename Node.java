public class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> prev;
    private Node<T> right;
    private Node<T> left;

    public Node(T data) {
        this.data = data;
    }

    /*
     * Getters and setters
     */
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public Node<T> getNext() { return next; }
    public void setNext(Node<T> next) { this.next = next; }
    public Node<T> getPrev() { return prev; }
    public void setPrev(Node<T> prev) { this.prev = prev; }
    public Node<T> getRight() {return right; }
    public void setRight(Node<T> right) { this.right = right; }
    public Node<T> getLeft() { return left; }
    public void setLeft(Node<T> left) { this.left = left;} 

}

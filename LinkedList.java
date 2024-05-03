public class LinkedList<T> {
    private Node<T> root;
    private int n;

    public Node<T> getRoot() { return root; }
    public void setRoot(Node<T> root) { this.root = root; }

    /*
     * Appends node to end
     * @param node - node that will be appended at the end
     */
    public void add(Node<T> node) {
        if(node == null) {
            return;
        }
        if(root == null) { 
            root = node; 
            return;
        }
        Node<T> curr = node;
        while(curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(node);
        n++;
    }

    public void addToFront(Node<T> node) {
        node.setNext(root);
        root = node;
        n++;
    }

    public Node<T> search(T data) {
        Node<T> curr = root;
        while(curr != null) {
            if(curr.getData() == data) return curr;
        }
        return null;
    }

    public Node<T> search(int index) {
        if(index >= n) return null;
        int currIndex = 0;
        Node<T> curr = root;
        while(currIndex != index) {
            currIndex++;
            curr = curr.getNext();
        }
        return curr;
    }

    public Node<T> delete(T data) {
        Node<T> curr = root;
        Node<T> prev = curr;
        while(curr != null) {
            if(curr.getData().equals(data)) {
                Node<T> temp = curr;
                prev.setNext(curr.getNext());
                return temp;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return null;
    }
    
    public Node<T> delete(int index) {
        if(index >= n) {
            return null;
        }
        Node<T> curr = root; 
        Node<T> prev = curr;
        int currIndex = 0; 
        while(currIndex != index) {
            prev = curr;
            curr = curr.getNext();
            currIndex++;
        }
        Node<T> temp = curr;
        prev.setNext(curr.getNext());
        return temp;
    }
}

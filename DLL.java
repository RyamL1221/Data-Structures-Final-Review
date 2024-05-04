public class DLL<T>{

    private Node<T> root;
    private int n;

    // default constructor
    public DLL () {}

    public void add(Node<T> node) {
        if(node == null) {
            return;
        }
        if(root == null) {
            root = node;
            return;
        }
        Node<T> curr = root;
        while(curr.getNext() != null) { curr = curr.getNext(); }
        curr.setNext(node);
        node.setPrev(curr);
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

    public int size() { return n; }
}

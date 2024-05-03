public class LinkedList {
    private Node root;

    public Node getRoot() { return root; }
    public void setRoot(Node root) { this.root = root; }

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() { return data; }
        public void setData(int data) { this.data = data; }
        public Node getNext() { return next; }
        public void setNext(Node next) { this.next = next; }
    }

    public void add(Node node) {
        if(node == null) {
            return;
        }
        if(root == null) { 
            root = node; 
            return;
        }
        Node curr = node;
        while(curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(node);
    }

    public Node search(int data) {
        Node curr = root;
        while(curr != null) {
            if(curr.getData() == data) return curr;
        }
        return null;
    }

    public void delete(int data) {
        Node curr = root;
        Node prev = curr;
        while(curr != null) {
            if(curr.getData() == data) {
                prev.setNext(curr.getNext());
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }       
}

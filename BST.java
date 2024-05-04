public class BST<T extends Comparable<T>> {
    private Node<T> root;
    public BST() {} 

    public void insert(Node<T> node) {
        if(root == null) {
            root = node;
            return;
        }
        Node<T> curr = root;
        Node<T> prev = curr;
        boolean wentRight = false;
        T data = node.getData();
        while(curr != null) {
            prev = curr;
            if(data.compareTo(curr.getData()) < 0) { curr = curr.getLeft(); wentRight = false; }
            else { curr = curr.getRight(); wentRight = true; }
        }
        if(wentRight) prev.setRight(node);
        else prev.setLeft(node);
    }
}

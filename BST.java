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

    public Node<T> search(T data) {
        Node<T> curr = root;
        Node<T> prev = curr;
        while(curr != null) {
            prev = curr;
            int comparison = data.compareTo(curr.getData());
            if(comparison < 0) curr = curr.getLeft();
            else if(comparison == 0) return curr;
            else curr = curr.getRight();
        }
        return null; 
    }

    public void delete(T data) {
        Node<T> delete = search(data);
        int numChild = 0;
        if(delete.getRight() == null) numChild++;
        if(delete.getLeft() == null) numChild++;
        if(numChild == 0) delete = null;
        else if(numChild == 1) {
            if(delete.getRight() != null) {
                delete.setData(delete.getRight().getData());
                delete.setRight(delete.getRight().getRight());
                delete.setLeft(delete.getRight().getLeft());
            } else {
                delete.setData(delete.getLeft().getData());
                delete.setRight(delete.getLeft().getRight());
                delete.setLeft(delete.getLeft().getLeft());
            }
        } 
        else {
            Node<T> inOrderSuccessor = delete.getRight();
            while(inOrderSuccessor.getLeft() != null) {
                inOrderSuccessor = inOrderSuccessor.getLeft();
            }
            T temp = delete.getData();
            delete.setData(inOrderSuccessor.getData());
            inOrderSuccessor.setData(temp);
            delete(inOrderSuccessor.getData());
        }
    }
}

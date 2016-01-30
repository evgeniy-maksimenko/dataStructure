package gontsov.trees;


import gontsov.lists.AList0;
import gontsov.patterns.Vizitor;

import java.util.Iterator;
public class BsTree implements ETree, Iterable<Integer> {


    Node root;

    public void init(int[] arr) {
        for (int anArr : arr) {
            add(anArr);
        }
    }
    private void printTree(Node node) {
        if (node == null)
            return;
        printTree(node.leftChild);
        System.out.print(node.val + " ");
        printTree(node.rightChild);


    }

    @Override
    public void add(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        addTree(root, val);
    }

    private void addTree(Node node, int val) {
        if (node.val < val) {
            if (node.leftChild == null)
                node.leftChild = new Node(val);
            else
                addTree(node.leftChild, val);
        } else {
            if (node.rightChild == null)
                node.rightChild = new Node(val);
            else
                addTree(node.rightChild, val);
        }
    }


    @Override
    public int size() {
        Vizitor vizitor = new Vizitor();
        size(root, vizitor);
        return vizitor.getI();
    }

    private void size(Node node, Vizitor vizitor) {
        if (node == null)
            return;
        size(node.leftChild, vizitor);
        vizitor.action(node);
        size(node.rightChild, vizitor);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Object[] toArray() {
        AList0<Integer> list = new AList0<Integer>();
        toArray(root, list);
        return list.toArray();
    }

    private void toArray(Node node, AList0 list) {
        if (node == null) return;
        toArray(node.leftChild, list);
        list.addStart(node.val);
        toArray(node.rightChild, list);
    }


    @Override
    public int leafs() {
        Vizitor vizitor = new Vizitor();
        leafs(root, vizitor);
        return vizitor.getI();
    }

    private void leafs(Node node, Vizitor vizitor) {
        if (node == null) {
            return;
        }
        leafs(node.leftChild, vizitor);
        if (node.leftChild == null && node.rightChild == null) {
            vizitor.action(node);
        }
        leafs(node.rightChild, vizitor);
    }

    @Override
    public int nodes() {

        Vizitor vizitor = new Vizitor();
        nodes(root, vizitor);
        return vizitor.getI();
    }

    private void nodes(Node node, Vizitor vizitor) {
        if (node == null) {
            return;
        }

        nodes(node.leftChild, vizitor);
        if (node.leftChild != null && node.rightChild != null) {
            vizitor.action(node);
        }
        nodes(node.rightChild, vizitor);

    }


    @Override
    public int width() {
        int maxWidth = 0;
        for (int k = 0; k < height(); k++) {
            int width = width(root, k);
            if (width > maxWidth)
                maxWidth = width;
        }
        return maxWidth;
    }

    private int width(Node node, int depth) {
        if (node == null)
            return 0;
        if (depth == 0)
            return 1;
        else
            return width(node.leftChild, depth - 1) + width(node.rightChild, depth - 1);
    }

    @Override
    public void reverse() {
        reverse(root);
    }

    private void reverse(Node node) {
        if (node == null)
            return;

        if (node.leftChild != null && node.rightChild != null) {
            Node newNode = node.leftChild;
            node.leftChild = node.rightChild;
            node.rightChild = newNode;
        }


        reverse(node.leftChild);
        reverse(node.rightChild);
    }

    public Iterator<Integer> iterator() {
        return new AList1Iterator(toArray());
    }

    class AList1Iterator implements Iterator<Integer> {

        int i = 0;
        Object[] arr = new Object[]{};

        public AList1Iterator(Object[] arr) {
            this.arr = arr;

        }

        @Override
        public boolean hasNext() {
            return i < arr.length;
        }

        @Override
        public Integer next() {
            return (Integer) arr[i++];
        }
    }
}

package gontsov;

import java.util.Iterator;

public class BsTree implements ETree, Iterable<Integer> {
    private int size = 0;
    private int height = 0;

    class Node {
        int val;
        Node leftChild;
        Node rightChild;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;

    public void init(int[] arr) {
        for (int anArr : arr) {
            add(anArr);
        }
    }

    public void print() {
        printTree(root);
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
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        int i = 0;
        i += size(node.leftChild);
        i++;
        i += size(node.rightChild);
        return i;
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
    public int[] toArray() {
        AList0 list = new AList0();
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
        return leafs(root);
    }

    private int leafs(Node node) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        res += leafs(node.leftChild);
        if (node.leftChild == null && node.rightChild == null) {
            res++;
        }
        res += leafs(node.rightChild);

        return res;
    }

    @Override
    public int nodes() {
        return nodes(root);
    }

    private int nodes(Node node) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        res += nodes(node.leftChild);
        if (node.leftChild != null && node.rightChild != null) {
            res++;
        }
        res += nodes(node.rightChild);

        return res;
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
        int[] arr = new int[]{};

        public AList1Iterator(int[] arr) {
            this.arr = arr;

        }

        @Override
        public boolean hasNext() {
            return i < arr.length;
        }

        @Override
        public Integer next() {
            return arr[i++];
        }
    }
}

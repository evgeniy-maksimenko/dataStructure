package gontsov;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BsTree theTree = new BsTree();
        theTree.init(new int[] {123,54,6,6,778,234,45,5,7,878,45});
        System.out.println(Arrays.toString(theTree.toArray()));
        theTree.reverse();
        System.out.println(Arrays.toString(theTree.toArray()));
        System.out.println("");
        theTree.print();
    }
}

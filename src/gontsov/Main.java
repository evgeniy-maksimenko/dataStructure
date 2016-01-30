package gontsov;

import gontsov.hashTables.HashIndex;
import gontsov.hashTables.HashTable;
import gontsov.linkedLists.LinkedList;
import gontsov.lists.AList2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AList2<Integer> theList = new AList2<Integer>();
        /*
        theList.init(new Integer[]{100,200,300,400,500,600,700,800,900});
        System.out.println(theList.max());
        System.out.println(theList.size());
        System.out.println(Arrays.toString(theList.toArray()));
        System.out.println(theList.size());
        System.out.println(Arrays.toString(theList.toArray()));
        */

        theList.addStart(100);
        theList.addStart(200);
        theList.addStart(300);

        for (Integer l : theList) {
            System.out.println(l);
        }

//        theList.addStart(20);
//

//        theList.addEnd(100);
//        theList.addEnd(200);


//        theList.addPos(1, 1000);
//        theList.delStart();
//        theList.delPos(1);
//        theList.delEnd();

//        System.out.println("min = "+theList.min());
//        System.out.println("max = "+theList.max());
//        System.out.println("maxIndex = "+theList.maxIndex());
//        System.out.println("minIndex = "+theList.minIndex());
//        System.out.println(Arrays.toString(theList.toArray()));
//        theList.reverse();

//        System.out.println(Arrays.toString(theList.toArray()));
//        System.out.println("");

    }
}

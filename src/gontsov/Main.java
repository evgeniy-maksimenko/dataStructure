package gontsov;

import gontsov.hashTables.HashIndex;
import gontsov.hashTables.HashTable;
import gontsov.linkedLists.LinkedList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        HashTable theTable = new HashTable();
        theTable.init(new int[]{100,200,300,400,500,600,700,800,900});
        System.out.println(theTable.size());
        System.out.println(Arrays.toString(theTable.toArray()));
        System.out.println(theTable.find(800));
        System.out.println(theTable.del(800));
        System.out.println(theTable.size());
        System.out.println(Arrays.toString(theTable.toArray()));



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

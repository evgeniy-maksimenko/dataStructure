package gontsov;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AList1 theList = new AList1();
        theList.init(new int[]{100,200,300,400,500});

        theList.addPos(2,10);
        System.out.println(theList.size());
        System.out.println(Arrays.toString(theList.toArray()));


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

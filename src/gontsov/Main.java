package gontsov;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AList2 theList = new AList2();
        theList.init(new int[] {1,2,3,4,5,6});
        System.out.println(theList.size());

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
        System.out.println(Arrays.toString(theList.toArray()));
//        theList.reverse();
//        System.out.println(Arrays.toString(theList.toArray()));
//        System.out.println(Arrays.toString(theList.toArray()));
//        System.out.println("");

    }
}

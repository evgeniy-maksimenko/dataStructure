import gontsov.AList0;
import gontsov.AList1;
import gontsov.EList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class AlistTest {
    EList aList;

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new AList0()},
                {new AList1()}
        });
    }

    public AlistTest(EList listObj) {
        aList = listObj;

    }

    @Test
    public void testAddStart1() {
        aList.clear();
        aList.addStart(100);
        assertEquals(1, aList.size());
        assertArrayEquals(new int[]{100}, aList.toArray());
    }

    @Test
    public void testAddStart2() {
        aList.clear();
        aList.addStart(100);
        aList.addStart(200);
        assertEquals(2, aList.size());
        assertArrayEquals(new int[]{200,100}, aList.toArray());
    }

    @Test
    public void testAddStart3() {
        aList.clear();
        aList.addStart(100);
        aList.addStart(200);
        aList.addStart(300);
        assertEquals(3, aList.size());
        assertArrayEquals(new int[]{300,200,100}, aList.toArray());
    }


    @Test
    public void testAddStart4() {
        aList.clear();
        aList.addStart(100);
        aList.addStart(200);
        aList.addStart(300);
        aList.addStart(400);
        assertEquals(4, aList.size());
        assertArrayEquals(new int[]{400,300,200,100}, aList.toArray());
    }

    @Test
    public void testAddEnd1() {
        aList.clear();
        aList.addEnd(100);
        assertEquals(1, aList.size());
        assertArrayEquals(new int[]{100}, aList.toArray());
    }

    @Test
    public void testAddEnd2() {
        aList.clear();
        aList.addEnd(100);
        aList.addEnd(200);
        assertEquals(2, aList.size());
        assertArrayEquals(new int[]{100,200}, aList.toArray());
    }

    @Test
    public void testAddEnd3() {
        aList.clear();
        aList.addEnd(100);
        aList.addEnd(200);
        aList.addEnd(300);
        assertEquals(3, aList.size());
        assertArrayEquals(new int[]{100,200,300}, aList.toArray());
    }

    @Test
    public void testAddEnd4() {
        aList.clear();
        aList.addEnd(100);
        aList.addEnd(200);
        aList.addEnd(300);
        aList.addEnd(400);
        assertEquals(4, aList.size());
        assertArrayEquals(new int[]{100,200,300,400}, aList.toArray());
    }

    @Test
    public void testAddPos1() {
        aList.clear();
        aList.init(new int[]{1,2,3,4,5});
        assertEquals(5, aList.size());
        assertArrayEquals(new int[]{1,2,3,4,5}, aList.toArray());
        aList.addPos(0,100);
        assertEquals(6, aList.size());
        assertArrayEquals(new int[]{100,1,2,3,4,5}, aList.toArray());
    }

    @Test
    public void testAddPos2() {
        aList.clear();
        aList.init(new int[]{1,2,3,4,5});
        assertEquals(5, aList.size());
        assertArrayEquals(new int[]{1,2,3,4,5}, aList.toArray());
        aList.addPos(1,100);
        assertEquals(6, aList.size());
        assertArrayEquals(new int[]{1,100,2,3,4,5}, aList.toArray());
    }

    @Test
    public void testAddPos3() {
        aList.clear();
        aList.init(new int[]{1,2,3,4,5});
        assertEquals(5, aList.size());
        assertArrayEquals(new int[]{1,2,3,4,5}, aList.toArray());
        aList.addPos(3,100);
        assertEquals(6, aList.size());
        assertArrayEquals(new int[]{1,2,3,100,4,5}, aList.toArray());
    }

    @Test
    public void testAddPos4() {
        aList.clear();
        aList.init(new int[]{1,2,3,4,5});
        assertEquals(5, aList.size());
        assertArrayEquals(new int[]{1,2,3,4,5}, aList.toArray());
        aList.addPos(4,100);
        assertEquals(6, aList.size());
        assertArrayEquals(new int[]{1,2,3,4,100,5}, aList.toArray());
    }

    @Test
    public void testDelStart1() {
        aList.init(new int[]{120});
        assertEquals(1, aList.size());
        int Actual = aList.delStart();
        assertEquals(0, aList.size());
        assertEquals(120, Actual);
        assertArrayEquals(new int[]{}, aList.toArray());
    }

    @Test
    public void testDelStart2() {
        aList.init(new int[]{240,120});
        assertEquals(2, aList.size());
        int Actual = aList.delStart();
        assertEquals(1, aList.size());
        assertEquals(240, Actual);
        assertArrayEquals(new int[]{120}, aList.toArray());
    }

    @Test
    public void testDelStart3() {
        aList.init(new int[]{700,240,120});
        assertEquals(3, aList.size());
        int Actual = aList.delStart();
        assertEquals(2, aList.size());
        assertEquals(700, Actual);
        assertArrayEquals(new int[]{240, 120}, aList.toArray());
    }

    @Test
    public void testDelEnd1() {
        aList.init(new int[]{700,240,120});
        assertEquals(3, aList.size());
        int Actual = aList.delEnd();
        assertEquals(2, aList.size());
        assertEquals(120, Actual);
        assertArrayEquals(new int[]{700,240}, aList.toArray());
    }

    @Test
    public void testDelEnd2() {
        aList.init(new int[]{700,240});
        assertEquals(2, aList.size());
        int Actual = aList.delEnd();
        assertEquals(1, aList.size());
        assertEquals(240, Actual);
        assertArrayEquals(new int[]{700}, aList.toArray());
    }

    @Test
    public void testDelEnd3() {
        aList.init(new int[]{700});
        assertEquals(1, aList.size());
        int Actual = aList.delEnd();
        assertEquals(0, aList.size());
        assertEquals(700, Actual);
        assertArrayEquals(new int[]{}, aList.toArray());
    }

    @Test
    public void testDelPos1() {
        aList.init(new int[]{700,100});
        assertEquals(2, aList.size());
        int Actual = aList.delPos(1);
        assertEquals(1, aList.size());
        assertEquals(100, Actual);
        assertArrayEquals(new int[]{700}, aList.toArray());
    }

    @Test
    public void testDelPos2() {
        aList.init(new int[]{700,100,800});
        assertEquals(3, aList.size());
        int Actual = aList.delPos(2);
        assertEquals(2, aList.size());
        assertEquals(800, Actual);
        assertArrayEquals(new int[]{700,100}, aList.toArray());
    }

    @Test
    public void testDelPos3() {
        aList.init(new int[]{700,100,800});
        assertEquals(3, aList.size());
        int Actual = aList.delPos(0);
        assertEquals(2, aList.size());
        assertEquals(700, Actual);
        assertArrayEquals(new int[]{100,800}, aList.toArray());
    }

    @Test
    public void testDelPos4() {
        aList.init(new int[]{700});
        assertEquals(1, aList.size());
        int Actual = aList.delPos(0);
        assertEquals(0, aList.size());
        assertEquals(700, Actual);
        assertArrayEquals(new int[]{}, aList.toArray());
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testDelPos5() {
        aList.init(new int[]{700});
        assertEquals(1, aList.size());
        int Actual = aList.delPos(2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDelEnd4() {
        aList.init(new int[]{});
        assertEquals(0, aList.size());
        int Actual = aList.delEnd();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDelStart4() {
        aList.init(new int[]{});
        assertEquals(0, aList.size());
        int Actual = aList.delStart();
    }

    @Test
    public void testSize1() {
        aList.init(new int[]{});
        assertEquals(0, aList.size());
    }

    @Test
    public void testSize2() {
        aList.init(new int[]{1});
        assertEquals(1, aList.size());
    }

    @Test
    public void testSize3() {
        aList.init(new int[]{1,2});
        assertEquals(2, aList.size());
    }

    @Test
    public void testSize4() {
        aList.init(new int[]{1,2,3});
        assertEquals(3, aList.size());
    }

    @Test
    public void testSize5() {
        aList.init(new int[]{1,2,3,4,5,6,7});
        assertEquals(7, aList.size());
    }

    @Test
    public void testClear() {
        aList.init(new int[]{1,2,3,4,5,6,7});
        aList.clear();
        assertEquals(0, aList.size());
    }

    @Test
    public void testToArray1() {
        aList.init(new int[]{1});
        assertEquals(1, aList.size());
        assertArrayEquals(new int[]{1}, aList.toArray());
    }

    @Test
    public void testToArray2() {
        aList.init(new int[]{1,2});
        assertEquals(2, aList.size());
        assertArrayEquals(new int[]{1,2}, aList.toArray());
    }

    @Test
    public void testToArray3() {
        aList.init(new int[]{1,2,3});
        assertEquals(3, aList.size());
        assertArrayEquals(new int[]{1,2,3}, aList.toArray());
    }


    @Test
    public void testToArray4() {
        aList.init(new int[]{1,2,3,4,5});
        assertEquals(5, aList.size());
        assertArrayEquals(new int[]{1,2,3,4,5}, aList.toArray());
    }


    @Test
    public void testMin1() {
        aList.init(new int[]{120, 340, 292, 33, 24});
        assertEquals(24, aList.min());
    }

    @Test
    public void testMin2() {
        aList.init(new int[]{33, 24});
        assertEquals(24, aList.min());
    }

    @Test
    public void testMin3() {
        aList.init(new int[]{24});
        assertEquals(24, aList.min());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testMin4() {
        aList.init(new int[]{});
        assertEquals(0, aList.min());
    }


    @Test
    public void testMax1() {
        aList.init(new int[]{120, 340, 292, 33, 24});
        assertEquals(340, aList.max());
    }

    @Test
    public void testMax2() {
        aList.init(new int[]{33, 24});
        assertEquals(33, aList.max());
    }

    @Test
    public void testMax3() {
        aList.init(new int[]{24});
        assertEquals(24, aList.max());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testMax4() {
        aList.init(new int[]{});
        assertEquals(0, aList.max());
    }




    @Test
    public void testMaxIndex1() {
        aList.init(new int[]{120, 340, 292, 33, 24});
        assertEquals(2, aList.maxIndex());
    }

    @Test
    public void testMaxIndex2() {
        aList.init(new int[]{33, 24});
        assertEquals(0, aList.maxIndex());
    }

    @Test
    public void testMaxIndex3() {
        aList.init(new int[]{24});
        assertEquals(0, aList.maxIndex());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testMaxIndex4() {
        aList.init(new int[]{});
        assertEquals(0, aList.maxIndex());
    }


    @Test
    public void testMinIndex1() {
        aList.init(new int[]{120, 340, 292, 33, 24});
        assertEquals(4, aList.minIndex());
    }

    @Test
    public void testMinIndex2() {
        aList.init(new int[]{33, 24});
        assertEquals(1, aList.minIndex());
    }

    @Test
    public void testMinIndex3() {
        aList.init(new int[]{24});
        assertEquals(0, aList.minIndex());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testMinIndex4() {
        aList.init(new int[]{});
        assertEquals(0, aList.minIndex());
    }


    @Test  (expected = IllegalArgumentException.class)
    public void testSort1() {
        aList.init(new int[]{});
        assertEquals(0, aList.size());
        aList.sort();
        assertArrayEquals(new int[]{}, aList.toArray());
    }

    @Test
    public void testSort2() {
        aList.init(new int[]{1});
        assertEquals(1, aList.size());
        aList.sort();
        assertArrayEquals(new int[]{1}, aList.toArray());
    }

    @Test
    public void testSort3() {
        aList.init(new int[]{34,1});
        assertEquals(2, aList.size());
        aList.sort();
        assertArrayEquals(new int[]{1,34}, aList.toArray());
    }

    @Test
    public void testSort4() {
        aList.init(new int[]{34,1,23});
        assertEquals(3, aList.size());
        aList.sort();
        assertArrayEquals(new int[]{1,23,34}, aList.toArray());
    }



    @Test  (expected = IllegalArgumentException.class)
    public void testReverse1() {
        aList.init(new int[]{});
        assertEquals(0, aList.size());
        aList.reverse();
        assertArrayEquals(new int[]{}, aList.toArray());
    }

    @Test
    public void testReverse2() {
        aList.init(new int[]{1});
        assertEquals(1, aList.size());
        aList.reverse();
        assertArrayEquals(new int[]{1}, aList.toArray());
    }

    @Test
    public void testReverse3() {
        aList.init(new int[]{34,1});
        assertEquals(2, aList.size());
        aList.reverse();
        assertArrayEquals(new int[]{1,34}, aList.toArray());
    }

    @Test
    public void testReverse4() {
        aList.init(new int[]{34,1,23});
        assertEquals(3, aList.size());
        aList.reverse();
        assertArrayEquals(new int[]{23,1,34}, aList.toArray());
    }


    @Test  (expected = IllegalArgumentException.class)
    public void testHalfReverse1() {
        aList.init(new int[]{});
        assertEquals(0, aList.size());
        aList.halfRevers();
        assertArrayEquals(new int[]{}, aList.toArray());
    }

    @Test
    public void testHalfReverse2() {
        aList.init(new int[]{1});
        assertEquals(1, aList.size());
        aList.halfRevers();
        assertArrayEquals(new int[]{1}, aList.toArray());
    }

    @Test
    public void testHalfReverse3() {
        aList.init(new int[]{34,1});
        assertEquals(2, aList.size());
        aList.halfRevers();
        assertArrayEquals(new int[]{1,34}, aList.toArray());
    }

    @Test
    public void testHalfReverse4() {
        aList.init(new int[]{34,1,23});
        assertEquals(3, aList.size());
        aList.halfRevers();
        assertArrayEquals(new int[]{23,1,34}, aList.toArray());
    }



    @Test  (expected = IllegalArgumentException.class)
    public void testGet1() {
        aList.init(new int[]{});
        assertEquals(0, aList.size());
        assertEquals(0, aList.get(0));
    }

    @Test
    public void testGet2() {
        aList.init(new int[]{10});
        assertEquals(1, aList.size());
        assertEquals(10, aList.get(0));
    }

    @Test
    public void testGet3() {
        aList.init(new int[]{34,1});
        assertEquals(2, aList.size());
        assertEquals(1, aList.get(1));
    }

    @Test
    public void testGet4() {
        aList.init(new int[]{34,1,23});
        assertEquals(3, aList.size());
        assertEquals(23, aList.get(2));
    }


    @Test
    public void testSet1() {
        aList.init(new int[]{120, 340, 292, 33, 24});
        int[] expected = {120, 200, 292, 33, 24};
        aList.set(1, 200);
        assertArrayEquals(expected, aList.toArray());
    }

    @Test
    public void testSet2() {
        aList.init(new int[]{120, 340});
        int[] expected = {120, 200};
        aList.set(1, 200);
        assertArrayEquals(expected, aList.toArray());
    }

    @Test
    public void testSet3() {
        aList.init(new int[]{120});
        int[] expected = {200};
        aList.set(0, 200);
        assertArrayEquals(expected, aList.toArray());
    }

    @Test  (expected = IllegalArgumentException.class)
    public void testSet4() {
        aList.init(new int[]{});
        int[] expected = {};
        aList.set(0, 200);
        assertArrayEquals(expected, aList.toArray());
    }
}

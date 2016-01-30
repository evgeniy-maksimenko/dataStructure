import gontsov.trees.BsTree;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class BsTreeTest {

    BsTree theTree;

    public BsTreeTest(){
        theTree = new BsTree();
    }

    @Test
    public void testAdd1(){
        theTree.add(1);
        assertEquals(1, theTree.size());
        assertArrayEquals(new Integer[] {1}, theTree.toArray());
    }

    @Test
    public void testAdd2(){
        theTree.add(1);
        theTree.add(2);
        assertEquals(2, theTree.size());
        assertArrayEquals(new Integer[] {1,2}, theTree.toArray());
    }

    @Test
    public void testAdd3(){
        theTree.add(123);
        theTree.add(22);
        assertEquals(2, theTree.size());
        assertArrayEquals(new Integer[] {22,123}, theTree.toArray());
    }

    @Test
    public void testSize(){
        theTree.init(new int[] {1,23,4,5,6,7,8,9,0});
        int Actual = theTree.size();
        int Expected = 9;
        assertEquals(Expected, Actual);
    }

    @Test
    public void testClear(){
        theTree.init(new int[] {1,23,4,5,6,7,8,9,0});
        theTree.clear();
        assertEquals(0, theTree.size());
    }

    @Test
    public void testToArray1(){
        theTree.init(new int[] {1});
        Object[] Actual = theTree.toArray();
        Object[] Expected = new Object[] {1};
        assertArrayEquals(Expected, Actual);
    }

    @Test
    public void testToArray2(){
        theTree.init(new int[] {1,2});
        Object[] Actual = theTree.toArray();
        Object[] Expected = new Object[] {1,2};
        assertArrayEquals(Expected, Actual);
    }

    @Test
    public void testToArray3(){
        theTree.init(new int[] {1,2,3});
        Object[] Actual = theTree.toArray();
        Object[] Expected = new Object[] {1,2,3};
        assertArrayEquals(Expected, Actual);
    }

    @Test
    public void testToArray4(){
        theTree.init(new int[] {875,34,56});
        Object[] Actual = theTree.toArray();
        Object[] Expected = new Object[] {34,56,875};
        assertArrayEquals(Expected, Actual);
    }

    @Test
    public void testLeafs1(){
        theTree.init(new int[] {1});
        assertEquals(1, theTree.leafs());
    }

    @Test
    public void testLeafs2(){
        theTree.init(new int[] {10,9,11});
        assertEquals(2, theTree.leafs());
    }

    @Test
    public void testLeafs3(){
        theTree.init(new int[] {10,8,12,7,9,11,13});
        assertEquals(4, theTree.leafs());
    }

    @Test
    public void testLeafs4(){
        theTree.init(new int[] {10,8,12,7,9,11});
        assertEquals(3, theTree.leafs());
    }

    @Test
    public void testLeafs5(){
        theTree.init(new int[] {10,8,12,9,11});
        assertEquals(2, theTree.leafs());
    }

    @Test
    public void testNodes1(){
        theTree.init(new int[] {10});
        assertEquals(0, theTree.nodes());
    }

    @Test
    public void testNodes2(){
        theTree.init(new int[] {10,8,12});
        assertEquals(1, theTree.nodes());
    }

    @Test
    public void testNodes3(){
        theTree.init(new int[] {10,8,12,7,9,11,13});
        assertEquals(3, theTree.nodes());
    }

    @Test
    public void testNodes4(){
        theTree.init(new int[] {10,8,12,7,9,11});
        assertEquals(2, theTree.nodes());
    }

    @Test
    public void testNodes5(){
        theTree.init(new int[] {10,8,12,9,11});
        assertEquals(1, theTree.nodes());
    }

    @Test
    public void testHeight1(){
        theTree.init(new int[] {1});
        assertEquals(0, theTree.width());
    }

    @Test
    public void testHeight2(){
        theTree.init(new int[] {1,2});
        assertEquals(1, theTree.width());
    }

    @Test
    public void testHeight3(){
        theTree.init(new int[] {1,2,4});
        assertEquals(1, theTree.width());
    }

    @Test
    public void testWidth1(){
        theTree.init(new int[] {10,8,12,7,9,11,13});
        assertEquals(2, theTree.width());
    }

    @Test
    public void testWidth2(){
        theTree.init(new int[] {100,80,70,60,50,40,10,55});
        assertEquals(2, theTree.width());
    }

    @Test
    public void testWidth3(){
        theTree.init(new int[] {10,15,20,25,24,26});
        assertEquals(1, theTree.width());
    }

    @Test
    public void testWidth4(){
        theTree.init(new int[] {1,2,3,4,5,6,7,8,9,10,100,90,110});
        assertEquals(1, theTree.width());
    }


    @Test
    public void testReverse(){
        theTree.init(new int[] {1,2,3,4,5});
        theTree.reverse();
        assertArrayEquals(new Integer[]{1,2,3,4,5}, theTree.toArray());
    }
}
package gontsov;

public interface EList
{

    public void  addStart(int val);
    public void  addEnd(int val);
    public void  addPos(int pos, int val);

    public int   delStart();
    public int   delEnd();
    public int   delPos(int pos);

    public int   size();
    public void  clear();
    public void  init(int[] ar);
    public int[] toArray();

    public void  set(int pos, int val);
    public int   get(int pos);

    public int   min();
    public int   max();
    public int   minIndex();
    public int   maxIndex();

    public void  reverse();
    public void  halfRevers();
    public void  sort();
}


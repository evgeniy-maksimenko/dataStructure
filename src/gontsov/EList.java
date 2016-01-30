package gontsov;

public interface EList<EE>
{

    public void  addStart(int val);
    public void  addEnd(int val);
    public void  addPos(int pos, int val);

    public EE   delStart();
    public EE   delEnd();
    public EE   delPos(int pos);

    public int   size();
    public void  clear();
    public void  init(EE[] ar);
    public Object[] toArray();

    public void  set(int pos, int val);
    public EE  get(int pos);

    public int   min();
    public int   max();
    public int   minIndex();
    public int   maxIndex();

    public void  reverse();
    public void  halfRevers();
    public void  sort();
}


package gontsov.trees;

public interface ETree {
    public void add(int val);
    public int size();
    public void clear();
    public int[] toArray();
    public int leafs();
    public int nodes();
    public int width();
    public int height();
    public void reverse();
}
